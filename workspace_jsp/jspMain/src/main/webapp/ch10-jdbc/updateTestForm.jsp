<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="dbinfo.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript">
	window.onload = function() {
		var myForm = document.getElementById('myForm');
		// 이벤트 연결
		myForm.onsubmit = function() {
			list = document.getElementsByTagName('li');
			for(let i=0;i<list.length;i++) {
				let input = list[i].querySelector('input,textarea');
				if(input.value.trim()=='') {
					let label = list[i].querySelector('label').innerHTML;
					let post = ((label.charCodeAt(label.length-1) - 44032) % 28) > 0 ? '을' : '를'; // 주어진 단어의 마지막 글자에 받침(=종성)이 있으면 을, 없으면 를; 44032는 유니코드에서 첫 번째 한글인 '가'의 10진수 값
					alert(label + post + ' 입력하세요!');
					input.focus();
					input.value = '';
					return false;
				}
			}
		};
	};
</script>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try {
		// JDBC 수행 1단계 : 드라이버 로드
		Class.forName(driverName);
		
		// JDBC 수행 2단계 : Connection 객체 생성
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		// SQL문 작성
		sql = "SELECT * FROM tboard WHERE num=?";
		
		// JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt =  conn.prepareStatement(sql);
		// ?에 데이터를 바인딩
		pstmt.setInt(1, num);
		
		// JDBC 수행 4단계 : SQL문을 실행하고 결과 행을 ResultSet에 담아 반환
		rs = pstmt.executeQuery();
		if(rs.next()) { // 행이 있는 경우
			String name = rs.getString("name");	
			String title = rs.getString("title");	
			String content = rs.getString("content");	
%>
<div class="page-main">
	<h2>글 수정</h2>
	<form id="myForm" action="updateTest.jsp" method="post">
		<input type="hidden" name="num" value="<%= num %>"> <!-- type을 hidden으로 지정하면 해당 태그가 화면에 보이지 않아 사용자는 수정할 수 없지만 서버에는 값이 전송됨 -->
		<ul>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name" value="<%= name %>" size="10" maxlength="10">
			</li>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" value="<%= title %>">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40" name="content" id="content"><%= content %></textarea> <!-- <textarea> 태그는 시작 태그와 끝 태그 사이에 미리보기 내용을 넣어야 하며, 개행문자나 \t등도 모두 태그의 내용으로 인식되기 때문에 불필요한 공백을 넣지 말아야 함 -->
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="목록" onclick="location.href='selectTest.jsp'">
		</div>
	</form>
</div>
<%
		}
		else { // 행이 없는 경우
%>
<div class="result-display">
	<div class="align-center">
		수정할 글 정보 호출 실패!<br>
		<input type="button" value="목록" onclick="location.href='selectTest.jsp'">
	</div>
</div>
<%			
		}
	}
	catch(Exception e) {
		e.printStackTrace();
%>
<div class="result-display">
	<div class="align-center">
		오류 발생! 수정할 글 정보 호출 실패!<br>
		<input type="button" value="목록" onclick="location.href='selectTest.jsp'">
	</div>
</div>
<%
	}
	finally {
		// 자원 정리
		if(rs!=null) try {rs.close();} catch(SQLException e) {}
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
	}
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="dbinfo.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
	// 전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");
	
	// 전송된 데이터 반환
	int num = Integer.parseInt(request.getParameter("num"));
	String name = request.getParameter("name");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	try {
		// JDBC 수행 1단계 : 드라이버 로드
		Class.forName(driverName);
		// JDBC 수행 2단계 : Connection 객체 생성
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);

		// SQL문 작성
		sql = "UPDATE tboard SET name=?, title=?, content=?, reg_date=SYSDATE WHERE num=?";
		
		// JDBC 수행 3단계 : PreparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		// ?에 데이터를 바인딩
		pstmt.setString(1, name);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setInt(4, num);
		
		// JDBC 수행 4단계 : SQL문 실행
		pstmt.executeUpdate();
%>
<div class="result-display">
	<div class="align-center">
		글 수정 완료!<br>
		<input type="button" value="상세 페이지" onclick="location.href='detailTest.jsp?num=<%= num %>'">
		<input type="button" value="목록" onclick="location.href='selectTest.jsp'">
	</div>
</div>
<%
	}
	catch(Exception e) {
		e.printStackTrace();
%>
<div class="result-display">
	<div class="align-center">
		오류 발생! 글 수정 실패<br>
		<input type="button" value="글 수정하기" onclick="location.href='updateTestForm.jsp?num=<%= num %>'">
	</div>
</div>
<%
	}
	finally {
		// 자원 정리
		if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
	}
%>
</body>
</html>
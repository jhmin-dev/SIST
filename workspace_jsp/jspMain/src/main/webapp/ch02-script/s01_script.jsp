<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 연습</title>
</head>
<body>
<h2>배열의 내용 출력 : 선언부, 스크립트릿</h2>
<%!
	// 선언부 : 변수 선언, 메서드 선언
	String[] str = {"JSP가", "정말", "재미", "있다"};
%>
<table border="1">
	<tr>
		<th>배열의 인덱스</th>
		<th>배열의 내용</th>
	</tr>
	<%
		// 스크립트릿 : 변수 선언, 연산, 제어문, 출력
		for(int i=0;i<str.length;i++) {
			out.println("<tr>"); // 스크립트릿에서 출력하는 것은 서블릿과 같은 방식으로, 문자열로 태그를 작성하기 때문에 속성 지정이나 JavaScript, CSS 등을 활용하기 불편해서 권장되지 않음
			out.println("<td>" + i + "</td>");
			out.println("<td>" + str[i] + "</td>");
			out.println("</tr>");
		}
	%>
</table>
<br>
<h2>배열의 내용 출력 - 선언부, 스크립트릿, 표현식</h2>
<table border="1">
	<tr>
		<th>배열의 인덱스</th>
		<th>배열의 내용</th>
	</tr>
<%
	for(int i=0;i<str.length;i++) { // 스크립트릿 내부에는 표현식을 사용할 수 없으므로, 스크립트릿 영역을 분할 후 스크립트릿 영역 바깥에 표현식을 사용해야 함
%>
	<tr>
		<!-- 표현식 : 변수의 값 출력, 메서드의 결과 값 출력, 연산의 결과 값 출력  -->
		<%-- JSP 주석 : Java 주석과 마찬가지로 컴파일시 제외되어 HTML 페이지 원본 보기에 나타나지 않음 --%>
		<td><%= i %></td>
		<td><%= str[i] %></td>
	</tr>
<%
	} // for문 시작과 끝 영역을 분할한 경우, 두 영역 사이에 오는 HTML 영역은 for문에 의해 반복됨
%>
</table>
<br>
<h2>배열의 내용 출력 : 확장 for문</h2>
<table border="1">
	<tr>
		<th>배열의 내용</th>
	</tr>
<%
	for(String s : str) {
%>
	<tr>
		<td><%= s %></td>
	</tr>
<%
	}
%>
</table>
<style type="text/css"> /* 테이블의 행과 열을 pivot */
	table {border-collapse: collapse;}
	tbody {display: flex; flex-direction: row;}
	tr {display: flex; flex-direction: column;}
</style>
</body>
</html>
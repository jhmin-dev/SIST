<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<h3>표현 언어(EL) - 파라미터값 처리</h3>
<form action="s02_el.jsp" method="post"> <!-- 자기 자신에 데이터를 전송 -->
	이름 : <input type="text" name="name">
	<input type="submit" value="확인">
</form>
<br>
이름은 <%= request.getParameter("name") %><br> <%-- 파라미터가 없는 경우 null 반환 --%>
이름은 ${param.name} <%-- 파라미터가 없는 경우 null 대신 빈 문자열 반환 --%>
</body>
</html>
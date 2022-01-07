<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 4개 기본 객체와 영역</title>
</head>
<body>
<%
	pageContext.setAttribute("msg1", "봄"); // setAttribute() 메서드에 속성명과 값을 인자로 전달하면 객체에 해당 속성을 저장
	request.setAttribute("msg2", "여름");
	session.setAttribute("msg3", "가을");
%>
page 영역 msg1 = <%= pageContext.getAttribute("msg1") %><br> <%-- getAttribute() 메서드에 속성명을 인자로 전달하면 값을 반환 --%>
request 영역 msg2 = <%= request.getAttribute("msg2") %><br>
session 영역 msg3 = <%= session.getAttribute("msg3") %>
</body>
</html>
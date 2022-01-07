<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 기본 객체 속성 보기</title>
</head>
<body>
<%
	// application의 모든 속성명 구하기
	Enumeration attrEnum = application.getAttributeNames();
	while(attrEnum.hasMoreElements()) {
		// 속성명 구하기
		String name = (String)attrEnum.nextElement();
		// 값 구하기
		Object value = application.getAttribute(name);
%>
		application 속성 : <b><%= name %></b> = <%= value %><br> <%-- 웹 어플리케이션 하나당 application 객체가 1개 생성되며, 공유 범위가 가장 넓음; 서버가 종료되기 전까지 객체가 유지됨 --%>
<%
	}
%>
</body>
</html>
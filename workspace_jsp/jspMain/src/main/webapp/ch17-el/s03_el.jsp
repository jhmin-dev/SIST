<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
<%
	// 변수에 값 저장
	String str = "여름 여행";
	// JSP 4개 영역에 데이터 저장
	pageContext.setAttribute("msg", "봄");
	request.setAttribute("msg2", "여름");
	session.setAttribute("msg3", "가을");
	application.setAttribute("msg4", "겨울");
%>
</head>
<body>
<%-- JSP 4개 영역에 속성을 저장하고 EL로 읽는 경우, 내장 객체를 생략하고 속성명만으로 호출 가능; 영역을 명시하지 않았는데 속성명이 유일하지 않으면 가장 작은 영역인 pageContext부터 검색 --%>
page 영역 : ${pageScope.msg}, ${msg}<br>
request 영역 : ${requestScope.msg2}, ${msg2}<br>
session 영역 : ${sessionScope.msg3}, ${msg3}<br>
application 영역 : ${applicationScope.msg4}, ${msg4}<br>
변수의 값 : ${str} <%-- 스크립트릿에서 만든 변수의 값은 EL에서 직접 호출하지 못함 --%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습</title>
</head>
<body>
이름 : <%= request.getParameter("name") %><br>
아이디 : <%= request.getParameter("id") %><br>
비밀번호 : <%= request.getParameter("password") %><br>
전화번호 : 
<%
	String[] phones = request.getParameterValues("phone");
	String phone = "";
	for(int i=0;i<phones.length;i++) {
		if(phones.length==4 && i==0) continue;
		phone += phones[i];
		if(i<phones.length - 1) phone += " - ";
	}
%>
<%= phone %><br>
취미 :
<%
	String[] hobbies = request.getParameterValues("hobby");
	String hobby = "";
	if(hobbies!=null) {
		for(int i=0;i<hobbies.length;i++) {
			hobby += hobbies[i];
			if(i<hobbies.length-1) hobby += ", ";
		}
	}
%>
<%= hobby %><br>
자기 소개 : <br>
<textarea rows="5" cols="50" readonly><%= request.getParameter("content") %></textarea><br>
</body>
</html>
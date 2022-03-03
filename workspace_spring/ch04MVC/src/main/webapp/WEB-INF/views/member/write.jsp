<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<form:form modelAttribute="vo">
	<form:errors element="div"/>
	<ul>
		<li>
			<form:label path="id">아이디</form:label>
			<form:input path="id"/>
			<form:errors path="id"/>
		</li>
		<li>
			<form:label path="password">비밀번호</form:label>
			<form:password path="password"/>
			<form:errors path="password"/>
		</li>
		<li>
			<form:label path="name">이름</form:label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</li>
		<li>
			<form:label path="age">나이</form:label>
			<form:input path="age"/>
			<form:errors path="age"/>
		</li>
		<li>
			<form:label path="email">이메일</form:label>
			<form:input path="email"/>
			<form:errors path="email"/>
		</li>
	</ul>
	<div>
		<form:button>전송</form:button>
	</div>
</form:form>
</body>
</html>
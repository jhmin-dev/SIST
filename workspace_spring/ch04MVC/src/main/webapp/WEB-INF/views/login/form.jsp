<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.form.title"/></title>
</head>
<body>
<form:form modelAttribute="loginVO">
	<form:errors element="div"/>
	<ul>
		<li>
			<form:label path="userId"><spring:message code="login.form.userId"/></form:label>
			<form:input path="userId"/>
			<form:errors path="userId"/>
		</li>
		<li>
			<form:label path="password"><spring:message code="login.form.password"/></form:label>
			<form:password path="password"/>
			<form:errors path="password"/>
		</li>
	</ul>
	<div>
		<form:button><spring:message code="login.form.submit"/></form:button>
	</div>
</form:form>
</body>
</html>
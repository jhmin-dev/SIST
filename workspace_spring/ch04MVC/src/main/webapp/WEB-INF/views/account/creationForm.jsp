<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 생성</title>
</head>
<body>
<form:form method="post" modelAttribute="vo">
	<ul>
		<li>
			<form:label path="id">아이디</form:label>
			<form:input path="id"/>
			<form:errors path="id"/>
		</li>
		<li>
			<form:label path="name">이름</form:label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</li>
		<li>
			<form:label path="zipcode">우편번호</form:label>
			<form:input path="zipcode"/>
			<form:errors path="zipcode"/>
		</li>
		<li>
			<form:label path="address1">주소</form:label>
			<form:input path="address1"/>
			<form:errors path="address1"/>
		</li>
		<li>
			<form:label path="address2">나머지 주소</form:label>
			<form:input path="address2"/>
			<form:errors path="address2"/>
		</li>
	</ul>
	<div>
		<form:button>전송</form:button>
	</div>
</form:form>
</body>
</html>
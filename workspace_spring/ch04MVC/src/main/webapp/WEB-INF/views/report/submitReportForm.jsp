<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리포트 등록 폼</title>
</head>
<body>
<form:form action="submitReport.do" method="post" enctype="multipart/form-data" modelAttribute="report">
	<ul>
		<li>
			<form:label path="subject">제목</form:label>
			<form:input path="subject"/>
			<form:errors path="subject"/>
		</li>
		<li>
			<form:label path="reportFile">리포트 파일</form:label>
			<input type="file" name="reportFile" id="reportFile"/>
			<form:errors path="reportFile"/>
		</li>
	</ul>
	<div>
		<form:button>리포트 전송</form:button>
	</div>
</form:form>
</body>
</html>
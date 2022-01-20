<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out 태그</title>
</head>
<body>
<%-- out 태그는 출력을 담당하며, 일반적으로는 출력에 EL을 사용하지만 HTML 태그를 불인정해야 하는 경우에 out 태그를 사용 --%>
<c:out value="<h1>오늘은 목요일</h1>" escapeXml="true"/><br> <%-- escapeXml="true"이면 HTML 태그 불인정(기본값) --%>
<c:out value="<h1>내일은 금요일</h1>" escapeXml="false"/> <%-- escapeXml="false"이면 HTML 태그 인정 --%>
</body>
</html>
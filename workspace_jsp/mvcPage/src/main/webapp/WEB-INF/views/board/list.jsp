<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		
	});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h2>게시판 목록</h2>
	<div class="list-space align-right">
		<input type="button" value="글쓰기" onclick="location.href = 'writeForm.do';" <c:if test="${empty user_num}">disabled</c:if>>
		<input type="button" value="목록" onclick="location.href = 'list.do';">
		<input type="button" value="홈으로" onclick="location.href = '${pageContext.request.contextPath}/main/main.do';">
	</div>
</div>
</body>
</html>
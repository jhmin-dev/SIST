<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="page-main">
	<h2>${board.title}</h2>
	<p>
		글 번호 : ${board.num}<br>
		작성자 : ${board.name}<br>
		작성일 : ${board.reg_date}
	</p>
	<hr width="100%" size="1" noshade>
	<p>
		${board.content}
	</p>
	<hr width="100%" size="1" noshade>
	<div class="align-center">
		<input type="button" value="수정" onclick="location.href = 'update.do?num=${board.num}';">
		<input type="button" value="삭제" onclick="location.href = 'delete.do?num=${board.num}';">
		<input type="button" value="홈으로" onclick="location.href = 'list.do';">
	</div>
</div>
</body>
</html>
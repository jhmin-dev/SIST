<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
<div class="page-main">
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="board" items="${list}">
		<tr>
			<td>${board.num}</td>
			<td><a href="detail.do?num=${board.num}">${board.title}</a></td>
			<td>${board.name}</td>
			<td>${board.reg_date}</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
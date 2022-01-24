<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 삭제</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
</head>
<body>
<div class="page-main">
	<h2>상품 정보 삭제</h2>
	<form action="delete.do" method="post">
		<input type="hidden" name="num" value="${param.num}">
		<div class="align-center">
			<p>
				정말 삭제하시겠습니까?
			</p>
			<input type="submit" value="삭제">
			<input type="button" value="목록" onclick="location.href = 'list.do';">
		</div>
	</form>
</div>
</body>
</html>
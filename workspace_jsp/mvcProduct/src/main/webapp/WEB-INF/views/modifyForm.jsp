<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
</head>
<body>
<div class="page-main">
	<h2>상품 수정</h2>
	<form id="form" action="modify.do" method="post">
		<input type="hidden" name="num" value="${param.num}">
		<ul>
			<li>
				<label for="name">상품명</label>
				<input type="text" name="name" id="name" value="${vo.name}">
			</li>
			<li>
				<label for="price">가격</label>
				<input type="number" name="price" id="price" min="0" value="${vo.price}">
			</li>
			<li>
				<label for="stock">재고</label>
				<input type="number" name="stock" id="stock" min="0" value="${vo.stock}">
			</li>
			<li>
				<label for="origin">원산지</label>
				<input type="text" name="origin" id="origin" value="${vo.origin}">
			</li>
			<li>
				<label for="content">설명</label>
				<textarea rows="5" cols="40" name="content">${vo.content}</textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="목록" onclick="location.href = 'list.do';">
		</div>
	</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/validateLength.js"></script>
<script type="text/javascript">
	validateSubmit('form');
	validateBytesLength({name:30,price:9,stock:9,origin:30});
</script>
</body>
</html>
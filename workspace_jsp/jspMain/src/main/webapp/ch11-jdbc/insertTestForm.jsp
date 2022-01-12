<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-main">
	<h2 class="align-center">상품 등록</h2>
	<form id="myForm" action="insertTest.jsp" method="post">
		<ul>
			<li>
				<label for="name">상품명</label>
				<input type="text" name="name" id="name">
			</li>
			<li>
				<label for="price">가격</label>
				<input type="number" name="price" id="price" min="1" placeholder="1 ~ 999,999,999"> <!-- 가격이 0이면 무의미하기 때문에 최솟값은 1로 설정 -->
			</li>
			<li>
				<label for="stock">재고</label>
				<input type="number" name="stock" id="stock" min="0" placeholder="0 ~ 999,999,999"> <!-- max값에 연산 식을 넣을 수 없으며, max값을 직접 999999999로 지정시 JavaScript를 통한 입력 값 길이 제어가 제대로 동작하지 않음 -->
			</li>
			<li>
				<label for="origin">원산지</label>
				<input type="text" name="origin" id="origin">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="상품 등록">
			<input type="button" value="상품 목록" onclick="location.href='selectTest.jsp'">
		</div>
	</form>
</div>
<script type="text/javascript" src="validateLength.js"></script>
</body>
</html>
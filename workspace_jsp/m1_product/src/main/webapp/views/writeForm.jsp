<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
</head>
<body>
<div class="page-main">
	<h1>상품 등록</h1>
	<form action="write.jsp" method="post">
		<ul>
			<li>
				<label for="name">상품명</label>
				<input type="text" name="name">
			</li>
			<li>
				<label for="price">가격</label>
				<input type="number" name="price" min="0">
			</li>
			<li>
				<label for="stock">재고</label>
				<input type="number" name="stock" min="0">
			</li>
			<li>
				<label for="origin">원산지</label>
				<input type="text" name="origin">
			</li>
			<li>
				<label for="content">상품 설명</label>
				<textarea rows="5" cols="40" name="content"></textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="등록">
			<input type="button" value="목록" onclick="location.href = 'list.jsp';">
		</div>
	</form>
</div>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/validateLength.js"></script>
<script type="text/javascript">
	document.querySelector('form').onsubmit = validateSubmit;
	
	let txts = document.querySelectorAll('input[type="text"]');
	for(let i=0;i<txts.length;i++) {
		txts[i].onkeyup = function() {
			while(getBytesLength(this.value)>30) {
				this.value = this.value.slice(0, -1);
			}
		};
	}
</script>
</body>
</html>
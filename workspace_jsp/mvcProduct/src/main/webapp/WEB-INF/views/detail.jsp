<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 정보</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<style type="text/css">
	hr {border-style: solid; color: gray;}
</style>
</head>
<body>
<div class="page-main">
	<h2>상품 상세 정보</h2>
	<ul>
		<li>
			<label>상품 번호</label>
			${vo.num}
		</li>
		<li>
			<label>상품명</label>
			${vo.name}
		</li>
		<li>
			<label>가격</label>
			${String.format("%,d원", vo.price)}
		</li>
		<li>
			<label>재고</label>
			${String.format("%,d개", vo.stock)}
		</li>
		<li>
			<label>원산지</label>
			${vo.origin}
		</li>
		<li>
			<label>등록일</label>
			${vo.reg_date}
		</li>
	</ul>
	<hr>
	<p>
		${vo.content}
	</p>
	<hr>
	<div class="align-right">
		<input type="button" value="수정" onclick="location.href = 'modifyForm.do?num=${vo.num}';">
		<input type="button" value="삭제" onclick="location.href = 'deleteForm.do?num=${vo.num}';">
		<input type="button" value="목록" onclick="location.href = 'list.do';">
	</div>
</div>
</body>
</html>
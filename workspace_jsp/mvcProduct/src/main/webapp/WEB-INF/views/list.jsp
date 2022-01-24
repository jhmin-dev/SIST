<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
</head>
<body>
<div class="page-main">
	<h2>상품 목록</h2>
	<div class="align-right">
		<input type="button" value="등록" onclick="location.href = 'writeForm.do';">
	</div>
	<c:if test="${totalCount == 0}">
	<div class="result-display">
		상품 정보가 없습니다!
	</div>
	</c:if>
	<c:if test="${totalCount > 0}">
	<table>
		<tr>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>가격 (원)</th>
			<th>재고 (개)</th>
			<th>원산지</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.num}</td>
			<td><a href="detail.do?num=${vo.num}">${vo.name}</a></td>
			<td>${String.format("%,d", vo.price)}</td>
			<td>${String.format("%,d", vo.stock)}</td>
			<td>${vo.origin}</td>
			<td>${vo.reg_date}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="align-center">
		${pagingHtml}
	</div>
	</c:if>
</div>
</body>
</html>
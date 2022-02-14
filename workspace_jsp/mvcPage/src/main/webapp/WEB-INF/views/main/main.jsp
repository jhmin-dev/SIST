<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div>
		<h3>신규 상품</h3>
		<div class="item-space">
			<c:forEach var="item" items="${itemList}">
			<div class="horizontal-area">
				<a href="${pageContext.request.contextPath}/item/detail.do?item_num=${item.item_num}">
					<img src="${pageContext.request.contextPath}/upload/${item.photo1}">
					<span>${item.name}
					<br>
					<b><fmt:formatNumber value="${item.price}"/>원</b>
					</span>
				</a>
			</div>
			</c:forEach>
			<div class="float-clear">
				<hr width="100%" size="1" noshade>
			</div>
		</div>
	</div>
</div>
</body>
</html>
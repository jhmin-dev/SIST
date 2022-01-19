<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.product.dao.ProductDAO" %>
<%@ page import="kr.product.vo.ProductVO" %>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	ProductVO vo = ProductDAO.getInstance().getProduct(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 정보</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
<style type="text/css">
	hr {color: gray; border-style: solid;}
</style>
</head>
<body>
<div class="page-main">
	<h1>상품 상세 정보</h1>
	<ul>
		<li>
			<label>상품 번호</label>
			<%= vo.getNum() %>
		</li>
		<li>
			<label>상품명</label>
			<%= vo.getName() %>
		</li>
		<li>
			<label>가격</label>
			<%= String.format("%,d원", vo.getPrice()) %>
		</li>
		<li>
			<label>재고</label>
			<%= String.format("%,d개", vo.getStock()) %>
		</li>
		<li>
			<label>원산지</label>
			<%= vo.getOrigin() %>
		</li>
		<li>
			<label>등록일</label>
			<%= vo.getReg_date() %>
		</li>
	</ul>
	<hr>
	<p>
		<%= vo.getContent() %>
	</p>
	<hr>
	<div class="align-right">
		<input type="button" value="수정" onclick="location.href = 'updateForm.jsp?num=<%= num %>';">
		<input type="button" value="삭제" onclick="location.href = 'deleteForm.jsp?num=<%= num %>';">
		<input type="button" value="목록" onclick="location.href = 'list.jsp';">
	</div>
</div>
</body>
</html>
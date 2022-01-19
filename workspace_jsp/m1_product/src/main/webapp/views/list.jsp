<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.product.dao.ProductDAO" %>
<%@ page import="kr.product.vo.ProductVO" %>
<%@ page import="kr.util.PagingUtil" %>
<%@ page import="java.util.List" %>
<%
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null) pageNum = "1";
	int currentPage = Integer.parseInt(pageNum);
	ProductDAO dao = ProductDAO.getInstance();
	int totalCount = dao.getCount();
	int rowCount = 10;
	int pageCount = 10;
	String pageUrl = request.getRequestURI();
	
	PagingUtil pg = new PagingUtil(currentPage, totalCount, rowCount, pageCount, pageUrl);
	List<ProductVO> list = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
</head>
<body>
<div class="page-main">
	<h1>상품 목록</h1>
	<div class="align-right">
		<input type="button" value="상품 등록" onclick="location.href = 'writeForm.jsp';">
	</div>
<%
	if(totalCount<=0) {
%>
	<div class="result-display">저장된 상품 정보가 없습니다!</div>
<%
	}
	else {
%>
	<!-- 목록 출력 시작 -->
	<table>
		<tr>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>가격 (원)</th>
			<th>재고 (개)</th>
			<th>원산지</th>
			<th>등록일</th>
		</tr>
<%
		list = dao.getList(pg.getStartCount(), pg.getEndCount());
		for(ProductVO vo : list) {
%>
		<tr>
			<td><%= vo.getNum() %></td>
			<td><a href="detail.jsp?num=<%= vo.getNum() %>"><%= vo.getName() %></a></td>
			<td><%= String.format("%,d", vo.getPrice()) %></td>
			<td><%= String.format("%,d", vo.getStock()) %></td>
			<td><%= vo.getOrigin() %></td>
			<td><%= vo.getReg_date() %></td>
		</tr>
<%
		}
%>
	</table>
	<!-- 목록 출력 끝 -->
	<div class="align-center">
		<%= pg.getPagingHtml() %>
	</div>
<%
	}
%>
</div>
</body>
</html>
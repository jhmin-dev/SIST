<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.product.dao.ProductDAO" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="vo" class="kr.product.vo.ProductVO"/>
<jsp:setProperty property="*" name="vo"/>
<%
	ProductDAO dao = ProductDAO.getInstance();
	dao.insert(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 완료</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
</head>
<body>
<div class="page-main">
	<h1>상품 등록 완료</h1>
	<div class="result-display">
		<div class="align-center">
			상품 등록이 완료되었습니다.<br>
			<input type="button" value="목록" onclick="location.href = 'list.jsp';">
			<input type="button" value="추가" onclick="location.href = 'writeForm.jsp';">
		</div>
	</div>
</div>
</body>
</html>
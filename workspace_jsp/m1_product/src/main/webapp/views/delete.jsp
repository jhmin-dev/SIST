<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.product.dao.ProductDAO" %>
<%
	ProductDAO.getInstance().delete(Integer.parseInt(request.getParameter("num")));
%>
<script type="text/javascript">
	alert('상품 정보를 삭제하였습니다.');
	location.href = 'list.jsp';
</script>
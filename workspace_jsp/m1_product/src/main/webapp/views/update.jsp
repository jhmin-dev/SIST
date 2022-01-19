<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.product.dao.ProductDAO" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="vo" class="kr.product.vo.ProductVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo"/>
<%
	ProductDAO.getInstance().update(vo);
%>
<script type="text/javascript">
	alert('상품 정보를 수정하였습니다.');
	location.href = 'list.jsp';
</script>
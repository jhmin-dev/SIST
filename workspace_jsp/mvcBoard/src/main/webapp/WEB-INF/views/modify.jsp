<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${check}">
	<script type="text/javascript">
		alert('글 수정을 완료하였습니다.');
		location.href = 'list.do';
	</script>
</c:if>
<c:if test="${!check}">
	<script type="text/javascript">
		alert('비밀번호 불일치!');
		history.go(-1);
	</script>
</c:if>
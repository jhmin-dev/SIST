<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 완료</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/> <%-- <jsp:include> 태그 사용시에는 서블릿으로 변환되면서 Context Path를 인식하기 때문에 EL로 Context Path를 읽어오지 않아도 됨 --%>
	<h2>회원 가입 완료</h2>
	<div class="result-display">
		<div class="align-center">
			회원 가입이 완료되었습니다.
			<p>
			<input type="button" value="홈으로" onclick="location.href = '${pageContext.request.contextPath}/main/main.do';">
		</div>
	</div>
</div>
</body>
</html>
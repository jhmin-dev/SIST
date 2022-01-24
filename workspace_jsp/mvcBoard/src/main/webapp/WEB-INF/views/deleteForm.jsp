<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
</head>
<body>
<div class="page-main">
	<h2>글 삭제</h2>
	<form id="delete_form" action="delete.do" method="post">
		<input type="hidden" name="num" value="${num}"> <%-- 클래스에서 request 영역에 속성을 저장하지 않고 ${param.num}을 사용하는 것도 가능 --%>
		<ul>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" size="12">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="삭제">
			<input type="button" value="목록" onclick="location.href = 'list.do';">
		</div>
	</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/validateLength.js"></script>
<script type="text/javascript">
	validateSubmit('delete_form');
	validateBytesLength({passwd:12});
</script>
</body>
</html>
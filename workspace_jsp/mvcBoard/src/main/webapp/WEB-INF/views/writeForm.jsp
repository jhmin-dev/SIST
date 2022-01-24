<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
</head>
<body>
<div class="page-main">
	<h2>글쓰기</h2>
	<form id="register_form" action="write.do" method="post">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" size="30">
			</li>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name" size="10">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" size="12">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40" name="content" id="content"></textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="등록">
			<input type="button" value="목록" onclick="location.href = 'list.do';">
		</div>
	</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/validateLength.js"></script>
<script type="text/javascript">
	validateSubmit('register_form');

	validateBytesLength({
		title:150,
		name:30,
		passwd:12
	});
</script>
</body>
</html>
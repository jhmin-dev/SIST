<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<style type="text/css">
	hr {border-style: solid; color: gray;}
</style>
</head>
<body>
<div class="page-main">
	<h2>게시판 글 상세</h2>
	<ul>
		<li>
			<label>글 번호</label>
			${vo.num}
		</li>
		<li>
			<label>제목</label>
			${vo.title}
		</li>
		<li>
			<label>작성자</label>
			${vo.name}
		</li>
	</ul>
	<hr>
	<p>
		${vo.content}
	</p>
	<hr>
	<div class="align-right">
		작성일 : ${vo.reg_date}
		<input type="button" value="수정" onclick="location.href = 'modifyForm.do?num=${vo.num}';">
		<input type="button" value="삭제" onclick="location.href = 'deleteForm.do?num=${vo.num}';">
		<input type="button" value="목록" onclick="location.href = 'list.do';">
	</div>
</div>
</body>
</html>
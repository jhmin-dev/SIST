<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록 완료</title>
</head>
<body>
게시글 등록이 완료되었습니다.<br>
<br>
제목 : ${newArticleVO.title}<br>
내용 : ${newArticleVO.content}<br>
아이디 : ${newArticleVO.parentId}
</body>
</html>
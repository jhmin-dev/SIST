<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
<form action="s02_fileUpload.jsp" method="post" enctype="multipart/form-data"> <!-- 파일 업로드시 method를 post로 지정하지 않으면 파일의 경로와 이름만 전송되고 내용은 전송되지 않으며, enctype을 multipart/form-data로 지정하지 않으면 파일을 업로드해도 인식하지 못함 -->
	작성자 <input type="text" name="user"><br>
	제목 <input type="text" name="title"><br>
	파일명 <input type="file" name="uploadFile"><br>
	<input type="submit" value="파일 전송">
</form>
</body>
</html>
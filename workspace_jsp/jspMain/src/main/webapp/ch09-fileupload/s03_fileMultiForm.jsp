<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다중 업로드 예제</title>
</head>
<body>
<form action="s04_fileMultiUpload.jsp" method="post" enctype="multipart/form-data">
	이름 <input type="text" name="name"><br>
	제목 <input type="text" name="title"><br>
	이미지1 <input type="file" name="uploadFile1" accept="image/gif,image/png,image/jpeg"><br>
	이미지2 <input type="file" name="uploadFile2" accept="image/gif,image/png,image/jpeg"><br>
	<input type="submit" value="전송">	
</form>
</body>
</html>
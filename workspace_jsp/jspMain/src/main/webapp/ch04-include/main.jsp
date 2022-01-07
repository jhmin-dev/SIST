<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 디렉티브</title>
</head>
<body>
이미지 경로 : <%= img_path %><br> <%-- include한 jspf 코드는 같은 파일 내에 있는 코드로 인식되기 때문에, jspf에서 만든 변수를 직접 읽어올 수 있음 --%>
파일 경로 : <%= file_path %>
</body>
</html>
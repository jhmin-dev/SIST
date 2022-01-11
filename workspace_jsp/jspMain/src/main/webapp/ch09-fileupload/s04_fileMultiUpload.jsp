<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다중 업로드 처리</title>
</head>
<body>
<%
	String saveFolder = "/upload"; // 파일 업로드 경로
	String encType = "UTF-8"; // 인코딩 타입
	int maxSize = 5*1024*1024; // 최대 업로드 파일 크기
	// upload의 절대 경로
	String realFolder = application.getRealPath(saveFolder);
	
	// 파일 업로드를 하기 위해 MultipartRequest 객체 생성
	MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());	
	
	out.println("이름 : " + multi.getParameter("name") + "<br>");
	out.println("제목 : " + multi.getParameter("title") + "<br>");
	out.println("--------<br>");
	
	String img1 = multi.getFilesystemName("uploadFile1");
	String img2 = multi.getFilesystemName("uploadFile2");
%>
<%-- 파일명에 괄호, 공백 등 특수문자가 사용된 경우 퍼센트 인코딩해야 서버에서 파일을 불러올 수 있음; URLEncoder의 경우 공백을 +로 변환하므로 %20으로 일괄 치환 필요 --%>
<img src="/jspMain/upload/<%= URLEncoder.encode(img1, "UTF-8").replace("+", "%20") %>"><br>
<img src="/jspMain/upload/<%= URLEncoder.encode(img2, "UTF-8").replace("+", "%20") %>"><br>
</body>
</html>
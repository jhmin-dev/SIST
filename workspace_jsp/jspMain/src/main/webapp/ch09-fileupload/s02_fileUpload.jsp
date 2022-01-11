<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 처리</title>
</head>
<body>
<%
	// 파일 업로드 경로
	String saveFolder = "/upload";
	// 인코딩 타입
	String encType = "UTF-8";
	// 파일의 최대 업로드 사이즈
	int maxSize = 5*1024*1024; // 바이트 단위 

	// 파일 업로드 절대 경로 구하기
	String realFolder = application.getRealPath(saveFolder); // 다이나믹 웹 프로젝트에서는 이클립스가 publish하는 경로를 반환; C:/javaWork/workspace_jsp/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/jspMain/upload
	
	out.println("파일 업로드 절대 경로 : " + realFolder + "<br>");
	out.println("--------<br>");
	
	// 파일 업로드 작업을 위해서 MultipartRequest 객체 생성
	MultipartRequest multi = new MultipartRequest(request, // 파일 정보 제공
			realFolder, // 절대 경로
			maxSize, // 전송 전에 파일의 최대 업로드 사이즈를 초과하지 않는지 확인
			encType, // 인코딩 타입
			new DefaultFileRenamePolicy()); // 이미 업로드된 파일명과 동일한 파일명을 업로드하는 경우 덮어씌우지 않도록 파일명을 교체
	
	out.println("작성자 : " + multi.getParameter("user") + "<br>"); // enctype="multipart/form-data"으로 전송시 request 객체에서는 파라미터 값을 얻을 수 없음 
	out.println("제목 : " + multi.getParameter("title") + "<br>");
	out.println("--------<br>");
	
	// 파일 정보 처리
	// 전송된 원래의 파일명
	String original = multi.getOriginalFileName("uploadFile"); // 파라미터명(<input type="file"> 태그의 name 속성 값)을 전달
	// 서버에 저장된 파일명
	String filename = multi.getFilesystemName("uploadFile");
	// 전송된 파일의 컨텐트 타입
	String type = multi.getContentType("uploadFile");
	
	out.println("전송 전 원래의 파일명 : " + original + "<br>");
	out.println("서버에 저장된 파일명 : " + filename + "<br>");
	out.println("컨텐트 타입 : " + type + "<br>");
	
	// 파일의 용량 구하기
	File file = multi.getFile("uploadFile");
	out.println("파일의 용량 : " + file.length() + " bytes");
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/ch06-errorPage/error/viewErrorMessage.jsp" %> <%-- 생략시 에러가 발생하면 컨테이너가 만든 에러 페이지를 호출 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 출력</title>
</head>
<body>
name 파라미터 값 : <%= request.getParameter("name").toUpperCase() %> <%-- 없는 파라미터를 호출하면 null이 반환되는데, null에서 메서드를 호출하여 NPE를 발생시킴 --%>
</body>
</html>
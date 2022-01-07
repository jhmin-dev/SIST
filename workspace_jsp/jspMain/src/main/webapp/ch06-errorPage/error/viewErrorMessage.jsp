<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 발생</title>
</head>
<body>
요청 처리 과정에서 예외가 발생했습니다.<br>
빠른 시간 내에 문제를 해결하도록 하겠습니다.
<p> <!-- 단독 <p> 태그는 <br><br>과 같음 -->
에러 타입 : <%= exception.getClass().getName() %><br> <%-- exception 객체는 에러 페이지(isErrorPage="true")에서만 호출 가능 --%>
에러 메시지 : <b><%= exception.getMessage() %></b>
</body>
</html>
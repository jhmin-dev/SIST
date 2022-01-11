<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date time = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보</title>
</head>
<body>
세션 ID : <%= session.getId() %><br>

세션 생성 시간 : <%= session.getCreationTime() %><br> <%-- getCreationTime() 메서드는 1970년 1월 1일부터 세션 생성 시간까지의 경과 시간을 밀리초 단위, long 자료형의 값으로 반환 --%>
<%
	// long 자료형의 시간을 Date 객체가 표시하는 연, 월, 일, 시, 분, 초로 변환
	time.setTime(session.getCreationTime());
%>
세션 생성 시간 : <%= sf.format(time) %><br>

최근 접근 시간 : <%= session.getLastAccessedTime() %><br> <%-- getLastAccessedTime() 메서드는 1970년 1월 1일부터 세션 생성 시간까지의 경과 시간을 밀리초 단위, long 자료형의 값으로 반환 --%>
<%
	time.setTime(session.getLastAccessedTime());
%>
최근 접근 시간 : <%= sf.format(time) %><br>

세션 유지 시간 변경하기(기본값: 30분)<br>
<%
	// JSP 페이지 내에서 지정한 값은 web.xml에서 지정한 값보다 우선하며, 서버를 재시작하지 않아도 바로 적용됨
	session.setMaxInactiveInterval(60*20); // 초 단위로 지정
%>
세션 유지 시간 : <%= session.getMaxInactiveInterval() %>초
</body>
</html>
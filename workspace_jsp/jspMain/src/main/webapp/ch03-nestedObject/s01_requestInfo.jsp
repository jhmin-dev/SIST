<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클라이언트 및 서버 정보</title>
</head>
<body>
<%-- request는 HttpServletRequest 객체의 참조 변수 --%>
클라이언트의 IP : <%= request.getRemoteAddr() %><br> <%-- getRemoteAddr() 메서드는 요청을 보낸 클라이언트 혹은 마지막 프록시의 IP 주소를 IPv6 형식으로 반환하며, localhost로 접속시에는 실제 IP 주소가 아닌 0:0:0:0:0:0:0:1을 반환 --%>
요청 정보 프로토콜 : <%= request.getProtocol() %><br>
요청 정보 전송 방식 : <%= request.getMethod() %><br> <%-- URL로 요청했으므로 GET 방식 --%>
요청 URL(Uniform Resource Locator) : <%= request.getRequestURL() %><br> <%-- 전체 주소(=절대 주소) --%>
요청 URI(Uniform Resource Identifier) : <%= request.getRequestURI() %><br> <%-- Root를 생략한(=Context Root부터 시작하는) 부분 주소(=상대 주소) --%>
컨텍스트 경로 : <%= request.getContextPath() %><br>
서버 이름 : <%= request.getServerName() %><br>
서버 포트 : <%= request.getServerPort() %> <%-- 상용 서비스는 80이 기본이지만, Tomcat의 경우 테스트용으로 8080이 설정되어 있음 --%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 4개 기본 객체와 영역</title>
</head>
<body>
page 영역 msg1 = <%= pageContext.getAttribute("msg1") %><br> <%-- pageContext의 영역은 하나의 JSP 페이지와 일대일 대응; s14_scopeA와 별개의 페이지이므로 속성이 공유되지 않아 null 반환 --%>
request 영역 msg2 = <%= request.getAttribute("msg2") %><br> <%-- request의 영역은 하나의 JSP 페이지와 일대일 대응; s14_scopeA와 별개의 HTTP 요청이므로 속성이 공유되지 않아 null 반환; include, forward 액션 태그를 사용해서 영역 확장 가능 --%>
session 영역 msg3 = <%= session.getAttribute("msg3") %><br> <%-- session의 영역은 하나의 클라이언트(=브라우저)와 일대일 대응; s14_scopeA를 실행했던 브라우저가 종료되기 전까지는 속성이 공유되어 값을 반환; 브라우저 종료 후 재시작시 클라이언트가 변경된 것으로 인식됨 --%>
</body>
</html>
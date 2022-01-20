<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.web.member.UserVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- jar 파일에서 설정 정보를 읽어들여 JSTL 커스텀 태그를 사용할 수 있도록 함; uri는 실제 웹 주소가 아니라 태그 라이브러리의 식별자 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set 태그</title>
</head>
<body>
<c:set var="msg" value="봄" scope="page"/> <%-- var에 속성명, value에 속성값, scope에 저장 영역을 명시; scope 생략시 기본값은 page --%>
${pageScope.msg}, ${msg}<br>

<%
	UserVO user = new UserVO();
%>
<c:set var="user" value="<%= user %>"/> <%-- UserVO 객체를 page 영역의 속성에 저장 --%>
<c:set target="${user}" property="name" value="도로롱" /> <%-- EL로 저장된 객체를 읽어와 target으로 지정한 후 대상 객체의 프로퍼티에 값을 저장 --%>
회원 이름 : ${user.name}<br> <%-- 객체에 접근한 후 프로퍼티명을 명시하면 값을 읽어옴 --%>
회원 이름 : ${user.getName()} <%-- Tomcat의 상위 버전에서는 객체의 메서드 호출도 가능 --%>
</body>
</html>
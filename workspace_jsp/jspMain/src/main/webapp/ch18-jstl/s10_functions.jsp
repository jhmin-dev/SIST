<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <%-- functions 라이브러리 사용 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>functions 라이브러리</title>
</head>
<body>
<c:set var="str1" value=" Functions <태그>를 사용합니다. "/>
<c:set var="tokens" value="10,20,30,40"/>

문자열의 길이 : ${fn:length(str1)}<br>
문자열의 길이 : ${str1.length()}<br>
대문자로 변경 : ${fn:toUpperCase(str1)}<br>
대문자로 변경 : ${str1.toUpperCase()}<br>
소문자로 변경 : ${fn:toLowerCase(str1)}<br>
소문자로 변경 : ${str1.toLowerCase()}<br>
인덱스 3부터 6 전까지의 문자열 추출 : ${fn:substring(str1, 3, 6)}<br>
인덱스 3부터 6 전까지의 문자열 추출 : ${str1.substring(3, 6)}<br>
문자열에서 원래 문자를 지정한 문자로 대체 : ${fn:replace(str1," ", "-")}<br>
문자열에서 원래 문자를 지정한 문자로 대체 : ${str1.replace(" ", "-")}<br>
문자열에서 지정한 문자를 구분자로 문자열 잘라내기<br>
<c:forEach var="array" items="${fn:split(tokens,',')}">
	${array}<br>
</c:forEach>
</body>
</html>
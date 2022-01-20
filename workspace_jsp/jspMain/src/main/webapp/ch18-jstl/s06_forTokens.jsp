<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forTokens 태그</title>
</head>
<body>
<h4>쉼표와 점을 구분자로 사용</h4>
<c:forTokens var="token" items="붉은색,주황색.노란색.초록색,파란색,남색.보라색" delims=",."> <%-- StringTokenizer 역할 --%>
	${token}<br>
</c:forTokens>

<h4>날짜를 연월일시분초로 구분해서 출력</h4>
<c:forTokens var="now" items="2022-01-20 15:11:05" delims="- :"> <%-- 공백의 경우 delims에 명시하지 않더라도 기본적으로 구분자로 사용됨 --%>
	${now}<br>
</c:forTokens>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if 태그</title>
</head>
<body>
<%-- if 태그는 단일 if문만 지원하며 if~else나 다중 if문을 지원하지 않음 --%>
<c:if test="true"> <%-- test에 if문의 조건식을 명시 --%>
항상 수행<br> <%-- 태그로 영역을 분리하고 있기 때문에, 영역 내에 다른 태그도 사용 가능 --%>
</c:if>

<c:if test="${param.name == 'sleepy'}"> <%-- 조건식에 EL의 비교 연산자 사용; 큰따옴표 안에 문자열로 EL을 전달하고 있기 때문에, EL 내에서 문자열 사용시에는 작은따옴표를 사용 --%>
name 파라미터의 값이 ${param.name} 입니다.<br>
</c:if>

<c:if test="${param.name.equals('sleepy')}"> <%-- Tomcat의 상위 버전에서는 (비교 연산자 대신) equals() 메서드 호출 가능 --%>
name 파라미터의 값이 ${param.name} 입니다.<br>
</c:if>

<c:if test="${param.age>= 20}">
당신의 나이는 20세 이상입니다.
</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formatNumber 태그</title>
</head>
<body>
숫자 : <fmt:formatNumber value="10000" type="number"/><br> <%-- 세 자리 단위로 쉼표 삽입 --%>
통화 : <fmt:formatNumber value="10000" type="currency" currencySymbol="$"/><br>
통화 : <fmt:formatNumber value="10000" type="currency" currencySymbol="\\"/><br> <%-- 원 표시 \는 1개만 사용시 특수문자로 취급되어 에러가 발생하므로, \를 2개 사용하여 일반문자로 변환 --%>
퍼센트 : <fmt:formatNumber value="0.3" type="percent"/><br>
패턴 : <fmt:formatNumber value="12.345" pattern="0000.00"/> <%-- 소수점 이상의 0 갯수는 자릿수보다 적은 경우 원래 값대로, 자릿수보다 많은 경우 0을 앞에 붙이며, 소수점 이하의 0 갯수는 자릿수보다 적은 경우 반올림 처리하고, 자릿수보다 많은 경우 0을 뒤에 붙임 --%>
</body>
</html>
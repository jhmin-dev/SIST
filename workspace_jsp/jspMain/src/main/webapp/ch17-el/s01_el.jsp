<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<table border="1">
	<tr>
		<th>표현식</th>
		<th>값</th>
	</tr>
	<tr>
		<td>\${2 + 5}</td> <%-- $ 앞에 \를 붙여 EL 표현식을 그대로 출력 --%>
		<td>${2 + 5}</td> <%-- EL 표현식의 연산 결과를 출력 --%>
	</tr>
	<tr>
		<td>\${"10" + 2}</td>
		<td>${"10" + 2}</td> <%-- 문자열과 숫자를 + 연산시, 연결하는 대신 문자열을 숫자로 parsing해서 덧셈 수행 --%>
	</tr>
	<tr>
		<td>\${"10" + "2"}</td>
		<td>${"10" + "2"}</td> <%-- 문자열을 숫자로 parsing해서 덧셈 수행 --%>
	</tr>
	<tr>
		<td>\${"십" + 5}</td>
		<td>에러 발생</td> <%-- 문자열을 숫자로 parsing하는 데 실패하여 NumberFormatException 발생 --%>
	</tr>
	<tr>
		<td>\${4 / 5}</td>
		<td>${4 / 5}</td> <%-- 정수끼리 연산하더라도 실수 몫을 반환 --%>
	</tr>
</table>
</body>
</html>
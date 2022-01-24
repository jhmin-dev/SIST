<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>
결과 : <%= request.getAttribute("result") %><br> <%-- result 속성은 Servlet에서 만들기 때문에 JSP 직접 호출시에는 null이 반환됨 --%>
결과 : ${result} <%-- result가 유일하기 때문에 영역 명시하지 않고 속성명만 명시해도 의도대로 request 영역의 result가 호출됨 --%>
</body>
</html>
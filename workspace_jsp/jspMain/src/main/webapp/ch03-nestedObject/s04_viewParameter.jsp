<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 출력</title>
</head>
<body>
<h3>request.getParameter() 메서드 사용</h3>
name 파라미터 = <%= request.getParameter("name") %><br>
address 파라미터 = <%= request.getParameter("address") %><br>
	
<h3>request.getParameterValues() 메서드 사용</h3>
<%
	String[] values = request.getParameterValues("pet");
	if(values!=null) { // 체크박스의 경우 선택하지 않으면 파라미터가 아예 전송되지 않으므로 배열로 처리시 NPE가 발생할 수 있음
		for(int i=0;i<values.length;i++) { // for 시작
%>
		<%= values[i] %>
<%
		} // for 끝
	}
%>
</body>
</html>
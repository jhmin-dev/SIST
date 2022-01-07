<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습</title>
</head>
<body>
<!-- 
구매 금액이 30만원 미만이면 배송비 5천원 추가
[출력 예시]
이름 : 
주문 날짜 : 
구입 내용 : 
배송비 : 
총 구매 비용(배송비 포함):  
 -->
<h2>구매 내역</h2>
이름 : <%= request.getParameter("name") %><br>
주문 날짜 : <%= request.getParameter("order_date") %><br>
<%
	// 가격 정보
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	map.put("가방", 200000);
	map.put("신발", 100000);
	map.put("옷", 50000);
	map.put("식사권", 150000);
	
	// 배송비
	int delivery_fee = 5000;
 %>
구입 내용 : 
<%
	String[] items = request.getParameterValues("item");
	int sum = 0;
	if(items!=null) {
		for(int i=0;i<items.length;i++) {
			// 구매 비용 누적
			sum += map.get(items[i]);
			if(i>0) out.println(",");
%>
			<%= items[i] %>
<%
		} // end of for
		if(sum<300000) sum += delivery_fee;
		else delivery_fee = 0;
%>
		<br>
		배송비 : <%= String.format("%,d원", delivery_fee) %><br> <%-- String의 format() 메서드를 이용해 세 자리마다 쉼표 찍기 --%>
		총 구매 비용(배송비 포함) : <%= String.format("%,d원", sum) %><br>
<%
	} // end of if
%>
</body>
</html>
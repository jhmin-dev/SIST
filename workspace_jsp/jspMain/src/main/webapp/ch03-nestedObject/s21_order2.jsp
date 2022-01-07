<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습</title>
</head>
<body>
<!-- 
[실습 문제] 짜장면 4,000원, 짬뽕 5,000원, 볶음밥 6,000원
[출력 예시]
[주문 음식]
짜장면 2개
짬뽕 1개
총 지불 금액 : 13,000원
 -->
<h2>주문서 확인</h2>

<%
	// 전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");
	
	int[] orderArray = {4000, 5000, 6000};
	
	int total = 0;
	String orderName = "";
	
	int food_c0 = Integer.parseInt(request.getParameter("food_c0"));
	int food_c1 = Integer.parseInt(request.getParameter("food_c1"));
	int food_c2 = Integer.parseInt(request.getParameter("food_c2"));

	if(food_c0>0) {
		total += orderArray[0] * food_c0;
		orderName += "짜장면 " + food_c0 + "개<br>";
	}
	if(food_c1>0) {
		total += orderArray[1] * food_c1;
		orderName += "짬뽕 " + food_c1 + "개<br>";
	}
	if(food_c2>0) {
		total += orderArray[2] * food_c2;
		orderName += "볶음밥 " + food_c2 + "개<br>";
	}
%>
[주문 음식]<br>
<%= orderName %>
총 지불 금액 : <%= String.format("%,d원", total) %>

<%--
<%
	String[] food = {"짜장면", "짬뽕", "볶음밥"};
	int[] price = {4000, 5000, 6000};
	int[] count = new int[food.length];
	for(int i=0;i<count.length;i++) {
		count[i] = Integer.parseInt(request.getParameter("food_c" + i));
	}
%>
[주문 음식]<br>
<%
	int sum = 0;
	for(int i=0;i<count.length;i++) {
		if(count[i]>0) {
%>
<%= food[i] %> <%= count[i] %>개<br>
<%
		}
		sum += price[i] * count[i];
	}
%>
총 지불 금액 : <%= String.format("%,d원", sum) %>
 --%>
</body>
</html>
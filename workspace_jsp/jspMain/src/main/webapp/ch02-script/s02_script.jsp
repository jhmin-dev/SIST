<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습</title>
</head>
<body>
<%--
[실습 문제]
배열 생성(score) 국어, 수학, 영어
[출력 예시]
국어 : 88
수학 : 99
영어 : 86
총점 : 273
평균 : 91
 --%>
<%!
	String[] subject = {"국어", "수학", "영어"};
	int[] score = {88, 99, 86};
	// int sum = 0, avg = 0; // 변수를 선언부에서 선언하면 서블릿에서 멤버 변수로 만들어져 HTML 요청(새로고침 등)이 반복될 때 변수의 값이 계속 유지됨; 즉, 두 번째 요청시 sum의 값이 273인 상태에서 다시 한 번 for문을 수행하므로 요청시마다 값이 계속해서 증가
%>
<%
	int sum = 0, avg = 0; // 변수를 스크립트릿에서 선언하면 서블릿에서 service() 메서드의 지역 변수로 만들어져 HTML 요청시마다 변수가 새로 생성 및 초기화됨
	for(int i=0;i<score.length;i++) {
		sum += score[i]; // 총점 구하기
%>
<%= subject[i] %> : <%= score[i] %><br> <%-- 과목명과 점수 출력 --%>
<%
	}
	avg = sum/score.length; // 평균 구하기
%>
<%--
국어 : <%= score[0] %><br>
수학 : <%= score[1] %><br>
영어 : <%= score[2] %><br>
 --%>
총점 : <%= sum %><br>
평균 : <%= avg %>
</body>
</html>
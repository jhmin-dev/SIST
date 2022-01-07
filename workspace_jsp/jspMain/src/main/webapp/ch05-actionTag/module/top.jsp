<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%-- 한글이 포함되면 반드시 page 디렉티브로 인코딩 방식을 설정해야 함 --%>
<%-- 다른 페이지에 삽입될 것이므로 전체적인 <HTML> 구조는 중복되지 않게 삭제해야 함 --%>
<% String company = request.getParameter("company"); %>
<b><%= company %></b>
상단 메뉴 :
<a href="#">HOME</a>
<a href="#">INFO</a>
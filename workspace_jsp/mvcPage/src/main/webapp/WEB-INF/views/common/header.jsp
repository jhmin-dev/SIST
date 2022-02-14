<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- header 시작 -->
<h1 class="align-center"><a href="${pageContext.request.contextPath}/main/main.do">회원제 게시판</a></h1> <%-- 메뉴는 여러 파일에 include되기 때문에 상대 경로 대신 Context Path부터의 경로를 명시해야 함 --%>
<div class="align-right">
	<c:if test="${!empty user_num && !empty user_photo}"> <%-- EL의 empty 연산자는 객체가 null이거나 값이 비어 있는지 여부를 확인 --%>
		<img src="${pageContext.request.contextPath}/upload/${user_photo}" width="25" height="25" class="my-photo">
	</c:if>
	<c:if test="${!empty user_num && empty user_photo}">
		<img src="${pageContext.request.contextPath}/images/face.png" width="25" height="25" class="my-photo">
	</c:if>
	<a href="${pageContext.request.contextPath}/item/itemList.do">상품 목록</a>
	<a href="${pageContext.request.contextPath}/board/list.do">게시판</a>
	<c:if test="${!empty user_num}">
		[<span>${user_id}</span>]
		<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
	</c:if>
	<c:if test="${empty user_num}">
		<a href="${pageContext.request.contextPath}/member/registerUserForm.do">회원 가입</a>
		<a href="${pageContext.request.contextPath}/member/loginForm.do">로그인</a>
	</c:if>
	<c:if test="${!empty user_num && user_auth == 2}">
		<a href="${pageContext.request.contextPath}/member/myPage.do">MY페이지</a>
	</c:if>
	<c:if test="${!empty user_num && user_auth == 3}">
		<a href="${pageContext.request.contextPath}/member/memberList.do">회원 관리</a>
		<a href="${pageContext.request.contextPath}/item/list.do">상품 관리</a>
	</c:if>
</div>
<!-- header 끝 -->
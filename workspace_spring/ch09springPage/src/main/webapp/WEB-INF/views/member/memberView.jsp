<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main">
	<h2>프로필 사진</h2>
	<h2>회원 상세 정보</h2>
	<ul>
		<li>이름 : ${member.name}</li>
		<li>전화번호 : ${member.phone}</li>
		<li>이메일 : ${member.email}</li>
		<li>우편번호 : ${member.zipcode}</li>
		<li>주소 : ${member.address1}</li>
		<li>상세 주소 : ${member.address2}</li>
		<li>가입일 : ${member.reg_date}</li>
		<c:if test="${!empty member.modify_date}">
		<li>최근 정보 수정일 : ${member.modify_date}</li>
		</c:if>
	</ul>
	<hr size="1" width="100%" noshade>
	<p class="align-right">
		<input type="button" value="회원 정보 수정" onclick="location.href = 'update.do';">
		<input type="button" value="비밀번호 변경" onclick="location.href = 'changePassword.do';">
		<input type="button" value="회원 탈퇴" onclick="location.href = 'delete.do';">
	</p>
</div>
<!-- 중앙 컨텐츠 끝 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		
	});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h2>회원 정보</h2>
	<div class="mypage-div">
		<h3>프로필 사진</h3>
		<ul>
			<li>
				<c:if test="${empty member.photo}">
				<img src="${pageContext.request.contextPath}/images/face.png" width="200" height="200" class="my-photo">
				</c:if>
				<c:if test="${!empty member.photo}">
				<img src="${pageContext.request.contextPath}/upload/${member.photo}" width="200" height="200" class="my-photo">
				</c:if>
			</li>
			<li>
				<div class="align-center">
					<input type="button" value="수정" id="photo_btn">
				</div>
				<div id="photo_choice" style="display: none;">
					<input type="file" id="photo" accept="image/gif, image/png, image/jpeg">
					<input type="button" value="전송" id="photo_submit">
					<input type="button" value="취소" id="photo_reset">
				</div>
			</li>
		</ul>
		<h3>회원 탈퇴</h3>
		<ul>
			<li>
				<input type="button" value="회원 탈퇴" onclick="location.href = 'deleteUserForm.do';"> <%-- myPage.do와 같은 폴더에 있으므로 Context Path 생략 가능 --%>
			</li>
		</ul>
	</div>
	<div class="mypage-div">
		<h3>연락처</h3>
		<ul>
			<li>
				이름 : ${member.name}
			</li>
			<li>
				전화번호 : ${member.phone}
			</li>
			<li>
				이메일 : ${member.email}
			</li>
			<li>
				우편번호 : ${member.zipcode}
			</li>
			<li>
				주소 : ${member.address1} ${member.address2}
			</li>
			<li>
				가입일 : ${member.reg_date}
			</li>
			<c:if test="${!empty member.modify_date}">
			<li>
				최근 정보 수정일 : ${member.modify_date}
			</li>
			</c:if>
			<li>
				<input type="button" value="연락처 수정" onclick="location.href = 'modifyUserForm.do';">
			</li>
		</ul>
		<h3>비밀번호 수정</h3>
		<ul>
			<li>
				<input type="button" value="비밀번호 수정" onclick="location.href = 'modifyPasswordForm.do';">
			</li>
		</ul>
	</div>
</div>
</body>
</html>
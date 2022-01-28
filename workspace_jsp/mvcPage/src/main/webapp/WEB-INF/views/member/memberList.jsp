<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#search_form').submit(function() {
			if($('#keyword').val().trim()=='') {
				alert('검색어를 입력하세요!');
				$('#keyword').val('').focus();
				return false;
			}
		}); // end of submit
	});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h2>회원 목록 (관리자 전용)</h2>
	<form id="search_form" action="memberList.do" method="get"> <%-- 검색 결과를 링크할 수 있도록 하기 위해 GET 방식 사용; 모델 클래스에서 인코딩 처리 불필요 --%>
		<ul class="search">
			<li>
				<select name="keyfield"> <%-- 검색할 컬럼 --%>
					<option value="1">아이디</option>
					<option value="2">이름</option>
					<option value="3">이메일</option>
				</select>
			</li>
			<li>
				<input type="search" size="16" name="keyword" id="keyword"> <%-- 검색할 값 --%>
			</li>
			<li>
				<input type="submit" value="검색">
			</li>
		</ul>
	</form>
	<div class="list-space align-right">
		<input type="button" value="목록" onclick="location.href = 'memberList.do';">
		<input type="button" value="홈으로" onclick="location.href = '${pageContext.request.contextPath}/main/main.do';">
	</div>
	<c:if test="${count==0}">
	<div class="result-display">
		표시할 내용이 없습니다.
	</div>
	</c:if>
	<c:if test="${count>0}">
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>가입일</th>
			<th>등급</th>
		</tr>
		<c:forEach var="member" items="${list}">
		<tr>
			<td>
				<c:if test="${member.auth>0}">
				<a href="detailUserForm.do?mem_num=${member.mem_num}">${member.id}</a>
				</c:if>
				<c:if test="${member.auth==0}"> <%-- 탈퇴 회원의 경우 변경 가능한 정보가 없으므로 링크 비활성화 --%>
				${member.id}
				</c:if>
			</td>
			<td>${member.name}</td>
			<td>${member.email}</td>
			<td>${member.phone}</td>
			<td>${member.reg_date}</td>
			<td>
				<c:if test="${member.auth==0}">탈퇴</c:if>
				<c:if test="${member.auth==1}">정지</c:if>
				<c:if test="${member.auth==2}">일반</c:if>
				<c:if test="${member.auth==3}">관리자</c:if>
			</td>
		</tr>
		</c:forEach>	
	</table>
	<div class="align-center">
		${pagingHtml}
	</div>
	</c:if>
</div>
</body>
</html>
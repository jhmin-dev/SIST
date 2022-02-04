<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<style type="text/css">
	hr {border-style: solid; color: gray;}
</style>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h2>게시판 글 상세</h2>
	<ul>
		<li>
			<label>글 번호</label>
			${board.board_num}
		</li>
		<li>
			<label>글 제목</label>
			${board.title}
		</li>
		<li>
			<label>작성자</label>
			${board.id}
		</li>
		<li>
			<label>조회수</label>
			${board.hit}
		</li>
	</ul>
	<hr>
	<c:if test="${!empty board.filename}">
	<div class="align-center">
		<img src="${pageContext.request.contextPath}/upload/${board.filename}" class="detail-img">
<script type="text/javascript">
	let img = document.getElementsByClassName('detail-img')[0];
	img.src = encodeURI(decodeURI(img.src)); // 파일명에 괄호, 공백 등 특수문자가 사용된 경우 불러오지 못함; encodeURI만 사용하면 %20이 %2520으로 이중 인코딩되므로 이를 해결하기 위해 decodeURI를 먼저 사용; decodeURI만 사용하면 한글 파일명을 불러오지 못함
</script>
	</div>
	</c:if>
	<p>
		${board.content}
	</p>
	<hr>
	<div class="align-right">
		<c:if test="${!empty board.modify_date}">
		최근 수정일 : ${board.modify_date}
		</c:if>
		작성일 : ${board.reg_date}
		<%-- 로그인한 회원 번호와 작성자 회원 번호가 일치해야 수정, 삭제 가능 --%>
		<c:if test="${user_num==board.mem_num}">
		<input type="button" value="수정" onclick="location.href = 'updateForm.do?board_num=${board.board_num}';">
		<input type="button" value="삭제" id="delete_btn">
<script type="text/javascript">
	let delete_btn = document.getElementById('delete_btn');
	delete_btn.onclick = function() {
		let choice = confirm('삭제하시겠습니까?');
		if(choice) {
			location.replace = 'delete.do?board_num=${board.board_num}'; // 삭제 후 뒤로가기 방지
		}
	};
</script>
		</c:if>
		<input type="button" value="목록" onclick="location.href = 'list.do';">
	</div>
</div>
</body>
</html>
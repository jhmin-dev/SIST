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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/board-reply.js"></script>
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
			location.replace('delete.do?board_num=${board.board_num}'); // 삭제 후 뒤로가기 방지
		}
	};
</script>
		</c:if>
		<input type="button" value="목록" onclick="location.href = 'list.do';">
	</div>
	<!-- 댓글 시작 -->
	<div id="reply_div">
		<span class="re-title">댓글 달기</span>
		<form id="re_form">
			<input type="hidden" name="board_num" value="${board.board_num}" id="board_num">
			<textarea rows="3" cols="50" name="re_content" id="re_content" class="rep-content" <c:if test="${empty user_num}">disabled</c:if>><c:if test="${empty user_num}">로그인해야 작성할 수 있습니다.</c:if></textarea>
			<c:if test="${!empty user_num}">
			<div id="re_first">
				<span class="letter-count">300/300</span>
			</div>
			<div id="re_second" class="align-right">
				<input type="submit" value="전송">
			</div>
			</c:if>
		</form>
	</div>
	<!-- 댓글 목록 출력 시작 -->
	<div id="output"></div>
	<div class="paging-button" style="display: none;">
		<input type="button" value="다음 댓글 보기">
	</div>
	<div class="loading" style="display: none;">
		<img src="${pageContext.request.contextPath}/images/ajax-loader.gif">
	</div>
	<!-- 댓글 목록 출력 끝 -->
	<!-- 댓글 끝 -->
</div>
</body>
</html>
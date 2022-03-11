<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 중앙 컨텐츠 시작 -->
<div class="page-main">
	<h2>${board.title}</h2>
	<ul>
		<li>번호 : ${board.board_num}</li>
		<li>작성자 : ${board.id}</li>
		<li>조회수 : ${board.hit}</li>
		<c:if test="${!empty board.modify_date}">
		<li>최근 수정일 : ${board.modify_date}</li>
		</c:if>
		<li>작성일 : ${board.reg_date}</li>
		<c:if test="${!empty board.filename}">
		<li>첨부 파일 : <a href="file.do?board_num=${board.board_num}">${board.filename}</a></li>
		</c:if>
	</ul>
	<hr size="1" width="100%" noshade>
	<c:if test="${fn:endsWith(board.filename, '.jpg') ||
				fn:endsWith(board.filename, '.JPG') ||
				fn:endsWith(board.filename, '.png') ||
				fn:endsWith(board.filename, '.PNG') ||
				fn:endsWith(board.filename, '.gif') ||
				fn:endsWith(board.filename, '.GIF')}">
	<div class="align-center">
		<img src="imageView.do?board_num=${board.board_num}" style="max-width: 500px">
	</div>
	</c:if>
	<p>
		${board.content}
	</p>
	<hr size="1" width="100%" noshade>
	<div class="align-right">
		<c:if test="${!empty user_num && user_num==board.mem_num}">
		<input type="button" value="수정" onclick="location.href = 'update.do?board_num=${board.board_num}';">
		<input type="button" value="삭제" id="delete_btn">
		<script type="text/javascript">
			let delete_btn = document.getElementById('delete_btn');
			delete_btn.onclick = function() {
				let choice = confirm('삭제하시겠습니까?');
				if(choice) {
					location.replace('delete.do?board_num=${board.board_num}');
				}
			};
		</script>
		</c:if>
		<input type="button" value="목록" onclick="location.href = 'list.do';">
	</div>
</div>
<!-- 중앙 컨텐츠 끝 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<style type="text/css">
	hr {border-style: solid; color: gray;}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#update_form').submit(function() {
			if($('#title').val().trim()=='') {
				alert('제목을 입력하세요!');
				$('#title').val('').focus();
				return false;
			}
			if($('#content').val().trim()=='') {
				alert('내용을 입력하세요!');
				$('#content').val('').focus();
				return false;
			}			
		}); // end of submit
		
		$('#filename').change(function() {
			let file = this.files[0];
			if(file.size>5*1024*1024) {
				alert('5MB까지만 업로드 가능합니다!');
				$(this).val('');
			}
		}); // end of change		
	});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h2>글 수정</h2>
	<form action="update.do" method="post" enctype="multipart/form-data" id="update_form">
		<input type="hidden" name="board_num" value="${board.board_num}">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" value="${board.title}" maxlength="50">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="30" name="content" id="content">${board.content}</textarea>
			</li>
			<li>
				<label for="filename">파일</label>
				<input type="file" name="filename" id="filename" accept="image/jpeg, image/png, image/gif">
				<c:if test="${!empty board.filename}">
				<br>
				<span id="file_detail">
					(${board.filename}) 파일이 등록되어 있습니다.
					파일을 새로 업로드하면 기존 파일은 삭제됩니다.
					<input type="button" value="파일 삭제" id="file_del">
				</span>
<script type="text/javascript">
	$('#file_del').click(function() {
		let choice = confirm('삭제하시겠습니까?');
		if(choice) {
			$.ajax({
				url:'deleteFile.do',
				type:'post',
				data:{board_num:${board.board_num}}, // JavaScript를 외부 파일(.js)로 삽입하는 경우 EL 표기법 사용 불가하므로 주의
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(param) {
					if(param.result=='logout') {
						alert('로그인 후 사용하세요!');
					}
					else if(param.result=='success') {
						$('#file_detail').hide();
					}
					else if(param.result=='worngAccess') {
						alert('잘못된 접근입니다!');
					}
					else {
						alert('파일 삭제 오류 발생!');
					}
				},
				error:function() {
					alert('네트워크 오류 발생!');
				}
			}); // end of ajax
		}
	});
</script>
				</c:if>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="목록" onclick="location.href = 'list.do';">
		</div>
	</form>
</div>
</body>
</html>
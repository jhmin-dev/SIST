<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#write_form').submit(function() {
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
	<h2>게시판 글쓰기</h2>
	<form id="write_form" action="write.do" method="post" enctype="multipart/form-data">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" maxlength="50">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40" name="content" id="content"></textarea>
			</li>
			<li>
				<label for="filename">첨부 이미지</label>
				<input type="file" name="filename" id="filename" accept="image/jpeg, image/png, image/gif">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="등록">
			<input type="button" value="목록" onclick="location.href = 'list.do';">
		</div>
	</form>
</div>
</body>
</html>
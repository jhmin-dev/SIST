<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 등록</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript">
	window.onload = function() {
		var myForm = document.getElementById('myForm');
		// 이벤트 연결
		myForm.onsubmit = function() {

			var name = document.getElementById('name');
			if(name.value.trim()=='') {
				alert('이름을 입력하세요!');
				name.focus();
				name.value = '';
				return false;
			}
			var title = document.getElementById('title');
			if(title.value.trim()=='') {
				alert('이름을 입력하세요!');
				title.focus();
				title.value = '';
				return false;
			}
			var passwd = document.getElementById('passwd');
			if(passwd.value.trim()=='') {
				alert('이름을 입력하세요!');
				passwd.focus();
				passwd.value = '';
				return false;
			}
			var content = document.getElementById('content');
			if(content.value.trim()=='') {
				alert('이름을 입력하세요!');
				content.focus();
				content.value = '';
				return false;
			}
			/*
			list = document.getElementsByTagName('li');
			for(let i=0;i<list.length;i++) {
				let input = list[i].querySelector('input,textarea');
				if(input.value.trim()=='') {
					alert(list[i].querySelector('label').innerHTML + '을/를 입력하세요!');
					input.focus();
					input.value = '';
					return false;
				}
			}
			*/
		};
	};
</script>
</head>
<body>
<div class="page-main">
	<h2>글쓰기</h2>
	<form id="myForm" action="insertTest.jsp" method="post">
		<ul>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name" size="20" maxlength="10"> <!-- 관리하기 편하게 식별자를 SQL 테이블의 컬럼명과 통일시킴 -->
			</li>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" size="30" maxlength="50">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" size="20" maxlength="10">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40" name="content" id="content"></textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="목록" onclick="location.href='selectTest.jsp'">
		</div>
	</form>
</div>
</body>
</html>
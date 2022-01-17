<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('write_form').onsubmit = function() {
			let list = document.getElementsByTagName('li');
			for(let i=0;i<list.length;i++) {
				let input = list[i].querySelector('input,textarea');
				input.value = input.value.trim();
				if(!input.value) {
					let word = list[i].querySelector('label').textContent;
					let post = (word.charCodeAt(word.length-1) - '가'.charCodeAt(0)) % 28 > 0 ? '을' : '를';
					alert(word + post + ' 입력하세요!');
					input.focus();
					return false;
				}
			}
		};
	};
</script>
</head>
<body>
<div class="page-main">
	<h1>글쓰기</h1>
	<form id="write_form" action="write.jsp" method="post">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" size="30" maxlength="50">
			</li>
			<li>
				<label for="name">작성자</label>
				<input type="text" name="name" id="name" size="10" maxlength="10">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" size="10" maxlength="12">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40" name="content" id="content"></textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="글쓰기">
			<input type="button" value="목록" onclick="location.href = 'list.jsp';">
		</div>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		var count = 0;
		
		$('#confirm_id').click(function() {
			if($('#id').val().trim()=='') {
				alert('아이디를 입력하세요!');
				$('#id').val('').focus();
				return;
			}
			
			// 서버 연동
			$.ajax({
				url:'confirmId.jsp',
				type:'post',
				data:{id:$('#id').val()},
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(param) {
					if(param.result=='idDuplicated') {
						count = 0;
						$('#id_signed').text('아이디 중복').css('color', 'red');
						$('#id').val('').focus();
					}
					else if(param.result=='idNotFound') {
						count = 1;
						$('#id_signed').text('사용 가능한 아이디').css('color', 'black');
					}
					else { // 정상적인 값이 아닌 경우
						count = 0;
						alert('오류 발생!');
					}
				},
				error:function() {
					count = 0;
					alert('네트워크 에러 발생!');
				}
			}); // end of ajax
		}); // end of click
		
		$('#register_form #id').keyup(function() {
			count = 0;
			$('#id_signed').text('');
		}); // end of keyup
		
		$('#register_form').submit(function() {
			if($('#id').val().trim()=='') {
				alert('아이디를 입력하세요!');
				$('#id').val('').focus();
				return false;
			}
			
			if(count==0) {
				alert('아이디 중복 체크 필수!');
				return false;
			}
			
			if($('#name').val().trim()=='') {
				alert('이름을 입력하세요!');
				$('#name').val('').focus();
				return false;
			}
			
			if($('#passwd').val().trim()=='') {
				alert('비밀번호를 입력하세요!');
				$('#passwd').val('').focus();
				return false;
			}
			
			if($('#email').val().trim()=='') {
				alert('이메일을 입력하세요!');
				$('#email').val('').focus();
				return false;
			}
		}); // end of submit
	});
</script>
</head>
<body>
<div class="page-main">
	<h1>회원 가입</h1>
	<form action="registerUser.jsp" method="post" id="register_form">
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id" size="7" maxlength="12">
				<input type="button" id="confirm_id" value="중복 확인">
				<span id="id_signed"></span>
			</li>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name" maxlength="10">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" maxlength="12">
			</li>
			<li>
				<label for="email">이메일</label>
				<input type="email" name="email" id="email" maxlength="50">
			</li>
			<li>
				<label for="phone">전화번호</label>
				<input type="text" name="phone" id="phone" maxlength="15">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="등록">
			<input type="button" value="홈으로" onclick="location.href = 'main.jsp';">
		</div>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#password_form').submit(function() {
			let isValid = true; // submit()의 return 값 지정
			
			$('li').each(function() {
				let input = $(this).find('input');
				if(!input.val().trim()) {
					let word = $(this).find('label').text();
					let post = (word.charCodeAt(word.length-1) - '가'.charCodeAt(0)) % 28 > 0 ? '을' : '를';
					alert(word + post + ' 입력하세요!');
					input.val('').focus();
					isValid = false; // submit()의 return 값 지정
					return false; // each() 루프 중단
				}
			}); // end of each
					
			if($('#passwd').val()!=$('#cpasswd').val()) {
				if(isValid) alert('새 비밀번호와 새 비밀번호 확인이 불일치합니다!');
				$('#cpasswd').val('').focus();
				isValid = false; // submit()의 return 값 지정;
			}

			return isValid;
		}); // end of submit
		
		// 새 비밀번호 확인까지 명시한 후 다시 새 비밀번호를 수정하려고 하면 새 비밀번호 확인을 초기화
		$('#passwd').keyup(function() {
			$('#cpasswd').val('');
			$('#message_cpasswd').text('');
		}); // end of keyup
		
		// 새 비밀번호와 새 비밀번호 확인 일치 여부 체크
		$('#cpasswd').keyup(function() {
			if($('#passwd').val()==$('#cpasswd').val()) {
				$('#message_cpasswd').text('새 비밀번호 일치');
			}
			else {
				$('#message_cpasswd').text('');
			}
		}); // end of keyup
	});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h2>비밀번호 수정</h2>
	<form action="modifyPassword.do" method="post" id="password_form">
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id" maxlength="12">
			</li>
			<li>
				<label for="origin_passwd">현재 비밀번호</label>
				<input type="password" name="origin_passwd" id="origin_passwd" maxlength="12">
			</li>
			<li>
				<label for="passwd">새 비밀번호</label>
				<input type="password" name="passwd" id="passwd" maxlength="12">
			</li>
			<li>
				<label for="cpasswd">새 비밀번호 확인</label>
				<input type="password" name="cpasswd" id="cpasswd" maxlength="12">
				<span id="message_cpasswd"></span>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="비밀번호 수정">
			<input type="button" value="MyPage" onclick="location.href='myPage.do';">
		</div>
	</form>
</div>
</body>
</html>
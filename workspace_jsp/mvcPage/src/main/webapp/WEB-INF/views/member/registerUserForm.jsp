<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		let idChecked = 0;
		
		// 아이디 중복 체크
		$('#id_check').click(function name() {
			if($('#id').val().trim()=='') {
				alert('아이디를 입력하세요!');
				$('#id').val('').focus();
				return;
			}
			
			$.ajax({
				url:'checkId.do',
				type:'post',
				data:{id:$('#id').val()},
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(param) {
					if(param.result=='idNotFound') {
						idChecked = 1;
						$('#message_id').css('color', '#000').text('아이디 사용 가능');
					}
					else if(param.result=='idDuplicated') {
						idChecked = 0;
						$('#message_id').css('color', 'red').text('아이디 중복');
					}
					else {
						idChecked = 0;
						alert('아이디 중복 체크 오류 발생!');
					} 
				},
				error:function() {
					idChecked = 0;
					alert('네트워크 오류 발생!');
				}
			}); // end of ajax
			
		}); // end of click
		
		// 아이디 중복 안내 메시지 초기화 및 아이디 중복 여부 초기화
		$('#register_form #id').keyup(function() {
			idChecked = 0;
			$('#message_id').text('');
		});
		
		// 회원 정보 등록 유효성 체크
		$('#register_form').submit(function() {
			let isValid = true; // submit()의 return 값 지정
			
			$('li').each(function() {
				let input = $(this).find('input[type!="button"]'); // button이 아닌 <input> 태그들만 선택
				if(!input.val().trim()) {
					let word = $(this).find('label').text();
					let post = (word.charCodeAt(word.length-1) - '가'.charCodeAt(0)) % 28 > 0 ? '을' : '를';
					alert(word + post + ' 입력하세요!');
					input.val('').focus();
					isValid = false; // submit()의 return 값 지정
					return false; // each() 루프 중단
				}
			}); // end of each
			
			if(idChecked==0) {
				if(isValid) alert('아이디 중복 체크 필수!');
				return false;
			}
			
			return isValid;
		});
	});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h2>회원 가입</h2>
	<form id="register_form" action="registerUser.do" method="post">
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id">
				<input type="button" value="아이디 중복 체크" id="id_check">
				<span id="message_id"></span>
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
				<label for="phone">전화번호</label>
				<input type="text" name="phone" id="phone" maxlength="15">
			</li>
			<li>
				<label for="email">이메일</label>
				<input type="email" name="email" id="email" maxlength="50">
			</li>
			<li>
				<label for="zipcode">우편번호</label>
				<input type="text" name="zipcode" id="zipcode" maxlength="5">
				<input type="button" value="우편번호 찾기">
			</li>
			<li>
				<label for="address1">주소</label>
				<input type="text" name="address1" id="address1" maxlength="30">
			</li>
			<li>
				<label for="address2">나머지 주소</label>
				<input type="text" name="address2" id="address2" maxlength="30">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="등록">
			<input type="button" value="홈으로" onclick="location.href = '${pageContext.request.contextPath}/main/main.do';">
		</div>
	</form>
</div>
</body>
</html>
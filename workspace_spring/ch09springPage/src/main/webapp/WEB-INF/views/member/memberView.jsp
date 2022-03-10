<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 중앙 컨텐츠 시작 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		// 프로필 사진 업로드
		$('#photo_btn').click(function() {
			$('#photo_choice').show();
			$(this).hide();
		}); // end of click
		
		// 처음 화면에 보여지는 이미지 읽기
		let photo_path = $('.my-photo').attr('src');
		let my_photo;
		
		$('#upload').change(function() {
			my_photo = this.files[0];
			if(!my_photo) { // 아무것도 선택하지 않은 경우
				$('.my-photo').attr('src', photo_path); // 미리보기 초기화
				return;
			}
			
			if(my_photo.size>1024 * 1024) { // 선택한 파일이 지정한 크기를 초과한 경우
				alert(Math.round(my_photo.size/1024) + 'kbytes (1024kbytes까지만 업로드 가능)');
				$('.my-photo').attr('src', photo_path); // 미리보기 초기화
				$(this).val(''); // 선택한 파일 초기화
				return;
			}
			
			// 이미지 미리보기
			var reader = new FileReader();
			reader.readAsDataURL(my_photo);
			
			reader.onload = function() {
				$('.my-photo').attr('src', reader.result);
			};
		}); // end of change
		
		// 이미지를 서버에 전송
		$('#photo_submit').click(function() {
			if($('#upload').val()=='') {
				alert('파일을 선택하세요!');
				$('#upload').focus();
				return;
			}
			
			// 파일 전송
			var form_data = new FormData();
			form_data.append('upload', my_photo); // upload는 자바빈에서 MultipartFile 자료형의 프로퍼티명
			
			$.ajax({
				url:'updateMyPhoto.do',
				type:'post',
				data:form_data,
				dataType:'json',
				contentType:false,
				enctype:'multipart/form-data',
				processData:false,
				success:function(param) {
					if(param.result=='logout') {
						alert('로그인 후 사용하세요!');
					}
					else if(param.result=='success') {
						alert('프로필 사진이 수정되었습니다.');
						photo_path = $('.my-photo').attr('src'); // 미리보기 갱신
						$('#upload').val(''); // 선택한 파일 초기화
						$('#photo_choice').hide();
						$('#photo_btn').show();
					}
					else {
						alert('파일 전송 오류 발생!');
					}
				},
				error:function() {
					alert('네트워크 오류 발생!');
				}
			}); // end of ajax
		}); // end of click
		
		$('#photo_reset').click(function() {
			$('.my-photo').attr('src', photo_path); // 미리보기 초기화
			$('#upload').val(''); // 선택한 파일 초기화
			$('#photo_choice').hide();
			$('#photo_btn').show();
		}); // end of click
	});
</script>
<div class="page-main">
	<h2>프로필 사진</h2>
	<ul>
		<li>
			<c:if test="${empty member.photo_name}">
			<img src="${pageContext.request.contextPath}/resources/images/face.png" width="200" height="200" class="my-photo">
			</c:if>
			<c:if test="${!empty member.photo_name}">
			<img src="${pageContext.request.contextPath}/member/photoView.do" width="200" height="200" class="my-photo">
			</c:if>
		</li>
		<li>
			<div class="align-center">
				<input type="button" value="수정" id="photo_btn">
			</div>
			<div id="photo_choice" style="display: none;">
				<input type="file" id="upload" accept="image/jpeg, image/png, image/gif">
				<input type="button" value="전송" id="photo_submit">
				<input type="button" value="취소" id="photo_reset">
			</div>
		</li>
	</ul>
	<h2>회원 상세 정보</h2>
	<ul>
		<li>이름 : ${member.name}</li>
		<li>전화번호 : ${member.phone}</li>
		<li>이메일 : ${member.email}</li>
		<li>우편번호 : ${member.zipcode}</li>
		<li>주소 : ${member.address1}</li>
		<li>상세 주소 : ${member.address2}</li>
		<li>가입일 : ${member.reg_date}</li>
		<c:if test="${!empty member.modify_date}">
		<li>최근 정보 수정일 : ${member.modify_date}</li>
		</c:if>
	</ul>
	<hr size="1" width="100%" noshade>
	<p class="align-right">
		<input type="button" value="회원 정보 수정" onclick="location.href = 'update.do';">
		<input type="button" value="비밀번호 변경" onclick="location.href = 'changePassword.do';">
		<input type="button" value="회원 탈퇴" onclick="location.href = 'delete.do';">
	</p>
</div>
<!-- 중앙 컨텐츠 끝 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		let photo_path = $('.my-photo').attr('src'); // 이미지 경로를 담을 변수; 원래 이미지를 처음 프로필 사진으로 지정
		let my_photo; // File 객체를 담을 변수
		
		$('#photo_btn').click(function() {
			$('#photo_choice').show();
			$(this).hide(); // 수정 버튼 감추기
		}); // end of click
		
		// 이미지 미리보기 취소
		$('#photo_reset').click(function() {
			$('.my-photo').attr('src', photo_path); // 미리보기 전 원래 이미지로 되돌리기
			$('#photo').val(''); // <input type="file"> 태그에서 선택한 파일 정보 지우기
			$('#photo_choice').hide();
			$('#photo_btn').show(); // 수정 버튼 보이기
		}); // end of click
		
		// 이미지 선택 및 이미지 미리보기
		$('#photo').change(function() {
			my_photo = this.files[0];
			if(!my_photo) {
				$('.my-photo').attr('src', photo_path); // 파일 선택 취소시 원래 이미지로 되돌리기
				return;
			}
			
			if(my_photo.size>1024*1024) {
				alert('1MB까지만 업로드 가능합니다!');
				$(this).val('');
				return;
			}
			
			let reader = new FileReader();
			reader.readAsDataURL(my_photo);
			
			reader.onload = function() {
				$('.my-photo').attr('src', reader.result);
			}; // end of onload
		}); // end of change
		
		// 이미지 전송
		$('#photo_submit').click(function() {
			if($('#photo').val()=='') {
				alert('이미지를 선택하세요!');
				$('#photo').focus();
				return;
			}
			
			// 파일 전송
			let form_data = new FormData(); // FormData 객체에 저장된 key와 value는 <form> 태그의 입력 필드와 같은 효과
			form_data.append('photo', my_photo); // photo는 식별자, my_photo는 선택된 파일 정보
			$.ajax({
				url:'updateMyPhoto.do',
				type:'post',
				data:form_data,
				dataType:'json',
				contentType:false, // 기본값은 "application/x-www-form-urlencoded; charset=UTF-8"이며, "multipart/form-data"로 전송되게 하기 위해 false로 설정
		        processData:false, // true일 경우 jQuery 내부적으로 key와 value를 Query String으로 변환; 일반 문자열이 아니라 파일로 전송되어야 하므로 false로 설정
				enctype:'multipart/form-data',
				success:function(param) {
					if(param.result=='logout') {
						alert('로그인 후 사용하세요!');
					}
					else if(param.result=='success') {
						alert('프로필 사진이 수정되었습니다.');
						photo_path = $('.my-photo').attr('src'); // 원래 이미지를 수정한 프로필 사진으로 갱신
						$('#photo').val('');
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
	});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h2>회원 정보</h2>
	<div class="mypage-div">
		<h3>프로필 사진</h3>
		<ul>
			<li>
				<c:if test="${empty member.photo}">
				<img src="${pageContext.request.contextPath}/images/face.png" width="200" height="200" class="my-photo">
				</c:if>
				<c:if test="${!empty member.photo}">
				<img src="${pageContext.request.contextPath}/upload/${member.photo}" width="200" height="200" class="my-photo">
				</c:if>
			</li>
			<li>
				<div class="align-center">
					<input type="button" value="수정" id="photo_btn">
				</div>
				<div id="photo_choice" style="display: none;">
					<input type="file" id="photo" accept="image/gif, image/png, image/jpeg">
					<input type="button" value="전송" id="photo_submit">
					<input type="button" value="취소" id="photo_reset">
				</div>
			</li>
		</ul>
		<h3>회원 탈퇴</h3>
		<ul>
			<li>
				<input type="button" value="회원 탈퇴" onclick="location.href = 'deleteUserForm.do';"> <%-- myPage.do와 같은 폴더에 있으므로 Context Path 생략 가능 --%>
			</li>
		</ul>
	</div>
	<div class="mypage-div">
		<h3>연락처</h3>
		<ul>
			<li>
				이름 : ${member.name}
			</li>
			<li>
				전화번호 : ${member.phone}
			</li>
			<li>
				이메일 : ${member.email}
			</li>
			<li>
				우편번호 : ${member.zipcode}
			</li>
			<li>
				주소 : ${member.address1} ${member.address2}
			</li>
			<li>
				가입일 : ${member.reg_date}
			</li>
			<c:if test="${!empty member.modify_date}">
			<li>
				최근 정보 수정일 : ${member.modify_date}
			</li>
			</c:if>
			<li>
				<input type="button" value="연락처 수정" onclick="location.href = 'modifyUserForm.do';">
			</li>
		</ul>
		<h3>비밀번호 수정</h3>
		<ul>
			<li>
				<input type="button" value="비밀번호 수정" onclick="location.href = 'modifyPasswordForm.do';">
			</li>
		</ul>
		<h3>상품 구매 목록</h3>
		<ul>
			<li>
				<c:forEach var="order" items="${orderList}">
				<div>
					<a href="${pageContext.request.contextPath}/order/orderModifyForm.do?order_num=${order.order_num}">
						${order.order_num} ${order.item_name} ${order.reg_date}
					<c:if test="${order.status==1}">배송 대기</c:if>
					<c:if test="${order.status==2}">배송 준비 중</c:if>
					<c:if test="${order.status==3}">배송 중</c:if>
					<c:if test="${order.status==4}">배송 완료</c:if>
					<c:if test="${order.status==5}">주문 취소</c:if>
					</a>
				</div>
				</c:forEach>
			</li>
			<li>
				<input type="button" value="구매 목록 보기" onclick="location.href = '${pageContext.request.contextPath}/order/orderList.do';">
			</li>
		</ul>
	</div>
</div>
</body>
</html>
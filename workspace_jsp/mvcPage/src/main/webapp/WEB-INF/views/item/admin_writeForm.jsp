<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#write_form').submit(function(event) {
			if($('input[type=radio]:checked').length<1) {
				alert('상품 표시 여부를 지정하세요!');
				return false;
			}
			
			let isValid = true; // submit()의 return 값 지정
			
			$('li').each(function() {
				let input = $(this).find('input[type!="button"],textarea');
				if(!input.val().trim()) {
					let word = $(this).find('label').text();
					let last = word.charCodeAt(word.length-1);
					let post;
					if(last>'가'.charCodeAt(0) && last<'힣'.charCodeAt(0)) {
						post = (last - '가'.charCodeAt(0)) % 28 > 0 ? '을' : '를';
					}
					else {
						post = '을/를';
					}
					if(input.attr('type')=='file') post += ' 선택하세요!';
					else post += ' 입력하세요!';
					alert(word + post);
					input.val('').focus();
					isValid = false; // submit()의 return 값 지정
					return false; // each() 루프 중단
				}
			}); // end of each
			
			return isValid;
		}); // end of submit
	});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h2>상품 등록</h2>
	<form action="write.do" method="post" enctype="multipart/form-data" id="write_form">
		<ul>
			<li>
				<label>상품 표시 여부</label>
				<input type="radio" name="status" value="1" id="status1">미표시
				<input type="radio" name="status" value="2" id="status2">표시
			</li>
			<li>
				<label for="name">상품명</label>
				<input type="text" name="name" id="name" maxlength="10">
			</li>
			<li>
				<label for="price">가격</label>
				<input type="number" name="price" id="price" min="1" max="99999999">
			</li>
			<li>
				<label for="quantity">수량</label>
				<input type="number" name="quantity" id="quantity" min="0" max="99999">
			</li>
			<li>
				<label for="photo1">상품 사진1</label>
				<input type="file" name="photo1" id="photo1" accept="image/jpeg,image/gif,image/png">
			</li>
			<li>
				<label for="photo2">상품 사진2</label>
				<input type="file" name="photo2" id="photo2" accept="image/jpeg,image/gif,image/png">
			</li>
			<li>
				<label for="detail">상품 설명</label>
				<textarea rows="5" cols="30" name="detail" id="detail"></textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="등록">
			<input type="button" value="목록으로" onclick="location.href = 'list.do';">
		</div>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-main">
	<h2 class="align-center">상품 등록</h2>
	<form id="myForm" action="insertTest.jsp" method="post">
		<ul>
			<li>
				<label for="name">상품명</label>
				<input type="text" name="name" id="name">
			</li>
			<li>
				<label for="price">가격</label>
				<input type="number" name="price" id="price" min=1 placeholder="1 ~ 999,999,999"> <!-- 가격이 0이면 무의미하기 때문에 최솟값은 1로 설정 -->
			</li>
			<li>
				<label for="stock">재고</label>
				<input type="number" name="stock" id="stock" min=0 placeholder="0 ~ 999,999,999"> <!-- max값에 연산 식을 넣을 수 없으며, max값을 직접 999999999로 지정시 JavaScript를 통한 입력 값 길이 제어가 제대로 동작하지 않음 -->
			</li>
			<li>
				<label for="origin">원산지</label>
				<input type="text" name="origin" id="origin">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="상품 등록">
			<input type="button" value="상품 목록" onclick="location.href='selectTest.jsp'">
		</div>
	</form>
</div>
<script type="text/javascript">
	document.querySelector('form').onsubmit = function() {
		let list = document.getElementsByTagName('li');
		for(let i=0;i<list.length;i++) {
			let input = list[i].querySelector('input');
			input.value = input.value.trim(); // 입력된 값 양 끝의 공백 제거
			if(!input.value) { // 아무것도 입력하지 않은 경우
				let label = list[i].querySelector('label').textContent; // 현재 입력 필드에 대응하는 <label> 태그 선택
				let post = ((label.charCodeAt(label.length-1) - 44032) % 28) > 0 ? '을' : '를'; // 항목명의 받침 유무에 따라 적절한 조사 선택
				alert(label + post + ' 입력하세요!');
				input.focus();
				return false;
			}
		}
	};
	
	let nums = document.querySelectorAll('input[type="number"]');
	for(let i=0;i<nums.length;i++) {
		nums[i].onkeyup = function() {
			if(this.value.length>9) { // 입력된 숫자가 9자리를 초과하면
				this.value = this.value.slice(0, 9); // 10번째 이후 숫자를 제거
			}
		};
	}
	
	let texts = document.querySelectorAll('input[type="text"]');
	for(let i=0;i<texts.length;i++) {
		texts[i].onkeyup = function() {
			while(getBytesLength(this.value)>30) { // 입력된 값이 30bytes를 초과하는 동안
				this.value = this.value.slice(0, -1); // 마지막 글자를 제거
			}
		};
	}
	
	function getBytesLength(str) {
		let bytes = 0;
		for(let i=0;i<str.length;i++) {
			let unicode = str.charCodeAt(i);
			bytes += unicode >> 11 ? 3 : (unicode >> 7 ? 2 : 1); // 2^11=2048로 나누었을 때 몫이 있으면 3bytes, 그보다 작은 수이면서 2^7=128로 나누었을 때 몫이 있으면 2bytes, 그 외에는 1byte
		}
		return bytes;
	}
</script>
</body>
</html>
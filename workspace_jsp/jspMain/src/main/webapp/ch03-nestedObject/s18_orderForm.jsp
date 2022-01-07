<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습</title>
<style type="text/css">
	.goods {display: flex; flex-direction: column;}
	.row {display: flex; flex-direction: row;}
	.row div,.row label {margin: 5px 15px; width: 75px;}
	h3 small {color: gray; font-style: italic; font-weight: normal; font-size: 0.8rem;
	}
</style>
</head>
<body>
<!-- 
[실습 문제] 이름(name), 날짜(order_date), 상품(item: 가방, 신발, 옷, 식사권)
가방(20만원), 신발(10만원), 옷(5만원), 식사권(15만원)
30만원 미만 배송비 5천원 추가
 -->
<h2>상품 구매</h2>
<form action="s19_order.jsp" method=get id="myForm">
	<label>이름 <input type="text" name="name" id="name"></label><br>
	<label>날짜 <input type="date" name="order_date" id="order_date"></label><br>
	<h3>상품 목록<small>(30만원 미만 배송비 5천원 추가)</small></h3>
	<div class="goods">
		<div class="row">
			<label><input type="checkbox" name="item" value="가방">가방</label>
			<label><input type="checkbox" name="item" value="신발">신발</label>
			<label><input type="checkbox" name="item" value="옷">옷</label>
			<label><input type="checkbox" name="item" value="식사권">식사권</label><br>
		</div>
		<div class="row">
			<div class="price">20만원</div>
			<div class="price">10만원</div>
			<div class="price">5만원</div>
			<div class="price">15만원</div>
		</div>
	</div>
	<input type="submit" value="구입">
</form>
<script type="text/javascript">
	document.getElementById('myForm').onsubmit = function(event) {
		let name = document.getElementById('name');
		name.value = name.value.trim(); // 공백 제거
		if(!name.value) {
			alert('이름을 입력하세요!');
			name.focus();
			return false;
		}
		
		let order_date = document.getElementById('order_date');
		if(!order_date.value) {
			alert('날짜를 입력하세요!');
			order_date.focus(); // <input type="date">의 경우 focus되는 위치(연도 대신 picker 등)를 지정할 수 없기 때문에 생략해도 무방
			return false;
		}
		
		let items = document.getElementsByName('item');
		let check = false;
		for(let i=0;i<items.length;i++) {
			if(items[i].checked) check = true;
		}
		if(!check) {
			alert('상품을 하나 이상 선택하세요!');
			return false;
		}
		
		/*
		let items = document.getElementsByName('item');
		let prices = document.getElementsByClassName('price');
		for(let i=0;i<items.length;i++) {
			if(items[i].checked) { // 선택된 상품에 대응하는 가격을 값으로 갖는 <input> 태그 동적 생성
				let price_out = document.createElement("input");
				price_out.type = 'number';
				price_out.name = 'price'; // 서버 전송용 식별자 부여
				price_out.value = parseInt(prices[i].textContent)*10000;
				price_out.style.display = 'none';
				prices[i].parentNode.insertBefore(price_out, prices[i].nextSibling);
			}
		}
		*/
	}
</script>
</body>
</html>
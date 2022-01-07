<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습</title>
<style type="text/css">
	table {
		border-collapse: collapse;
		border: 1px solid gray;
	}
	td {
		border: 1px solid gray;
		height: 30px;
	}
	td.title {
		text-align: right;
		background-color: ivory;
		font-weight: bold;
		color: #f60;
		padding: 0 10px;
	}
	input[type="number"] {
		text-align: right;
		width: 50px;
		height: 19px;	
	}
	ul {
		list-style: none;
		padding: 0 10px;
		margin: 5px;
	}
	ul li {
		display: inline;
	}
</style>
</head>
<body>
<h2>주문서</h2>
<form action="s21_order2.jsp" method="post" id="myForm">
	<table>
		<tr>
			<td class="title">식사류</td>
			<td>
				<ul>
					<li>
						<label for="c0">짜장면</label>
						<input type="number" name="food_c0" id="c0" min="0" max="99" value="0">
					</li>
					<li>
						<label for="c1">짬뽕</label>
						<input type="number" name="food_c1" id="c1" min="0" max="99" value="0">
					</li>
					<li>
						<label for="c2">볶음밥</label>
						<input type="number" name="food_c2" id="c2" min="0" max="99" value="0">
					</li>
				</ul>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="전송">
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript">
	document.getElementById('myForm').onsubmit = function() {
		
		let c0 = document.getElementById('c0');
		if(c0.value=='') { // number 필드는 숫자 및 공백 입력 가능; 사용자가 기본값 0을 지우고 공백만 입력한 경우
			alert('짜장면의 수량을 입력하세요!');
			c0.focus();
			c0.value = 0;
			return false;
		}
		let c1 = document.getElementById('c1');
		if(c1.value=='') {
			alert('짬뽕의 수량을 입력하세요!');
			c1.focus();
			c1.value = 0;
			return false;
		}
		let c2 = document.getElementById('c2');
		if(c2.value=='') {
			alert('볶음밥의 수량을 입력하세요!');
			c2.focus();
			c2.value = 0;
			return false;
		}
		if(c0.value==0 && c1.value==0 && c2.value==0) { // 아무 것도 주문하지 않는 경우
			alert('세 가지 음식 중 하나는 꼭 주문해야 합니다!');
			return false;
		}

		/*
		let nums = document.querySelectorAll('input[type="number"]');
		let count = 0;
		for(let i=0;i<nums.length;i++) {
			if(!nums[i].value.trim()) { // 아무 것도 입력하지 않거나 공백만 입력한 경우
				nums[i].value = 0; // 입력된 값을 0으로 변경하여 JSP에서 NumberFormatException 발생을 방지
			}
			count += Number(nums[i].value); // HTML의 <input> 요소에서 입력받는 값은 문자열로 인식되며, type="number"는 사용자가 입력할 수 있는 값을 제한할 뿐 입력된 값의 자료형을 변경하지 않음; 즉, <input type="number">의 value 속성은 string을 반환하므로, 연산하기 위해서는 숫자로 변환해야 함
		}
		if(count===0) {
			alert('1개 이상 주문해주세요!')
			return false;
		}
		*/
	};
</script>
</body>
</html>
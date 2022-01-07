<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습</title>
</head>
<body>
<h2>구구단</h2>
<form id="myForm" action="s06_gugudan.jsp" method="post">
	<label title="2부터 9 사이의 숫자만 입력 가능합니다">단을 입력하세요 : <input type="text" name="dan" id="dan"></label>
	<input type="submit" value="보기" id="btn">
</form>
<script type="text/javascript">
	let dan = document.getElementById('dan');

	dan.onkeyup = function() {
		let num = Number(dan.value);
		if(!Number.isInteger(num) || num>9 || num<2) { // isNaN(dan.value)도 가능
			reset();
			return;
		}
		document.getElementById('btn').value = num + '단 보기';
	}
	
	document.getElementById('myForm').onsubmit = function() {
		dan.value = dan.value.trim(); // 4    처럼 공백을 포함하여 전송하는 경우 대비
		if(!dan.value) {
			reset();
			alert('단을 입력하세요!')
			return false;
		}
	}
	
	function reset() {
		dan.value = '';
		document.getElementById('btn').value = '보기';
		dan.focus();
	}
</script>
</body>
</html>
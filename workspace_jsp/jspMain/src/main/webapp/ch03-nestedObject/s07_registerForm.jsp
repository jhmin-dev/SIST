<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습</title>
</head>
<body>
<!-- 이름(name), 아이디(id)와 비밀번호(password), 전화번호(phone), 취미(hobby: 영화보기, 음악 감상, 등산, 낚시, 춤), 자기 소개(content) -->
<form action="s08_register.jsp" method="get" id="myForm">
	<label>이름 : <input type="text" name="name" id="name" size="10"></label><br> <!-- name은 서버용 식별자, id 및 class는 CSS와 JavaScript용 식별자 -->
	<label>아이디 : <input type="text" name="id" id="id" size="30"></label><br>
	<label>비밀번호 : <input type="password" name="password" id="password" size="30"></label><br>
	
	<label>전화번호 : <select name="phone" id="area_code">
		<option>010</option><option>070</option>
		<option>02</option><option>031</option><option>032</option>
		<option>직접 입력</option>
	</select>
	- <input type="text" name="phone" size="4">
	- <input type="text" name="phone" size="4"></label><br>
	<!-- <label>전화번호 : <input type="text" name="phone" id="phone" size="30"></label><br> -->
	
	취미 : 
	<label><input type="checkbox" name="hobby" class="hobby" value="영화 보기">영화 보기</label>
	<label><input type="checkbox" name="hobby" class="hobby" value="음악 감상">음악 감상</label>
	<label><input type="checkbox" name="hobby" class="hobby" value="게임">게임</label>
	<label><input type="checkbox" name="hobby" class="hobby" value="독서">독서</label>
	<label><input type="checkbox" name="hobby" class="hobby" value="그림 그리기">그림 그리기</label><br>
	
	<label>자기 소개 : <br><textarea rows="5" cols="50" name="content" id="content"></textarea></label><br>
	
	<input type="submit" value="전송">
</form>
<script type="text/javascript">
	let area_code = document.getElementById('area_code');
	area_code.onchange = function() {
		if(this.value=='직접 입력') { // 동적으로 태그 생성
			let area_code_text = document.createElement("input");
			area_code_text.type = 'text';
			area_code_text.name = 'phone'; // 서버 전송용 식별자 부여
			area_code_text.size = 3; // 국번이므로 길이를 3자로 제한
			area_code_text.onkeyup = checkPhone; // 유효성 검사 이벤트 핸들러 연결
			this.parentNode.insertBefore(area_code_text, this.nextSibling);
		}
		else if(this.nextSibling.size==3) { // 동적으로 태그 삭제
			this.nextSibling.remove();
		}
	}
	
	let phones = area_code.parentNode.getElementsByTagName('input'); // 국번의 부모 <label> 태그의 자식 <input> 태그들을 선택
	for(let i=0;i<phones.length;i++) {
		phones[i].onkeyup = checkPhone; // 유효성 검사 이벤트 핸들러 연결
	}
	
	function checkPhone() {
		this.value = this.value.trim(); // 공백 제거
		if(!Number.isInteger(Number(this.value))) {
			let num = parseInt(this.value);
			if(isNaN(num)) this.value = ''; // 입력 값이 숫자가 아닌 문자로 시작하는 경우 전부 삭제
			else this.value = num; // 입력 값이 숫자로 시작하다 문자가 섞인 경우 문자 부분을 잘라냄
		}
		if(this.value.length>this.size) {
			this.value = this.value.substring(0, this.size); // 길이 제한
		}
	}
	
	myForm.onsubmit = function() {
		let inputs = document.getElementsByTagName('input'); // <textarea> 태그를 제외한 입력 칸들 얻기
		for(let i=0;i<inputs.length;i++) {
			if(!inputs[i].value.trim()) { // value가 지정되어 있는 체크박스와 전송 버튼은 항상 else로 빠짐
				inputs[i].value = '';
				inputs[i].focus();
				alert(inputs[i].parentNode.innerText.split(':')[0].trim() + '을/를 입력하세요!'); // split('\n')[0]은 첫 줄을 반환; <label> 태그로 <input> 태그들을 감싸두지 않으면 원하는 문자열이 추출되지 않으므로 주의
				return false;
			}
		}
	}
</script>
</body>
</html>
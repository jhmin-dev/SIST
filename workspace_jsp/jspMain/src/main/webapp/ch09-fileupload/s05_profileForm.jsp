<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 사진 업로드 폼</title>
<script type="text/javascript">
	window.onload = function() {
		var file = document.getElementById('file');
		// 파일을 선택할 때 이벤트 연결
		file.onchange = function() {
			if(file.files && file.files[0]) { // 파일이 선택되어 files 배열의 인덱스 0에 File 객체가 저장되어 있는 경우
				var reader = new FileReader();
				// 이미지 파일 읽기
				reader.readAsDataURL(file.files[0]);
				// 이미지 파일을 모두 읽어들이면 이벤트 발생
				reader.onload = function() {
					var image = document.getElementById('image');
					var submit_btn = document.getElementById('submit_btn');
					// 이미지 미리 보기 처리
					image.src = reader.result;
					image.style.display = '';
					submit_btn.style.display = '';
				};
			}
		};
	};
</script>
</head>
<body>
<h2>프로필 사진 업로드하기</h2>
<img id="image" width="100" height="100" alt="Image Preview" style="display: none;">
<form action="s06_profile.jsp" method="post" enctype="multipart/form-data">
	<input type="file" name="file" id="file" accept="image/png,image/jpeg,image/gif">
	<input type="submit" value="전송" style="display: none;" id="submit_btn">
</form>
</body>
</html>
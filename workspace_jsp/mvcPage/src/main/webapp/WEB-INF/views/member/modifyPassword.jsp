<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	if(${check}) {
		alert('비밀번호를 수정했습니다.');
		location.href = 'myPage.do';
	}
	else {
		alert('아이디 또는 비밀번호가 불일치합니다!');
		history.go(-1);
	}
</script>
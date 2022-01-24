<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	if(${check}) {
		alert('글 삭제를 완료하였습니다.');
		location.href = 'list.do';
	}
	else {
		alert('비밀번호 불일치!');
		history.go(-1);
	}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO" %>
<%@ page import="kr.board.vo.BoardVO" %>
<%
	// 전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="boardVO" class="kr.board.vo.BoardVO"/>
<jsp:setProperty property="*" name="boardVO"/>
<%
	BoardDAO dao = BoardDAO.getInstance();
	// 비밀번호 인증을 수행하기 위해 글 번호를 전달하고 한 건의 레코드 정보를 자바빈에 담아 반환
	BoardVO db_board = dao.getBoard(boardVO.getNum());
	boolean check = false;
	if(db_board!=null) {
		check = db_board.isCheckedPassword(boardVO.getPasswd());	
	}
	
	if(check) { // 인증 성공
		boardVO.setIp(request.getRemoteAddr());
		dao.update(boardVO);
%>
	<script type="text/javascript">
		alert('글 수정을 완료했습니다.');
		location.href = 'list.jsp';
	</script>
<%
	}
	else { // 인증 실패
%>
	<script type="text/javascript">
		alert('비밀번호 불일치!');
		history.go(-1);
	</script>
<%
	}
%>
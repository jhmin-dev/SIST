<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO" %>
<%@ page import="kr.board.vo.BoardVO" %>
<%
	// 전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");

	// 전송된 데이터 반환
	int num = Integer.parseInt(request.getParameter("num"));
	String passwd = request.getParameter("passwd");
	
	BoardDAO dao = BoardDAO.getInstance();
	BoardVO db_board = dao.getBoard(num);
	boolean check = false;
	if(db_board!=null) {
		check = db_board.isCheckedPassword(passwd);
	}
	
	if(check) { // 인증 성공
		dao.delete(num); // 글 삭제
%>
	<script type="text/javascript">
		alert('글 삭제가 완료되었습니다.');
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
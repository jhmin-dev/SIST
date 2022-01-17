<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO" %>
<%
	// 전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="board" class="kr.board.vo.BoardVO"/>
<jsp:setProperty property="*" name="board"/>
<%
	// 클라이언트의 IP 주소 저장
	board.setIp(request.getRemoteAddr());

	BoardDAO dao = BoardDAO.getInstance();
	dao.insert(board);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 완료</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
</head>
<body>
<div class="page-main">
	<h1>글쓰기 완료</h1>
	<div class="result-display">
		<div class="align-center">
			게시판에 글을 등록하였습니다.<br>
			<input type="button" value="목록" onclick="location.href = 'list.jsp';">
		</div>
	</div>
</div>
</body>
</html>
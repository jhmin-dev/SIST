<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO" %>
<%@ page import="kr.board.vo.BoardVO" %>
<%@ page import="kr.util.PagingUtil" %>
<%@ page import="java.util.List" %>
<%
	// 선택한 페이지 번호
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null) {
		pageNum = "1";
	}
	
	// 한 화면에 몇 개의 글(행, 레코드)을 보여줄지 지정
	int rowCount = 10;
	// 한 화면에 몇 개의 페이지 수를 보여줄지 지정
	int pageCount = 10;
	
	// 현재 선택한 페이지
	int currentPage = Integer.parseInt(pageNum);
	
	BoardDAO dao = BoardDAO.getInstance();
	// 총 레코드 수 구하기
	int count = dao.getCount();
	
	PagingUtil pagingUtil = new PagingUtil(currentPage, count, rowCount, pageCount, "list.jsp");
	
	List<BoardVO> list = null;
	if(count>0) {
		list = dao.getList(pagingUtil.getStartCount(), pagingUtil.getEndCount()); // PagingUtil의 메서드를 이용하여 시작 ROWNUM 번호, 끝 ROWNUM 번호를 전달
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/layout.css">
</head>
<body>
<div class="page-main">
	<h1>게시판 목록</h1>
	<div class="align-right">
		<input type="button" value="글쓰기" onclick="location.href = 'writeForm.jsp';">
	</div>
<%
	if(count==0) {
%>
	<div class="result-display">저장된 글이 없습니다.</div>
<%		
	}
	else {
%>
	<!-- 목록 출력 시작 -->
	<table>
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
<%
		for(BoardVO boardVO : list) {
%>
		<tr>
			<td><%= boardVO.getNum() %></td>
			<td><a href="detail.jsp?num=<%= boardVO.getNum() %>"><%= boardVO.getTitle() %></a></td> <%-- 회원 번호와 달리 글 번호는 세션에 저장하지 않으므로 GET 방식으로 전달 --%>
			<td><%= boardVO.getName() %></td>
			<td><%= boardVO.getReg_date() %></td>
		</tr>
<%		
		}
%>
	</table>
	<!-- 목록 출력 끝 -->
	<div class="align-center">
		<%= pagingUtil.getPagingHtml() %>
	</div>
<%
	}
%>
</div>
</body>
</html>
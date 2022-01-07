<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %> <%-- <jsp:param/>으로 파라미터 전송시, request에 처음 액세스하는 것은 include된 JSP 파일이 아니라 include하는 JSP 파일이므로 인코딩 방식 설정도 include하는 JSP 파일에서 해야 전송되는 파라미터 값이 깨지지 않음 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 모듈화</title>
<style type="text/css">
	table {
		border:solid 1px #000;
		border-collapse: collapse;
		width: 500px;
		margin: 0 auto;
	}
	td {
		border: solid 1px #000;
		text-align: center;
		vertical-align: middle;
		height: 40px;
	}
	td.td-middle {
		text-align: left;
		vertical-align: top;
		height: 200px;
	}
	td.td-width {
		width: 100px;
	}
</style>
</head>
<body>
<table>
	<tr>
		<td colspan="2">
			<%-- <jsp:include> 시작 태그와 끝 태그 사이에는 HTML 주석과 JSP 주석 모두 사용 불가하고, 태그만 내용으로 들어갈 수 있음 --%>
			<jsp:include page="/ch05-actionTag/module/top.jsp">
				<jsp:param value="서울" name="company"/>
			</jsp:include>
		</td>
	</tr>
	<tr>
		<td class="td-middle td-width">
			<jsp:include page="module/left.jsp"/>
		</td>
		<td class="td-middle">
			<!-- 내용 부분 : 시작 -->
			레이아웃 1
			<!-- 내용 부분 : 끝 -->
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<jsp:include page="module/bottom.jsp"/>
		</td>
	</tr>
</table>
</body>
</html>
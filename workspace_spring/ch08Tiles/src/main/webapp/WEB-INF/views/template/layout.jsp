<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title"/></title>
</head>
<body>
	<table style="background-color: #a0a0a0; width: 800px;">
		<tr height="100">
			<td colspan="2" bgcolor="ffffff">
				<tiles:insertAttribute name="header"/>
			</td>
		</tr>
		<tr height="670" bgcolor="ffffff">
			<td width="15%" valign="top">
				<tiles:insertAttribute name="menu"/>
			</td>
			<td width="85%" align="center">
				<tiles:insertAttribute name="body"/>
			</td>
		</tr>
		<tr bgcolor="ffffff">
			<td colspan="2">
				<tiles:insertAttribute name="footer"/>
			</td>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버퍼 정보</title>
</head>
<body>
버퍼 크기 : <%= out.getBufferSize() %><br>
남은 버퍼 크기 : <%= out.getRemaining() %><br> <%-- getRemaining() 메서드는 메서드가 호출된 시점에서의 남은 버퍼 크기를 반환 --%>
autoFlush : <%= out.isAutoFlush() %><br>
남은 버퍼 크기 : <%= out.getRemaining() %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 전송된 데이터 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
<%-- 자바빈 객체 생성 --%>
<jsp:useBean id="member" class="kr.web.member.MemberVO"/> <%-- <jsp:useBean>은 시작 태그와 끝 태그가 있지만, 내용이 없는 태그이므로 일반적으로 단독 태그로 사용; id 속성에 자바빈의 식별자, class 속성에 패키지명까지 포함한 전체 클래스명을 명시 --%>
<%-- <jsp:setProperty>는 request에 저장된 데이터의 파라미터명과 자바빈의 프로퍼티명을 대조해서 일치하면 전송된 데이터를 자바빈의 프로퍼티에 저장 --%>
<jsp:setProperty name="member" property="*"/> <%-- name 속성에 자바빈의 식별자, property 속성에 자바빈의 프로퍼티를 명시 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
아이디 : <jsp:getProperty property="id" name="member"/><br> <%-- <jsp:getProperty>는 getter 메서드에 비해 이점이 없으므로 잘 사용되지 않음 --%>
비밀번호 : <jsp:getProperty property="password" name="member"/><br>
이름 : <jsp:getProperty property="name" name="member"/><br>
이메일 : <jsp:getProperty property="email" name="member"/><br>
주소 : <jsp:getProperty property="address" name="member"/>
</body>
</html>
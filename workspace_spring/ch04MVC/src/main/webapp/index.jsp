<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/hello.do">HelloController</a><br>
<a href="${pageContext.request.contextPath}/search/internal.do?query=dev">SearchController : internal.do</a><br>
<a href="${pageContext.request.contextPath}/search/external.do">SearchController : external.do</a><br>
<a href="${pageContext.request.contextPath}/article/newArticle.do">NewArticleController</a><br>
<a href="${pageContext.request.contextPath}/cookie/make.do">CookieController : make.do</a><br>
<a href="${pageContext.request.contextPath}/cookie/view.do">CookieController : view.do</a><br>
<a href="${pageContext.request.contextPath}/search/main.do">GameSearchController</a><br>
<a href="${pageContext.request.contextPath}/account/create.do">CreateAccountController</a><br>
<a href="${pageContext.request.contextPath}/report/submitReport.do">SubmitReportController</a><br>
<a href="${pageContext.request.contextPath}/login/login.do">LoginController</a><br>
----------------------------<br>
===로케일 변경하기===<br>
<a href="${pageContext.request.contextPath}/changeLanguage.do?lang=ko">/changeLanguage.do?lang=ko</a><br>
<a href="${pageContext.request.contextPath}/changeLanguage.do?lang=en">/changeLanguage.do?lang=en</a><br>
로케일 변경하기를 클릭한 후 로케일 변경을 확인하기 위해 /login/login.do를 클릭하세요.<br>
----------------------------<br>
<a href="${pageContext.request.contextPath}/login/login.do?language=ko">/login/login.do?language=ko</a><br>
<a href="${pageContext.request.contextPath}/login/login.do?language=en">/login/login.do?language=en</a><br>
----------------------------<br>
<a href="${pageContext.request.contextPath}/file.do">DownloadController</a><br>
<a href="${pageContext.request.contextPath}/member/write.do">MemberWriteController</a><br>
<a href="${pageContext.request.contextPath}/pageJsonReport.do">PageReportController</a><br>
<a href="${pageContext.request.contextPath}/member">RestMainController</a><br>
<a href="${pageContext.request.contextPath}/member/id/sleepy/name/도로롱">/member/id/sleepy/name/도로롱</a><br>
</body>
</html>
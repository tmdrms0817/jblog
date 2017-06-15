<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body>
	<div class="center-content">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<form:form modelAttribute="userVo" class="login-form" method="post" action="${pageContext.request.contextPath}/user/auth">
			<label>아이디</label> 
			<input type="text" name="id"> 
			<p style="margin:0; padding:0; color:red; text-align:left">
				<form:errors path="id" />		
			</p>
			
			<label>패스워드</label>
			<input type="password" name="password"> 
			<p style="margin:0; padding:0; color:red; text-align:left">
				<form:errors path="password" />		
			</p>
			<input type="hidden" name="path" value="login"/>
			<input type="submit" value="로그인">
		</form:form>
	</div>
</body>
</html>

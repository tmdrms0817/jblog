<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script
	src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
var id_st = false;

	$(function() {
		$("#btn-checkemail").click(function() {
			var id = $("#blog-id").val();
			if (id == "") {
				alert("값을 입력해 주세요 ~!");
				return;
			}

			//ajax 통신
			$.ajax({
				url : "/jblog/user/api/checkid?id=" + id,
				type : "get",
				dataType : "json",
				data : "",
				success : function(response) {
					if (response.data == true) {
						if(id.length <5 || id.length > 12){
							id_st = false;
							alert("아이디의 길이는 5 ~ 12자리 이여야 합니다.");
						}else{
							id_st = true;
							alert("사용 가능한 아이디 입니다.");
						}
					
					} else {
						id_st = false;
						alert("이미 존재하는 아이디  입니다.");
					}
				},
				error : function(jqXHR, status, error) {
					console.error(status + " : " + error);
				}
			});
		});
	});
	
	$(function() {
		$("#sum").click(function() {
			
			var name = $("#name").val().replace(/\s/gi, ""); 
			var id = $("#blog-id").val().replace(/\s/gi, ""); 
			var password = $("#password").val().replace(/\s/gi, ""); 
			
			if(name == ""){
				alert("이름을 입력하세요");
				return false;
			}else if(id == ""){
				alert("id 를 입력하세요");
				return false;
			}else if(password == ""){
				alert("password 를 입력하세요 ");
				return false;
			}else if(id_st === false){
				alert("id 중복확인을 해주세요 ~!");
				return false;
			}
			
		});
	});
	
</script>
</head>
<body>
	<div class="center-content">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<form:form
					modelAttribute="userVo"
					id="join-form"
					name="joinForm"
					method="post"
					class="join-form"
					action="${pageContext.servletContext.contextPath }/user/join">
			<label class="block-label" for="name">이름</label> 
			<input id="name" name="name" type="text" value="${userVo.name }"> 
			<p style="margin:0; padding:0; color:red; text-align:left">
				<form:errors path="name" />		
			</p>
			
			<label class="block-label" for="blog-id">아이디</label> 
			<input id="blog-id" name="id" type="text" value="${userVo.id }">
			<input id="btn-checkemail" type="button" value="id 중복체크"> 
			<p style="margin:0; padding:0; color:red; text-align:left">
				<form:errors path="id" />		
			</p>
			
			<img id="img-checkemail" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label> 
			<input id="password" name="password" type="password" />
			<p style="margin:0; padding:0; color:red; text-align:left">
				<form:errors path="password" />		
			</p>

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>
			
			<input type="hidden" name="path" value="join"/>
			<input id="sum" type="submit" value="가입하기">

		</form:form>
	</div>
</body>
</html>

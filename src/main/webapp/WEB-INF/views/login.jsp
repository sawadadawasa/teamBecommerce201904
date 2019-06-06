<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
<title>ログインフォーム</title>
</head>
<body>
	<div id="form">
		<p class="form-title">Login</p>
		<form:errors path="loginForm" cssStyle="color:red" />
		<form:form modelAttribute="loginForm"
			action="${pageContext.request.contextPath}/tea/login">
			
			<p>メールアドレス</p>
				<p class="mail"><form:input path="email" type="email" placeholder="Email" />
				<form:errors path="email" cssStyle="color:red" />
			</p>
			
			<p>パスワード</p>
			<p>
				<p class="pass"><form:password path="password" placeholder="Password" />
				<form:errors path="password" cssStyle="color:red" />
			</p>

		<p class="submit">
			<input type="submit" value="ログイン">
		</p>
			</form:form>
			
		<form:form action="${pageContext.request.contextPath}/user/form"
			id="toInsertMember">
			
			<p class="submit">
			<input type="submit" value="新規登録">
			</p>
			
		</form:form>
		</div>
		<script>
		$(function() {
		    if(${registerMessage}){
		    	alert("登録ありがとうございます！\nお手数ですがログインからお願いします。");
			}
		});
		</script>
</body>
</html>
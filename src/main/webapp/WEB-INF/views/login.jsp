<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
<title>ログインフォーム</title>
</head>
<body>
<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
										<a class="navbar-brand"
						href="${pageContext.request.contextPath}/godtea/"> <!-- 企業ロゴ -->
						<img alt="main log" src="../img/tea_header_logo.png" width="100" height="100">
					</a>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
				</div>
				<!-- /.navbar-collapse --></div>
			<!-- /.container-fluid -->
				</nav>
				</div>
				
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
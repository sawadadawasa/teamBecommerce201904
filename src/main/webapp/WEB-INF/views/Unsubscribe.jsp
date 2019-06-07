<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
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
					<p class="navbar-text navbar-right">
					<a href="${pageContext.request.contextPath}/godtea/"
							class="navbar-link">TOP</a>&nbsp;&nbsp;
							</p>
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
		<p class="form-title">退会</p>
		<form:form modelAttribute="userForm"
			action="${pageContext.request.contextPath}/user/delete">
			<p>メールアドレス</p>
			<p class="mail">
				<form:input path="email" placeholder="Email" />
				<form:errors path="email" cssStyle="color:red" />
			</p>
			<p>パスワード</p>
			<p>
			<p class="pass">
				<form:password path="password" placeholder="Password" />
				<form:errors path="password" cssStyle="color:red" />
			</p>

			<p class="submit">
				<input class="btn" type="submit" value="退会する">
			</p>
		</form:form>
	</div>
</body>
</html>
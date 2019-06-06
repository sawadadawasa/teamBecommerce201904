<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>お茶で健康</title>
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
						<a href="${pageContext.request.contextPath}/tea/"
							class="navbar-link">ログイン</a>&nbsp;&nbsp; <a
							href="${pageContext.request.contextPath}/user/form"
							class="navbar-link">新規登録</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/orderItem/cart"
							class="navbar-link">ショッピングカート🛒</a>&nbsp;&nbsp;
						<br>
						<br>
						<br>
						<br>
					</p>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
				
				</div>

				<!-- /.navbar-collapse --></div>
			<!-- /.container-fluid -->
				</nav>
				</div>
	<form action="${pageContext.request.contextPath}/godtea/">　</form>
	<div class="box">
  <div class="bgImg src1"></div>
  <div class="bgImg src2"></div>
  <div class="bgImg src3"></div>
  <div class="bgImg src4"></div>
  <div class="boxString">神茶<br>~God Tea~</div>

</div>

				



</body>
</html>
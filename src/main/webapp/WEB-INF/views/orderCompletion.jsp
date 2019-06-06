<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/order.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/orderCompletion.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
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

					<a class="navbar-brand"
						href="${pageContext.request.contextPath}/godtea/"> <!-- 企業ロゴ -->
						<img alt="main log" src="../img/header_logo.png" height="35">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<a href="${pageContext.request.contextPath}/tea/"
							class="navbar-link">ログイン</a>&nbsp;&nbsp; <a
							href="${pageContext.request.contextPath}/user/form"
							class="navbar-link">新規登録</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/orderItem/cart"
							class="navbar-link">ショッピングカート🛒</a>&nbsp;&nbsp;
						
					</p>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
				
				</div>

				<!-- /.navbar-collapse --></div>
			<!-- /.container-fluid -->
				</nav>
				</div>
ご注文が確定しました。<br>
ありがとうございます。<br>
<br>
<a href ="${pageContext.request.contextPath}/item/">商品一覧に戻る</a>
</body>
</html>
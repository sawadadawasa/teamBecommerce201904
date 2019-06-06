<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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

					<a class="navbar-brand"
						href="${pageContext.request.contextPath}/godtea/"> <!-- 企業ロゴ -->
						<img alt="main log" src="../img/header_logo.png" height="35">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<a href="${pageContext.request.contextPath}/user/form"
							class="navbar-link">新規登録</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/item/"
							class="navbar-link">商品一覧</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/orderItem/cart"
							class="navbar-link">ショッピングカート🛒</a>&nbsp;&nbsp;
							
						<c:if test="${user == null}">
							<a href="${pageContext.request.contextPath}/tea/"
								class="navbar-link">ログイン</a>&nbsp;&nbsp;
						</c:if>
						<c:if test="${user != null}">
							<a
								href="${pageContext.request.contextPath}/logout/sessionInvalidate"
								class="navbar-link">ログアウト</a>&nbsp;&nbsp;
						</c:if>
					</p>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<c:if test="${user != null}">
							<c:out value="${user.name}さんでログイン中" />
						</c:if>
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
  <div class="boxString"><center>神茶</center><br>~God Tea~</div>

</div>

				



</body>
</html>
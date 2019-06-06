<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/piza.css" rel="stylesheet">
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
						href="${pageContext.request.contextPath}/item/"> <!-- 企業ロゴ -->
						<img alt="main log" src="img/header_logo.png" height="35">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<a href="${pageContext.request.contextPath}/orderItem/cart"
							class="navbar-link">ショッピングカート</a>&nbsp;&nbsp; <a
							href="${pageContext.request.contextPath}/order/searchOrderHistory"
							class="navbar-link">注文履歴</a>&nbsp;&nbsp;

						<c:if test="${user == null}">
							<a href="${pageContext.request.contextPath}/tea/"
								class="navbar-link">ログイン</a>
						</c:if>
						<c:if test="${user != null}">
							<a
								href="${pageContext.request.contextPath}/logout/sessionInvalidate"
								class="navbar-link">ログアウト</a>
						</c:if>
					</p>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<p class="navbar-text navbar-right">
						<c:if test="${user != null}">
							<c:out value="${user.name}さんでログイン中" />
						</c:if>
						<p>
				
				</div>

				<!-- /.navbar-collapse --></div>
			<!-- /.container-fluid -->
	

				
				</nav>
		
		<div class="row">
			<div
				class="table-responsive col-lg-offset-1 col-lg-10 col-md-offset-1 col-md-10 col-sm-10 col-xs-12">

				<table class="table table-striped">
					<tr>
						<td>商品名</td>
						<td>値段</td>
						<td>画像</td>
						<td>パック数</td>
						<td>個数</td>
						<td>小計</td>
						<td>取消</td>
					</tr>
<c:out value="${orderId }"/>
					<c:forEach items="${orderItemList}" var="orderItem">

						<tr>
<c:out value="${orderItem.id}"/>
							<td><c:out value="${orderItem.name}" /></td>
							<td><fmt:formatNumber value="${orderItem.price }"
									pattern="###,###,###" /></td>
							<td><img src="img/<c:out value="${orderItem.imagePATH}"/>" /></td>
							<td><c:out value="${orderItem.piece}" /></td>
							<td><c:out value="${orderItem.quantity}" /></td>
							<td><fmt:formatNumber value="${orderItem.subTotalPrice }"
									pattern="###,###,###" /></td>
							<td>
								<form
									action="${pageContext.request.contextPath}/orderItem/deleteId/${orderItem.itemId}/${orderItem.id}"
									method="post">
									<input type="submit" value="削除">
								</form>
							</td>

						</tr>



					</c:forEach>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-offset-2 col-xs-8">
				<div class="form-group text-center">
					<span id="total-price">消費税：<c:out
							value="${viewTaxOfTotalPrice}" />円</span><br> 
					<span id="total-price">ご注文金額合計：<c:out
							value="${viewTotalPrice}" />円(税込)</span>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-offset-5 col-xs-3">
				<div class="form-group">
					<form
						action="${pageContext.request.contextPath}/order/view?orderId =${orderId}"
						method="post">
						<input type="hidden" name="orderId" value="${orderId}">
						<input class="form-control btn btn-warning btn-block"
							type="submit" value="注文に進む">
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- end container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
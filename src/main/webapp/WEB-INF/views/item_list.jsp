<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>item_list</title>
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/piza.css" rel="stylesheet">
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
						<img alt="main log" src="../img/tea_header_logo.png" width="100"
						height="100">
					</a>

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
						<br> <br> <br> <br>
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

			</div>

		</nav>

		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->



	<!-- /.navbar-collapse -->

	<!-- /.container-fluid -->
	
	<!-- search form -->
	<div class="row">
		<div
			class="col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-10 col-xs-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">商品を検索する</div>
				</div>
				<div class="panel-body">
					<form action="${pageContext.request.contextPath}/item/search"
						method="post" action="#" class="form-horizontal">
						<div class="form-group">
							<label for="code" class="control-label col-sm-2">商品名</label>
							<div class="col-sm-9">
								<input type="text" name="code" id="code"
									class="form-control input-sm" />
							</div>
						</div>
						<div>
							お茶の種類 :<select name="origin">
								<option value="0">お茶の種類</option>
								<c:forEach var="originList" items="${originList}">
									<option value="${originList}">${originList}</option>
								</c:forEach>
							</select> グラム数 :<select name="piece">
								<option value="0">グラム数</option>
								<c:forEach var="pieceList" items="${pieceList}">
									<option value="${pieceList}">${pieceList}</option>
								</c:forEach>
							</select>
						</div>
						<div class="text-center">
							<button type="submit" value="検索" class="btn btn-primary">検索</button>
							<button type="reset" value="クリア" class="btn btn-default">クリア</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- table -->
	<div class="row">
		<div
			class="table-responsive col-lg-offset-1 col-lg-10 col-md-offset-1 col-md-10 col-sm-10 col-xs-12">
			<table class="table table-striped">
				<tbody>
					<tr>
						<c:forEach var="itemList" items="${itemList}">
							<th><a
								href="${pageContext.request.contextPath}/item/show/${itemList.id}">
									<img src="../img/<c:out value="${itemList.imagePath}/"/>"
									class="img-responsive img-rounded" width="200" height="600" />
							</a> <br> <a
								href="${pageContext.request.contextPath}/item/show/${itemList.id}">
									<c:out value="${itemList.name}" />
							</a> <br> 数量 : <c:out value="${itemList.piece}" />g <br>
								お茶の種類 : <c:out value="${itemList.origin}" /> <br></th>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- end container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>

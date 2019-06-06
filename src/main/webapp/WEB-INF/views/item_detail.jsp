<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ja">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/piza.css"/>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Insert title here</title>
   </head>
<body>
  <div class="container">
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
        	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            	<span class="icon-bar"></span>
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
						<a href="${pageContext.request.contextPath}/orderItem/cart"
							class="navbar-link">ショッピングカート🛒</a>&nbsp;&nbsp; <a
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
						<br>
						<br>
						<br>
						<br>
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
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-fluid -->
    </nav>
  </div>
  <form:form modelAttribute="orderItemForm" action="${pageContext.request.contextPath}/orderItem/addItem">
    <div class="row">
      <table class="table table-striped">
        <tr>
          <th>商品名</th>
          <td>
            <c:out value="${item.name}" />
          </td>
        </tr>
        <tr>
          <th>説明</th>
          <td>
            <c:out value="${item.description}" />
          </td>
        </tr>
        <tr>
          <th>パック数</th>
          <td>
            <c:out value="${item.piece}" />
          </td>
        </tr>
        <tr>
          <th>原産地</th>
          <td>
            <c:out value="${item.origin}" />
          </td>
        </tr>
        <tr>
          <th>画像</th>
          <td><img src="../img/<c:out value=" ${item.imagePath} "/>" /></td>
        </tr>
        <tr>
          <th>個数</th>
          <td>
            <form:select path="quantity" items="${quantityList}" />
          </td>
        </tr>
      </table> <input type="hidden" name="itemId" value="${item.id}"> <input type="submit" value="カートに入れる"> </div>
  </form:form>
  <a href="javascript:history.back();">商品一覧に戻る</a>
  <!-- end container -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
</body>
</html>

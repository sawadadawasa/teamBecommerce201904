<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/orderHistory.css"/>
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
						<img alt="main log" src="../img/tea_header_logo.png" height="35">
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
		
<strong>注文履歴</strong>

<table border="1" class="tableBorder sample01">
<tr>
  
    <td>注文日</td>
    <td>宛先氏名</td>
    <td>宛先Eメール</td>
    <td>宛先住所</td>
    <td>宛先TEL</td>
    <td>配達時間</td>
    <td>支払い方法</td>
    <td></td>
</tr>
<c:forEach items="${orderHistoryList}" var="orderHistory">
<tr>

    
    <td><fmt:formatDate value="${orderHistory.orderDate}" pattern="yyyy/MM/dd"/></td>
    <td><c:out value="${orderHistory.destinationName}"/></td>
    <td><c:out value="${orderHistory.destinationEmail}"/></td>
    <td><c:out value="${orderHistory.destinationAddress}"/></td>
    <td><c:out value="${orderHistory.destinationTel}"/></td>
    <td><fmt:formatDate value="${orderHistory.deliveryTime}" pattern="yyyy/MM/dd　HH時"/></td>
    <td><c:choose>
    	<c:when  test="${orderHistory.paymentMethod==0}">
    		代金引換
    	</c:when>
    	<c:when  test="${orderHistory.paymentMethod==1}">
    		クレジットカート
    	</c:when>
    </c:choose>
    
    </td>
    <td><a href ="${pageContext.request.contextPath}/orderItem/showHistoryDetail?orderId=${orderHistory.id}">詳細情報</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
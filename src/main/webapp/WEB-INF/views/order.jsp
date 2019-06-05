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

					<c:forEach items="${orderItemList}" var="orderItem">

						<tr>

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
					<span id="total-price">消費税：<c:out value="${viewTaxOfTotalPrice}" />円</span><br> 
					<span id="total-price">ご注文金額合計：<c:out value="${viewTotalPrice}" />円(税込)</span>
				</div>
			</div>
		</div>
		
<table border="1">
<form:form modelAttribute="orderForm" action="${pageContext.request.contextPath}/order/fix">
	
	<form:hidden path="id" value="${orderId}"/>
	<form:hidden path="userId" value="${user.id}"/>
<tr>
	<td>お名前</td><td><form:input path="destinationName"/></td>
</tr>
<tr>
	<td>メールアドレス</td><td><form:input path="destinationEmail"/></td>
</tr>
<tr>	
	<form:hidden path="totalPrice" value="10"/><!-- valueの10は後でtotalPriceに -->

</tr>
<tr>
	<td>郵便番号</td>
	<td>
		<form:input  path="postalCode" />
         &nbsp;&nbsp;
        <button id="btn" type="button">住所検索</button>
	</td>
</tr>
<tr>
	<td>住所</td>
	<td>
        <form:input path="destinationAddress"/>
	</td>
</tr>
<tr>	
	<td>TEL</td><td><form:input path="destinationTel"/></td>
</tr>
<tr>
	<td>配達日</td><td><form:input path="deliveryTime"/></td><!-- 後でdeliveryHourと合わせる -->
</tr>
<tr>
	<td>配達時間</td>
	<td><form:select path="deliveryHour">
			<form:options items="${hourList}"/>
		</form:select>
	時
	</td>
</tr>
<tr>
	<td>支払い方法</td>
	<td><form:radiobuttons path="paymentMethod" items="${paymentMethodList}" /></td>
</tr>
<br>
	<input type="submit" value="注文を確定する">
</form:form>
</table>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
<script>
	$(function(){
		console.log("debug");
    	$("#btn").on("click", function(){AjaxZip3.zip2addr('postalCode','','destinationAddress','destinationAddress')});
	});
</script>
</body>
</html>
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
		
<a href="${pageContext.request.contextPath}/order/deleteOrder?orderId=${orderId}"><c:out value="${deleteOrNotMessage}"/></a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>


<table border="1">
<form:form modelAttribute="orderForm" action="${pageContet.request.contetPath}/order/fix">

	<form:hidden path="userId" value="1"/><!-- 一次的にvalue 1に -->

<tr>
	<td>お名前</td><td><form:input path="destinationName"/></td>
</tr>
<tr>
	<td>メールアドレス</td><td><form:input path="destinationEmail"/></td>
</tr>
	
	<form:hidden path="totalPrice" value="10"/><!-- valueの10は後でtotalPriceに -->

<tr>
</tr>
<tr>
	<td>住所</td><td><form:input path="destinationAddress"/></td>
</tr>
<tr>	
	<td>TEL</td><td><form:input path="destinationTel"/></td>
</tr>
<tr>
	<td>配達時間</td><td><form:input path="deliveryTime"/></td>
</tr>
<tr>
	<td>支払い方法</td><td><form:input path="paymentMethod"/></td>
</tr>
<br>
	<input type="submit" value="注文を確定する">
</form:form>
</table>

</body>
</html>
	
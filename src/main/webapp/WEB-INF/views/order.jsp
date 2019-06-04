<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<title>Insert title here</title>
</head>

<body>


<table border="1">
<form:form modelAttribute="orderForm" action="${pageContet.request.contetPath}/order/fix">

	<form:hidden path="userId" value="2"/><!-- 一次的にvalue 1に -->

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
	<td>配達時間</td><td><form:input path="deliveryTime"/></td>
</tr>
<tr>
	<td>支払い方法</td><td><form:input path="paymentMethod"/></td>
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
<br>
</body>
</html>
	
	
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
<title>ピザ屋のネット注文</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/piza.css" rel="stylesheet">
</head>
<body>
<form:form modelAttribute ="orderItemForm" 
action="${pageContext.request.contextPath}/orderItem/addItem">
		<div class="row">
			<table class="table table-striped">
				<tr>
					<th>商品名</th>
					<td><c:out value="${item.name}" /></td>
				</tr>
				<tr>
					<th>説明</th>
					<td><c:out value="${item.description}" /></td>
				</tr>
				<tr>
					<th>パック数</th>
					<td><c:out value="${item.piece}" /></td>
				</tr>
				<tr>
					<th>原産地</th>
					<td><c:out value="${item.origin}" /></td>
				</tr>
				
				<tr>
					<th>画像</th>
					<td><img src="img/<c:out value="${item.imagePath}"/>" /></td>
				</tr>
				<tr>
					<th>個数</th>
					<td><form:select path="quantity" items="${quantityList}" /></td>
				</tr>
			</table>
				<input type="hidden" name="itemId" value="${item.id}">
				<input type="submit" value="カートに入れる">
		</div>
</form:form>
	
	<!-- end container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
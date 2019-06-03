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
				<td><c:out value="${viewPiece}" /></td>
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
				<th>在庫数</th>
				<td><form action="/book/update" method="post">
						<input type="text" name="stock"
							value="<c:out value="${item.id}"/>"> <input type="hidden"
							name="id" value="<c:out value="${item.id}"/>"> <input
							class="btn" type="submit" value="更新">
					</form></td>
			</tr>
		</table>
	</div>
	<!-- end container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
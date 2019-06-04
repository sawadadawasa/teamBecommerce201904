<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<strong>注文履歴</strong>

<table border="1">
<c:forEach items="${orderHistoryList}" var="orderHistory">
<tr>
	<td>宛先氏名</td>
	<td>宛先Eメール</td>
	<td>合計金額</td>
	<td>注文日</td>
	<td>宛先氏名</td>
	<td>宛先Eメール</td>
	<td>宛先住所</td>
	<td>宛先TEL</td>
	<td>配達時間</td>
	<td>支払い方法</td>
	<td><!-- 詳細情報 --></td>
	
</tr>

<tr>
	<td><c:out value="${orderHistory.id}"/></td>
	<td><c:out value="${orderHistory.userId}"/></td>
	<td><c:out value="${orderHistory.totalPrice}"/></td>
	<td><c:out value="${orderHistory.orderDate}"/></td>
	<td><c:out value="${orderHistory.destinationName}"/></td>
	<td><c:out value="${orderHistory.destinationEmail}"/></td>
	<td><c:out value="${orderHistory.destinationAddress}"/></td>
	<td><c:out value="${orderHistory.destinationTel}"/></td>
	<td><fmt:formatDate value="${orderHistory.deliveryTime}" pattern="yyyy/MM/dd"/></td>
	<td><c:out value="${orderHistory.paymentMethod}"/></td>
	<td><a href ="${pageContext.request.contextPath}/orderItem/showHistoryDetail?orderId=${orderHistory.id}">詳細情報</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>

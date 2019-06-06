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
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="form">
		<p class="form-title">退会</p>
		<form:form modelAttribute="userForm"
			action="${pageContext.request.contextPath}/user/delete">
			<p>メールアドレス</p>
			<p class="mail">
				<form:input path="email" placeholder="Email" />
				<form:errors path="email" cssStyle="color:red" />
			</p>
			<p>パスワード</p>
			<p>
			<p class="pass">
				<form:password path="password" placeholder="Password" />
				<form:errors path="password" cssStyle="color:red" />
			</p>

			<p class="submit">
				<input class="btn" type="submit" value="退会する">
			</p>
		</form:form>
	</div>
</body>
</html>
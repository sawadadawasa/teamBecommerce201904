<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録</title>
</head>
<body>
<div class="container">
	<h3>メンバー登録画面</h3>
	<div class="span8">
		<div class="row">
		<form:errors path="userForm.*" cssStyle="color:red" />
		<form:form modelAttribute="userForm" action="${pageContext.request.contextPath}/tea/create">
			<table class="table table-striped">
			  <tr>
			    <th>
			     	 氏名
			    </th>
			    <td>
			    	<form:input path="name"  placeholder="Name"/>
			    	<form:errors path="name" cssStyle="color:red" element="div"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      	メールアドレス
			    </th>
			    <td>
			    	<form:input path="email" placeholder="Email"/>
			    	<form:errors path="email" cssStyle="color:red" element="div"/>
			    </td>
			  </tr>
			  <tr>
			  	<th>
			  		住所
			  	</th>
			  	<td>
			  		<form:input path="address" placeholder="Address"/>
			  		<form:errors path="address" cssStyle="color:red" element="div"/>
			  	</td>
			  </tr>
			  <tr>
			  	<th>
			  		電話番号
			  	</th>
			  	<td>
			  		<form:input path="telephone" placeholder="Telephone"/>
			  		<form:errors path="telephone" cssStyle="color:red" element="div"/>
			  	</td>
			  </tr>
			  <tr>
			    <th>
			     	 パスワード
			    </th>
			    <td>
			    	<form:password path="password" placeholder="Password"/>
			    	<form:errors path="password" cssStyle="color:red" element="div"/><br>
			    </td>
			  </tr>
			  
			  <tr>
			    <th>
			     	 パスワード(確認用)
			    </th>
			    <td>
			    	<form:password path="passwordConfirm" placeholder="PasswordConfirm"/>
			    </td>
			  </tr>
			  
			  <tr>
			    <td>
					<input class="btn" type="submit" value="登録">
			    </td>
			  </tr>
			</table>
		  </form:form>
		</div>
	</div>
</div>
</body>
</html>
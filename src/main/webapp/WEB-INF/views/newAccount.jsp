<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<title>新規登録</title>
</head>
<body>
<div class="container">
	<h3>メンバー登録画面</h3>
	<div class="span8">
		<div class="row">
<<<<<<< HEAD
		<form:errors path ="userForm.*" cssStyle="color:red" />
=======
		<form:errors path="userForm.*" cssStyle="color:red" />
>>>>>>> 2055ddef02e78d57ece1714b9637f69a85ead6dd
		<form:form modelAttribute="userForm" action="${pageContext.request.contextPath}/user/create">
			<table class="table table-striped">
			  <tr>
			    <th>
			     	 お名前
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
			  		郵便番号
			  	</th>
				<td>
					<form:input path="postalCode" placeholder="1234567"/> &nbsp;&nbsp;
					<button id="btn" type="button">住所検索</button>
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
			  		TEL
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
				<script
					src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
				<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
				<script>
					$(function() {
						console.log("debug");
						$("#btn").on(
								"click",
								function() {
									AjaxZip3.zip2addr('postalCode', '',
											'address',
											'address')
								});
					});
				</script>

			</div>
	</div>
</div>
</body>
</html>
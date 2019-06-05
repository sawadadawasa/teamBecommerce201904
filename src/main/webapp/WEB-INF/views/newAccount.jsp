<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
<title>新規登録</title>
</head>
<body>
<div id="form">
	<p class="form-title">メンバー登録画面</p>
		<form:errors path ="userForm.*" cssStyle="color:red" />
		<form:form modelAttribute="userForm" action="${pageContext.request.contextPath}/user/create">
			     	<p> お名前</p>

			    	<form:input path="name"  placeholder="Name"/>
			    	<form:errors path="name" cssStyle="color:red" element="div"/>
			    
			      	<p>メールアドレス</p>
			    
			    	<form:input path="email" placeholder="Email"/>
			    	<form:errors path="email" cssStyle="color:red" element="div"/>
			   
			  		<p>郵便番号</p>
			  	
					<form:input path="postalCode" placeholder="1234567"/> &nbsp;&nbsp;
					<button id="btn" type="button">住所検索</button>
				
				<p>住所</p>
				
			  		<form:input path="address" placeholder="Address"/>
			  		<form:errors path="address" cssStyle="color:red" element="div"/>
			  	
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
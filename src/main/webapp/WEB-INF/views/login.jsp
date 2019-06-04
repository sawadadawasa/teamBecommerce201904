<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
<div class="container">
	<div class="span8">
		<img src="img/header_logo_bk.png/" >
		<div class="row">
		<form:errors path="loginForm" cssStyle="color:red"/>
		<form:form modelAttribute="loginForm" action="${pageContext.request.contextPath}/tea/login">
			<table class="table table-striped">
			  <tr>
			    <th>
			    	 メールアドレス
			    </th>
			    <td>
			    	<form:input path="email" placeholder="Email"/>
			    	<form:errors path="email" cssStyle="color:red"/>
			    </td>
			  </tr>
			  <tr>
			    <th>
			      	パスワード
			    </th>
			    <td>
			    	<form:password path="password" placeholder="Password"/>
			    	<form:errors path="password" cssStyle="color:red"/>
			    </td>
			  </tr>
			  <tr>
			  	<td></td>
			    <td>
					<input class="btn" type="submit" value="ログイン">
			    </td>
			  </tr>
			</table>
		  </form:form>
		  <a href="${pageContext.request.contextPath}/user/form" id="toInsertMember">メンバー登録はこちらから</a>
		</div>
	</div>
</div>
</body>
</html>

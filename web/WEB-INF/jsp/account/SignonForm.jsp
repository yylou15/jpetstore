<%@ include file="../common/IncludeTop.jsp"%>
${sessionScope.message}
<div id="Catalog">
	<form action="login" method="post" name="signon">
		<p>Please enter your username and password.</p>
		<p>Username:<input type="text" name="username"></p>
		<p>Password:<input type="password" name="password"></p>
		<input type="submit" name="login" value="Login">
	</form>
	Need a user name and password? <a href="newAccount">Register Now!</a>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>


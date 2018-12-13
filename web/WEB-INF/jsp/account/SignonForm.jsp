<%@ include file="../common/IncludeTop.jsp"%>
<div id="Catalog">
	<form action="login" method="post" name="signon" role="form" style="width: 400px;margin: 0 auto">
		<span style="color: red;font-weight: bold">${sessionScope.message}</span>
		<div class="row">
			<div class="col-12">
				<p>Please enter your username and password.</p>
			</div>
		</div>
		<div class="row">
			<div class="col-4">
				<label for="username">Username:</label>
			</div>
			<div class="col-8">
				<input type="text" name="username" id="username" class="form-control">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-4">
				<label for="password">password:</label>
			</div>
			<div class="col-8">
				<input type="text" name="password" id="password" class="form-control">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-4">
				<label for="verify">VerifyCode:</label>
			</div>
			<div class="col-4">
				<input type="text" name="verifyCode" id="verify" class="form-control">
			</div>
			<div class="col-4">
				<img src="VerifyCode"  alt="看不清？换一张" title="看不清？换一张" width="100%" height="38px" onclick="changeVerify(this)">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-12">
				<input type="submit" name="login" value="Login">
			</div>
		</div>
	</form>
	Need a user name and password? <a href="newAccount">Register Now!</a>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>


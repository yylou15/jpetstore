<%@ include file="../common/IncludeTop.jsp"%>
<div id="Catalog">
	<div role="form" style="width: 400px;margin: 0 auto">
		<span id="SignInInfo" style="color: red;font-weight: bold"></span>
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
				<input type="password" name="password" id="password" class="form-control">
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
				<img src="VerifyCode"  alt="Verify Code" title="Not clear?Click to change!" width="100%" height="38px" onclick="changeVerify(this)">
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-12">
				<button id="submitForm" class="button btn-primary">Sign In</button>
			</div>
		</div>
	</div>
	Need a user name and password? <a href="newAccount">Register Now!</a>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>


<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	${sessionScope.message}
	<form action="createNewAccount" method="post">
		<h3>User Information</h3>

		<table>
			<tr>
				<td>User ID:</td>
				<td><input type ="text" name="username" /></td>
			</tr>
			<tr>
				<td>New password:</td>
				<td><input type ="text"name="password" /></td>
			</tr>
			<tr>
				<td>Repeat password:</td>
				<td><input type ="text" name="repeatedPassword" /></td>
			</tr>
			<tr>
				<td>Enter VerifyCode:</td>
				<td>
					<input type ="text" name="verifyCode" />
					<img src="VerifyCode" alt="Not clear?Click to change!" onclick="changeVerify(this)">
				</td>
			</tr>
		</table>

		<%@ include file="IncludeAccountFields.jsp"%>
		<input type ="submit" name="newAccount" value="Create New Account" />

	</form></div>
<%@ include file="../common/IncludeBottom.jsp"%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
<<<<<<< HEAD
	<form action="saveAccountInfomation?username=${sessionScope.username}" method="post">
=======
	<form action="#" method="post">
>>>>>>> 1212

	<h3>User Information</h3>

	<table>
		<tr>
			<td>User ID:</td>
<<<<<<< HEAD
			<td>${sessionScope.username}</td>
=======
			<td>${actionBean.username}</td>
>>>>>>> 1212
		</tr>
		<tr>
			<td>New password:</td>
			<td><input type="text" name="password"/></td>
		</tr>
		<tr>
			<td>Repeat password:</td>
			<td><input type="text" name="repeatedPassword"/></td>
		</tr>
	</table>
	<%@ include file="IncludeAccountFields.jsp"%>
		<input type="submit" name="editAccount" value="Save Account Information"/>

</form>
<<<<<<< HEAD
	<a href="myOrder?orderId=${sessionScope.order.orderId}">My Orders</a>
=======
	<a href="myOrder">My Orders</a>
>>>>>>> 1212
</div>

<%@ include file="../common/IncludeBottom.jsp"%>

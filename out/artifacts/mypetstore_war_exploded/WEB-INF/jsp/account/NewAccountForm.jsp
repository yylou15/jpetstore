<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<div id="app">
		<form action="#" method="post">
			<h3>User Information</h3>

			<table class="table table-hover">
				<tr>
					<td>User ID:</td>
					<td><input type ="text" name="username" /></td>
				</tr>
				<tr>
					<td>New password:</td>
					<td><input type ="text" name="password" /></td>
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
			<input type ="submit" name="newAccount" value="Save Account Information" />

		</form>
	</div>
</div>


<%--<script>--%>
    <%--new Vue({--%>
        <%--el:"#app",--%>
        <%--data:{--%>
            <%--userInfomation:{--%>
				<%--userId:'',--%>
				<%--pwd:'',--%>
				<%--confirm:''--%>
			<%--},--%>
			<%--accountInformation:{--%>
				<%--firstName:'',--%>
				<%--lastName:'',--%>
				<%--email:'',--%>
				<%--phone:'',--%>
				<%--address1:'',--%>
				<%--address2:'',--%>
				<%--city:'',--%>
				<%--state:'',--%>
				<%--zip:'',--%>
				<%--country:''--%>
			<%--},--%>
			<%--profileInfomation:{--%>
                <%--languagePreference:[--%>
                    <%--'english','japanese'--%>
				<%--],--%>
                <%--favouriteCategory:[--%>
                    <%--'FISH','DOG','REPTILES','CATS','BIRDS'--%>
				<%--],--%>
                <%--enableMyList:--%>
            <%--}--%>
        <%--},--%>
        <%--methods:{--%>

        <%--}--%>
    <%--})--%>
<%--</script>--%>

<%@ include file="../common/IncludeBottom.jsp"%>


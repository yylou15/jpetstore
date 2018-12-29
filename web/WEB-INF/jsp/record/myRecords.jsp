<%--
  Created by IntelliJ IDEA.
  User: lou
  Date: 2018/12/13
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>

<div class="container">
    <table class="table log-table table-hover table-bordered table-striped">
        <caption style="caption-side: top">
            User Log Infomation
        </caption>
        <thead>
            <tr>
                <th>User Name</th>
                <th>Action</th>
                <th>Details</th>
                <th>Create Time</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="logItem" items="${sessionScope.logList}">
            <tr>
                <td>${logItem.userId}</td>
                <td>${logItem.action}</td>
                <td>${logItem.details}</td>
                <td>${logItem.createTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br><br><br>
</div>


<%@ include file="../common/IncludeBottom.jsp"%>
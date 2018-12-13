<%--
  Created by IntelliJ IDEA.
  User: Ice
  Date: 2018/12/9
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

    <table>
        <tr>
            <th>&nbsp;</th>
            <th>Product ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="product" items="${sessionScope.productList}">
            <tr>
            <td>
                    ${product.description}
            </td>
            <td>
                    ${product.productId}
            </td>
            <td>
                    ${product.name}
            </td>
            </tr>
        </c:forEach>

    </table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>
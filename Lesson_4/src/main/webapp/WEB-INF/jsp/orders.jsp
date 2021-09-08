<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Orders</title>
</head>

<body>
    <a href="/index">Main</a><br>
    <br><h1>Orders</h1>
    <br>
    <ul>
        <c:forEach items="${orders}" var="order">
            <li>
                <p>ID: <c:out value="${order.id}"/></p>
                <p>DATE: <c:out value="${order.date}"/></p>
                <p>COST: <c:out value="${order.cost}"/></p>
                <p>PRODUCT LIST: <c:out value="${order.stringProductList()}"/></p>
            </li>
        </c:forEach>
    </ul>
</body>
</html>

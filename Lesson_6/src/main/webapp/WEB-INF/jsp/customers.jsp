<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Customers</title>
</head>

<body>
<a href="index">Main page</a><br>
<br><a href="customers-add">Add new customer</a><br>
<br><h1>Customers</h1><br>
<ul>
    <c:forEach items="${customers}" var="customer">
        <li>
            <p>ID: <c:out value="${customer.id}"/></p>
            <p>NAME: <c:out value="${customer.name}"/></p>
            <p>PRODUCTS BOUGHT: <c:out value="${customer.products}"/></p>
        </li>
    </c:forEach>
</ul>
</body>
</html>
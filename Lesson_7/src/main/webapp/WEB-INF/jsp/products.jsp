<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Products</title>
    </head>

    <body>
        <a href="index">Main page</a><br>
        <br><a href="products/add">Add new product</a><br>
        <br><h1>Products</h1><br>
        <ul>
            <c:forEach items="${products}" var="product">
                <li>
                    <p>ID: <c:out value="${product.id}"/></p>
                    <p>NAME: <c:out value="${product.title}"/></p>
                    <p>PRICE: <c:out value="${product.price}"/></p>
                    <p>CUSTOMERS: <c:out value="${product.customers}"/></p>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<head>
    <title>Add new author</title>
</head>

<body>
<a href="/index">Main</a><br>
<br><h1>Customer:</h1><br>
<ul>
    <li>ID: <c:out value="${customer.id}"/></li>
    <li>NAME: <c:out value="${customer.name}"/></li>
    <li>PRODUCTS BOUGHT: <c:out value="${customer.products}"/></li>
</ul>

<br><h1>Sell product to customer:</h1><br>
<form:form modelAttribute="product" method="post">
    <br>ID: <form:input path="id"/><br>
    <br><input type="submit" value="Sell product">
</form:form>

</body>
</html>

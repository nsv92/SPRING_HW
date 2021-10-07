<%@ taglib prefix="customer_form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<head>
    <title>Add new author</title>
</head>

<body>
<a href="/index">Main</a><br>
<br><h1>Product:</h1><br>
<ul>
    <li>ID: <c:out value="${product.id}"/></li>
    <li>TITLE: <c:out value="${product.title}"/></li>
    <li>PRICE: <c:out value="${product.price}"/></li>
    <li>CUSTOMERS: <c:out value="${product.customers}"/></li>
</ul>

<br><h1>Add customer to product:</h1><br>
<customer_form:form modelAttribute="customer" method="post">
    <br>ID: <customer_form:input path="id"/><br>
    <br><input type="submit" value="Sell product">
</customer_form:form>

</body>
</html>
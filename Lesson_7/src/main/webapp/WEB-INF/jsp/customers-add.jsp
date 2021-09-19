<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<head>
    <title>Add new author</title>
</head>

<body>
<a href="/index">Main</a><br>
<br><h1>Add new customer</h1><br>
<form:form modelAttribute="customer" method="post">
    <br>ID: <form:input path="id"/>
    <br>
    <br>NAME: <form:input path="name"/>
    <br>
<%--    <br>PRICE: <form:input path="price"/>--%>
<%--    <br>--%>
    <input type="submit" value="Add customer">
</form:form>

</body>
</html>

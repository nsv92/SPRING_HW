<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<head>
    <title>Add new author</title>
</head>

<body>
    <a href="/index">Main</a><br>
    <br><h1>Add new product</h1><br>
    <form:form modelAttribute="product" method="post">
<%--        ID: <form:input path="id"/>--%>
        <br>
        <br>NAME: <form:input path="title"/>
        <br>
        <br>PRICE: <form:input path="price"/>
        <br>
        <input type="submit" value="Add product">
    </form:form>

</body>
</html>

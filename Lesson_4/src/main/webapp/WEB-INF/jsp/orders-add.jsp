<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<head>
  <title>Add new author</title>
</head>

<body>
  <a href="/index">Main</a><br>
  <br><h1>Add new order</h1>
  <form:form modelAttribute="order" method="post">
    ID: <form:input path="id"/>
    <br>
    <input type="submit" value="Add product">
  </form:form>
</body>
</html>
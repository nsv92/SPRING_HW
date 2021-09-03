<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Add new author</title>
</head>
<body>
  <a href="/Lesson_3_example_war/index">Main</a><br>
  <br><h1>Add new order</h1>
  <form th:action="@{'/orders/add'}" th:object="${order}" method="post">
  <%--  разобраться как отдать id из формы в метод setId()--%>
    ID: <input type="text" th:field="*{id}"/>
    <br>
    <button type="submit">Save</button>
  </form>
</body>
</html>
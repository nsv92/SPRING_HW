<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Add new author</title>
</head>

<body>
    <a href="/Lesson_3_example_war/index">Main</a><br>
    <br><h1>Add new product</h1>
    <form th:action="@{'/products/add'}" th:object="${product}" method="post">
        ID: <input type="text" th:field="*{id}"/>
        <br>
        NAME: <input type="text" th:field="*{name}"/>
        <br>
        PRICE: <input type="text" th:field="*{price}"/>
        <br>
        <button type="submit">Save</button>
    </form>
</body>
</html>

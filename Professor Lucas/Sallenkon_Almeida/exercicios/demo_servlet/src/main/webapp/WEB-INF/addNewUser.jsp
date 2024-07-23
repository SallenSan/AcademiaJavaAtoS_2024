<%--
  Created by IntelliJ IDEA.
  User: a867759
  Date: 7/13/2024
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding a new user</title>
</head>
<body>
<form action="addNewUser" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required/>
    <br/>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required/>
    <br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required/>
    <br/>
    <button type="submit">Add</button>
</form>

</body>
</html>

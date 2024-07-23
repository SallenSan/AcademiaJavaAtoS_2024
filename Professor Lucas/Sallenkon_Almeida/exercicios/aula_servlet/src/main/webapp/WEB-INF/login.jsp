<%--
  Created by IntelliJ IDEA.
  User: a867759
  Date: 7/8/2024
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet login</title>
</head>
<body>
<h1>Minha página de login</h1>
<form action="login" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required/>
    <br/>
    <label for="password">Password</label>
    <input type="password" id="password" name="password" required/>
    <br/>
    <button type="submit">Login</button>
</form>
</body>
</html>

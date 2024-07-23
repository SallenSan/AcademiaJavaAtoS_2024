<%--
  Created by IntelliJ IDEA.
  User: a867759
  Date: 7/13/2024
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users in database</title>
</head>
<body>
<header>
    <c:choose>
        <c:when test="${not empty user}">
            <p>Usuário autenticado: ${user.name}</p>
            <a href="logout">Logout</a>
        </c:when>
        <c:otherwise>
            <p>Usuário não autenticado</p>
            <a href="login">Login</a>
        </c:otherwise>
    </c:choose>
</header>
    <h2>Users in database</h2>
    <ul>
        <c:if test="${not empty user}">
            <c:forEach items="${users}" var="user">
                <li>${user}</li>
            </c:forEach>
        </c:if>

    </ul>
<a href="index.jsp">Home</a>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Example</title>
    <link href="index.css" rel="stylesheet" type="text/css">
</head>
<body>
<br>
<center>
    <h1 class="h">Table-Users</h1>
    <form method="get">
        <table border=2 class="tabla">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Password</th>
                <th>Role</th>
                <th>UPDATE</th>
                <th>DELETE</th>
            </tr>
            <c:forEach var="user" items="${list}">
                <tr>
                    <td><input type="text" name="id"  value="${user.id}"/></td>
                    <td><input type="text" name="name"  value="${user.name}"/></td>
                    <td><input type="text" name="password" value="${user.password}"/></td>
                    <td><input type="text" name="role" value="${user.role}"/></td>
                    <th><a href="update?id=<c:out value="${user.id}"/>" style=text-decoration:none;"><input
                            type="button" id="update_id" value="Update" class="tag"/></a></th>
                    <th><a href="delete?id=<c:out value="${user.id}"/>" style=text-decoration:none;"><input
                            type="button" id="delete_user" value="Delete" class="tag"/></a></th>
                </tr>
            </c:forEach>
            <tr>
                <th colspan="7"><a href="user.jsp" style="text-decoration:none;">
                    <input type="button" action="/add" id="add_user" value="Добавить" class="tag"/>
                </a></th>
            </tr>
        </table>
    </form>
</center>
<br>
</body>
</html>

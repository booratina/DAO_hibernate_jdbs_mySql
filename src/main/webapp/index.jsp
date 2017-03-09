<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<jsp:forward page="/UserController?action=listUser" />
</body>

</form>
</html>

<%--
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
                    <th><c:out value="${user.id}"/></th>
                    <th><c:out value="${user.name}"/></th>
                    <th><c:out value="${user.password}"/></th>
                    <th><c:out value="${user.role}"/></th>
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
</html>--%>

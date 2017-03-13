<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css"
          href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    <title>Upd_user</title>
</head>
<body>

<form method="POST" action='/update' name="formUpdUser">
    User ID :
    <input type="text" readonly="readonly" name="id"
           value="<c:out value="${user.id}" />"/> <br/>
    name :
    <input type="text" name="name"  value="${user.name}"/> <br/>

    password : <input type="text" name="password"  value="${user.password}"/> <br/>

    role :  <input type="text" name="role"  value="${user.role}"/> <br/>

    <p><input type="submit"></p>
</form>


</body>
</html>
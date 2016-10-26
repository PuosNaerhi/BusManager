<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %><html>
<head>
    <title>User update</title>
</head>
<body>
<form action='/userupdate/${UserId}' method="POST" enctype="application/x-www-form-urlencoded" >
    <table>
        <tr><td>Username</td><td><input type="text" name="username" value="${UserObject.username}"/></td></tr>
        <tr><td>Email</td><td><input type="text" name="email" value="${UserObject.email}"/></td></tr>
    </table>
    <button type="submit">Update User</button>
</form>

</body>
</html>

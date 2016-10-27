<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<a href="<c:url value='/home' />">Back home</a>
<table>
    <tr><td>Username</td><td>Email</td></tr>
    <c:forEach items="${Users}" var="User">
        <tr>
            <td>${User.username}</td>
            <td><a href="<c:url value='/userupdate/${User.id}' />">update</a></td>
            <td><a href="<c:url value='/userdelete/${User.id}' />">delete</a></td>
            <td><a href="<c:url value='/userprofile/${User.id}' />">profile</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

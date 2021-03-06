<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Bus Manager App</title>
</head>
<body>

<ul>
    <sec:authorize access="isAnonymous()">
        <li><a href='<c:url value="/login" />'>Login</a></li>
        <li><a href="<c:url value='/register' />">Register User</a></li>

    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <table>
            <tr><td>id</td><td>Start LocatioBusn</td><td>End Location</td><td>Size</td></tr>
            <c:forEach items="${BusObjects}" var="BusObject">
                <tr>
                    <td>${BusObject.id}</td>
                    <td>${BusObject.startLocation}</td>
                    <td>${BusObject.endLocation}</td>
                    <td>${BusObject.busSize}</td>
                    <td><a href="<c:url value='/update/${BusObject.id}' />">update</a></td>
                    <td><a href="<c:url value='/delete/${BusObject.id}' />">delete</a></td>
                    <td><a href="<c:url value='/bus/${BusObject.id}' />">places</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="<c:url value='/create' />">Create Bus</a>
        <li><a href='<c:url value="/profile" />'>Profile</a></li>
        <li><a href='<c:url value="/userlist" />'>User List</a></li>
        <li><a href='<c:url value="/logout" />'>Logout</a></li>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
        <table>
            <tr><td>id</td><td>Start LocatioBusn</td><td>End Location</td><td>Size</td></tr>
            <c:forEach items="${BusObjects}" var="BusObject">
                <tr>
                    <td>${BusObject.id}</td>
                    <td>${BusObject.startLocation}</td>
                    <td>${BusObject.endLocation}</td>
                    <td>${BusObject.busSize}</td>
                    <td><a href="<c:url value='/bus/${BusObject.id}' />">places</a></td>
                </tr>
            </c:forEach>
        </table>
        <li><a href='<c:url value="/profile" />'>Profile</a></li>
        <li><a href='<c:url value="/logout" />'>Log out</a></li>


    </sec:authorize>
</ul>

</body>
</html>

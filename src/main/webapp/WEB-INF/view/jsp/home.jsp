<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Bus Manager App</title>
</head>
<body>

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
</body>
</html>

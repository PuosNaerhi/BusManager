<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h2>${UserProfile.username}</h2>
    <h2>${UserProfile.email}</h2>
<table>
        <tr><td>Bus id</td><td>Place Number</td></tr>
        <c:forEach items="${ReservedPlaces}" var="ReservedPlace">
            <tr>
                <td>${ReservedPlace.busEntity.id}</td>
                <td>${ReservedPlace.placeNumber}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

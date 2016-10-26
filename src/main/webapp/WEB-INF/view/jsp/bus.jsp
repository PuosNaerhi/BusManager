<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Bus Manager App</title>
</head>
<body>

<h1>Placenumber's</h1>
<form action='/bus/${BusObject.id}' method="POST" enctype="application/x-www-form-urlencoded">
<table>
    <c:if test="${BusObject.busSize == '21'}"><c:set var="backSeat" value="14"/></c:if>
    <c:if test="${BusObject.busSize == '37'}"><c:set var="backSeat" value="30"/></c:if>
    <c:if test="${BusObject.busSize == '53'}"><c:set var="backSeat" value="46"/></c:if>

    <c:forEach begin="0" end="1" varStatus="j">
        <c:set var="count" value="${j.index}"/>
            <tr>
            <c:forEach items="${PlaceObjects}" step="1" varStatus="i" var="PlaceObject">

                <c:if test="${j.index < 2}">
                    <c:if test="${count eq i.index}">
                        <c:if test="${!i.last}">
                            <td>
                                <input type="radio" name="placeId" value=" ${PlaceObject.id}" ${PlaceObject.reserved == true ? 'disabled' : ''}>
                                ${PlaceObject.placeNumber}
                            </td>
                            <c:set var="count" value="${count+4}"/>
                        </c:if>
                    </c:if>
                </c:if>
            </c:forEach>
            </tr>
    </c:forEach>
    <c:set var="count" value="2"/>
    <tr>
        <c:forEach items="${PlaceObjects}" step="1" varStatus="i" var="PlaceObject">
                <c:if test="${count eq i.index}">
                    <c:if test="${count <= backSeat}">
                        <td> </td>
                    </c:if>
                    <c:if test="${count > backSeat}">
                        <td>
                            <input type="radio" name="placeId" value=" ${PlaceObject.id}" ${PlaceObject.reserved == true ? 'disabled' : ''}>
                                ${PlaceObject.placeNumber}
                        </td>
                    </c:if>
                    <c:set var="count" value="${count+4}"/>
                </c:if>

        </c:forEach>
    </tr>
    <c:forEach begin="2" end="3" varStatus="j">
        <c:set var="count" value="${j.index}"/>
        <tr>
            <c:forEach items="${PlaceObjects}" step="1" varStatus="i" var="PlaceObject">
                    <c:if test="${count eq i.index}">
                            <td>
                                <input type="radio" name="placeId" value=" ${PlaceObject.id}" ${PlaceObject.reserved == true ? 'disabled' : ''}>
                                    ${PlaceObject.placeNumber}
                            </td>
                        <c:if test="${count >= backSeat}">
                            <c:set var="count" value="${count+5}"/>
                        </c:if>
                        <c:if test="${count < backSeat}">
                            <c:set var="count" value="${count+4}"/>
                        </c:if>
                    </c:if>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
    Reserver name: <input type="text" value="${Reserver}" disabled/>
    <input type="hidden" name="reserver" value="${Reserver}"/>
    <br>
    <button type="submit">Reserve place</button>
</form>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<table>
    <tr><td>Reservation maker</td><td>Place Number</td></tr>
    <c:forEach items="${PlaceObjects}" var="PlaceObject">
        <c:if test="${PlaceObject.reserved}">
        <tr>
            <td>${PlaceObject.reservationMaker}</td>
            <td>${PlaceObject.placeNumber}</td>
        </tr>
        </c:if>
    </c:forEach>
</table>
    </sec:authorize>
</body>
</html>


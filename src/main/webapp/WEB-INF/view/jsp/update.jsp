<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Update Bus</title>
</head>
<body>
<form action='/update/${BusObject.id}' method="POST" enctype="application/x-www-form-urlencoded" >
    <table>
        <tr><td>Start Location</td><td><input type="text" name="startLocation" value="${BusObject.startLocation}"/></td></tr>
        <tr><td>End Location</td><td><input type="text" name="endLocation" value="${BusObject.endLocation}"/></td></tr>
        <tr><td>Size</td>
            <td>
            <select name="busSize">
                <option value="21" ${BusObject.busSize == '21' ? 'selected' : ''}>21</option>
                <option value="37" ${BusObject.busSize == '37' ? 'selected' : ''}>37</option>
                <option value="53" ${BusObject.busSize == '53' ? 'selected' : ''}>53</option>
            </select>
            </td>
        </tr>

    </table>
    <button type="submit">Update Bus</button>
</form>
</body>
</html>

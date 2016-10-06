<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Create Bus</title>
</head>
<body>
<form action="create" method="POST" enctype="application/x-www-form-urlencoded" >
    <table>
        <tr><td>Start Location</td><td><input type="text" name="startLocation" /></td></tr>
        <tr><td>End Location</td><td><input type="text" name="endLocation" /></td></tr>
        <tr>
            <td>Size</td>
            <td>
                <select  name="busSize">
                    <option value="21">21</option>
                    <option value="37">37</option>
                    <option value="53">53</option>
                </select>
            </td>
        </tr>
    </table>
    <button type="submit">New Bus</button>
</form>

</body>
</html>

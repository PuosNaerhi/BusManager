<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<a href="<c:url value='/home' />">Back home</a>
<h2>Register User</h2>


<form action="register" method="POST" enctype="application/x-www-form-urlencoded" >
<table>

   <tr><td>Username</td><td><input type="text" name="username" /></td></tr>
   <tr><td>Password</td><td><input type="text" name="password" /></td></tr>
   <tr><td>Email</td><td><input type="text" name="email" /></td></tr>

</table>
<button type="submit">Register</button>
</form>
</body>
</html>

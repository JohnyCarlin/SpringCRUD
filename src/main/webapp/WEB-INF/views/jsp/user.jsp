<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
    <title>UserPage</title>
</head>
<body>
<h1 align="center">Hello, <c:out value='${name}' /></h1>
<a href="/login" align="right">Logout</a>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>

    <h1 align="center">User Management</h1>
    <h2 align="center">
        <a  href="new">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="">List All Users</a>

    </h2>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Password</th>
            <th>Email</th>
            <th>Country</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.userId}" /></td>
                <td><c:out value="${user.username}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td><c:out value="${user.userEmail}" /></td>
                <td><c:out value="${user.userCountry}" /></td>
                <td><c:out value="${user.userRole}" /></td>

                <td>
                    <a href="edit?id=<c:out value='${user.userId}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${user.userId}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
    <a href="/login" align="right">Logout</a>
</body>
</html>
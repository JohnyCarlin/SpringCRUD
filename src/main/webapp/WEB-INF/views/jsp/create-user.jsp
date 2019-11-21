<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>

    <h1 align="center">User Management</h1>
    <h2 align="center">
        <a href="new">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Users</a>
    </h2>

<div align="center">

    <c:if test="${user != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
        <form action="insert" method="post">
            </c:if>

            <table border="1" cellpadding="5">

                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.userId}' />" />
                </c:if>
                <tr>
                    <th>User Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${user.username}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Password: </th>
                    <td>
                        <input type="text" name="password" size="45"
                               value="<c:out value='${user.password}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>User Email: </th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="<c:out value='${user.userEmail}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Country: </th>
                    <td>
                        <input type="text" name="country" size="15"
                               value="<c:out value='${user.userCountry}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Role: </th>
                    <td>
                        <input type="text" name="role" size="15"
                               value="<c:out value='${user.userRole}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
    <a href="/login" align="right">Logout</a>
</body>
</html>
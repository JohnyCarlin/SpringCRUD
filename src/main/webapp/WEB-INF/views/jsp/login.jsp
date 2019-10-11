<html>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<head><title>First JSP</title></head>
<body>

<div class="row align-items-center justify-content-center">
    <form name="user" action="spring-mvc-default" method="post" style="background-color: deepskyblue">
        <legend>Add User</legend>
        <div class="form-group" align="left">
            <label for="name">Name</label>
            <input id="name" type="text" name="name"/>
        </div>
        <div class="form-group" align="left">
            <label for="lastName">Last name</label>
            <input id="lastName" type="text" name="lastName"/>
        </div>
        <input type="submit" value="   Register   "/>
    </form>
</div>

<h2>Users${users}</h2>
<div class="container">
    <TABLE>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.lastName}"/></td>
            </tr>
        </c:forEach>
    </TABLE>
</div>

</body>
</html>
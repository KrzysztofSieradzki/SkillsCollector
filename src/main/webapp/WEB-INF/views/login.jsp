<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sony
  Date: 12.01.2020
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div>
        <form method="post" action="/login">
            <label>Username:
                <input type="text" name="username"/>
            </label>
            <label>Password:
                <input type="password" name="password"/>
            </label>
            <label><input type="submit" value="Zaloguj"/></label>
            <label><input type="reset" value="Resetuj"/></label>
        </form>
    </div>

    <c:if test="${error!=null}">
        <p style="color: red">${error}</p>
    </c:if>
</body>
</html>

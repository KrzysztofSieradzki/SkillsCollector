<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sony
  Date: 12.01.2020
  Time: 09:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Rejestracja</title>

</head>
<body>
 <jsp:include page="fragments/header.jsp"/>

 <h1>Rejestracja</h1>



<div>
    <form action="/register" method="post">

        <label for="username"><h2>Username:</h2>
            <input id="username" name="username" type="text" value="${user.username}"/>
        </label>
        <label for="password"><h2>Password:</h2>
            <input id="password" name="password" type="password"/>
        </label>
        <label for="firstname"><h2>First name:</h2>
            <input id="firstname" name="firstname" type="text" />
        </label>
        <label for="lastname"><h2>Last name:</h2>
            <input id="lastname" name="lastname" type="text" />
        </label><br/>
        <label><input type="submit" value="Zarejestruj"/></label>
        <label><input type="reset" value="Wyczyść"/></label>
    </form>
</div>

 <c:if test="${error!=null}">
     <p style="color: red">${error}</p>
 </c:if>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

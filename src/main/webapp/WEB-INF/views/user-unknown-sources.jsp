<%--
  Created by IntelliJ IDEA.
  User: Sony
  Date: 14.01.2020
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Unknown Sources</title>

</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<% int counter = 1;%>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name of Source</th>
        <th>Description</th>
        <th>Skills</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${sources}" var="source">
        <tr>
            <td><%=counter++%></td>

            <td>${source.key.name}</td>
            <td>${source.key.description}</td>
            <td>${source.value}</td>
            <td><form method="post" action="/user/unknown-sources">
                <button type="submit">Add</button>
                <input type="hidden" value="${source.key.id}" name="sourceId">
            </form></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<jsp:include page="fragments/footer.jsp"/>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Sony
  Date: 12.01.2020
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Sources</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<% int counter = 1;%>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name of Source</th>
                <th>Description</th>
<%--                <th>Skills</th>--%>
            </tr>
        </thead>
        <tbody>

            <c:forEach items="${sources}" var="source">
            <tr>
                <td><%=counter++%></td>
                <td>${source.name}</td>
                <td>${source.description}</td>
<%--                <td>${source.skills}</td>--%>
            </tr>
            </c:forEach>

        </tbody>
    </table>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

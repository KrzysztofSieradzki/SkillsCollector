<%--
  Created by IntelliJ IDEA.
  User: Sony
  Date: 12.01.2020
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Skills</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<% int counter = 1;%>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Skill</th>
        <th>Level</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${skills}" var="skill">
            <tr>
                <td><%=counter++%></td>
                <td>${skill.key.name}</td>
                <td>${skill.value}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

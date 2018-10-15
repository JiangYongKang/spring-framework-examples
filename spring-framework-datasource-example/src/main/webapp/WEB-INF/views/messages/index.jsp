<%--
  Created by IntelliJ IDEA.
  User: vincent
  Date: 2018/10/14
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>message</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>content</td>
        <td>status</td>
        <td>created_at</td>
        <td>updated_at</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="message" items="${messages}">
        <tr>
            <td>${message.id}</td>
            <td>${message.content}</td>
            <td>${message.status}</td>
            <td>${message.createdAt}</td>
            <td>${message.updatedAt}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

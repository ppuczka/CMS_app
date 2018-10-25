<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 25/10/2018
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>CMS HOME PAGE</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Content</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Title</th>
        <th>Author Id</th>
        <th>Categories</th>
    </tr>
    </thead>

    <tbody>
        <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.id}</td>
            <td>${article.content}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            <td>${article.title}</td>
            <td>${article.author}</td>
            <td>${article.categories}</td>
        </tr>
        </c:forEach>
    </tbody>


    </thead>


</table>

</body>
</html>

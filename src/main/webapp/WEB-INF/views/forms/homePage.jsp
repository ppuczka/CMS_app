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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="p-3 mb-2 bg-dark text-white">
<h1>CMS HOME PAGE</h1>
<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th>Id</th>
        <th>Content</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Title</th>
        <th>Author</th>
        <th>Categories</th>
    </tr>
    </thead>

    <tbody>
        <c:forEach items="${articles}" var="article">
            <td>${article.id}</td>
            <td>${article.content}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            <td>${article.title}</td>
            <td>${article.author.firstName} ${article.author.lastName}</td>
            <td><c:forEach items="${article.categories}" var="category">
             ${category.name}<br/>
            </c:forEach></td>

        </tr>
        </c:forEach>
    </tbody>


    </thead>


</table>

</body>
</html>

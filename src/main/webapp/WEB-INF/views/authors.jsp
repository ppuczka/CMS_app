<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 31/10/2018
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="p-3 mb-2 bg-dark text-white">
<jsp:include page="/WEB-INF/views/links.jsp"></jsp:include><br/>
<h2><p align="centre">List of Authors</p></h2>
<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th>Id</th>
        <th>Frist Name</th>
        <th>Last Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="author" items="${authors}">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href="/author/delConfirm/${author.id}">Delete Author ||</a>
                <a href="/author/edit/${author.id}">Edit Author</a></td>
        </tr>
        </c:forEach>
        <a href="/author/add/">Add new Author</a>

    </tbody>
</table>


</body>
</html>

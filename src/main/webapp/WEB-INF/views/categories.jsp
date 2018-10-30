<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 30/10/2018
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="p-3 mb-2 bg-dark text-white">
<jsp:include page="/WEB-INF/views/links.jsp"></jsp:include>
</table>
<h2><p align="centre">List of Categories</p></h2>

<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Desription</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td><a href="/getCatArticles/${category.id}">Show Articles ||</a> <a href="/category/catDelConfirm/${category.id}">Delete Category ||</a>
                <a href="/category/catEdit/${category.id}">Edit Category</a></td>
        </tr>
    </c:forEach>
    <a href="/category/add/">Add new category</a>


    </tbody>



</body>
</html>

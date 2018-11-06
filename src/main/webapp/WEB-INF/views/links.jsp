<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 26/10/2018
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>links</title>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
    <%--<link rel="stylesheet" href="css/style.css" type="text/css">--%>
</head>
<body>
<nav class="main-nav">
    <ul>
        <li>
            <a href="/home">Home Page</a>
        </li>
        <li>
            <a href ="/category/showAll">Show Categories</a>
        </li>
        <li>
            <a href="/author/showAll">Show Authors</a>
        </li>
        <li>
            <a href="/article/showAll">Show Articles</a>
        </li>
    </ul>
</nav>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 30/10/2018
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author Edit</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="p-3 mb-2 bg-dark text-white">
<jsp:include page="/WEB-INF/views/links.jsp"></jsp:include>
<h4>Edit selected Article</h4>
<form:form method="post"
           modelAttribute="article">
    Article Title: <form:input path="title"/> <br/></br><br/>
    Article Author: <form:select path="author.id" items="${authors}" itemValue="id" itemLabel="lastName"/> <br/><br/><br/>
    Article Categories: <form:select path="categories" items="${categories}" itemValue="id" itemLabel="name" multiple="true"/> <br/><br/><br/>
    Article Content: <form:input path="content"/><br/><br/><br/>
    <form:errors path="*"/>
    <input type="submit" value="save">
</form:form>




</body>
</html>

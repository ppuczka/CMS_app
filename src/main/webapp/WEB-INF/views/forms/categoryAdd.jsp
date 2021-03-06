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
    <title>CategoryAdd</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="p-3 mb-2 bg-dark text-white">
<jsp:include page="/WEB-INF/views/links.jsp"></jsp:include>
<H1>Add new Category</H1>
<form:form method="post"
        modelAttribute="category">
    Category Name: <form:input path="name"/> <br/>
    Category Description: <form:input path="description"/> <br/>
    Select Articles: <form:select path="articles" items="${articles}" itemValue="id" itemLabel="title" multiple="true" /> <br/>
    <form:errors path="*"/>
        <input type="submit" value="save">
</form:form>



</body>
</html>

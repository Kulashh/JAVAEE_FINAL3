<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 02.03.2024
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="model.User" %>
<html>
<head>
    <title>Add Blog Page </title>
    <%@include file="links.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
        <br>
        <div class="row mt-3">
            <div class="col-6 mx-auto">
                <form action="/addBlog" method="post">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">TITLE</label>
                        <input name="title" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">CONTENT</label>
                        <textarea name="content" class="form-control"></textarea>
                    </div>
                    <button type="submit" class="btn btn-danger">Enter</button>
                </form>
            </div>
        </div>
</body>
</html>

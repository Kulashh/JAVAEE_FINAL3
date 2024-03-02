<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 02.03.2024
  Time: 5:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="model.User" %>
<%@ page import="model.Blog" %>
<html>
<head>
    <title>Title</title>
    <%@include file="links.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br>
    <%
        Blog blog = (Blog) request.getAttribute("blogDetails");
        if (blog!=null){
    %>
        <div class="card w-75">
            <div class="card-body">
                <h5 class="card-title"><%=blog.getTitle()%></h5>
                <p class="card-text"><%=blog.getContent()%></p>
                <p><%=blog.getUser().getFulName() + "/"+blog.getUser().getEmail()%></p>
                <p><%=blog.getPostData()%></p>
            </div>
        </div>
    <%}%>

</body>
</html>

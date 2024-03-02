<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="model.User" %>
<%@ page import="model.Blog" %>
<%@ page import="db.DBManager" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Index</title>
    <%@include file="links.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <%
        List<Blog> blogs = DBManager.getAllBlogs();
        for (Blog blog : blogs){
    %>
    <br>
    <div class="card w-75">
        <div class="card-body">
            <h5 class="card-title"><%=blog.getTitle()%></h5>
            <p class="card-text"><%=blog.getContent()%></p>
            <p><%=blog.getUser().getFulName() + "/"+blog.getUser().getEmail()%></p>
            <P><%=blog.getPostData()%></P>
            <a href="/blogDetails?id="<%=blog.getId()%> class="btn btn-danger">DETAILS</a>
        </div>
    </div>
    <%}%>
</div>
</body>
</html>

<%@ page import="model.User" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <%
        User user = (User) request.getSession().getAttribute("ONLINE_USER");
    %>
    <div class="container-fluid">
        <a class="navbar-brand" href="/home">BITLAB NEWS</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <%
                  if (user == null){
              %>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/login">Sign In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/register">Sign Up</a>
                </li>
                <%
                    }
                %>

                <%
                    if (user!=null){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="#"><%=user.getFulName()%></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/addBlog">Add Blog</a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>

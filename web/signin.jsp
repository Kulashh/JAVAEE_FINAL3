<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <%@include file="links.jsp"%>
</head>
<body>
    <div class="container">
        <%@include file="navbar.jsp"%>
        <br>
        <div class="row mt-3">
            <div class="col-6 mx-auto">
                <%
                    String error = request.getParameter("someerror");
                    if (error!=null){
                %>
                    <div class="alert alert-primary alert-dismissible fade show" role="alert">
                        The username or password was entered incorrectly. Check that your username and password are correct.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                <%
                    }
                %>

                <form action="/login" method="post">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Email address</label>
                        <input name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Password</label>
                        <input name="password" type="password" class="form-control" id="exampleInputPassword1">
                    </div>
                    <div class="mb-3 form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Check me out</label>
                    </div>
                    <button type="submit" class="btn btn-danger">Enter</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>

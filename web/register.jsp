<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <%@include file="links.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
        <div class="row mt-3">
            <div class="col-6 mx-auto">
                <form action="/register" method="post">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Email address</label>
                        <input name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Password</label>
                        <input name="password" type="password" class="form-control" id="exampleInputPassword1">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Repeat password </label>
                        <input name="repeatPassword" type="password" class="form-control" id="exampleInputPassword1">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Full name</label>
                        <input name="fullName" type="text" class="form-control" id="exampleInputPassword1">
                    </div>
                    <button type="submit" class="btn btn-danger">Enter</button>
                </form>
            </div>
        </div>
</div>
</body>
</html>


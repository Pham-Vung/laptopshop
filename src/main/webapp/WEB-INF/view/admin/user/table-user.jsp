<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Table users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
          crossorigin="anonymous">
</head>

<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-12 mx-auto">
            <div class="d-flex justify-content-between mb-3">
                <h3>Table users</h3>
                <a href="/admin/user/create" class="btn btn-primary">Create a user</a>
            </div>
            <hr>

            <table class="table table-bordered table-hover text-center align-middle">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Email</th>
                    <th>Full Name</th>
                    <th>Action</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.email}</td>
                        <td>${user.fullName}</td>
                        <td class="d-flex justify-content-center align-items-center">
                            <a href="/admin/user/${user.id}" class="btn btn-success">View</a>
                            <a href="/admin/user/update/${user.id}" class="btn btn-warning mx-2">Update</a>
                            <a href="/admin/user/delete/${user.id}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>

                <%-- <tr>--%>
                <%-- <td>2</td>--%>
                <%-- <td>Jacob</td>--%>
                <%-- <td>Thornton</td>--%>
                <%-- <td
                    class="d-flex justify-content-center align-items-center">--%>
                <%-- <button class="btn btn-success">View</button>--%>
                <%-- <button
                    class="btn btn-warning mx-2">Update</button>--%>
                <%-- <button class="btn btn-danger">Delete</button>--%>
                <%-- </td>--%>
                <%-- </tr>--%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</body>

</html>
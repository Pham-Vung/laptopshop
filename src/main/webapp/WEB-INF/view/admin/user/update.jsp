<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update a user</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
          crossorigin="anonymous">
    <link href="/css/styles.css" rel="stylesheet">
</head>

<body class="sb-nav-fixed">
<jsp:include page="../layout/header.jsp"/>
<div id="layoutSidenav">
    <jsp:include page="../layout/sidebar.jsp"/>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Manage users</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                    <li class="breadcrumb-item active">Users</li>
                </ol>

                <div class="mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <h3>Update a user</h3>
                            <hr>
                            <form:form action="/admin/user/update" method="post"
                                       modelAttribute="newUser">
                                <div class="mb-3" style="display: none">
                                    <label class="form-label">Id:</label>
                                    <form:input type="number" class="form-control" path="id"/>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Email:</label>
                                    <form:input type="email" class="form-control" path="email"
                                                disabled="true"/>
                                </div>

                                <%-- <div class="mb-3">--%>
                                <%-- <label class="form-label">Password:</label>--%>
                                <%-- <form:input type="password" class="form-control"
                                    path="password" />--%>
                                <%-- </div>--%>

                                <div class="mb-3">
                                    <label class="form-label">Phone number:</label>
                                    <form:input type="text" class="form-control"
                                                path="phone"/>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Full Name:</label>
                                    <form:input type="text" class="form-control"
                                                path="fullName"/>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Address:</label>
                                    <form:input type="text" class="form-control"
                                                path="address"/>
                                </div>

                                <%-- <div class="mb-3">--%>
                                <%-- <label class="form-label">Role:</label>--%>
                                <%-- <form:select class="form-select"
                                    path="role.name">--%>
                                <%-- <form:option value="ADMIN">ADMIN
                                    </form:option>--%>
                                <%-- <form:option value="USER">USER
                                    </form:option>--%>
                                <%-- </form:select>--%>
                                <%-- </div>--%>

                                <button type="submit"
                                        class="btn btn-warning">Update
                                </button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="../layout/footer.jsp"/>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/js/scripts.js"></script>
</body>

</html>
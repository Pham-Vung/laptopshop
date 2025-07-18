<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product detail ${id}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body class="sb-nav-fixed">
<jsp:include page="../layout/header.jsp"/>
<div id="layoutSidenav">
    <jsp:include page="../layout/sidebar.jsp"/>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Products</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                    <li class="breadcrumb-item"><a href="/admin/product">Product</a></li>
                    <li class="breadcrumb-item active">View Detail</li>
                </ol>

                <div class="mt-5">
                    <div class="row">
                        <div class="col-12 mx-auto">
                            <div class="d-flex justify-content-between">
                                <h3>Product detail with id = ${id}</h3>
                            </div>
                            <hr>

                            <div class="card" style="width: 60%">
                                <img class="card-img-top" src="/images/product/${product.image}"
                                     alt="Card image cap">
                                <div class="card-header">Product information</div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">ID: ${product.id}</li>
                                    <li class="list-group-item">Name: ${product.name}</li>
                                    <li class="list-group-item">Price: ${product.price}</li>
                                </ul>
                            </div>
                            <a href="/admin/product" class="btn btn-success mt-3">Back</a>
                        </div>
                    </div>
                </div>

            </div>
        </main>
        <jsp:include page="../layout/footer.jsp"/>
    </div>
</div>
<script src="/js/scripts.js"></script>
</body>
</html>
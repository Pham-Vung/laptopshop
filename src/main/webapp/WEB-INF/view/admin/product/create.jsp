<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create product page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
          crossorigin="anonymous">
    <link href="/css/styles.css" rel="stylesheet">
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(document).ready(() => {
            const avatarFile = $("#productImageFile");
            avatarFile.change(function (e) {
                const imgURL = URL.createObjectURL(e.target.files[0]);
                $("#productImagePreview").attr("src", imgURL);
                $("#productImagePreview").css({"display": "block"});
            });
        });
    </script>

    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

</head>

<body class="sb-nav-fixed">
<jsp:include page="../layout/header.jsp"/>
<div id="layoutSidenav">
    <jsp:include page="../layout/sidebar.jsp"/>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Manage products</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                    <li class="breadcrumb-item active">Products</li>
                </ol>
                <div class="mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <h3>Create a product</h3>
                            <hr>
                            <form:form action="/admin/product/create" method="post"
                                       modelAttribute="newProduct" class="row"
                                       enctype="multipart/form-data">
                                <div class="mb-3 col-12 col-md-6">
                                    <c:set var="errorName">
                                        <form:errors path="name" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <label class="form-label">Name:</label>
                                    <form:input type="text" path="name" cssClass="${not empty errorName ? 'is-invalid' : ''} form-control"/>
                                    ${errorName}
                                </div>

                                <div class="mb-3 col-12 col-md-6">
                                    <c:set var="errorPrice">
                                        <form:errors path="price" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <label class="form-label">Price:</label>
                                    <form:input type="number" path="price" cssClass="${not empty errorPrice ? 'is-invalid' : ''} form-control"/>
                                    ${errorPrice}
                                </div>

                                <div class="mb-3 col-12">
                                    <c:set var="errorDetailDesc">
                                        <form:errors path="detailDesc" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <label class="form-label">Detail description:</label>
                                    <form:textarea type="text" path="detailDesc" cssClass="${not empty errorDetailDesc ? 'is-invalid' : ''} form-control"/>
                                    ${errorDetailDesc}
                                </div>

                                <div class="mb-3 col-12 col-md-6">
                                    <c:set var="errorShortDesc">
                                        <form:errors path="shortDesc" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <label class="form-label">Short description:</label>
                                    <form:input type="text" path="shortDesc" cssClass="${not empty errorShortDesc ? 'is-invalid' : ''} form-control"/>
                                    ${errorShortDesc}
                                </div>

                                <div class="mb-3 col-12 col-md-6">
                                    <c:set var="errorQuantity">
                                        <form:errors path="quantity" cssClass="invalid-feedback"/>
                                    </c:set>
                                    <label class="form-label">Quantity:</label>
                                    <form:input type="number" path="quantity" cssClass="${not empty errorQuantity ? 'is-invalid' : ''} form-control"/>
                                    ${errorQuantity}
                                </div>

                                <div class="mb-3 col-12 col-md-6">
                                    <label class="form-label">Factory:</label>
                                    <form:select class="form-select" path="factory">
                                        <form:option value="APPLE">Apple (Macbook)</form:option>
                                        <form:option value="ASUS">Asus</form:option>
                                        <form:option value="LENOVO">Lenovo</form:option>
                                        <form:option value="DELL">Dell</form:option>
                                        <form:option value="LG">LG</form:option>
                                        <form:option value="ACER">Acer</form:option>
                                    </form:select>
                                </div>

                                <div class="mb-3 col-12 col-md-6">
                                    <label class="form-label">Target:</label>
                                    <form:select class="form-select" path="target">
                                        <form:option value="GAMING">Gaming</form:option>
                                        <form:option value="SINHVIEN-VANPHONG">Sinh viên - Văn phòng</form:option>
                                        <form:option value="THIET-KE-DO-HOA">Thiết kế đồ họa</form:option>
                                        <form:option value="MONG-NHE">Mỏng nhẹ</form:option>
                                        <form:option value="DOANH-NHAN">Doanh nhân</form:option>
                                    </form:select>
                                </div>

                                <div class="mb-3 col-12 col-md-6">
                                    <label for="productImageFile" class="form-label">Image:</label>
                                    <input class="form-control" type="file" id="productImageFile"
                                           accept=".png, .jpg, .jpeg" name="vincentFile"/>
                                </div>
                                <div class="col-12 mb-3">
                                    <img style="max-height: 250px; display: none;" alt="product image preview"
                                         id="productImagePreview"/>
                                </div>
                                <div class="col-12 mb-5">
                                    <button type="submit" class="btn btn-primary">Create</button>
                                </div>
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
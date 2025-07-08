<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>404 Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <style>
        body,
        html {
            height: 100%;
        }
    </style>
</head>
<body class="d-flex justify-content-center align-items-center">
<div class="col-md-12 text-center">
    <h1>404</h1>
    <h2>Page Not Found</h2>
    <p>
        ${message}
    </p>
    <a href="/admin/product">Back</a>
</div>
</body>

</html>
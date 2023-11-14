<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h1 class="text-center">Welcome to Admin Mode 😶‍🌫️</h1>
    <br>

    <div class="list-group">
        <a href="AddnewServlet" class="list-group-item list-group-item-action">Add new employee 🚀</a>
        <a href="UpdateServlet" class="list-group-item list-group-item-action">Update employee 🚀</a>
        <a href="DeleteServlet" class="list-group-item list-group-item-action">Delete employee 🚀</a>
        <a href="SearchServlet" class="list-group-item list-group-item-action">Search employee 🚀</a>
    </div>
</div>
<div class="container mt-5">
    <h1 class="text-center">Office Data</h1>

    <table class="table mt-3">
        <thead>
        <tr>
            <c:forEach var="column" items="${columns}">
                <th scope="col">${column}</th>

            </c:forEach>


            <!-- Add more columns based on your database structure -->
        </tr>
        </thead>
        <tbody>
        <!-- Replace the following rows with your actual database data -->

        <c:forEach var="office" items="${allOffices}">
            <tr>
                <th scope="row">${office.officeCode}</th>
                <td>${office.addressLine1}</td>
                <td>${office.addressLine2}</td>
                <td>${office.city}</td>
                <td>${office.state}</td>
                <td>${office.country}</td>
                <td>${office.postalCode}</td>
                <td>${office.phone}</td>
                <td>${office.territory}</td>

            </tr>

        </c:forEach>
        <th scope="row">1</th>
        <td>John Doe</td>
        <!-- Add more cells based on your database structure -->

        <!-- Repeat rows for each record -->

        <!-- Add more rows based on your database data -->

        </tbody>
    </table>

    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center mt-3">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
            </li>
            <li class="page-item active" aria-current="page">
                <a class="page-link" href="#">1 <span class="sr-only">(current)</span></a>
            </li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </nav>
</div>

<!-- Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
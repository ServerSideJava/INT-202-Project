<%--
  Created by IntelliJ IDEA.
  User: monke
  Date: 11/14/2023
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Search Office</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Search Offices</h1>
    <div class="container mt-5">


        <form action="SearchServlet" method="post">
            <div class="form-group">
                <label for="searchBy">Search By:</label>
                <select class="form-control" id="searchBy" name="searchBy" required>
                    <option value="country">Country</option>
                    <option value="city">City</option>
                </select>
            </div>

            <div class="form-group">
                <label for="searchTerm">Search Term:</label>
                <input type="text" class="form-control" id="searchTerm" name="searchTerm" required>
            </div>

            <button type="submit" class="btn btn-primary">Search</button>
        </form>

        <hr>

        <!-- Display search results in a table -->
        <h2 class="mt-4">Search Results</h2>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Office Code</th>
                <th>Address Line 1</th>
                <th>City</th>
                <th>State</th>
                <th>Country</th>
                <th>Postal Code</th>
                <th>Phone</th>
                <th>Territory</th>
            </tr>
            </thead>
            <tbody>
            <!-- Loop through the search results and display them in the table -->
            <c:forEach var="office" items="${searchResults}">
                <tr>
                    <td>${office.officeCode}</td>
                    <td>${office.addressLine1}</td>
                    <td>${office.city}</td>
                    <td>${office.state}</td>
                    <td>${office.country}</td>
                    <td>${office.postalCode}</td>
                    <td>${office.phone}</td>
                    <td>${office.territory}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<!-- Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>

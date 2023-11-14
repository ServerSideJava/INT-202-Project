<%--
  Created by IntelliJ IDEA.
  User: monke
  Date: 11/14/2023
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Office</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Search Offices</h1>
    <div class="container mt-5">


        <form action="SearchOfficeServlet" method="post">
            <div class="form-group">
                <label for="country">Country:</label>
                <input type="text" class="form-control" id="country" name="country" required>
            </div>

            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" class="form-control" id="city" name="city" required>
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
            <!-- The table rows will be populated dynamically based on search results -->
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

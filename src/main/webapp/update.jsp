<%--
  Created by IntelliJ IDEA.
  User: monke
  Date: 11/13/2023
  Time: 5:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Update Office Data</h1>

    <form action="UpdateServlet" method="post">
        <div class="form-group">
            <label for="officeId">Office ID:</label>
            <input type="text" class="form-control" id="officeId" name="officeId" required>
        </div>

        <div class="form-group">
            <label for="updateField">Select Data to Update:</label>
            <select class="form-control" id="updateField" name="updateField" required>
                <option value="addressLine1">Address Line 1</option>
                <option value="city">City</option>
                <option value="state">State</option>
                <option value="country">Country</option>
                <option value="postalCode">Postal Code</option>
                <option value="phone">Phone</option>
                <option value="territory">Territory</option>
                <!-- Add more options based on your data fields -->
            </select>
        </div>

        <div class="form-group">
            <label for="newValue">New Value:</label>
            <input type="text" class="form-control" id="newValue" name="newValue" required>
        </div>

        <button type="submit" class="btn btn-primary">Update Data</button>
    </form>
</div>

<!-- Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>

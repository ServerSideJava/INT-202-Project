<%--
  Created by IntelliJ IDEA.
  User: monke
  Date: 11/14/2023
  Time: 11:17 AM
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
    <h1 class="text-center">Delete Office Data</h1>

    <form action="DeleteServlet" method="post">
        <div class="form-group">
            <label for="officeId">Office ID:</label>
            <input type="text" class="form-control" id="officeId" name="officeId" required>
        </div>

        <button type="submit" class="btn btn-danger">Delete Data</button>
    </form>
</div>

<!-- Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

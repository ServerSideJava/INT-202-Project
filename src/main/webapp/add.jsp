<%--
  Created by IntelliJ IDEA.
  User: monke
  Date: 11/13/2023
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add mode</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<form action="AddOfficeServlet" method="post">
    Office Code: <input type="text" name="officeCode"><br>
    <br>
    Address Line 1: <input type="text" name="addressLine1"><br>
    <br>
    City: <input type="text" name="city"><br>
    <br>
    State: <input type="text" name="state"><br>
    <br>
    Country: <input type="text" name="country"><br>
    <br>
    Postal Code: <input type="text" name="postalCode"><br>
    <br>
    Phone: <input type="text" name="phone"><br>
    <br>
    Territory: <input type="text" name="territory"><br>
    <br>
    <input type="submit" value="Submit">
</form>
</form>
</body>
</html>

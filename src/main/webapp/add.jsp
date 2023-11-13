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
</head>
<body>
<form action="AddOfficeServlet" method="post">
    Office Code: <input type="text" name="officeCode"><br>
    Address Line 1: <input type="text" name="addressLine1"><br>
    City: <input type="text" name="city"><br>
    State: <input type="text" name="state"><br>
    Country: <input type="text" name="country"><br>
    Postal Code: <input type="text" name="postalCode"><br>
    Phone: <input type="text" name="phone"><br>
    Territory: <input type="text" name="territory"><br>
    <input type="submit" value="Submit">
</form>
</form>
</body>
</html>

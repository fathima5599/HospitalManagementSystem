<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Doctor</title>
</head>
<body>
    <h1>Add Doctor</h1>
    <form action="DoctorServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="department">Department:</label>
        <input type="text" id="department" name="department" required><br><br>
        <input type="submit" value="Add Doctor">
    </form>
</body>
</html>

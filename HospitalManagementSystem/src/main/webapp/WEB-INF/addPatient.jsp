<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Patient</title>
</head>
<body>
    <h1>Add Patient</h1>
    <form action="PatientServlets" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>
        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select><br><br>
        <input type="submit" value="Add Patient">
    </form>
</body>
</html>

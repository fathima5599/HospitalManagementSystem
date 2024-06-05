<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Appointment</title>
</head>
<body>
    <h1>Book Appointment</h1>
    <form action="BookAppointmentServlet" method="post">
        <label for="patientId">Patient ID:</label>
        <input type="number" id="patientId" name="patientId" required><br><br>
        <label for="doctorId">Doctor ID:</label>
        <input type="number" id="doctorId" name="doctorId" required><br><br>
        <label for="appointmentDate">Appointment Date:</label>
        <input type="date" id="appointmentDate" name="appointmentDate" required><br><br>
        <input type="submit" value="Book Appointment">
    </form>
</body>
</html>

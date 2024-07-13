<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register Employee</title>
</head>
<body>
    <h1>Register Employee</h1>
    <form action="register" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br><br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="birthdate">Date of Birth:</label>
        <input type="text" id="birthdate" name="birthdate" required><br><br>
        <label for="salary">Salary:</label>
        <input type="text" id="salary" name="salary" required><br><br>
        <label for="age">Age:</label>
        <input type="text" id="age" name="age" required><br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>

package com.epsilon.dao;

import com.epsilon.model.Employee;
import java.sql.*;

public class EmployeeDao {
    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String sql = "INSERT INTO EMPLOYEES (ID, COMPLETE_NAME, BIRTHDATE, SALARY, AGE) VALUES (?, ?, ?, ?, ?)";
        String url = "jdbc:mysql://localhost:3306/MyDb";
        String username = "root";
        String password = "22904110";
        int result = 0;

        // Load and register the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Set the parameters
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getDate());
            ps.setInt(4, employee.getSalary());
            ps.setInt(5, employee.getAge());

            // Execute the update
            result = ps.executeUpdate();
        } catch (SQLException e) {
//            e.printStackTrace();
        }
        return result;
    }
}

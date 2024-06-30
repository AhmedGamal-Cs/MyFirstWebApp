
package com.epsilon.dao;

import com.epsilon.entity.Employee;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.*;
import java.util.logging.Logger;

public class EmployeeImp implements Crud<Employee>{

    @Override
    public int insert(Employee t) {
        Connection conn = null;
        int result = 0;
        try {
            conn = DbConnection.getConnection();
            String sql = "INSERT INTO EMPLOYEES(COMPLETE_NAME,BIRTHDATE,SALARY,AGE) VALUES(?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, t.getId());
            ps.setString(1, t.getComplete_name());
            ps.setString(2, t.getBirthDate());
            ps.setInt(3, t.getSalary());
            ps.setInt(4, t.getAge());
            result = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public int delete(int id) {
        Connection conn = null;
        int result = 0;
        try {
            conn = DbConnection.getConnection();
            String sql = "DELETE FROM EMPLOYEES WHERE ID = ? ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            result = ps.executeUpdate();
            if(result != 0){
                System.out.println("Data Deleted !!");
            }else{
                System.out.println("ERRoorr");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public int update(Employee t) {
        Connection conn = null;
        int result = 0;
        try {
            conn = DbConnection.getConnection();
            String sql = "UPDATE EMPLOYEES SET COMPLETE_NAME=?, BIRTHDATE=?, SALARY=?, AGE=? WHERE ID = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getComplete_name());
            ps.setString(2, t.getBirthDate());
            ps.setInt(3, t.getSalary());
            ps.setInt(4, t.getAge());
            ps.setInt(5, t.getId());
            result = ps.executeUpdate();
            if(result != 0){
                System.out.println("Data Updated");
            }else{
                System.out.println("ErRorr in updated");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public Employee get(int id) {
        Employee emp = new Employee();
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DbConnection.getConnection();
            if(conn != null){
                System.out.println("Connected");
            }else{
                System.out.println("ERRRoRR");
            }
            String sql = "SELECT * FROM EMPLOYEES WHERE ID=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                emp.setId(rs.getInt("ID"));
                emp.setComplete_name(rs.getString("COMPLETE_NAME"));
                emp.setBirthDate(rs.getString("BIRTHDATE"));
                emp.setSalary(rs.getInt("SALARY"));
                emp.setAge(rs.getInt("AGE"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return emp;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DbConnection.getConnection();
            String sql = "SELECT * FROM EMPLOYEES;";
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Employee emp = new Employee();
                emp.setId(rs.getInt("ID"));
                emp.setComplete_name(rs.getString("COMPLETE_NAME"));
                emp.setBirthDate(rs.getString("BIRTHDATE"));
                emp.setSalary(rs.getInt("SALARY"));
                emp.setAge(rs.getInt("AGE"));
                list.add(emp);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }
    
}

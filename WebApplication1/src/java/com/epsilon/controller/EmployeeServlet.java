package com.epsilon.controller;

import com.epsilon.dao.EmployeeDao;
import com.epsilon.model.Employee;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/register","/"})
public class EmployeeServlet extends HttpServlet {

    private EmployeeDao employeeDao;

    @Override
    public void init() {
        employeeDao = new EmployeeDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Thanks for watching!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/EmployeeRegister.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ID = request.getParameter("id");
        String name = request.getParameter("name"); // Changed from "complete name" to "name"
        String date = request.getParameter("birthdate");
        String salary = request.getParameter("salary");
        String age = request.getParameter("age");

        Employee emp = new Employee();
        emp.setId(Integer.parseInt(ID));
        emp.setName(name);
        emp.setDate(date);
        emp.setSalary(Integer.parseInt(salary));
        emp.setAge(Integer.parseInt(age));

        try {
            employeeDao.registerEmployee(emp);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

//        request.setAttribute("employee", emp);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/EmployeeDetails.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

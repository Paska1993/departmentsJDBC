package controllers.handlers.employeeHandlers;

import controllers.handlers.Handle;
import exception.DAOException;
import models.Employee;
import services.DepartmentService;
import services.EmployeeService;
import services.impl.DepartmentSpringServiceImpl;
import services.impl.EmployeeSpringServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pavel on 23.04.15.
 */
public class EmployeeIdSendler implements Handle {

    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DepartmentService departmentService = new DepartmentSpringServiceImpl(); /*new DepartmentServiceImpl();*/
            departmentService.getAllDepartments();
            EmployeeService employeeService = new EmployeeSpringServiceImpl(); /*new EmployeeServiceImpl();*/
            Employee employee = employeeService.getEmployeeById(Integer.valueOf(request.getParameter("id")));
            request.setAttribute("departments",  departmentService.getAll());
            request.setAttribute("employee", employee);
            RequestDispatcher rd = request.getRequestDispatcher("edit_employee.jsp");
            rd.forward(request,response);
        } catch (DAOException e) {
            request.setAttribute("errorMessage",e.getDatabaseException());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}

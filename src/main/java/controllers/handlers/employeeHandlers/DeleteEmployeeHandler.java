package controllers.handlers.employeeHandlers;

import controllers.handlers.Handle;
import controllers.handlers.creators.EmployeeFromRequest;
import exception.DAOException;
import models.Employee;
import services.EmployeeService;
import services.impl.EmployeeSpringServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pavel on 23.04.15.
 */
public class DeleteEmployeeHandler implements Handle {

    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = EmployeeFromRequest.createEmployeeID(request);
        try {
            EmployeeService employeeService = new EmployeeSpringServiceImpl(); /*new EmployeeServiceImpl();*/
            employeeService.deleteEmployee(employee);
            RequestDispatcher rd = request.getRequestDispatcher("employees.html");
            rd.forward(request, response);
        } catch (DAOException e) {
            request.setAttribute("errorMessage",e.getDatabaseException());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}

package controllers.handlers.employeeHandlers;

import controllers.handlers.Handle;
import exception.DAOException;
import services.EmployeeService;
import services.impl.EmployeeSpringServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pavel on 22.04.15.
 */
public class EmployeeListHandler implements Handle {

    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            EmployeeService employeeService = new EmployeeSpringServiceImpl(); /*new EmployeeServiceImpl();*/
            employeeService.getAllEmployee();
            request.setAttribute("employees", employeeService.getAll());
            RequestDispatcher rd = request.getRequestDispatcher("employees.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            request.setAttribute("errorMessage",e.getDatabaseException());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}

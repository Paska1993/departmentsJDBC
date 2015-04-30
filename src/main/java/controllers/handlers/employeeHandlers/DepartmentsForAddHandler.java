package controllers.handlers.employeeHandlers;

import controllers.handlers.Handle;
import exception.DAOException;
import services.DepartmentService;
import services.impl.DepartmentSpringServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 24.04.15.
 */
public class DepartmentsForAddHandler implements Handle {

    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DepartmentService departmentService = new DepartmentSpringServiceImpl(); /*new DepartmentServiceImpl();*/
            departmentService.getAll();
            request.setAttribute("departments", departmentService.getList());
            RequestDispatcher rd = request.getRequestDispatcher("add_employee.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            request.setAttribute("errorMessage",e.getDatabaseException());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}

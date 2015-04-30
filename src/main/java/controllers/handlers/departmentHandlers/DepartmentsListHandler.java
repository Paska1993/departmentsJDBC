package controllers.handlers.departmentHandlers;

import controllers.handlers.Handle;
import exception.DAOException;
import services.DepartmentService;
import services.impl.DepartmentSpringServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DepartmentsListHandler implements Handle {

    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DepartmentService departmentService = new DepartmentSpringServiceImpl();
            departmentService.getAll();
            request.setAttribute("departments", departmentService.getList());
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            request.setAttribute("errorMessage",e.getDatabaseException());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}

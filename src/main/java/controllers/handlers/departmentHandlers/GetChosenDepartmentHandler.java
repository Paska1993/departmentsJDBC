package controllers.handlers.departmentHandlers;

import controllers.handlers.Handle;
import exception.DAOException;
import models.Department;
import services.DepartmentService;
import services.DepartmentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pavel on 22.04.15.
 */
public class GetChosenDepartmentHandler implements Handle {

    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department department = null;
        try {
            DepartmentService departmentService = new DepartmentServiceImpl();
            department = departmentService.getDepartmentById(Integer.valueOf(request.getParameter("id")));
            request.setAttribute("department",department);
            RequestDispatcher rd = request.getRequestDispatcher("department_edit.jsp");
            rd.forward(request,response);
        } catch (DAOException e) {
            request.setAttribute("errorMessage",e.getDatabaseException());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}

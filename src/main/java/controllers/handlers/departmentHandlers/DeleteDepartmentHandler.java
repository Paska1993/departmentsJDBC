package controllers.handlers.departmentHandlers;

import controllers.handlers.Handle;
import controllers.handlers.creators.DepartmentFromRequest;
import exception.DAOException;
import models.Department;
import services.DepartmentService;
import services.impl.DepartmentSpringServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pavel on 22.04.15.
 */
public class DeleteDepartmentHandler implements Handle {
    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department department = DepartmentFromRequest.createDepartment(request);
        try {
            DepartmentService departmentService = new DepartmentSpringServiceImpl(); /*new DepartmentServiceImpl();*/
            departmentService.deleteDepartment(department);
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        }catch (DAOException e) {
            request.setAttribute("errorMessage",e.getDatabaseException());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}

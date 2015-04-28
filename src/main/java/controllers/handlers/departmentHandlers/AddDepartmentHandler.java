package controllers.handlers.departmentHandlers;

import controllers.handlers.Handle;
import controllers.handlers.creators.DepartmentFromRequest;
import exception.DAOException;
import exception.DepartmentNullNameExceptin;
import exception.SameDepartmentNameException;
import models.Department;
import services.DepartmentService;
import services.DepartmentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 22.04.15.
 */
public class AddDepartmentHandler implements Handle {

    public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department department = DepartmentFromRequest.createDepartmentByName(request);
        try {
            DepartmentService departmentService = new DepartmentServiceImpl();
            departmentService.addDepartment(department);
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        } catch (DepartmentNullNameExceptin e) {
            request.setAttribute("errorMessage", e.getErrorMessage());
            RequestDispatcher rd = request.getRequestDispatcher("add_department.jsp");
            rd.forward(request, response);
        } catch (SameDepartmentNameException e) {
            request.setAttribute("department", department);
            request.setAttribute("errorMessage", e.getErrorMessage());
            RequestDispatcher rd = request.getRequestDispatcher("add_department.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            request.setAttribute("department", department);
            request.setAttribute("errorMessage", e.getDatabaseException());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}

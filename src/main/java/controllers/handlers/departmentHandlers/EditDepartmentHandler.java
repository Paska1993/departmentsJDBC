package controllers.handlers.departmentHandlers;

import controllers.handlers.DepartmentsHandle;
import controllers.handlers.creators.DepartmentFromRequest;
import dao.departmentDAO.DepartmentDAO;
import exception.DepartmentNullNameExceptin;
import exception.SameDepartmentNameException;
import models.Department;
import services.DepartmentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by pavel on 22.04.15.
 */
public class EditDepartmentHandler implements DepartmentsHandle {

    private final String DriverException = "You probably will never see this message, " +
            "but if it`s happen you must to know that you have not jdbc.mysql.Driver!";
    private final String DatabaseException = "We have some trouble with Database, sorry for that!";

    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO departmentDAO) throws ServletException, IOException {
        Department department = DepartmentFromRequest.createDepartment(request);
        try {
            DepartmentService.service(department, departmentDAO ,false /*, request, response, "department_edit.jsp"*/);
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        } catch (DepartmentNullNameExceptin e) {
            request.setAttribute("errorMessage", e.getErrorMessage());
            RequestDispatcher rd = request.getRequestDispatcher("department_edit.jsp");
            rd.forward(request, response);
        } catch (SameDepartmentNameException e) {
            request.setAttribute("department", department);
            request.setAttribute("errorMessage", e.getErrorMessage());
            RequestDispatcher rd = request.getRequestDispatcher("department_edit.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage",DatabaseException);
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            request.setAttribute("errorMessage",DriverException);
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}

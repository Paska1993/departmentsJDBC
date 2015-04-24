package controllers.hendlers.departmentHandlers;

import controllers.hendlers.DepartmentsHandle;
import controllers.hendlers.creators.DepartmentFromRequest;

import dao.departmentDAO.DepartmentDAO;
import models.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by pavel on 22.04.15.
 */
public class GetChosenDepartmentHandler implements DepartmentsHandle {

    private final String DriverException = "You probably will never see this message, " +
            "but if it`s happen you must to know that you have not jdbc.mysql.Driver!";
    private final String DatabaseException = "We have some trouble with Database, sorry for that!";

    public void handle(HttpServletRequest request, HttpServletResponse response, DepartmentDAO departmentDAO) throws ServletException, IOException {
        Department department = null;
        try {
            departmentDAO.getDepartmentById(Integer.valueOf(request.getParameter("id")));
            department = departmentDAO.getAll().get(0);
            request.setAttribute("department",department);
            RequestDispatcher rd = request.getRequestDispatcher("department_edit.jsp");
            rd.forward(request,response);
        } catch (ClassNotFoundException e) {
            request.setAttribute("errorMessage",DriverException);
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage",DatabaseException);
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}

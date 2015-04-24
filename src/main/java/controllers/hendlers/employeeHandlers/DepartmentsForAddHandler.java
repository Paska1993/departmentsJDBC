package controllers.hendlers.employeeHandlers;

import controllers.hendlers.EmployeesHandle;
import dao.departmentDAO.DepartmentDAO;
import dao.departmentDAO.jdbc.DepartmentJDBCImplementation;
import dao.employeeDAO.EmployeeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created on 24.04.15.
 */
public class DepartmentsForAddHandler implements EmployeesHandle{

    private final String DriverException = "You probably will never see this message, " +
            "but if it`s happen you must to know that you have not jdbc.mysql.Driver!";
    private final String DatabaseException = "We have some trouble with Database, sorry for that!";

    public void handle(HttpServletRequest request, HttpServletResponse response, EmployeeDAO employeeDAO) throws ServletException, IOException {
        try {
            DepartmentDAO departmentDAO = new DepartmentJDBCImplementation();
            departmentDAO.getAllDepartments();
            request.setAttribute("departments", departmentDAO.getAll());
            RequestDispatcher rd = request.getRequestDispatcher("add_employee.jsp");
            rd.forward(request, response);
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

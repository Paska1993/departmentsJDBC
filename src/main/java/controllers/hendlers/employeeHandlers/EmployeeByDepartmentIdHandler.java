package controllers.hendlers.employeeHandlers;

import controllers.hendlers.EmployeesHandle;
import dao.employeeDAO.EmployeeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by pavel on 23.04.15.
 */
public class EmployeeByDepartmentIdHandler implements EmployeesHandle {
    private final String DriverException = "You probably will never see this message, " +
            "but if it`s happen you must to know that you have not jdbc.mysql.Driver!";
    private final String DatabaseException = "We have some trouble with Database, sorry for that!";

    public void handle(HttpServletRequest request, HttpServletResponse response, EmployeeDAO employeeDAO) throws ServletException, IOException {
        Integer department_id = Integer.valueOf(request.getParameter("id"));
        try {
            employeeDAO.getEmployeesByDepartmentId(department_id);
            request.setAttribute("employees", employeeDAO.getAll());
            RequestDispatcher rd = request.getRequestDispatcher("employees.jsp");
            rd.forward(request, response);
        }catch (SQLException e) {
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

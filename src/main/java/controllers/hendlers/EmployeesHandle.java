package controllers.hendlers;

import dao.employeeDAO.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by pavel on 23.04.15.
 */
public interface EmployeesHandle {
    void handle(HttpServletRequest request, HttpServletResponse response,
                EmployeeDAO employeeDAO) throws ServletException, IOException, SQLException, ClassNotFoundException;
}

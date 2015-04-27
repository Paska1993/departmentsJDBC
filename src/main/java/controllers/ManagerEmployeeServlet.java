package controllers;

import controllers.handlers.EmployeesHandle;
import controllers.handlers.employeeHandlers.*;
import dao.employeeDAO.EmployeeDAO;
import dao.employeeDAO.hibernate.EmployeeHibernateImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pavel on 23.04.15.
 */
@WebServlet(name = "ManagerEmployeeServlet" , urlPatterns = {"/employees.html", "/add_employee.html" ,"/delete_employee.html" ,
        "/employee_id.html", "/update_employee.html" , "/special_employee_list.html", "/add_form.html"})
public class ManagerEmployeeServlet extends HttpServlet {

    private final String DriverException = "You probably will never see this message, " +
            "but if it`s happen you must to know that you have not jdbc.mysql.Driver!";
    private final String DatabaseException = "We have some trouble with Database, sorry for that!";

    private static final Map<String, EmployeesHandle> handler = new HashMap();

    @Override
    public void init() throws ServletException {
        handler.put("/employees.html", new EmployeeListHandler());
        handler.put("/add_employee.html", new AddEmployeeHandler());
        handler.put("/delete_employee.html", new DeleteEmployeeHandler());
        handler.put("/employee_id.html",new EmployeeIdSendler());
        handler.put("/update_employee.html" , new EditEmployeeHandler());
        handler.put("/special_employee_list.html", new EmployeeByDepartmentIdHandler());
        handler.put("/add_form.html", new DepartmentsForAddHandler());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI().substring(request.getContextPath().length());
        EmployeesHandle worker = handler.get(path);
        EmployeeDAO employeeDAO = new EmployeeHibernateImpl(); /*new EmployeeJDBCImpl();*/

        try {
            worker.handle(request, response, employeeDAO);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

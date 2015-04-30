/*
package controllers;

import controllers.handlers.Handle;
import controllers.handlers.departmentHandlers.*;
import controllers.handlers.employeeHandlers.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


*/
/**
 * Created by pavel on 22.04.15.
 *//*

@WebServlet(name = "DispatcherServlet", urlPatterns = "*.html")
public class DispatcherServlet extends HttpServlet {

    private static final Map<String, Handle> handlers = new HashMap();
    @Override
    public void init() throws ServletException {
        handlers.put("/index.html", new DepartmentsListHandler());
        handlers.put("/get_chosen_department.html", new GetChosenDepartmentHandler());
        handlers.put("/department_edit.html", new EditDepartmentHandler());
        handlers.put("/add_department.html", new AddDepartmentHandler());
        handlers.put("/department_delete.html", new DeleteDepartmentHandler());
        handlers.put("/employees.html", new EmployeeListHandler());
        handlers.put("/add_employee.html", new AddEmployeeHandler());
        handlers.put("/delete_employee.html", new DeleteEmployeeHandler());
        handlers.put("/employee_id.html",new EmployeeIdSendler());
        handlers.put("/update_employee.html" , new EditEmployeeHandler());
        handlers.put("/special_employee_list.html", new EmployeeByDepartmentIdHandler());
        handlers.put("/add_form.html", new DepartmentsForAddHandler());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI().substring(req.getContextPath().length());
        Handle handler = handlers.get(path);
        handler.handle(req, resp);
        }
    }

*/

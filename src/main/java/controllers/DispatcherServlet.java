package controllers;

import controllers.handlers.DepartmentsHandle;
import controllers.handlers.departmentHandlers.*;
import dao.departmentDAO.DepartmentDAO;
import dao.departmentDAO.hibernate.DepartmentHibernateImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by pavel on 22.04.15.
 */
@WebServlet(name = "DispatcherServlet", urlPatterns = {"/index.html" , "/get_chosen_department.html",
        "/department_edit.html", "/add_department.html", "/department_delete.html"})
public class DispatcherServlet extends HttpServlet {

    private static final Map<String, DepartmentsHandle> handlers = new HashMap();
    @Override
    public void init() throws ServletException {
        handlers.put("/index.html", new DepartmentsListHandler());
        handlers.put("/get_chosen_department.html", new GetChosenDepartmentHandler());
        handlers.put("/department_edit.html", new EditDepartmentHandler());
        handlers.put("/add_department.html", new AddDepartmentHandler());
        handlers.put("/department_delete.html", new DeleteDepartmentHandler());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI().substring(req.getContextPath().length());
        DepartmentsHandle handler = handlers.get(path);
        DepartmentDAO departmentDAO = new DepartmentHibernateImpl(); /*new DepartmentJDBCImpl();*/
        handler.handle(req, resp, departmentDAO);
    }
}

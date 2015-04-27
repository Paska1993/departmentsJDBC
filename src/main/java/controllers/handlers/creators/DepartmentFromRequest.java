package controllers.handlers.creators;

import models.Department;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pavel on 22.04.15.
 */
public class DepartmentFromRequest {

    public static Department createDepartmentByName(HttpServletRequest request){

        Department department = new Department();
        department.setName(request.getParameter("name"));

        return department;
    }

    public static Department createDepartment(HttpServletRequest request){

        Department department = new Department();
        department.setId(Integer.valueOf(request.getParameter("id")));
        department.setName(request.getParameter("name"));

        return department;
    }
}

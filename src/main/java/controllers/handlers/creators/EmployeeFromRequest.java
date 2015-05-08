package controllers.handlers.creators;

import models.Employee;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pavel on 22.04.15.
 */
public class EmployeeFromRequest {

    public static Employee createEmployee(HttpServletRequest request){

        Employee employee = new Employee();
        employee.setName(request.getParameter("name"));
        employee.setSurname(request.getParameter("surname"));
        employee.setAddress(request.getParameter("address"));
        //employee.setSalary(NumberParser.parseDouble(request.getParameter("salary")));
        employee.setEmail(request.getParameter("email"));
        //employee.setDepartment_id(NumberParser.parseInteger(request.getParameter("department_id")));
        //employee.setBirthday(Date.valueOf(request.getParameter("birthday")));
        return employee;
    }
    public static Employee createEmployeeID(HttpServletRequest request){

        Employee employee = new Employee();
        employee.setId(Integer.valueOf(request.getParameter("id")));
        return employee;
    }
    public static Employee createEmployeeFull(HttpServletRequest request){

        Employee employee = new Employee();
        employee.setId(Integer.valueOf(request.getParameter("id")));
        employee.setName(request.getParameter("name"));
        employee.setSurname(request.getParameter("surname"));
        employee.setAddress(request.getParameter("address"));
        //employee.setSalary(NumberParser.parseDouble(request.getParameter("salary")));
        employee.setEmail(request.getParameter("email"));
       // employee.setDepartment_id(NumberParser.parseInteger(request.getParameter("department_id")));
       // employee.setBirthday(Date.valueOf(request.getParameter("birthday")));
        return employee;
    }
}

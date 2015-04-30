package controllers.spring.controllers;

import exception.*;
import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.DepartmentService;
import services.EmployeeService;
import utils.NumberParser;

import java.sql.Date;

/**
 * Created on 29.04.15.
 */
@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    private DepartmentService departmentService;

    @Autowired(required=true)
    @Qualifier(value="employeeSpringService")
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired(required=true)
    @Qualifier(value="departmentSpringService")
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/special_employee_list.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String employeeList(@RequestParam("id") Integer id ,Model model) {
        try {
            employeeService.getEmployeesByDepartmentId(id);
            model.addAttribute("employees", employeeService.getAll());
            return "employees.jsp";
        } catch (DAOException e) {
            return "error.jsp";
        }
    }


    @RequestMapping(value = "/add_form.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String depList(Model model) {
        try {
            departmentService.getAllDepartments();
            model.addAttribute("departments", departmentService.getAll());
            return "add_employee.jsp";
        } catch (DAOException e) {
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/add_employee.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String add(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("salary") String salary,
                      @RequestParam("birthday") String birthday , @RequestParam("address") String address, @RequestParam("email") String email,
                      @RequestParam("department_id") String department_id) {
        try {
            Employee employee = new Employee();
            employee.setName(name);
            employee.setSurname(surname);
            employee.setAddress(address);
            employee.setSalary(NumberParser.parseDouble(salary));
            employee.setEmail(email);
            employee.setDepartment(departmentService.getDepartmentById(Integer.valueOf(department_id)));
            employee.setBirthday(Date.valueOf(birthday));
            employeeService.addEmployee(employee);
            return "employees.html";
        } catch (DAOException e) {
            return "error.jsp";
        } catch (EmployeeNullFieldsException e) {
            return "error.jsp";
        } catch (SalaryFormatException e) {
            return "error.jsp";
        } catch (SameEmailException e) {
            return "error.jsp";
        } catch (EmailFormatException e) {
            return "error.jsp";
        }
    }


    @RequestMapping(value = "/delete_employee.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String delete(@RequestParam("id") Integer id) {
        Employee employee = new Employee();
        employee.setId(id);
        try {
            employeeService.deleteEmployee(employee);
            return "employees.html";
        } catch (DAOException e) {
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/employees.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String delete(Model model) {
        try {
            employeeService.getAllEmployee();
            model.addAttribute("employees", employeeService.getAll());
            return "employees.jsp";
        } catch (DAOException e) {
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/employee_id.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String idSandler(@RequestParam("id") Integer id ,Model model) {
        try {
            departmentService.getAllDepartments();
            model.addAttribute("employee", employeeService.getEmployeeById(id));
            model.addAttribute("departments", departmentService.getAll());
            return "edit_employee.jsp";
        } catch (DAOException e) {
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/update_employee.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String edit(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("salary") String salary,
                      @RequestParam("birthday") String birthday , @RequestParam("address") String address, @RequestParam("email") String email,
                      @RequestParam("department_id") String department_id, @RequestParam("id") String id) {
        try {
            Employee employee = new Employee();
            employee.setId(Integer.valueOf(id));
            employee.setName(name);
            employee.setSurname(surname);
            employee.setAddress(address);
            employee.setSalary(NumberParser.parseDouble(salary));
            employee.setEmail(email);
            employee.setDepartment(departmentService.getDepartmentById(Integer.valueOf(department_id)));
            employee.setBirthday(Date.valueOf(birthday));
            employeeService.updateEmployee(employee);
            return "employees.html";
        } catch (DAOException e) {
            return "error.jsp";
        } catch (EmployeeNullFieldsException e) {
            return "error.jsp";
        } catch (SalaryFormatException e) {
            return "error.jsp";
        } catch (SameEmailException e) {
            return "error.jsp";
        } catch (EmailFormatException e) {
            return "error.jsp";
        }
    }

}

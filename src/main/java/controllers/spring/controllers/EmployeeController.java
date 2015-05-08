package controllers.spring.controllers;

import exception.DAOException;
import exception.SalaryFormatException;
import exception.SameEmailException;
import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.DepartmentService;
import services.EmployeeService;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created on 29.04.15.
 */
@Controller
public class EmployeeController {

    @Autowired
    @Qualifier(value="employeeSpringService")
    private EmployeeService employeeService;

    @Autowired
    @Qualifier(value="departmentSpringService")
    private DepartmentService departmentService;

    @Resource
    private Employee employee;

    @RequestMapping(value = "/special_employee_list.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String employeeList(@RequestParam("id") Integer id ,Model model) {
        try {
            employeeService.getByDepartmentId(id);
            model.addAttribute("employees", employeeService.getList());
            return "employees.jsp";
        } catch (DAOException e) {
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/add_form.html", method = { RequestMethod.GET})
    public String depList(Model model) {
        try {
            departmentService.getAll();
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("employee", new Employee());
            return "add_employee.jsp";
        } catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/add_employee.html", method = {RequestMethod.POST})
    public String add(@Valid Employee employee, BindingResult result, @RequestParam("department_id") String department_id, Model model) {
        if(result.hasErrors()){
            try {
                departmentService.getAll();
            } catch (DAOException e1) {
                model.addAttribute("errorMessage", e1.getDatabaseException());
                return "error.jsp";
            }
            model.addAttribute("departments", departmentService.getList());
            return "add_employee.jsp";
        }
        else {
            try {
                employee.setDepartment(departmentService.getById(Integer.valueOf(department_id)));
                employeeService.add(employee);
                return "employees.html";
            } catch (DAOException e) {
                model.addAttribute("errorMessage", e.getDatabaseException());
                return "error.jsp";
            } catch (SalaryFormatException e) {
                try {
                    departmentService.getAll();
                } catch (DAOException e1) {
                    model.addAttribute("errorMessage", e1.getDatabaseException());
                    return "error.jsp";
                }
                model.addAttribute("departments", departmentService.getList());
                model.addAttribute("employee", employee);
                model.addAttribute("salaryError", "Salary is not valid");
                return "add_employee.jsp";
            } catch (SameEmailException e) {
                try {
                    departmentService.getAll();
                } catch (DAOException e1) {
                    model.addAttribute("errorMessage", e1.getDatabaseException());
                    return "error.jsp";
                }
                model.addAttribute("departments", departmentService.getList());
                model.addAttribute("employee", employee);
                model.addAttribute("sameEmailError", "Employee with this email is already exist");
                return "add_employee.jsp";
            }
        }
        }

    @RequestMapping(value = "/delete_employee.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String delete(@RequestParam("id") Integer id , Model model) {
        employee.setId(id);
        try {
            employeeService.delete(employee);
            return "employees.html";
        } catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/employees.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String employeelist(Model model) {
        try {
            employeeService.getAll();
            model.addAttribute("employees", employeeService.getList());
            return "employees.jsp";
        } catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/employee_id.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String idSandler(@RequestParam("id") Integer id ,Model model) {
        try {
            departmentService.getAll();
            model.addAttribute("employee", employeeService.getById(id));
            model.addAttribute("departments", departmentService.getList());
            return "edit_employee.jsp";
        } catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/update_employee.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String edit(@Valid Employee employee, BindingResult result , @RequestParam("department_id") String department_id, Model model) {
        if (result.hasErrors()) {
            try {
                departmentService.getAll();
            } catch (DAOException e1) {
                model.addAttribute("errorMessage", e1.getDatabaseException());
                return "error.jsp";
            }
            model.addAttribute("departments", departmentService.getList());
            return "edit_employee.jsp";
        } else {
            try {
                employee.setDepartment(departmentService.getById(Integer.valueOf(department_id)));
                employeeService.update(employee);
                return "employees.html";
            } catch (DAOException e) {
                model.addAttribute("errorMessage", e.getDatabaseException());
                return "error.jsp";
            }  catch (SameEmailException e) {
                try {
                    departmentService.getAll();
                } catch (DAOException e1) {
                    model.addAttribute("errorMessage", e1.getDatabaseException());
                    return "error.jsp";
                }
                model.addAttribute("departments", departmentService.getList());
                model.addAttribute("employee", employee);
                model.addAttribute("sameEmailError", "Employee with this email is already exist");
                return "edit_employee.jsp";
            }
        }
    }
}

package controllers.spring.controllers;

import exception.*;
import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import services.DepartmentService;
import services.EmployeeService;
import utils.DateValidator;
import utils.NumberParser;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created on 29.04.15.
 */
@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    private DepartmentService departmentService;

    @Resource
    private Employee employee;

    @Autowired
    @Qualifier(value="employeeSpringService")
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    @Qualifier(value="departmentSpringService")
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

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


    @RequestMapping(value = "/add_form.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String depList(Model model) {
        try {
            departmentService.getAll();
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("employeeT", new Employee());
            return "add_employee.jsp";
        } catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
            return "error.jsp";
        }
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

  /*  @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("salary") String salary,
    @RequestParam("birthday") String birthday , @RequestParam("address") String address, @RequestParam("email") String email,
    @RequestParam("department_id") String department_id
            */
    @RequestMapping(value = "/add_employee.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String add(@ModelAttribute("employeeT") @Valid Employee employee ,BindingResult result, Model model) {
        try {
            Employee employee1 = employee;
          /*  employee.setName(name);
            employee.setSurname(surname);
            employee.setAddress(address);
            employee.setSalary(NumberParser.parseDouble(salary));
            employee.setEmail(email);
            employee.setDepartment(departmentService.getById(Integer.valueOf(department_id)));
            employee.setBirthday(DateValidator.validation(birthday));*/
            employeeService.add(employee);
            return "employees.html";
        } catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
            return "error.jsp";
        } catch (EmployeeNullFieldsException e) {
            try {
                departmentService.getAll();
            } catch (DAOException e1) {
                model.addAttribute("errorMessage", e1.getDatabaseException());
                return "error.jsp";
            }
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("employee", employee);
            model.addAttribute("errorMessage", e.getErrorMessage());
            return "add_employee.jsp";
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
        } catch (EmailFormatException e) {
            try {
                departmentService.getAll();
            } catch (DAOException e1) {
                model.addAttribute("errorMessage", e1.getDatabaseException());
                return "error.jsp";
            }
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("employee", employee);
            model.addAttribute("emailFormatError", "Email format is not correct");
            return "error.jsp";
        } /*catch (DateFormatException e) {
            try {
                departmentService.getAll();
            } catch (DAOException e1) {
                model.addAttribute("errorMessage", e1.getDatabaseException());
                return "error.jsp";
            }
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("employee", employee);
            //model.addAttribute("dateErr", e.getMessage());
            model.addAttribute("dateErrorMessage", "Wrong date format, try YYYY-MM-DD");
            return "add_employee.jsp";
        }*/
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

/*    @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("salary") String salary,
    @RequestParam("birthday") String birthday , @RequestParam("address") String address, @RequestParam("email") String email,
    @RequestParam("department_id") String department_id, @RequestParam("id") String id
    */

    @RequestMapping(value = "/update_employee.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String edit( @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("salary") String salary,
                        @RequestParam("birthday") String birthday , @RequestParam("address") String address, @RequestParam("email") String email,
                        @RequestParam("department_id") String department_id, @RequestParam("id") String id, Model model) {
        try {
            employee.setId(Integer.valueOf(id));
            employee.setName(name);
            employee.setSurname(surname);
            employee.setAddress(address);
            employee.setSalary(NumberParser.parseDouble(salary));
            employee.setEmail(email);
            employee.setDepartment(departmentService.getById(Integer.valueOf(department_id)));
            employee.setBirthday(DateValidator.validation(birthday));
            employeeService.update(employee);
            return "employees.html";
        } catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
            return "error.jsp";
        } catch (EmployeeNullFieldsException e) {
            try {
                departmentService.getAll();
            } catch (DAOException e1) {
                model.addAttribute("errorMessage", e1.getDatabaseException());
                return "error.jsp";
            }
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("errorMessage", e.getErrorMessage());
            model.addAttribute("employee", employee);
            return "edit_employee.jsp";
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
            return "edit_employee.jsp";
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
            return "edit_employee.jsp";
        } catch (EmailFormatException e) {
            try {
                departmentService.getAll();
            } catch (DAOException e1) {
                model.addAttribute("errorMessage", e1.getDatabaseException());
                return "error.jsp";
            }
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("employee", employee);
            model.addAttribute("emailFormatError", "Email format is not correct");
            return "edit_employee.jsp";
        } catch (DateFormatException e) {
            try {
                departmentService.getAll();
            } catch (DAOException e1) {
                model.addAttribute("errorMessage", e1.getDatabaseException());
                return "error.jsp";
            }
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("employee", employee);
            //model.addAttribute("dateErr", e.getMessage());
            model.addAttribute("dateErrorMessage" ,"Wrong date format, try YYYY-MM-DD");
            return "edit_employee.jsp";
        }
    }
}

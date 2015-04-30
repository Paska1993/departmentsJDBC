package controllers.spring.controllers;

import exception.DAOException;
import exception.DepartmentNullNameExceptin;
import exception.SameDepartmentNameException;
import models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.DepartmentService;

/**
 * Created on 29.04.15.
 */
@Controller
public class DepartmentController {


    private DepartmentService departmentService;


    @Autowired(required=true)
    @Qualifier(value="departmentSpringService")
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/index.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String index(Model model) {
        try {
            departmentService.getAllDepartments();
            model.addAttribute("departments", departmentService.getAll() );
            return "index.jsp";
        } catch (DAOException e) {
           return "error.jsp";
        }
    }

    @RequestMapping(value = "/add_department.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String add(@RequestParam("name") String name,Model model) {
        Department department = new Department(name);
        try {
            departmentService.addDepartment(department);
            return "index.html";
        } catch (SameDepartmentNameException e) {
            return "error.jsp";
        } catch (DepartmentNullNameExceptin departmentNullNameExceptin) {
            return "error.jsp";
        } catch (DAOException e) {
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/department_delete.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String delete(@RequestParam("name") String name,@RequestParam("id") Integer id  ,Model model) {
        Department department = new Department(id,name);
        try {
            departmentService.deleteDepartment(department);
            return "index.html";
        }catch (DAOException e) {
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/get_chosen_department.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String getChosenDepartment(@RequestParam("name") String name,@RequestParam("id") Integer id ,Model model) {

        Department department = new Department(id,name);
        model.addAttribute("department", department);
        return "department_edit.jsp";
    }


    @RequestMapping(value = "/department_edit.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String edit(@RequestParam("name") String name,@RequestParam("id") Integer id ,Model model) {

        Department department = new Department(id,name);
        try {
            departmentService.updateDepartment(department);
            return "index.html";
        } catch (SameDepartmentNameException e) {
            return "error.jsp";
        } catch (DepartmentNullNameExceptin departmentNullNameExceptin) {
            return "error.jsp";
        } catch (DAOException e) {
            return "error.jsp";
        }
    }

}

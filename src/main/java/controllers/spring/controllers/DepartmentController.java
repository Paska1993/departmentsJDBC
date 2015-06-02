package controllers.spring.controllers;

import exception.DAOException;
import exception.SameDepartmentNameException;
import models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.DepartmentService;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created on 29.04.15.
 */
@Controller
public class DepartmentController {

    @Autowired
    @Qualifier(value="departmentSpringService")
    private DepartmentService departmentService;

    @Resource
    private Department department;

    @RequestMapping(value = "/index.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String index(Model model) {
        try {
            model.addAttribute("departments", departmentService.getAll() );
            return "index.jsp";
        } catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
           return "error.jsp";
        }
    }

    @RequestMapping(value = "/befor_add.html", method = RequestMethod.GET)
    public String preAdd(Model model){
        model.addAttribute("department", new Department());
        return "add_department.jsp";
    }

    @RequestMapping(value = "/add_department.html", method = RequestMethod.POST)
    public String add(@Valid Department department,BindingResult result , Model model) {
        if(result.hasErrors()){
            return "add_department.jsp";
        }
        else {
            try {
                departmentService.add(department);
                return "index.html";
            } catch (SameDepartmentNameException e) {
                model.addAttribute("department", department);
                model.addAttribute("errorMessage", e.getErrorMessage());
                return "add_department.jsp";
            } catch (DAOException e) {
                model.addAttribute("errorMessage", e.getDatabaseException());
                return "error.jsp";
            }
        }
    }

    @RequestMapping(value = "/department_delete.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String delete(@Valid Department department , Model model) {
        try {
            departmentService.delete(department);
            return "index.html";
        }catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/get_chosen_department.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String getChosenDepartment(@Valid Department department ,Model model) {
        model.addAttribute("department", department);
        Department departmentT = new Department();
        model.addAttribute("departmentT", departmentT);
        return "department_edit.jsp";
    }


    @RequestMapping(value = "/department_edit.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String edit(@Valid Department department ,BindingResult result ,Model model) {
        if (result.hasErrors()) {
            return "department_edit.jsp";
        } else {
                try {
                departmentService.update(department);
                return "index.html";
            } catch (SameDepartmentNameException e) {
                model.addAttribute("department", department);
                model.addAttribute("errorMessage", e.getErrorMessage());
                return "department_edit.jsp";
            } catch (DAOException e) {
                model.addAttribute("errorMessage", e.getDatabaseException());
                return "department_edit.jsp";
            }
        }
    }
}

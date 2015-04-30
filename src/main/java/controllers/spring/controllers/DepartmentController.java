package controllers.spring.controllers;

import exception.DAOException;
import exception.DepartmentNullNameExceptin;
import exception.SameDepartmentNameException;
import models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.DepartmentService;

import javax.annotation.Resource;

/**
 * Created on 29.04.15.
 */
@Controller
public class DepartmentController {


    private DepartmentService departmentService;

    @Resource
    private Department department;

    @Autowired
    @Qualifier(value="departmentSpringService")
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/index.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String index(Model model) {
        try {
            departmentService.getAll();
            model.addAttribute("departments", departmentService.getList() );
            return "index.jsp";
        } catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
           return "error.jsp";
        }
    }

    @RequestMapping(value = "/befor_add.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String preAdd(Model model){
       model.addAttribute("departmentT", new Department());
        return "add_department.jsp";
    }

    @RequestMapping(value = "/add_department.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String add(@ModelAttribute("departmentT") Department department, Model model) {
        try {
            departmentService.add(department);
            return "index.html";
        } catch (SameDepartmentNameException e) {
            model.addAttribute("department", department);
            model.addAttribute("errorMessage", e.getErrorMessage());
            return "add_department.jsp";
        } catch (DepartmentNullNameExceptin e) {
            model.addAttribute("department", department);
            model.addAttribute("errorMessage", e.getErrorMessage());
            return "add_department.jsp";
        } catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/department_delete.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String delete(@RequestParam("name") String name, @RequestParam("id") Integer id , Model model) {
        department.setId(id);
        department.setName(name);
        try {
            departmentService.delete(department);
            return "index.html";
        }catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
            return "error.jsp";
        }
    }

    @RequestMapping(value = "/get_chosen_department.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String getChosenDepartment(@RequestParam("name") String name,@RequestParam("id") Integer id ,Model model) {
        department.setId(id);
        department.setName(name);
        model.addAttribute("department", department);
        Department departmentT = new Department();
        model.addAttribute("departmentT", departmentT);
        return "department_edit.jsp";
    }


    @RequestMapping(value = "/department_edit.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String edit(@ModelAttribute("departmentT") Department department ,Model model) {
        try {
            departmentService.update(department);
            return "index.html";
        } catch (SameDepartmentNameException e) {
            model.addAttribute("department", department);
            model.addAttribute("errorMessage", e.getErrorMessage());
            return "department_edit.jsp";
        } catch (DepartmentNullNameExceptin e) {
            model.addAttribute("department", department);
            model.addAttribute("errorMessage", e.getErrorMessage());
            return "department_edit.jsp";
        } catch (DAOException e) {
            model.addAttribute("errorMessage",e.getDatabaseException());
            return "department_edit.jsp";
        }
    }

}

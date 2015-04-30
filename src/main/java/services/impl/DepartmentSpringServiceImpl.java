package services.impl;

import dao.departmentDAO.DepartmentDAO;
import exception.DAOException;
import exception.DepartmentNullNameExceptin;
import exception.SameDepartmentNameException;
import models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.DepartmentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28.04.15.
 */
@Service
public class DepartmentSpringServiceImpl implements DepartmentService {

    private List<Department> departments;

    private ClassPathXmlApplicationContext context = null;


    @Autowired
    private DepartmentDAO departmentDAO;

    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public DepartmentSpringServiceImpl() {
        this.departments = new ArrayList<Department>();
        context = new ClassPathXmlApplicationContext("spring.xml");
        departmentDAO = (DepartmentDAO) context.getBean("DepartmentDAO");
    }

    @Transactional
    public Department getDepartmentById(Integer id) throws DAOException {
        return departmentDAO.getDepartmentById(id);
    }

    @Transactional
    public void addDepartment(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException {
        departmentDAO.addDepartment(department);
    }

    @Transactional
    public void updateDepartment(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException {
        departmentDAO.updateDepartment(department);
    }

    @Transactional
    public void deleteDepartment(Department department) throws DAOException {
        departmentDAO.deleteDepartment(department);
    }

    @Transactional
    public void getAllDepartments() throws DAOException {
        departmentDAO.getAllDepartments();
        this.departments = departmentDAO.getAll();
    }

    public List<Department> getAll() {
        return this.departments;
    }

}

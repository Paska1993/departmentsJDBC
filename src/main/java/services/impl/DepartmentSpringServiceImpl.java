package services.impl;

import dao.departmentDAO.DepartmentDAO;
import exception.DAOException;
import exception.DepartmentNullNameExceptin;
import exception.SameDepartmentNameException;
import models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
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
    private DepartmentDAO departmentDAOImpl;

    public DepartmentSpringServiceImpl() {
        this.departments = new ArrayList<Department>();
        context = new ClassPathXmlApplicationContext("spring.xml");
        departmentDAOImpl = (DepartmentDAO) context.getBean("DepartmentDAOImpl");
    }

    public Department getDepartmentById(Integer id) throws DAOException {
        return departmentDAOImpl.getDepartmentById(id);
    }

    /*@Transactional*/
    public void addDepartment(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException {
        departmentDAOImpl.addDepartment(department);
    }

    public void updateDepartment(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException {
        departmentDAOImpl.updateDepartment(department);
    }

    public void deleteDepartment(Department department) throws DAOException {
        departmentDAOImpl.deleteDepartment(department);
    }

    public void getAllDepartments() throws DAOException {
        departmentDAOImpl.getAllDepartments();
        this.departments = departmentDAOImpl.getAll();
    }

    public List<Department> getAll() {
        return this.departments;
    }
}

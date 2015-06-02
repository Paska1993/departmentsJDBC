package services.impl;

import dao.departmentDAO.DepartmentDAO;
import exception.DAOException;
import exception.SameDepartmentNameException;
import models.Department;
import org.springframework.beans.factory.annotation.Autowired;
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

    private DepartmentDAO departmentDAO;

    @Autowired
    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public DepartmentSpringServiceImpl() {
        this.departments = new ArrayList<Department>();
    }

    public Department getById(Integer id) throws DAOException {
        return departmentDAO.getDepartmentById(id);
    }

    public void add(Department department) throws SameDepartmentNameException, DAOException {
            if(isEquals(department)){
                throw new SameDepartmentNameException("Department with this name is already exist");
            }
            else{
                departmentDAO.addDepartment(department);
            }

    }

    public void update(Department department) throws SameDepartmentNameException, DAOException {

            if(isEquals(department)){
                throw new SameDepartmentNameException("Department with this name is already exist");
            }
            else{
                departmentDAO.updateDepartment(department);
            }
    }

    public void delete(Department department) throws DAOException {
        departmentDAO.deleteDepartment(department);
    }


    public List<Department> getAll() throws DAOException {
        List<Department> dep = departmentDAO.getAllDepartments();
        return dep;
    }

    public List<Department> getList() {
        return this.departments;
    }

    private boolean isEquals(Department department) throws DAOException {
        departmentDAO.getAllDepartments();
        for(Department check : departmentDAO.getAll()){
            if(department.getName().equals(check.getName())){
                return true;
            }
        }
        return false;
    }

}

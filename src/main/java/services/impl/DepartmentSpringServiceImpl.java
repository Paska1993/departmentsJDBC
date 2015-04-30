package services.impl;

import dao.departmentDAO.DepartmentDAO;
import exception.DAOException;
import exception.DepartmentNullNameExceptin;
import exception.SameDepartmentNameException;
import models.Department;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
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

    private DepartmentDAO departmentDAO;

    @Autowired
    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public DepartmentSpringServiceImpl() {
        this.departments = new ArrayList<Department>();
    }

    @Transactional
    public Department getById(Integer id) throws DAOException {
        return departmentDAO.getDepartmentById(id);
    }

    @Transactional
    public void add(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException {
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(department);
        if(violations.size() > 0){
            throw new DepartmentNullNameExceptin("Department name can`t be empty");
        }
        else{
            if(isEquals(department)){
                throw new SameDepartmentNameException("Department with this name is already exist");
            }
            else{
                departmentDAO.addDepartment(department);
            }
        }
    }

    @Transactional
    public void update(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException {
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(department);
        if(violations.size() > 0){
            throw new DepartmentNullNameExceptin("Department name can`t be empty");
        }
        else{
            if(isEquals(department)){
                throw new SameDepartmentNameException("Department with this name is already exist");
            }
            else{
                departmentDAO.updateDepartment(department);
            }
        }
    }

    @Transactional
    public void delete(Department department) throws DAOException {
        departmentDAO.deleteDepartment(department);
    }

    @Transactional
    public void getAll() throws DAOException {
        departmentDAO.getAllDepartments();
        this.departments = departmentDAO.getAll();
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

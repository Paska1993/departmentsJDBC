package services.impl;

import dao.DAOFactory;
import dao.departmentDAO.DepartmentDAO;
import dao.departmentDAO.hibernate.DepartmentHibernateImpl;
import exception.DAOException;
import exception.DepartmentNullNameExceptin;
import exception.SameDepartmentNameException;
import models.Department;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import services.DepartmentService;

import java.util.List;

/**
 * Created by pavel on 23.04.15.
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DAOFactory DAOs;

    public DepartmentServiceImpl() {
        DAOs = DAOFactory.getInstance();
    }

    public Department getDepartmentById(Integer id) throws  DAOException {
        return DAOs.getDeptDAO().getDepartmentById(id);
    }

    public void addDepartment(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException{
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
                DAOs.getDeptDAO().addDepartment(department);
            }
        }
    }

    public void updateDepartment(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException {
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
                DAOs.getDeptDAO().updateDepartment(department);
            }
        }
    }

    public void deleteDepartment(Department department) throws DAOException {
        DAOs.getDeptDAO().deleteDepartment(department);
    }

    public void getAllDepartments() throws DAOException {
            DAOs.getDeptDAO().getAllDepartments();
    }

    public List<Department> getAll(){
        return DAOs.getDeptDAO().getAll();
    }


    private static boolean isEquals(Department department) throws DAOException {
        DepartmentDAO dao = new DepartmentHibernateImpl();
        dao.getAllDepartments();
        for(Department check : dao.getAll()){
            if(department.getName().equals(check.getName())){
                return true;
            }
        }
        return false;
    }
}

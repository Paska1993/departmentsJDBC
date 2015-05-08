package services.impl;

import dao.DAOFactory;
import dao.departmentDAO.DepartmentDAO;
import dao.departmentDAO.hibernate.DepartmentHibernateImpl;
import exception.DAOException;
import exception.SameDepartmentNameException;
import models.Department;
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

    public Department getById(Integer id) throws  DAOException {
        return DAOs.getDeptDAO().getDepartmentById(id);
    }

    public void add(Department department) throws SameDepartmentNameException/*, DepartmentNullNameExceptin*/, DAOException{
       /* Validator validator = new Validator();
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
        }*/
    }

    public void update(Department department) throws SameDepartmentNameException, /*DepartmentNullNameExceptin,*/ DAOException {
        /*Validator validator = new Validator();
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
        }*/
    }

    public void delete(Department department) throws DAOException {
        DAOs.getDeptDAO().deleteDepartment(department);
    }

    public void getAll() throws DAOException {
            DAOs.getDeptDAO().getAllDepartments();
    }

    public List<Department> getList(){
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

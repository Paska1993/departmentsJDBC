package services;

import dao.departmentDAO.DepartmentDAO;
import dao.departmentDAO.jdbc.DepartmentJDBCImpl;
import exception.DepartmentNullNameExceptin;
import exception.SameDepartmentNameException;
import models.Department;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by pavel on 23.04.15.
 */
public class DepartmentService {

    public static void service(Department department, DepartmentDAO departmentDAO, boolean kindOfService) throws DepartmentNullNameExceptin, SameDepartmentNameException, SQLException, ClassNotFoundException {
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
                if(kindOfService == true)
                    departmentDAO.addDepartment(department);
                else
                    departmentDAO.updateDepartment(department);
            }
        }
    }

    private static boolean isEquals(Department department) throws SQLException, ClassNotFoundException {
        DepartmentDAO dao = new DepartmentJDBCImpl();
        dao.getAllDepartments();
        for(Department check : dao.getAll()){
            if(department.getName().equals(check.getName())){
                return true;
            }
        }
        return false;
    }
}

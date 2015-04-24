package dao.departmentDAO;

import models.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by pavel on 22.04.15.
 */
public interface DepartmentDAO {

    void getDepartmentById(Integer id) throws ClassNotFoundException, SQLException;
    void addDepartment(Department department) throws ClassNotFoundException, SQLException;
    void deleteDepartment(Department department) throws ClassNotFoundException, SQLException;
    void updateDepartment(Department department) throws ClassNotFoundException, SQLException;
    void getAllDepartments() throws ClassNotFoundException, SQLException;
    List<Department> getAll();

}

package dao.departmentDAO;

import exception.DAOException;
import models.Department;

import java.util.List;

/**
 * Created by pavel on 22.04.15.
 */
public interface DepartmentDAO {

    Department getDepartmentById(Integer id) throws DAOException;
    void addDepartment(Department department) throws DAOException;
    void deleteDepartment(Department department) throws DAOException;
    void updateDepartment(Department department) throws DAOException;
    void getAllDepartments() throws DAOException;
    List<Department> getAll();

}

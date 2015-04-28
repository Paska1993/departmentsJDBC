package services;

import exception.DAOException;
import exception.DepartmentNullNameExceptin;
import exception.SameDepartmentNameException;
import models.Department;

import java.util.List;

/**
 * Created on 27.04.15.
 */
public interface DepartmentService {
    Department getDepartmentById(Integer id) throws DAOException;
    void addDepartment(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException;
    void updateDepartment(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException;
    void deleteDepartment(Department department) throws DAOException;
    void getAllDepartments() throws DAOException;
    List<Department> getAll();
}

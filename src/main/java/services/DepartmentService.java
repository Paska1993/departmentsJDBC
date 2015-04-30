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
    Department getById(Integer id) throws DAOException;
    void add(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException;
    void update(Department department) throws SameDepartmentNameException, DepartmentNullNameExceptin, DAOException;
    void delete(Department department) throws DAOException;
    void getAll() throws DAOException;
    List<Department> getList();
}

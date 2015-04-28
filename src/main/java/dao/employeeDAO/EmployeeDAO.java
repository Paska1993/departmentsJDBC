package dao.employeeDAO;

import exception.DAOException;
import models.Employee;

import java.util.List;

/**
 * Created by pavel on 22.04.15.
 */
public interface EmployeeDAO {
    Employee getEmployeeById(Integer id) throws DAOException;
    void getEmployeesByDepartmentId(Integer id) throws  DAOException;
    void addEmployee(Employee employee) throws DAOException;
    void deleteEmployee(Employee employee) throws DAOException;
    void updateEmployee(Employee employee) throws DAOException;
    void getAllEmployee() throws DAOException;
    List <Employee> getAll();
}

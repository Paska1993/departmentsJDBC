package services;

import exception.*;
import models.Employee;

import java.util.List;

/**
 * Created on 27.04.15.
 */
public interface EmployeeService {
    Employee getEmployeeById(Integer id) throws DAOException;
    void getEmployeesByDepartmentId(Integer id) throws DAOException;
    void addEmployee(Employee employee) throws EmployeeNullFieldsException,
            EmailFormatException, SalaryFormatException, SameEmailException, DAOException;
    void deleteEmployee(Employee employee) throws DAOException;
    void updateEmployee(Employee employee) throws EmployeeNullFieldsException, EmailFormatException,
            SalaryFormatException, SameEmailException, DAOException;
    void getAllEmployee() throws DAOException;
    List<Employee> getAll();
}

package services;

import exception.DAOException;
import exception.SameEmailException;
import models.Employee;

import java.util.List;

/**
 * Created on 27.04.15.
 */
public interface EmployeeService {
    Employee getById(Integer id) throws DAOException;
    List<Employee> getByDepartmentId(Integer id) throws DAOException;
    void add(Employee employee) throws /*EmployeeNullFieldsException,*/
            /*EmailFormatException,*/ /*SalaryFormatException,*/ SameEmailException, DAOException;
    void delete(Employee employee) throws DAOException;
    void update(Employee employee) throws /*EmployeeNullFieldsException, EmailFormatException,
            SalaryFormatException,*/ SameEmailException, DAOException;
    List<Employee> getAll() throws DAOException;
    List<Employee> getList();
}

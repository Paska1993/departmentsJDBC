package dao.employeeDAO;

import models.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by pavel on 22.04.15.
 */
public interface EmployeeDAO {
    void getEmployeeById(Integer id) throws ClassNotFoundException, SQLException;
    void getEmployeesByDepartmentId(Integer id) throws ClassNotFoundException, SQLException;
    void addEmployee(Employee employee) throws ClassNotFoundException, SQLException;
    void deleteEmployee(Employee employee) throws ClassNotFoundException, SQLException;
    void updateEmployee(Employee employee) throws ClassNotFoundException, SQLException;
    void getAllEmployee() throws ClassNotFoundException, SQLException;
    List <Employee> getAll();
}

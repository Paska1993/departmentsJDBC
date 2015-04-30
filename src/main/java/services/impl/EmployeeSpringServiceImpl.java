package services.impl;

import dao.employeeDAO.EmployeeDAO;
import exception.*;
import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28.04.15.
 */
@Service
public class EmployeeSpringServiceImpl implements EmployeeService {
    private List<Employee> employees;

    private ClassPathXmlApplicationContext context = null;

    @Autowired
    private EmployeeDAO EmployeeDAOImpl;

    public void setEmployeeDAOImpl(EmployeeDAO employeeDAOImpl) {
        EmployeeDAOImpl = employeeDAOImpl;
    }

    public EmployeeSpringServiceImpl() {
        this.employees = new ArrayList<Employee>();
        context = new ClassPathXmlApplicationContext("spring.xml");
        EmployeeDAOImpl = (EmployeeDAO) context.getBean("EmployeeDAOImpl");
    }

    @Transactional
    public Employee getEmployeeById(Integer id) throws DAOException {
        return EmployeeDAOImpl.getEmployeeById(id);
    }

    @Transactional
    public void getEmployeesByDepartmentId(Integer id) throws DAOException {
        EmployeeDAOImpl.getEmployeesByDepartmentId(id);
        this.employees = EmployeeDAOImpl.getAll();
    }

    @Transactional
    public void addEmployee(Employee employee) throws EmployeeNullFieldsException, EmailFormatException, SalaryFormatException, SameEmailException, DAOException {
        EmployeeDAOImpl.addEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(Employee employee) throws DAOException {
        EmployeeDAOImpl.deleteEmployee(employee);
    }

    @Transactional
    public void updateEmployee(Employee employee) throws EmployeeNullFieldsException, EmailFormatException, SalaryFormatException, SameEmailException, DAOException {
        EmployeeDAOImpl.updateEmployee(employee);
    }

    @Transactional
    public void getAllEmployee() throws DAOException {
        EmployeeDAOImpl.getAllEmployee();
        this.employees = EmployeeDAOImpl.getAll();
    }

    public List<Employee> getAll() {
        return this.employees;
    }

}

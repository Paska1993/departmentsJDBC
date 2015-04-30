package services.impl;

import dao.employeeDAO.EmployeeDAO;
import exception.*;
import models.Employee;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.EmployeeService;
import utils.EmailValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28.04.15.
 */
@Service
public class EmployeeSpringServiceImpl implements EmployeeService {

    private List<Employee> employees;

    private EmployeeDAO employeeDAO;

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public EmployeeSpringServiceImpl() {
        this.employees = new ArrayList<Employee>();
    }

    @Transactional
    public Employee getById(Integer id) throws DAOException {
        return employeeDAO.getEmployeeById(id);
    }

    @Transactional
    public void getByDepartmentId(Integer id) throws DAOException {
        employeeDAO.getEmployeesByDepartmentId(id);
        this.employees = employeeDAO.getAll();
    }

    @Transactional
    public void add(Employee employee) throws EmployeeNullFieldsException, EmailFormatException, SalaryFormatException, SameEmailException, DAOException {
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(employee);
        if (violations.size() > 0) {
            throw new EmployeeNullFieldsException(violations);
        }else if (!EmailValidator.check(employee.getEmail())){
            throw new EmailFormatException(employee.getEmail());
        }else if (employee.getSalary() < 0){
            throw new SalaryFormatException(employee.getSalary().toString());
        }else if(chekEmail(employee)) {
            throw new SameEmailException(employee.getEmail());
        }else {
            employeeDAO.addEmployee(employee);
        }
    }

    @Transactional
    public void delete(Employee employee) throws DAOException {
        employeeDAO.deleteEmployee(employee);
    }

    @Transactional
    public void update(Employee employee) throws EmployeeNullFieldsException, EmailFormatException, SalaryFormatException, SameEmailException, DAOException {
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(employee);
        if (violations.size() > 0) {
            throw new EmployeeNullFieldsException(violations);
        }else if (!EmailValidator.check(employee.getEmail())){
            throw new EmailFormatException(employee.getEmail());
        }else if (employee.getSalary() < 0){
            throw new SalaryFormatException(employee.getSalary().toString());
        }else if(chekEmail(employee)) {
            throw new SameEmailException(employee.getEmail());
        }else {
            employeeDAO.updateEmployee(employee);
        }
    }

    @Transactional
    public void getAll() throws DAOException {
        employeeDAO.getAllEmployee();
        this.employees = employeeDAO.getAll();
    }

    public List<Employee> getList() {
        return this.employees;
    }

    private  boolean chekEmail(Employee employee) throws DAOException {
        employeeDAO.getAllEmployee();
        for(Employee chek : employeeDAO.getAll()){
            if(chek.getEmail().equals(employee.getEmail())) {
                if(!chek.equals(employee)) {
                    return true;
                }else{
                   // employeeDAO.delete(employee);
                }
            }
        }
        return false;
    }

}

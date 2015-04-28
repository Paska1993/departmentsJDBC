package services.impl;

import dao.DAOFactory;
import dao.employeeDAO.EmployeeDAO;
import dao.employeeDAO.jdbc.EmployeeJDBCImpl;
import exception.*;
import models.Employee;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import services.EmployeeService;
import utils.EmailFormatChecker;

import java.util.List;

/**
 * Created by pavel on 23.04.15.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private DAOFactory DAOs;

    public EmployeeServiceImpl() {
        DAOs = DAOFactory.getInstance();
    }

    public Employee getEmployeeById(Integer id) throws DAOException {
        return DAOs.getEmployeeDAO().getEmployeeById(id);
    }

    public void getEmployeesByDepartmentId(Integer id) throws DAOException {
        DAOs.getEmployeeDAO().getEmployeesByDepartmentId(id);
    }

    public void addEmployee(Employee employee) throws EmployeeNullFieldsException, EmailFormatException, SalaryFormatException, SameEmailException, DAOException {

        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(employee);
        if (violations.size() > 0) {
            throw new EmployeeNullFieldsException(violations);
        }else if (!EmailFormatChecker.check(employee.getEmail())){
            throw new EmailFormatException(employee.getEmail());
        }else if (employee.getSalary() < 0){
            throw new SalaryFormatException(employee.getSalary().toString());
        }else if(!chekEmail(employee)) {
            throw new SameEmailException(employee.getEmail());
        }else {
            DAOs.getEmployeeDAO().addEmployee(employee);
        }
    }

    public void deleteEmployee(Employee employee) throws DAOException {
        DAOs.getEmployeeDAO().deleteEmployee(employee);
    }

    public void updateEmployee(Employee employee) throws EmployeeNullFieldsException, EmailFormatException, SalaryFormatException, SameEmailException, DAOException {
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(employee);
        if (violations.size() > 0) {
            throw new EmployeeNullFieldsException(violations);
        }else if (!EmailFormatChecker.check(employee.getEmail())){
            throw new EmailFormatException(employee.getEmail());
        }else if (employee.getSalary() < 0){
            throw new SalaryFormatException(employee.getSalary().toString());
        }else if(!chekEmail(employee)) {
            throw new SameEmailException(employee.getEmail());
        }else {
            DAOs.getEmployeeDAO().updateEmployee(employee);
        }
    }

    public void getAllEmployee() throws DAOException {
        DAOs.getEmployeeDAO().getAllEmployee();
    }
    public List <Employee> getAll(){
        return DAOs.getEmployeeDAO().getAll();
    }


    private static boolean chekEmail(Employee employee) throws DAOException {
        EmployeeDAO employeeDAO = new EmployeeJDBCImpl();
        employeeDAO.getAllEmployee();
        for(Employee chek : employeeDAO.getAll()){
            if(!chek.equals(employee)) {
                return true;
            }
        }
        return false;
    }
}

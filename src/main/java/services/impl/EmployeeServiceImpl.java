package services.impl;

import dao.DAOFactory;
import dao.employeeDAO.EmployeeDAO;
import dao.employeeDAO.jdbc.EmployeeJDBCImpl;
import exception.DAOException;
import exception.SameEmailException;
import models.Employee;
import services.EmployeeService;

import java.util.List;

/**
 * Created by pavel on 23.04.15.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private DAOFactory DAOs;

    public EmployeeServiceImpl() {
        DAOs = DAOFactory.getInstance();
    }

    public Employee getById(Integer id) throws DAOException {
        return DAOs.getEmployeeDAO().getEmployeeById(id);
    }

    public List<Employee> getByDepartmentId(Integer id) throws DAOException {
        return DAOs.getEmployeeDAO().getEmployeesByDepartmentId(id);
    }

    public void add(Employee employee) throws /*EmployeeNullFieldsException, EmailFormatException,*//* SalaryFormatException, */SameEmailException, DAOException {

       /* Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(employee);
        if (violations.size() > 0) {
            throw new EmployeeNullFieldsException(violations);
        }else if (!EmailValidator.check(employee.getEmail())){
            throw new EmailFormatException(employee.getEmail());
        }else if (employee.getSalary() < 0){
            throw new SalaryFormatException(employee.getSalary().toString());
        }else if(!chekEmail(employee)) {
            throw new SameEmailException(employee.getEmail());
        }else {
            DAOs.getEmployeeDAO().addEmployee(employee);
        }*/
    }

    public void delete(Employee employee) throws DAOException {
        DAOs.getEmployeeDAO().deleteEmployee(employee);
    }

    public void update(Employee employee) throws /*EmployeeNullFieldsException, EmailFormatException, SalaryFormatException,*/ SameEmailException, DAOException {
      /*  Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(employee);
        if (violations.size() > 0) {
            throw new EmployeeNullFieldsException(violations);
        }else if (!EmailValidator.check(employee.getEmail())){
            throw new EmailFormatException(employee.getEmail());
        }else if (employee.getSalary() < 0){
            throw new SalaryFormatException(employee.getSalary().toString());
        }else*/ if(!chekEmail(employee)) {
            throw new SameEmailException(employee.getEmail());
        }else {
            DAOs.getEmployeeDAO().updateEmployee(employee);
        }
    }

    public List<Employee> getAll() throws DAOException {
        DAOs.getEmployeeDAO().getAllEmployee();
        return null;
    }
    public List <Employee> getList(){
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

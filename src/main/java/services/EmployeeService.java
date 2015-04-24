package services;

import dao.employeeDAO.EmployeeDAO;
import dao.employeeDAO.jdbc.EmployeeJDBCImplementation;
import exception.EmailFormatException;
import exception.EmployeeNullFieldsException;
import exception.SalaryFormatException;
import exception.SameEmailException;
import models.Employee;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import utils.EmailFormatChecker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pavel on 23.04.15.
 */
public class EmployeeService {


    public static void service(Employee employee, EmployeeDAO employeeDAO, boolean kindOfService) throws EmployeeNullFieldsException, SameEmailException, EmailFormatException, SalaryFormatException, SQLException, ClassNotFoundException {
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
        }else{
            if(kindOfService == true)
                employeeDAO.addEmployee(employee);
            else
                employeeDAO.updateEmployee(employee);
        }
    }


    private static boolean chekEmail(Employee employee) throws SQLException, ClassNotFoundException {
        EmployeeDAO employeeDAO = new EmployeeJDBCImplementation();
        employeeDAO.getAllEmployee();
        for(Employee chek : employeeDAO.getAll()){
            if(!chek.equals(employee)) {
                return true;
            }
        }
        return false;
    }
}

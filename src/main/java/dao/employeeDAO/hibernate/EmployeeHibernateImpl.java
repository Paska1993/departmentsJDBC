package dao.employeeDAO.hibernate;

import dao.employeeDAO.EmployeeDAO;
import models.Employee;
import models.hibernateImpl.EmployeeH;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 27.04.15.
 */
public class EmployeeHibernateImpl implements EmployeeDAO {

    private List <Employee> employees;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void getEmployeeById(Integer id) throws ClassNotFoundException, SQLException {

    }

    public void getEmployeesByDepartmentId(Integer id) throws ClassNotFoundException, SQLException {

    }

    public void addEmployee(Employee employee) throws ClassNotFoundException, SQLException {

    }

    public void deleteEmployee(Employee employee) throws ClassNotFoundException, SQLException {

    }

    public void updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {

    }

    public void getAllEmployee() throws ClassNotFoundException, SQLException {
        Session session = null;
        List<Employee> employeeHList;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            employeeHList = (List<Employee>) session.createCriteria(EmployeeH.class).list();
            this.employees = employeeHList;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Employee> getAll() {
        return this.employees;
    }
}

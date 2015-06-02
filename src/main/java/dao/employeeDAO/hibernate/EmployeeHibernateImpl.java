package dao.employeeDAO.hibernate;

import dao.employeeDAO.EmployeeDAO;
import exception.DAOException;
import models.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

/**
 * Created on 27.04.15.
 */
public class EmployeeHibernateImpl implements EmployeeDAO {

    private List <Employee> employees;



    public Employee getEmployeeById(Integer id) throws DAOException {
        Session session = null;
        Employee employee = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            employee = (Employee) session.get(Employee.class, id);
        }
        catch (Exception e) {
            throw new DAOException();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return employee;
    }

    public List<Employee> getEmployeesByDepartmentId(Integer id) throws DAOException {

        Session session = null;
        List<Employee> employeeHList;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Employee WHERE department.id = :dep_id");
            query.setInteger("dep_id", id);
            employeeHList = query.list();
            this.employees = employeeHList;
        }
        catch (Exception e) {
            throw new DAOException();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) throws DAOException {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            throw new DAOException();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteEmployee(Employee employee) throws DAOException {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            throw new DAOException();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateEmployee(Employee employee) throws DAOException {


        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            throw new DAOException();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Employee> getAllEmployee() throws DAOException {
        Session session = null;
        List<Employee> employeeHList;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            employeeHList = (List<Employee>) session.createCriteria(Employee.class).list();
            this.employees = employeeHList;
        }
        catch (Exception e) {
            throw new DAOException();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    public List<Employee> getAll() {
        return this.employees;
    }
}

package dao.employeeDAO.hibernate;

import dao.employeeDAO.EmployeeDAO;
import exception.DAOException;
import models.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28.04.15.
 */
@Repository
public class EmployeeSpringHibernateImpl implements EmployeeDAO {

    private List<Employee> employees;

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public EmployeeSpringHibernateImpl(){
        this.employees = new ArrayList<Employee>();
    }

    public Employee getEmployeeById(Integer id) throws DAOException {
        Session session = null;
        Employee employee = null;
        try {
            session = this.sessionFactory.openSession();
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

    public void getEmployeesByDepartmentId(Integer id) throws DAOException {

        Session session = null;
        List<Employee> employeeHList;
        try {
            session = this.sessionFactory.openSession();
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
    }

    public void addEmployee(Employee employee) throws DAOException {

        Session session = null;
        try {
            session = this.sessionFactory.openSession();
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
            session = this.sessionFactory.openSession();
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
            session = this.sessionFactory.openSession();
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

    public void getAllEmployee() throws DAOException {
        Session session = null;
        List<Employee> employeeHList;
        try {
            session = this.sessionFactory.openSession();
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
    }

    public List<Employee> getAll() {
        return this.employees;
    }
}

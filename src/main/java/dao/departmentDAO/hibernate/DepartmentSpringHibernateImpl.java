package dao.departmentDAO.hibernate;

import dao.departmentDAO.DepartmentDAO;
import exception.DAOException;
import models.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28.04.15.
 */
@Repository
public class DepartmentSpringHibernateImpl implements DepartmentDAO {

    private List<Department> department;


    private SessionFactory sessionFactory;


    public DepartmentSpringHibernateImpl(){
        this.department = new ArrayList<Department>();
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Department getDepartmentById(Integer id) throws DAOException {

        Session session = null;
        Department department = null;
        try {
            session = this.getSessionFactory().openSession();
            department = (Department) session.get(Department.class, id);
        }
        catch (Exception e) {
            throw new DAOException();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return department;
    }

    public void addDepartment(Department department) throws DAOException {
        Session session = null;
        try {
            session = this.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(department);
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

    public void deleteDepartment(Department department) throws DAOException {
        Session session = null;
        try {
            session = this.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(department);
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

    public void updateDepartment(Department department) throws DAOException {

        Session session = null;
        try {
            session = this.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(department);
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

    public void getAllDepartments() throws DAOException {
        Session session = null;
        List<Department> dep;
        try {
            session = this.getSessionFactory().openSession();
            List<Department> departments = session.createCriteria(Department.class).list();
            this.department = departments;
            session.close();
        } catch (Exception e) {
            throw new DAOException();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Department> getAll() {
        return this.department;
    }
}

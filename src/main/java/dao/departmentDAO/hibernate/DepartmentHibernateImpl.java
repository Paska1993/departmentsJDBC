package dao.departmentDAO.hibernate;

import dao.departmentDAO.DepartmentDAO;
import models.Department;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 24.04.15.
 */
public class DepartmentHibernateImpl implements DepartmentDAO{

    private List <Department> department;

    public DepartmentHibernateImpl(){
        this.department = new ArrayList<Department>();
    }

    public Department getDepartmentById(Integer id) throws ClassNotFoundException, SQLException {
        Session session = null;
        Department department = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            department = (Department) session.get(Department.class, id);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return department;
    }

    public void addDepartment(Department department) throws ClassNotFoundException, SQLException {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
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

    public void deleteDepartment(Department department) throws ClassNotFoundException, SQLException {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(department);
            session.getTransaction().commit();
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

    public void updateDepartment(Department department) throws ClassNotFoundException, SQLException {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(department);
            session.getTransaction().commit();
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

    public void getAllDepartments() throws ClassNotFoundException, SQLException {
        Session session = null;
        List<Department> dep;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            dep = (List<Department>) session.createCriteria(Department.class).list();
            this.department = dep;
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

    public List<Department> getAll() {
        return this.department;
    }
}

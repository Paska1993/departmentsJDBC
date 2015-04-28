package dao;

import dao.departmentDAO.DepartmentDAO;
import dao.departmentDAO.hibernate.DepartmentHibernateImpl;
import dao.employeeDAO.EmployeeDAO;
import dao.employeeDAO.hibernate.EmployeeHibernateImpl;

/**
 * Created by pavel on 23.04.15.
 */
public class DAOFactory {
    private static DepartmentDAO departmentDAO;
    private static EmployeeDAO employeeDAO;

    private static volatile DAOFactory daoFactory;

    private static final Object lock = new Object();

    private DAOFactory(){

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            synchronized (lock) {
                if (daoFactory == null) {
                    daoFactory = new DAOFactory();
                }
            }
        }
        return daoFactory;
    }


    public EmployeeDAO getEmployeeDAO() {
        if (employeeDAO == null) {
            employeeDAO = new EmployeeHibernateImpl(); /*new EmployeeJDBCImpl();*/
        }
        return employeeDAO;
    }

    public DepartmentDAO getDeptDAO() {
        if (departmentDAO == null) {
            departmentDAO = new DepartmentHibernateImpl(); /*new DepartmentJDBCImpl();*/
        }
        return departmentDAO;
    }

}

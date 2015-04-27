package dao.departmentDAO.jdbc;

import dao.departmentDAO.DepartmentDAO;
import models.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavel on 22.04.15.
 */
public class DepartmentJDBCImpl implements DepartmentDAO{

    private final String URL = "jdbc:mysql://localhost/departments";
    private final String NAME = "root";
    private final String PASSWORD = "1";
    private List<Department> departments;

    private final String GET_ALL_QUERY = "select * from department";
    private final String GET_BY_ID = "SELECT * FROM department WHERE department.id = ?";
    private final String DELETE_QUERY = "DELETE FROM department WHERE department.name = ?";
    private final String UPDATE_QUERY = "UPDATE department SET department.name = ? WHERE department.id = ?";
    private final String ADD_QUERY = "INSERT INTO department(name)VALUES (?)";

    public DepartmentJDBCImpl(){
        this.departments = new ArrayList<Department>();
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }


    public Department getDepartmentById(Integer id) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            createDepartmentFromResultSet(resultSet);
            Department department = this.getAll().get(0);
            preparedStatement.close();
            connection.close();
        return department;
    }

    public void addDepartment(Department department) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1, department.getName());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
    }

    public void deleteDepartment(Department department) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setString(1, department.getName());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
    }

    public void updateDepartment(Department department) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getId());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
    }

    public void getAllDepartments() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
            createDepartmentFromResultSet(resultSet);
            resultSet.close();
            statement.close();
            connection.close();
    }

    public List<Department> getAll() {
        return this.departments;
    }


    private void createDepartmentFromResultSet(ResultSet resultSet ) throws SQLException{
        while (resultSet.next()) {
            Department department = new Department();
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            department.setId(id);
            department.setName(name);
            this.departments.add(department);
        }
    }
}

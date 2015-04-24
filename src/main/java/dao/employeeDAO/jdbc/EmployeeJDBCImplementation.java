package dao.employeeDAO.jdbc;

import dao.employeeDAO.EmployeeDAO;
import models.Department;
import models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavel on 22.04.15.
 */
public class EmployeeJDBCImplementation implements EmployeeDAO {

    private final String URL = "jdbc:mysql://localhost/departments";
    private final String NAME = "root";
    private final String PASSWORD = "1";
    private List <Employee> employees;

    private final String GET_BY_ID = "SELECT * FROM employee WHERE employee.employee_id = ?";
    private final String GET_ALL_BY_ID_QUERY = "SELECT * FROM employee WHERE employee.department_id =?";
    private final String GET_ALL_QUERY = "SELECT * FROM employee";
    private final String DELETE_QUERY = "DELETE FROM employee WHERE employee.employee_id = ?";
    private final String UPDATE_QUERY = "UPDATE employee SET employee.name = ? , employee.surname = ?," +
            "employee.salary = ?, employee.address = ?, employee.department_id = ?, employee.birthday = ?," +
            "employee.email = ? WHERE employee.employee_id = ?";
    private final String ADD_QUERY = "INSERT INTO employee(name,surname,salary,address,department_id,birthday,email) " +
            "VALUES(?,? ,? ,?, ?, ?, ?)";

    public EmployeeJDBCImplementation(){
        this.employees = new ArrayList<Employee>();
    }

    public void getEmployeeById(Integer id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        createEmployeeFromResultSet(resultSet);
    }

    public void getEmployeesByDepartmentId(Integer id) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BY_ID_QUERY);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            createEmployeeFromResultSet(resultSet);
    }

    public void addEmployee(Employee employee) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2,employee.getSurname());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setInt(5, employee.getDepartment_id());
            preparedStatement.setDate(6, employee.getBirthday());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.execute();
    }

    public void deleteEmployee(Employee employee) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.execute();
    }

    public void updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setInt(5, employee.getDepartment_id());
            preparedStatement.setDate(6, employee.getBirthday());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setInt(8, employee.getId());
            preparedStatement.execute();
    }

    public void getAllEmployee() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_QUERY);
            ResultSet rs =  preparedStatement.executeQuery();
            createEmployeeFromResultSet(rs);
    }

    public List<Employee> getAll() {
        return this.employees;
    }

    private void createEmployeeFromResultSet(ResultSet resultSet ) throws SQLException {
        while (resultSet.next()) {
            Employee employee = new Employee();
            Integer id = resultSet.getInt("employee_id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            Double salary = resultSet.getDouble("salary");
            String address = resultSet.getString("address");
            Integer departments_id = resultSet.getInt("department_id");
            Date date_of_birth = resultSet.getDate("birthday");
            String email = resultSet.getString("email");
            employee.setId(id);
            employee.setName(name);
            employee.setSurname(surname);
            employee.setSalary(salary);
            employee.setAddress(address);
            employee.setDepartment_id(departments_id);
            employee.setBirthday(date_of_birth);
            employee.setEmail(email);
            this.employees.add(employee);
        }
    }
}

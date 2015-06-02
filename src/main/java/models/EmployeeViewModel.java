package models;

import java.util.Date;

/**
 * Created on 15.05.15.
 */
public class EmployeeViewModel {

    private Integer id;

    private String name;

    private String surname;

    private Double salary;

    private String address;

    private Date birthday;

    private String email;

    private Integer department_id;

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {

        return strToDate(birthday);
    }

    public String getSpecialBirthday() {
        return birthday.toString();
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public EmployeeViewModel(String address, Date birthday, Integer id, String email, String name, Double salary, String surname, Integer department_id) {
        this.address = address;
        this.birthday = birthday;
        this.id = id;
        this.email = email;
        this.name = name;
        this.salary = salary;
        this.surname = surname;
        this.department_id = department_id;
    }

    public EmployeeViewModel(Integer id, String name, String surname, Date birthday, Double salary, String address, String email, Integer department_id) {
        this.address = address;
        this.birthday = birthday;
        this.id = id;
        this.email = email;
        this.name = name;
        this.salary = salary;
        this.surname = surname;
        this.department_id = department_id;
    }

    public EmployeeViewModel(String address, Date birthday, String email, String name, Double salary, String surname, Integer department_id) {
        this.address = address;
        this.birthday = birthday;
        this.department_id = department_id;
        this.email = email;
        this.name = name;
        this.salary = salary;
        this.surname = surname;
    }

    public EmployeeViewModel() {
    }

    public String strToDate(Date strDate) {
        String []DateArr = strDate.toString().split(" ");
        return DateArr[0];
    }
}

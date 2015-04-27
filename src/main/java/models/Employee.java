package models;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import java.sql.Date;

/**
 * Created by pavel on 22.04.15.
 */

public class Employee {
    private Integer id;

    @NotEmpty(message = "Name: is empty")
    @NotNull(message = "Name: is empty")
    private String name;

    @NotEmpty(message = "Surname: is empty")
    @NotNull(message = "Surname: is empty")
    private String surname;

    @NotEmpty(message = "Salary: is empty")
    @NotNull(message = "Salary: is empty")
    private Double salary;

    @NotEmpty(message = "Address: is empty")
    @NotNull(message = "Address: is empty")
    private String address;

    @NotEmpty(message = "ID: is empty")
    @NotNull(message = "ID: is empty")
    private Integer department_id;

    @NotEmpty(message = "Date of birth: is empty")
    @NotNull(message = "Date of birth: is empty")
    private Date birthday;

    @NotEmpty(message = "Email: is empty")
    @NotNull(message = "Email: is empty")
    private String email;



    public Employee(){

    }

    public Employee(String name, String surname, Double salary, Integer department_id, String address, Date birthday, String email) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department_id = department_id;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public Employee(Integer id, String email, Date birthday, Integer department_id, String address, Double salary, String surname, String name) {
        this.id = id;
        this.email = email;
        this.birthday = birthday;
        this.department_id = department_id;
        this.address = address;
        this.salary = salary;
        this.surname = surname;
        this.name = name;
    }

    public Integer getId() {

        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return getId().equals(employee.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

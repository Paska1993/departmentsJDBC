package models;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;


/**
 * Created on 27.04.15.
 */
@Component
@Entity
@Table(name = "employee")
public class Employee {

    private Integer id;

    @Size(min=3, max=30 ,message="Field Name is empty or less then 3 characters")
    private String name;

    @Size(min=2, max=30, message="Field Surname is empty or less then 2 characters" )
    private String surname;

    @Min(value = 0, message = "Really, did you ever see salary less then 0?")
    @NotNull(message = "Salary: is empty")
    private Double salary;

    @NotEmpty(message = "Address: is empty")
    private String address;


    @NotNull(message = "Date of birth: is empty")
    @Past(message = "Date must be in past time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotEmpty(message = "Email: is empty")
    @Email(message = "Wrong Email format")
    private String email;

    private Department department;

    @Column(name="address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name="salary")
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="employee_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @ManyToOne
    @JoinColumn(name="department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Column(name="birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isEquals(Object o) {
        Employee employee = (Employee) o;
        return this.getId().equals(employee.getId());

    }

}

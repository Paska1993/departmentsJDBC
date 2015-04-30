package models;

import net.sf.oval.constraint.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created on 27.04.15.
 */
@Component
@Entity
@Table(name = "employee")
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
    @Digits(message = "Please type a valid data")
    private Double salary;

    @NotEmpty(message = "Address: is empty")
    @NotNull(message = "Address: is empty")
    private String address;


    @NotEmpty(message = "Date of birth: is empty")
    @NotNull(message = "Date of birth: is empty")
    @Past(message = "Wrong date")
    private Date birthday;

    @NotEmpty(message = "Email: is empty")
    @NotNull(message = "Email: is empty")
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

    @Override
    public boolean equals(Object o) {
        Employee employee = (Employee) o;
        return this.getId().equals(employee.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}

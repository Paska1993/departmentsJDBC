package models;

import models.hibernateImpl.EmployeeH;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by pavel on 22.04.15.
 */
@Entity
@Table(name = "department")
public class Department {

    private Integer id;

    @NotNull(message = "Field Name cannot be empty")
    @NotEmpty(message = "Field Name cannot be empty")
    private String name;

    private Set<EmployeeH> employees;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "department")
    public Set<EmployeeH> getEmployees() {
        return employees;
    }

    public void setEmployees(Set employees) {
        this.employees = employees;
    }

    public Department(){

    }

    public Department(String name) {
        this.name = name;
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
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
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

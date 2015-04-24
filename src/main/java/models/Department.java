package models;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * Created by pavel on 22.04.15.
 */
public class Department {

    private Integer id;

    @NotNull(message = "Field Name cannot be empty")
    @NotEmpty(message = "Field Name cannot be empty")
    private String name;

    public Department(){

    }

    public Department(String name) {
        this.name = name;
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}

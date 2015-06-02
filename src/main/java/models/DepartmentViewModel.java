package models;

/**
 * Created on 14.05.15.
 */
public class DepartmentViewModel {

    private Integer id;

    private String name;

    public DepartmentViewModel() {
    }

    public DepartmentViewModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentViewModel(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

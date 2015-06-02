package services.converters;

import models.Employee;
import models.EmployeeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import services.DepartmentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 15.05.15.
 */
@Service
public class EmployeeViewService {

    @Autowired
    @Qualifier(value = "departmentSpringService")
    private DepartmentService departmentService;

    public List<EmployeeViewModel> convertToViewModels(List<Employee> employees) {
        List<EmployeeViewModel> employeeViewModels = new ArrayList<EmployeeViewModel>();
        for (Employee employee : employees) {
            employeeViewModels.add(new EmployeeViewModel(employee.getAddress(), employee.getBirthday(), employee.getId(), employee.getEmail(),
                    employee.getName(), employee.getSalary(), employee.getSurname(), employee.getDepartment().getId()));
        }
        return employeeViewModels;
    }

    public Employee convertToDAOModel(EmployeeViewModel viewModel) {
        Employee employee = new Employee();
        employee.setName(viewModel.getName());
        employee.setSurname(viewModel.getSurname());
        employee.setAddress(viewModel.getAddress());
        employee.setBirthday(viewModel.getSpecialBirthday());
        employee.setEmail(viewModel.getEmail());
        employee.setSalary(viewModel.getSalary());
        return employee;
    }

    public Employee setDAOModel(Employee employee, EmployeeViewModel viewModel) {
        employee.setName(viewModel.getName());
        employee.setSurname(viewModel.getSurname());
        employee.setAddress(viewModel.getAddress());
        employee.setBirthday(viewModel.getSpecialBirthday());
        employee.setEmail(viewModel.getEmail());
        employee.setSalary(viewModel.getSalary());
        return employee;
    }
}

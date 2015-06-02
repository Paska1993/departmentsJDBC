package services.converters;

import models.Department;
import models.DepartmentViewModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 14.05.15.
 */
@Service
public class DepartmentViewService {

    public List<DepartmentViewModel> convertToViewModels(List<Department> departments){
        List<DepartmentViewModel> departmentsView = new ArrayList<DepartmentViewModel>();
        for(Department department: departments){
            departmentsView.add(new DepartmentViewModel(department.getId(),department.getName()));
        }
        return departmentsView;
    }

    public List<Department> convertToDAOModels(List<DepartmentViewModel> departments){
        List<Department> departmentList = new ArrayList<Department>();
        for(DepartmentViewModel viewModel: departments){
            departmentList.add(new Department(viewModel.getId(), viewModel.getName()));
        }
        return departmentList;
    }

    public Department convertToDAOModel(DepartmentViewModel viewModel){
        return new Department(viewModel.getId(), viewModel.getName());
    }
}

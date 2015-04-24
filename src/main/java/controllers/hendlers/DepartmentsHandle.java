package controllers.hendlers;
import dao.DAOFactory;
import dao.departmentDAO.DepartmentDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by pavel on 22.04.15.
 */
public interface DepartmentsHandle {

     void handle(HttpServletRequest request, HttpServletResponse response,
                 DepartmentDAO departmentDAO) throws ServletException, IOException;
}

package controllers.handlers;

import dao.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 27.04.15.
 */
public interface Handle {
    void handle(HttpServletRequest request, HttpServletResponse response,
                DAOFactory DAOs);
}

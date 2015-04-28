package controllers.handlers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 27.04.15.
 */
public interface Handle {
    void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
}

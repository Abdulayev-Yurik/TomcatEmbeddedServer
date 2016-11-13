package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yurik on 13.11.16.
 */
@WebServlet({"/greeter"})
public class GreeterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramName = req.getParameter("name");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/greeter.jsp");
        req.setAttribute("greeterName", paramName.isEmpty()? "world" : paramName);
        dispatcher.forward(req, resp);
    }
}

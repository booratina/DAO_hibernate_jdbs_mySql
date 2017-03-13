package controller;

import model.User;
import service.ServiceFactory;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 09.03.2017.
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static UserService service;

    static {
        try {
            service = ServiceFactory.getService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setRole(request.getParameter("role"));
        int id = Integer.parseInt(request.getParameter("id"));


        user.setId(id);
        service.updateUser(user);
         request.setAttribute("list", service.getAllUsers());
        request.getRequestDispatcher("index.jsp").forward(request,response);

}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user ;
        user = service.getUserId(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("upd.jsp").forward(request, response);
    }
}

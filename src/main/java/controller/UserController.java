package controller;

import service.ServerService;

import service.ServerServiceImp;
import model.Users;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by User on 05.03.2017.
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static ServerService service = ServerServiceImp.createService();
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/*

        req.setAttribute("list", service.getAllUsers());
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
*/

        service.createTable();

        String forward = "";
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            int userId = Integer.parseInt(req.getParameter("id"));
            service.deleteUser(userId);
            forward = LIST_USER;
            req.setAttribute("users", service.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(req.getParameter("id"));
            Users user = service.getUserId(userId);
            req.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")) {
            forward = LIST_USER;
            req.setAttribute("users", service.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }
        RequestDispatcher view = req.getRequestDispatcher(forward);
        view.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         Users user = new Users();
        user.setName(req.getParameter("name"));
        user.setPassword(req.getParameter("password"));
        user.setRole(req.getParameter("role"));
        String userid = req.getParameter("id");

        if (userid == null || userid.isEmpty()) {
            service.addUser(user);
        } else {
            user.setId(Integer.parseInt(userid));
            service.updateUser(user);
        }
        RequestDispatcher view = req.getRequestDispatcher(LIST_USER);
        req.setAttribute("users", service.getAllUsers());
        view.forward(req, resp);
    }
}


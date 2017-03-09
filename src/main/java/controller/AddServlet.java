package controller;

import model.Users;
import service.ServerService;
import service.ServerServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 09.03.2017.
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private static ServerService service = ServerServiceImp.createService();;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users user = new Users();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setRole(request.getParameter("role"));
        String userid = request.getParameter("id");


            service.addUser(user);

        request.setAttribute("list", service.getAllUsers());
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

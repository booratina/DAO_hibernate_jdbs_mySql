package controller;

import model.Users;
import service.ServerService;
import service.ServerServiceImp;

import javax.servlet.RequestDispatcher;
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
    private static ServerService service = ServerServiceImp.createService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users user = new Users();
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
        Users user = new Users();
        user = service.getUserId(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("upd.jsp").forward(request, response);


    }
}

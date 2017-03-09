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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private static ServerService service = ServerServiceImp.createService();;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int userId = Integer.parseInt(req.getParameter("id"));
        service.deleteUser(userId);
        req.setAttribute("list", service.getAllUsers());
        req.getRequestDispatcher("index.jsp").forward(req,resp);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

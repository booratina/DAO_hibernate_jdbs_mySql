package controller;

import service.ServiceFactory;
import service.UserService;

import service.UserServiceImp;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by User on 05.03.2017.
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {

    private static UserService service;

    static {
        try {
            service = ServiceFactory.getService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("list", service.getAllUsers());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}


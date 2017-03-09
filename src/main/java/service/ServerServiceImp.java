package service;

import model.Users;
import usersDAO.*;


import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public class ServerServiceImp implements ServerService {

    private static ServerServiceImp ourInstance = null;
    private static DAOFactory factory;


    private ServerServiceImp() {

        factory = DAOFactory.getFactory(1);


    }

    public static synchronized ServerServiceImp createService() {
        if (ourInstance == null) {
            ourInstance = new ServerServiceImp();
            return ourInstance;
        }
        return ourInstance;
    }
    @Override
    public Users getUserName(String name) {
        return factory.getUserDAO().getUserByName(name);
    }

    @Override
    public Users getUserId(int id) {
        return factory.getUserDAO().getUserById(id);
    }

    @Override
    public void updateUser(Users user) {
        factory.getUserDAO().updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        factory.getUserDAO().deleteUser(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return factory.getUserDAO().getAllUsers();
    }

    @Override
    public void addUser(Users user) {
        factory.getUserDAO().addUser(user);
    }

    @Override
    public void createTable() {
        factory.getUserDAO().createTable();
    }

    @Override
    public void dropTable() {
        factory.getUserDAO().dropTable();
    }
}

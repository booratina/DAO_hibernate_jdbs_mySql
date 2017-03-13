package service;

import model.User;
import usersDAO.*;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by User on 05.03.2017.
 */
public class UserServiceImp implements UserService {

    private static UserServiceImp ourInstance = null;
    private static UserDAO factory;


    private UserServiceImp() throws Exception {
        factory = DAOFactory.getUserDAO(getParamOrm());
    }

    public static synchronized UserServiceImp createService() throws Exception {
        if (ourInstance == null) {
            ourInstance = new UserServiceImp();
            return ourInstance;
        }
        return ourInstance;
    }
    public String getParamOrm() {
        Properties prop = new Properties();
        String fileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String ormPar = prop.getProperty("orm");


        return ormPar;
    }


    public User getUserName(String name) {
        return factory.getUserByName(name);
    }


    public User getUserId(int id) {
        return factory.getUserById(id);
    }


    public void updateUser(User user) {
        factory.updateUser(user);
    }


    public void deleteUser(int id) {
        factory.deleteUser(id);
    }


    public List<User> getAllUsers() {
        return factory.getAllUsers();
    }


    public void addUser(User user) {
        factory.addUser(user);
    }


    public void createTable() {
        factory.createTable();
    }


    public void dropTable() {
        factory.dropTable();
    }
}

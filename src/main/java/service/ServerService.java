package service;

import model.Users;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public interface ServerService {





    public Users getUserName(String name);

    public Users getUserId(int id);

    public void updateUser(Users user);

    public void deleteUser(int id);

    public List<Users> getAllUsers();

    public void addUser(Users user);

    public void createTable();

    public void dropTable();

}

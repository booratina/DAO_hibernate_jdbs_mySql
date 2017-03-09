package usersDAO;

import model.Users;

import java.util.List;

/**
 * Created by User on 06.03.2017.
 */
public interface UserDAO {
    public void addUser(Users user);

    public void deleteUser(int userId);

    public void updateUser(Users user);

    public List<Users> getAllUsers();

    public Users getUserById(int userId);

    public Users getUserByName(String name);


    public void createTable();

    public void dropTable();
}

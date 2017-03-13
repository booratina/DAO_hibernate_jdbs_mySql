package usersDAO;

import model.User;

import java.util.List;

/**
 * Created by User on 06.03.2017.
 */
public interface UserDAO {
     void addUser(User user);

     void deleteUser(int userId);

     void updateUser(User user);

     List<User> getAllUsers();

     User getUserById(int userId);

     User getUserByName(String name);


     void createTable();

     void dropTable();
}

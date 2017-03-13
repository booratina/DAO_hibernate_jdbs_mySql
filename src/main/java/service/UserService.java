package service;

import model.User;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public interface UserService {



     static UserServiceImp createService() throws Exception {
       return UserServiceImp.createService();
     }

     User getUserName(String name);

     User getUserId(int id);

     void updateUser(User user);

     void deleteUser(int id);

     List<User> getAllUsers();

     void addUser(User user);

     void createTable();

     void dropTable();

}

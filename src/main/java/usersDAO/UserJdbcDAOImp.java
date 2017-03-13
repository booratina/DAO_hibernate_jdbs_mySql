package usersDAO;

import connect.JdbsConnect;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.03.2017.
 */
public class UserJdbcDAOImp implements UserDAO {

    private static JdbsConnect jdbsConnect = new JdbsConnect();
    private static Executor executor = new Executor(jdbsConnect.getMysqlConnection());
    private static volatile UserJdbcDAOImp instance = null;

    public UserJdbcDAOImp() {
    }


    public synchronized static UserJdbcDAOImp getUserDAO() {
        if (instance == null) {
            return new UserJdbcDAOImp();
        }
        return instance;
    }

    public void createTable() {
        try {
            executor.getConnection().setAutoCommit(false);
            executor.execUpdate("create table if not exists users (id bigint auto_increment, name varchar(256),password varchar(256),role varchar(256) , primary key (id))");
            executor.getConnection().commit();
            executor.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            try {
                executor.getConnection().rollback();
            } catch (SQLException ignore) {
                ignore.printStackTrace();
            }
        }
    }

    public void addUser(User user) {
        try {
            executor.getConnection().setAutoCommit(false);
            executor.execUpdate("insert into users set name='" + user.getName() + "', password='" + user.getPassword() + "', role='" + user.getRole() + "'");
            executor.getConnection().commit();
            executor.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            try {
                executor.getConnection().rollback();
            } catch (SQLException ignore) {
                ignore.printStackTrace();
            }
        }


    }

    public void deleteUser(int userId) {
        try {
            executor.getConnection().setAutoCommit(false);
            executor.execUpdate("delete from users where id='" + userId + "'");
            executor.getConnection().commit();
            executor.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            try {
                executor.getConnection().rollback();
            } catch (SQLException ignore) {
                ignore.printStackTrace();
            }
        }
    }

    public void updateUser(User user) {
        try {
            executor.getConnection().setAutoCommit(false);
            executor.execUpdate("update users set name='" + user.getName() + "', password='" + user.getPassword() + "', role='" + user.getRole() + "' where id='" + user.getId() + "'");
            executor.getConnection().commit();
            executor.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            try {
                executor.getConnection().rollback();
            } catch (SQLException ignore) {
                ignore.printStackTrace();
            }

        }
    }

    public List<User> getAllUsers() {
        try {
            return executor.execQuery("select * from users", result -> {
                List<User> listUsers = new ArrayList<>();
                while (result.next()) {
                    User user = new User();
                    user.setId(result.getInt("id"));
                    user.setName(result.getString("name"));
                    user.setPassword(result.getString("password"));
                    user.setRole(result.getString("role"));
                    listUsers.add(user);
                }
                return listUsers;
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public User getUserById(int id) {

        try {
            return executor.execQuery("select * from users where id=" + id, result -> {
                result.next();
                return new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserByName(String name) {
        try {
            return executor.execQuery("select * from users where name=" + name, result -> {
                result.next();
                return new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void dropTable() {
        try {
            executor.execUpdate("drop table users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

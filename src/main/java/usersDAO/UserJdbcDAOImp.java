package usersDAO;

import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.03.2017.
 */
public class UserJdbcDAOImp implements UserDAO {

    private static Connect connect = new Connect();
    private static Executor executor = new Executor(connect.getMysqlConnection());
    private static UserJdbcDAOImp instance = null;

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

    public void addUser(Users user) {
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

    public void updateUser(Users user) {
        try {
            executor.getConnection().setAutoCommit(false);
            executor.execUpdate("UpdateServlet users set name='" + user.getName() + "', password='" + user.getPassword() + "', role='" + user.getRole() + "' where id='" + user.getId() + "'");
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

    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<Users>();
        try {
            Statement statement = executor.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Users getUserById(int id) {

        try {
            return executor.execQuery("select * from users where id=" + id, result -> {
                result.next();
                return new Users(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Users getUserByName(String name) {
        try {
            return executor.execQuery("select * from users where name=" + name, result -> {
                result.next();
                return new Users(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
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

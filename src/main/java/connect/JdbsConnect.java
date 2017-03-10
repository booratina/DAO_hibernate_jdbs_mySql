package connect;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by User on 05.03.2017.
 */
public class JdbsConnect {
    private static Connection connection;

    public JdbsConnect() {
    }


    public  Connection getMysqlConnection() {
        Properties prop = new Properties();
        String fileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }
}


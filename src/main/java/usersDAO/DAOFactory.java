package usersDAO;

import java.util.Properties;

/**
 * Created by User on 06.03.2017.
 */
public abstract class DAOFactory {

    public abstract UserDAO getUserDAO();


    public static DAOFactory getFactory(String param) {
        int key = 0;

        if ("jdbs".equals(param)) {
            key = 1;
        }
        if ("hibernate".equals(param)) {
            key = 2;
        }
        switch (key) {
            case 1:
                return new JdbsFactory();
            case 2:
                return new HibernateFactory();
            default:
                return null;
        }
    }
}

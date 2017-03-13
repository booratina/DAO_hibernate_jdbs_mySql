package usersDAO;

import java.util.Properties;

/**
 * Created by User on 06.03.2017.
 */
public abstract class DAOFactory {

    public abstract UserDAO getUserDAO();


    public static UserDAO getUserDAO(String param) throws Exception {

        if ("jdbs".equals(param)) {

            return new UserJdbcDAOImp();
        }
        if ("hibernate".equals(param)) {

            return new UserHibernateDAOImp();
        }

        throw new Exception("invalid orm conf value");

    }
}

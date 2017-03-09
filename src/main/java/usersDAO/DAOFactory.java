package usersDAO;

/**
 * Created by User on 06.03.2017.
 */
public abstract class DAOFactory {

    public abstract UserDAO getUserDAO();


    public static DAOFactory getFactory(int base) {

        switch (base) {
            case 1:
                return new JdbsFactory();

            case 2:
                return new HibernateFactory();
            default:
                return null;
        }
    }


}

package usersDAO;

/**
 * Created by User on 08.03.2017.
 */
public class HibernateFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        return new UserHibernateDAOImp();
    }
}

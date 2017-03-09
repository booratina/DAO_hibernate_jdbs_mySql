package usersDAO;

/**
 * Created by User on 08.03.2017.
 */
public class JdbsFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        return new UserJdbcDAOImp();
    }
}

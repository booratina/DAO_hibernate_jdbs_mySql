package usersDAO;

import connect.HibernateConnect;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by User on 08.03.2017.
 */
public class UserHibernateDAOImp implements UserDAO {



    EntityManager entityManager = HibernateConnect.getConnet();


    public void addUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public void deleteUser(int userId) {
        entityManager.getTransaction().begin();
        entityManager.remove(getUserById(userId));
        entityManager.getTransaction().commit();
    }

    public void updateUser(User user) {
        entityManager.getTransaction().begin();
        /*if (entityManager.find(User.class, user.getId()) == null) {
            throw new IllegalArgumentException("Unknown employee id: " + user.getId());
        }*/
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("SELECT e FROM User e");
        return (List<User>) query.getResultList();
    }

    public User getUserById(int userId) {

        return entityManager.find(User.class, userId);
    }

    public User getUserByName(String name) {
        return entityManager.find(User.class, name);
    }

    public void createTable() {

    }

    public void dropTable() {

    }
}

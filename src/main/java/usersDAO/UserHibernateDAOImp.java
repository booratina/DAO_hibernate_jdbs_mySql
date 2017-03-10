package usersDAO;

import connect.HibernateConnect;
import model.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by User on 08.03.2017.
 */
public class UserHibernateDAOImp implements UserDAO {



    EntityManager entityManager = HibernateConnect.getConnet();


    public void addUser(Users user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public void deleteUser(int userId) {
        entityManager.getTransaction().begin();
        entityManager.remove(getUserById(userId));
        entityManager.getTransaction().commit();
    }

    public void updateUser(Users user) {
        entityManager.getTransaction().begin();
        /*if (entityManager.find(Users.class, user.getId()) == null) {
            throw new IllegalArgumentException("Unknown employee id: " + user.getId());
        }*/
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public List<Users> getAllUsers() {
        Query query = entityManager.createQuery("SELECT e FROM Users e");
        return (List<Users>) query.getResultList();
    }

    public Users getUserById(int userId) {

        return entityManager.find(Users.class, userId);
    }

    public Users getUserByName(String name) {
        return entityManager.find(Users.class, name);
    }

    public void createTable() {

    }

    public void dropTable() {

    }
}

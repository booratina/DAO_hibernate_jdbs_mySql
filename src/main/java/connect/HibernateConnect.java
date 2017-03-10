package connect;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by User on 10.03.2017.
 */
public class HibernateConnect {
    private static EntityManagerFactory em = Persistence.createEntityManagerFactory("TEST");
    private static EntityManager entityManager = em.createEntityManager();

    public static EntityManager getConnet() {
        return entityManager;
    }
}


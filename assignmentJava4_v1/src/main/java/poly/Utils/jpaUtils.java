package poly.Utils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaUtils {
    public static EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        return entityManagerFactory.createEntityManager();
    }
}

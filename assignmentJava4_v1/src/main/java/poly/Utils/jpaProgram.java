package poly.Utils;

import poly.Entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class jpaProgram {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public void insert(Users users) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(users);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public static void main(String[] args) {
        Users users = new Users();
    }
}

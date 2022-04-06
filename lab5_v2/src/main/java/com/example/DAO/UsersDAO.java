package com.example.DAO;

import com.example.Utils.jpaUtils;
import com.example.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsersDAO {
   private EntityManager entityManager;
   private EntityTransaction entityTransaction;

    public List<Users> findAll() {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        String sql = "select u from Users u order by u.id desc";
        TypedQuery<Users> query = entityManager.createQuery(sql, Users.class);
        return query.getResultList();
    }

    public List<Users> findKeyword(String key) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        String sql = "select u from Users u where u.fullname like:key";
        TypedQuery<Users> query = entityManager.createQuery(sql, Users.class);
        query.setParameter("key", "%" + key + "%");
        return query.getResultList();
    }

    public Users findByID(int id){
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        return entityManager.find(Users.class, id);
    }

    public void insert(Users user) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public void update(Users user) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(user);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public void delete(int id) throws Exception {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        Users user = entityManager.find(Users.class, id);
        try {
            entityTransaction.begin();
            if(user != null){
                entityManager.remove(user);
            }else {
                throw new Exception("Error: Not find");
            }
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }
}

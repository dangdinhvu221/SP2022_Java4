package com.poly.DAO;

import com.poly.Entity.Users;
import com.poly.Utils.jpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsersDAO implements shopDao<Users, Integer>{
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;


    @Override
    public Users insert(Users users) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(users);
            entityTransaction.commit();
            return users;
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public Users update(Users users) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(users);
            entityTransaction.commit();
            return users;
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Integer key) throws Exception {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        Users users = entityManager.find(Users.class, key);
        try {
            entityTransaction.begin();
            if(key != null){
                entityManager.remove(users);
            }else{
                throw new  Exception("Error: Not find");
            }
            entityTransaction.commit();
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public List<Users> findAll() {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "SELECT u FROM Users u ORDER BY  u.id DESC";
            TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Users findByID(Integer key) {
           try {
               entityManager = jpaUtils.getEntityManager();
               entityTransaction = entityManager.getTransaction();
               return entityManager.find(Users.class, key);
           }catch (Exception e){
               e.printStackTrace();
               throw e;
           }
    }

    @Override
    public List<Users> findKeyword(String key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "select u from Users u where u.fullName like:key";
            TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
            query.setParameter("key", "%" + key + "%");
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}

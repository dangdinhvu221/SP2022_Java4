package com.example.DAO;

import com.example.Entity.Users;
import com.example.Utils.jpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO implements DAO<Users, Integer>{
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @Override
    public Users insert(Users users) {
        entityManager = jpaUtils.getEntityManager();
        transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(users);
            transaction.commit();
            return users;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Users update(Users listUsers) {
        entityManager = jpaUtils.getEntityManager();
        transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(listUsers);
            transaction.commit();
            return listUsers;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(Integer key) throws Exception {
        entityManager = jpaUtils.getEntityManager();
        transaction = entityManager.getTransaction();
        Users user = entityManager.find(Users.class, key);
        try {
            transaction.begin();
            if(user != null){
                entityManager.remove(user);
            }else{
                throw new Exception();
            }
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Users> findAll() {
        entityManager = jpaUtils.getEntityManager();
        transaction = entityManager.getTransaction();
        String jpql = "select u from Users u order by u.id desc";
        TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
        return query.getResultList();
    }

    @Override
    public Users findByID(Integer key) {
        entityManager = jpaUtils.getEntityManager();
        transaction = entityManager.getTransaction();
        return entityManager.find(Users.class, key);
    }

    @Override
    public List<Users> findKeyword(String key) {
        return null;
    }
}

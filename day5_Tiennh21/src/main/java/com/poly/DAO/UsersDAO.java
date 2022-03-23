package com.poly.DAO;

import com.poly.Utils.jpaUtils;
import com.poly.entity.Users;
import com.poly.entity.UsersMy;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsersDAO {
    EntityManager entityManager = jpaUtils.getEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();


    public List<Users> findAll() {
        String sql = "select u from Users u";
        TypedQuery<Users> query = entityManager.createQuery(sql, Users.class);
        return query.getResultList();
    }

    public Users findByID(int id){
        return entityManager.find(Users.class, id);
    }

    public void insert(Users user) {
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

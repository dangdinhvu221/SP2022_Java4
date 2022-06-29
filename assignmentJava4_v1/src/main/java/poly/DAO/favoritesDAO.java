package poly.DAO;

import poly.Entity.Category;
import poly.Entity.Favorite;
import poly.Entity.Orders;
import poly.Entity.order.FlowOrder;
import poly.Utils.jpaUtils;
import poly.jdbcHepler.Hepler;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class favoritesDAO implements shopDao<Favorite, Integer>{
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    @Override
    public Favorite insert(Favorite favorite) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(favorite);
            entityTransaction.commit();
            return favorite;
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public Favorite update(Favorite favorite) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(favorite);
            entityTransaction.commit();
            return favorite;
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
        Favorite favorite = entityManager.find(Favorite.class, key);
        try {
            entityTransaction.begin();
            if (key != null) {
                entityManager.remove(favorite);
            } else {
                throw new Exception("Error: Not find");
            }
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Favorite> findAll() {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "SELECT u FROM Favorite u ";
            TypedQuery<Favorite> query = entityManager.createQuery(jpql, Favorite.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Favorite findByID(Integer key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            return entityManager.find(Favorite.class, key);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Favorite> findKeyword(String key) {
        return null;
    }

    public List<Favorite> findByUserId(Integer key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "select u from Favorite u where u.user_id =:key";
            TypedQuery<Favorite> query = entityManager.createQuery(jpql, Favorite.class);
            query.setParameter("key", key);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

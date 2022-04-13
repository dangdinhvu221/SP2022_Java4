package poly.DAO;

import poly.Entity.OrderStates;
import poly.Entity.Orders;
import poly.Utils.jpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderStatesDAO implements shopDao<OrderStates, Integer> {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    @Override
    public OrderStates insert(OrderStates orderStates) {
        return null;
    }

    @Override
    public OrderStates update(OrderStates orderStates) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(orderStates);
            entityTransaction.commit();
            return orderStates;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Integer key) throws Exception {

    }

    @Override
    public List<OrderStates> findAll() {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "SELECT u FROM OrderStates u";
            TypedQuery<OrderStates> query = entityManager.createQuery(jpql, OrderStates.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public OrderStates findByID(Integer key) {
        return null;
    }

    @Override
    public List<OrderStates> findKeyword(String key) {
        return null;
    }
}

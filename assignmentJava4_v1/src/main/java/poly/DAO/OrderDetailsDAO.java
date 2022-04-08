//package poly.DAO;
//
//import poly.Entity.Orderdetails;
//import poly.Entity.Orders;
//import poly.Entity.Users;
//import poly.Utils.jpaUtils;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.TypedQuery;
//import java.util.List;
//
//public class OrderDetailsDAO implements shopDao<Orderdetails, Integer>{
//    private EntityManager entityManager;
//    private EntityTransaction entityTransaction;
//
//    @Override
//    public Orderdetails insert(Orderdetails orders) {
//        entityManager = jpaUtils.getEntityManager();
//        entityTransaction = entityManager.getTransaction();
//        try {
//            entityTransaction.begin();
//            entityManager.persist(orders);
//            entityManager.flush();
//            entityTransaction.commit();
//            return orders;
//        } catch (Exception e) {
//            entityTransaction.rollback();
//            e.printStackTrace();
//            throw e;
//        } finally {
//            entityManager.close();
//        }
//    }
//
//    @Override
//    public Orderdetails update(Orderdetails orders) {
//        entityManager = jpaUtils.getEntityManager();
//        entityTransaction = entityManager.getTransaction();
//        try {
//            entityTransaction.begin();
//            entityManager.merge(orders);
//            entityTransaction.commit();
//            return orders;
//        } catch (Exception e) {
//            entityTransaction.rollback();
//            e.printStackTrace();
//            throw e;
//        } finally {
//            entityManager.close();
//        }
//    }
//
//    @Override
//    public void delete(Integer key) throws Exception {
//        entityManager = jpaUtils.getEntityManager();
//        entityTransaction = entityManager.getTransaction();
//        Orderdetails orders = entityManager.find(Orderdetails.class, key);
//        try {
//            entityTransaction.begin();
//            if (key != null) {
//                entityManager.remove(orders);
//            } else {
//                throw new Exception("Error: Not find");
//            }
//            entityTransaction.commit();
//        } catch (Exception e) {
//            entityTransaction.rollback();
//            e.printStackTrace();
//            throw e;
//        } finally {
//            entityManager.close();
//        }
//    }
//
//    @Override
//    public List<Orderdetails> findAll() {
//        try {
//            entityManager = jpaUtils.getEntityManager();
//            entityTransaction = entityManager.getTransaction();
//            String jpql = "SELECT u FROM Orderdetails u ORDER BY  u.id DESC";
//            TypedQuery<Orderdetails> query = entityManager.createQuery(jpql, Orderdetails.class);
//            return query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
//    }
//
//    @Override
//    public Orderdetails findByID(Integer key) {
//        try {
//            entityManager = jpaUtils.getEntityManager();
//            entityTransaction = entityManager.getTransaction();
//            return entityManager.find(Orderdetails.class, key);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
//    }
//
//    @Override
//    public List<Orderdetails> findKeyword(String key) {
//      return null;
//    }
//}

package poly.DAO;

import poly.Entity.Category;
import poly.Entity.Supplier;
import poly.Utils.jpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class SupplierDAO implements shopDao<Supplier, Integer>{
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    @Override
    public Supplier insert(Supplier supplier) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(supplier);
            entityTransaction.commit();
            return supplier;
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public Supplier update(Supplier supplier) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(supplier);
            entityTransaction.commit();
            return supplier;
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
        Supplier supplier = entityManager.find(Supplier.class, key);
        try {
            entityTransaction.begin();
            if(key != null){
                entityManager.remove(supplier);
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
    public List<Supplier> findAll() {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "SELECT u FROM Supplier u ORDER BY  u.id DESC";
            TypedQuery<Supplier> query = entityManager.createQuery(jpql, Supplier.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Supplier findByID(Integer key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            return entityManager.find(Supplier.class, key);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Supplier> findKeyword(String key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "select u from Supplier u where u.nameSupplier like:key";
            TypedQuery<Supplier> query = entityManager.createQuery(jpql, Supplier.class);
            query.setParameter("key", "%" + key + "%");
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}

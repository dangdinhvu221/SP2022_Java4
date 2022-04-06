package poly.DAO;

import poly.Entity.Category;
import poly.Utils.jpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoriesDAO implements shopDao<Category, Integer>{
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;


    @Override
    public Category insert(Category category) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(category);
            entityTransaction.commit();
            return category;
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public Category update(Category category) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(category);
            entityTransaction.commit();
            return category;
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
        Category category = entityManager.find(Category.class, key);
        try {
            entityTransaction.begin();
            if(key != null){
                entityManager.remove(category);
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
    public List<Category> findAll() {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "SELECT u FROM Category u ORDER BY  u.id DESC";
            TypedQuery<Category> query = entityManager.createQuery(jpql, Category.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Category findByID(Integer key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            return entityManager.find(Category.class, key);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Category> findKeyword(String key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "select u from Category u where u.nameCategory like:key";
            TypedQuery<Category> query = entityManager.createQuery(jpql, Category.class);
            query.setParameter("key", "%" + key + "%");
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}

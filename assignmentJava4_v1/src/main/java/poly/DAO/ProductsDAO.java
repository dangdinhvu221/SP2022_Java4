package poly.DAO;

import lombok.extern.log4j.Log4j2;
import poly.Entity.Products;
import poly.Entity.Supplier;
import poly.Entity.Users;
import poly.Entity.order.FlowOrder;
import poly.Utils.jpaUtils;
import poly.jdbcHepler.Hepler;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductsDAO implements shopDao<Products, Integer>{
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    @Override
    public Products insert(Products products) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(products);
            entityTransaction.commit();
            return products;
        }catch (Exception e){
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public Products update(Products products) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(products);
            entityTransaction.commit();
            return products;
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
        Products products = entityManager.find(Products.class, key);
        try {
            entityTransaction.begin();
            if(key != null){
                entityManager.remove(products);
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
    public List<Products> findAll() {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "SELECT u FROM Products u ORDER BY  u.id DESC";
            TypedQuery<Products> query = entityManager.createQuery(jpql, Products.class);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<Products> findAllTop3(int amount) throws SQLException, ClassNotFoundException {
        List<Products> list = new ArrayList<>();
        try {
            Connection connection = Hepler.getConnection();
            String sql = "SELECT * FROM Products ORDER BY id OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, amount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Products(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }
            connection.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Products findByID(Integer key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            return entityManager.find(Products.class, key);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Products> findKeyword(String key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "select u from Products u where u.nameProduct like:key";
            TypedQuery<Products> query = entityManager.createQuery(jpql, Products.class);
            query.setParameter("key", "%" + key + "%");
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<Products> pagingAccount(int index) {
        List<Products> list = new ArrayList<>();
        String sql = "select  * from products order by id offset  ? rows  fetch next 4 rows  only";
        try {
            Connection con = Hepler.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Products(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalProducts() {
        String sql = "select count(*) from products";
        try {
            Connection con = Hepler.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void insertExcel(List<Products> entity) {
        EntityManager em = jpaUtils.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            final int numberOfRecords = 30;
            final int batchSize = 10;
            for (int i = 0; i <= entity.size() - 1; i++) {
                em.persist(entity.get(i));
                if (i % batchSize == 20) {
                    em.flush();
                    em.clear();
                }
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            em.close();
        }

    }
}

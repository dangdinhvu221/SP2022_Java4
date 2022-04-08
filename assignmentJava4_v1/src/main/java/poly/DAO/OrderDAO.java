package poly.DAO;

import poly.Entity.Orders;
import poly.Entity.Users;
import poly.Entity.order.FlowOrder;
import poly.Entity.order.Order;
import poly.Utils.jpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements shopDao<Orders, Integer> {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    @Override
    public Orders insert(Orders orders) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(orders);

            entityManager.flush();
            entityTransaction.commit();
            return orders;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Orders update(Orders orders) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(orders);
            entityTransaction.commit();
            return orders;
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
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        Orders orders = entityManager.find(Orders.class, key);
        try {
            entityTransaction.begin();
            if (key != null) {
                entityManager.remove(orders);
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
    public List<Orders> findAll() {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "SELECT u FROM Orders u ORDER BY  u.id DESC";
            TypedQuery<Orders> query = entityManager.createQuery(jpql, Orders.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Orders findByID(Integer key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            return entityManager.find(Orders.class, key);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Orders> findById(Integer key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "select u from Orders u where u.id =:key";
            TypedQuery<Orders> query = entityManager.createQuery(jpql, Orders.class);
            query.setParameter("key", key);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Orders> findKeyword(String key) {
        return null;
    }

    public Order insertOrder(Order order) {
        try {

            String jdbcURL = "jdbc:sqlserver://localhost;database=AssignmentJava4";
            String dbUser = "sa";
            String dbPassword = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "insert into orders(product_id, user_id, oder_quantity, date, statusState) values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getOrderId());
            statement.setInt(2, order.getUid());
            statement.setInt(3, order.getQuantity());
            statement.setString(4, order.getDate());
            statement.setInt(5, order.getStatusState());
            statement.executeUpdate();
            System.out.println("done-----------------------------------");

            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("error------------------------------------");

        }
        return order;
    }

    public List<FlowOrder> findAllOrder(int id) throws SQLException, ClassNotFoundException {
        List<FlowOrder> list = new ArrayList<>();
        try {
            String jdbcURL = "jdbc:sqlserver://localhost;database=AssignmentJava4";
            String dbUser = "sa";
            String dbPassword = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            String sql = "SELECT orders.id, p.id, imageProduct, nameProduct, size, color, oder_quantity, price, (price*orders.oder_quantity) as total, statusState FROM orders JOIN users u on u.id = orders.user_id JOIN products p on orders.product_id = p.id JOIN orderStates oS on orders.statusState = oS.id where user_id = ? and statusState = 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FlowOrder(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
            System.out.println("done-----------------------------------");
            connection.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error------------------------------------");
            throw e;
        }
    }

}

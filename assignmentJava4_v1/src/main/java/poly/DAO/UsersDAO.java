package poly.DAO;

import poly.Entity.Users;
import poly.Utils.jpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;

public class UsersDAO implements shopDao<Users, Integer> {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;


    @Override
    public Users insert(Users users) {
        entityManager = jpaUtils.getEntityManager();
        entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(users);
            entityManager.flush();
            entityTransaction.commit();
            return users;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
            throw e;
        } finally {
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
        Users users = entityManager.find(Users.class, key);
        try {
            entityTransaction.begin();
            if (key != null) {
                entityManager.remove(users);
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
    public List<Users> findAll() {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "SELECT u FROM Users u ORDER BY  u.id DESC";
            TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
            return query.getResultList();
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Users> findKeyword(String key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "select u from Users u where u.fullName like:key or u.username like:key";
            TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
            query.setParameter("key", "%" + key + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Users findKeywordEmail(String key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "select u from Users u where u.email like:key";
            TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
            query.setParameter("key", "%" + key + "%");
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Users findKeywordUser(String key) {
        try {
            entityManager = jpaUtils.getEntityManager();
            entityTransaction = entityManager.getTransaction();
            String jpql = "select u from Users u where u.username like:key";
            TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
            query.setParameter("key", key);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Users checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        String jdbcURL = "jdbc:sqlserver://localhost;database=AssignmentJava4";
        String dbUser = "sa";
        String dbPassword = "123";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM users WHERE username = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        Users user = null;

        if (result.next()) {
            user = new Users();
            user.setId(result.getInt("id"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
            user.setFullName(result.getString("fullName"));
            user.setAddress(result.getString("address"));
            user.setEmail(result.getString("email"));
            user.setPhone(result.getString("phone"));
            user.setAvatar(result.getString("avatar"));
            user.setRole(result.getBoolean("role"));
            user.setStatus(result.getBoolean("status"));
        }
        connection.close();

        return user;
    }
}

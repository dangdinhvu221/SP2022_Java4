package poly.Entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

@Entity
public class Orders {
    private int id;
    private Integer oderQuantity;
    private String date;
    private Users usersByUserId;
    private Products productsByProductId;
    private OrderStates ordersByOrderId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_quantity", nullable = true)
    public Integer getOderQuantity() {
        return oderQuantity;
    }

    public void setOderQuantity(Integer oderQuantity) {
        this.oderQuantity = oderQuantity;
    }

    @Basic
    @Column(name = "date", nullable = true, length = 50)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public Products getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(Products productsByProductId) {
        this.productsByProductId = productsByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "orderStates", referencedColumnName = "id")
    public OrderStates getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(OrderStates ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (oderQuantity != null ? !oderQuantity.equals(orders.oderQuantity) : orders.oderQuantity != null)
            return false;
        if (date != null ? !date.equals(orders.date) : orders.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (oderQuantity != null ? oderQuantity.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", oderQuantity=" + oderQuantity +
                ", date='" + date + '\'' +
                ", usersByUserId=" + usersByUserId +
                ", productsByProductId=" + productsByProductId +
                ", ordersByOrderId=" + ordersByOrderId +
                '}';
    }

    private static final Log log  = LogFactory.getLog(Orders.class);

    @PostPersist
    public void Create(){
        log.info("Add Orders: " + oderQuantity + "-" + date + "-" +usersByUserId + "-" +productsByProductId + "-" +ordersByOrderId + "With id: " + id);
    }

    @PostUpdate
    public void update(){
        log.info("update Orders: " + oderQuantity + "-" + date + "-" +usersByUserId + "-" +productsByProductId + "-" +ordersByOrderId + "With id: " + id);

    }

    @PostRemove
    public void remove(){
        log.info("remove Orders: " + oderQuantity + "-" + date + "-" +usersByUserId + "-" +productsByProductId + "-" +ordersByOrderId + "With id: " + id);
    }
}

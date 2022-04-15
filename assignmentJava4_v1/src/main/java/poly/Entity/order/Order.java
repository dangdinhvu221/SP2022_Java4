package poly.Entity.order;

import poly.Entity.Products;

public class Order extends Products {
    private int orderId;
    private int uid;
    private int order_quantity;
    private String date;
    private int statusState;

    public Order() {
    }

    public Order(int orderId, int uid, int order_quantity, String date, int statusState) {
        this.orderId = orderId;
        this.uid = uid;
        this.order_quantity = order_quantity;
        this.date = date;
        this.statusState = statusState;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatusState() {
        return statusState;
    }

    public void setStatusState(int statusState) {
        this.statusState = statusState;
    }
}

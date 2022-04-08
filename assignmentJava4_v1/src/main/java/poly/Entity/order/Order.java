package poly.Entity.order;

import poly.Entity.Products;

public class Order extends Products {
    private int orderId;
    private int uid;
    private int quantity;
    private String date;
    private int statusState;

    public Order() {
    }

    public Order(int orderId, int uid, int quantity, String date, int statusState) {
        this.orderId = orderId;
        this.uid = uid;
        this.quantity = quantity;
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

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

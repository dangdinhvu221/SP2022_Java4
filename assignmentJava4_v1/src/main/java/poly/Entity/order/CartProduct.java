package poly.Entity.order;

import poly.Entity.Products;

public class CartProduct extends Products {
    private int quantity;

    public CartProduct() {
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

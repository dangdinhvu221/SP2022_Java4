package poly.Entity;

public class Cart extends Products{
    private int quantity;

    public Cart() {
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

package poly.Entity.order;

public class FlowOrder {
    private int o_id, idP, o_quantity, price, total, status, u_id;
    private String imageProduct, nameProduct, size, color;

    public FlowOrder() {
    }

    public FlowOrder(int o_id, int idP, String imageProduct, String nameProduct, String size, String color, int o_quantity, int price, int total, int status) {
        this.o_id = o_id;
        this.idP = idP;
        this.o_quantity = o_quantity;
        this.price = price;
        this.total = total;
        this.status = status;
        this.imageProduct = imageProduct;
        this.nameProduct = nameProduct;
        this.size = size;
        this.color = color;
    }

    public FlowOrder(int o_id, int u_id ,int idP, String imageProduct, String nameProduct, String size, String color, int o_quantity, int price, int total, int status) {
        this.o_id = o_id;
        this.u_id = u_id;
        this.idP = idP;
        this.o_quantity = o_quantity;
        this.price = price;
        this.total = total;
        this.status = status;
        this.imageProduct = imageProduct;
        this.nameProduct = nameProduct;
        this.size = size;
        this.color = color;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getO_quantity() {
        return o_quantity;
    }

    public void setO_quantity(int o_quantity) {
        this.o_quantity = o_quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

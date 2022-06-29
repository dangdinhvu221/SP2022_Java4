package poly.Entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Products {
    private int id;
    private String nameProduct;
    private Integer quantity;
    private Integer price;
    private String color;
    private String size;
    private String imageProduct;
    private String description;
    private String title;
    private Timestamp created;
    private int category_id;
    private int supplier_id;
    private Category categoryByCategoryId;
    private Supplier supplierBySupplierId;


    public Products(int id, String nameProduct, int category_id, int supplier_id, int quantity, int price, String color, String size, String imageProduct, String description, String title) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.color = color;
        this.size = size;
        this.imageProduct = imageProduct;
        this.description = description;
        this.title = title;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
    }

    public Products() {

    }

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
    @Column(name = "nameProduct", nullable = true, length = 255)
    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "color", nullable = true, length = 255)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "size", nullable = true, length = 255)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "imageProduct", nullable = true, length = 2147483647)
    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 2147483647)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 2147483647)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Basic
    @Column(name = "created", nullable = true)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (id != products.id) return false;
        if (nameProduct != null ? !nameProduct.equals(products.nameProduct) : products.nameProduct != null)
            return false;
        if (quantity != null ? !quantity.equals(products.quantity) : products.quantity != null) return false;
        if (price != null ? !price.equals(products.price) : products.price != null) return false;
        if (color != null ? !color.equals(products.color) : products.color != null) return false;
        if (size != null ? !size.equals(products.size) : products.size != null) return false;
        if (imageProduct != null ? !imageProduct.equals(products.imageProduct) : products.imageProduct != null)
            return false;
        if (description != null ? !description.equals(products.description) : products.description != null)
            return false;
        if (title != null ? !title.equals(products.title) : products.title != null) return false;
        if (created != null ? !created.equals(products.created) : products.created != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameProduct != null ? nameProduct.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (imageProduct != null ? imageProduct.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    public Supplier getSupplierBySupplierId() {
        return supplierBySupplierId;
    }

    public void setSupplierBySupplierId(Supplier supplierBySupplierId) {
        this.supplierBySupplierId = supplierBySupplierId;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", imageProduct='" + imageProduct + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", created=" + created +
                ", category_id=" + category_id +
                ", supplier_id=" + supplier_id +
                ", categoryByCategoryId=" + categoryByCategoryId +
                ", supplierBySupplierId=" + supplierBySupplierId +
                '}';
    }

    private static final Log log  = LogFactory.getLog(Products.class);

    @PostPersist
    public void Create(){
        log.info("Add Products: " + nameProduct +  "-"+categoryByCategoryId + "-"+ supplierBySupplierId +  "-"+quantity +  "-"+price +  "-"+color + "-"+ size +  "-"+imageProduct +  "-"+description + "-"+ title  + "-"+ created + "With id: " + id);
    }

    @PostUpdate
    public void update(){
        log.info("Update Products: " + nameProduct +  "-"+categoryByCategoryId + "-"+ supplierBySupplierId +  "-"+quantity +  "-"+price +  "-"+color + "-"+ size +  "-"+imageProduct +  "-"+description + "-"+ title  + "-"+ created + "With id: " + id);
    }

    @PostRemove
    public void remove(){
        log.info("Remove Products: " + nameProduct +  "-"+categoryByCategoryId + "-"+ supplierBySupplierId +  "-"+quantity +  "-"+price +  "-"+color + "-"+ size +  "-"+imageProduct +  "-"+description + "-"+ title  + "-"+ created + "With id: " + id);
    }


}

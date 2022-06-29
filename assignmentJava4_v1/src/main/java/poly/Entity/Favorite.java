package poly.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Favorite {
    private int id;
    private Timestamp likeDate;
    private Users user_id;
    private Products product_id;

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
    @Column(name = "likeDate", nullable = true)
    public Timestamp getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Timestamp likeDate) {
        this.likeDate = likeDate;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Favorite favorite = (Favorite) o;

        if (id != favorite.id) return false;
        if (likeDate != null ? !likeDate.equals(favorite.likeDate) : favorite.likeDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (likeDate != null ? likeDate.hashCode() : 0);
        return result;
    }

}

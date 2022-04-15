package poly.Entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Favorite {
    private int id;
    private Timestamp likeDate;

    @Id
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

    private static final Log log  = LogFactory.getLog(Favorite.class);

    @PostPersist
    public void Create(){
        log.info("Add Favorite: " + likeDate + "With id: " + id);
    }

    @PostUpdate
    public void update(){
        log.info("Update Category: " + likeDate + "With id: " + id);

    }

    @PostRemove
    public void remove(){
        log.info("Remove Category: " + likeDate + "With id: " + id);

    }
}

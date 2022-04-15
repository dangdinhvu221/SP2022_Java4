package poly.Entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

@Entity
public class Category {
    private int id;
    private String nameCategory;
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
    @Column(name = "nameCategory", nullable = true, length = 255)
    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (nameCategory != null ? !nameCategory.equals(category.nameCategory) : category.nameCategory != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameCategory != null ? nameCategory.hashCode() : 0);
        return result;
    }

    private static final Log log  = LogFactory.getLog(Category.class);

    @PostPersist
    public void Create(){
        log.info("Add Category: " + nameCategory + "With id: " + id);
    }

    @PostUpdate
    public void update(){
        log.info("Update Category: " + nameCategory + "With id: " + id);

    }

    @PostRemove
    public void remove(){
        log.info("Remove Category: " + nameCategory + "With id: " + id);

    }
}

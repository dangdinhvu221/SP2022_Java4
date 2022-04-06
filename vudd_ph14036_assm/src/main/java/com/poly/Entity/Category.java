package com.poly.Entity;

import javax.persistence.*;

@Entity
public class Category {
    private int id;
    private String nameCategory;

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
}

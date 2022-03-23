package com.poly.entity;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "it16305", catalog = "")
public class UsersMy {
    private int id;
    private String fullname;
    private String address;
    private String email;
    private String password;
    private String phone;
    private String avatar;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fullname", nullable = false, length = 225)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 225)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 225)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 225)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 225)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "avatar", nullable = false, length = 225)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersMy usersMy = (UsersMy) o;

        if (id != usersMy.id) return false;
        if (fullname != null ? !fullname.equals(usersMy.fullname) : usersMy.fullname != null) return false;
        if (address != null ? !address.equals(usersMy.address) : usersMy.address != null) return false;
        if (email != null ? !email.equals(usersMy.email) : usersMy.email != null) return false;
        if (password != null ? !password.equals(usersMy.password) : usersMy.password != null) return false;
        if (phone != null ? !phone.equals(usersMy.phone) : usersMy.phone != null) return false;
        if (avatar != null ? !avatar.equals(usersMy.avatar) : usersMy.avatar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        return result;
    }
}

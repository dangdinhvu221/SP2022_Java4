package entity;

import javax.persistence.*;

@Entity
@Table(name = "list_users", schema = "dbo", catalog = "vuddLab5")
public class ListUsers {
    private String userId;
    private String password;
    private String fullname;
    private String email;
    private Boolean admin;

    @Id
    @Column(name = "userId", nullable = false, length = 50)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "fullname", nullable = true, length = 50)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "admin", nullable = true)
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListUsers users = (ListUsers) o;

        if (userId != null ? !userId.equals(users.userId) : users.userId != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (fullname != null ? !fullname.equals(users.fullname) : users.fullname != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (admin != null ? !admin.equals(users.admin) : users.admin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (admin != null ? admin.hashCode() : 0);
        return result;
    }
}

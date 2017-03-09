package edu.matc.personalfinance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by kvang on 3/7/17.
 */
@Entity
@Table(name = "user_roles", catalog = "financetracker", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_name")
})
public class UserRoles {

    private String user_name;
    private String role_name;

    public UserRoles() {
    }

    public UserRoles(String user_name, String role_name) {
        this.user_name = user_name;
        this.role_name = role_name;
    }

    @Column(name = "user_name", unique = true, nullable = false)
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Column(name = "role_name", nullable = false)
    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "user_name='" + user_name + '\'' +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}

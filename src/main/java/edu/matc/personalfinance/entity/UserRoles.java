package edu.matc.personalfinance.entity;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by kvang on 3/7/17.
 */
@Entity
@Table(name = "user_roles")
public class UserRoles {

    private final Logger logger = Logger.getLogger(this.getClass());
    private int role_id;
    private String user_name;
    private String role_name;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "role_id")
    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Column(name = "user_name")
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Column(name = "role_name")
    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}

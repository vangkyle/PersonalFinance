package edu.matc.personalfinance.entity;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created by kvang on 3/7/17.
 */
@Entity
@Table(name = "user_roles")
public class UserRoles {

    private final Logger logger = Logger.getLogger(this.getClass());
    private int userid;
    private String userName;
    private String roleName;
    private User user;


    @Id
    @GeneratedValue(generator = "newGenerator") // name of the primary key generator
    @GenericGenerator(name = "newGenerator", strategy = "foreign", parameters = {@Parameter(value = "user", name = "property")})
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @GeneratedValue(generator = "newGenerator2") // name of the primary key generator
    @GenericGenerator(name = "newGenerator2", strategy = "foreign", parameters = {@Parameter(value = "user", name = "property")})
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

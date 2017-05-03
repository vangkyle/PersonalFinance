package edu.matc.personalfinance.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by kvang on 2/9/17.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    private int userid;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String userPass;
    private Set<TransactionRecord> records = new HashSet<TransactionRecord>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    public User(String firstName, String lastName, String email, String userName, String userPass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.userPass = userPass;
    }

    public User(String firstName, String lastName, String email, String userName, String userPass, Set<TransactionRecord> records) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.userPass = userPass;
        this.records = records;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "user_id")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "user_pass")
    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    public Set<TransactionRecord> getRecords() {
        return records;
    }

    public void setRecords(Set<TransactionRecord> records) {
        this.records = records;
    }

}

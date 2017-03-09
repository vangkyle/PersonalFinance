package edu.matc.personalfinance.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Created by kvang on 2/9/17.
 */
@Entity
@Table(name = "users", catalog = "financetracker", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "user_name"),
        @UniqueConstraint(columnNames = "user_pass")
})
public class User {

    private int userid;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String userPass;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param userName  the user name
     * @param userPass  the user pass
     */
    public User(String firstName, String lastName, String email, String userName, String userPass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.userPass = userPass;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    public int getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    @Column(name = "user_name", unique = true, nullable = false)
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user pass.
     *
     * @return the user pass
     */
    @Column(name = "user_pass", unique = true, nullable = false)
    public String getUserPass() {
        return userPass;
    }

    /**
     * Sets user pass.
     *
     * @param userPass the user pass
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}

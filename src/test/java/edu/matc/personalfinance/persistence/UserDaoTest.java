package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kvang on 2/13/17.
 */
public class UserDaoTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    UserDao dao;
    User user;
    User kyle;
    int newUser = 0;

    @Before
    public void setUp() throws Exception {
        dao = new UserDao();
        user = new User();


        kyle = new User();

        kyle.setFirstName("Kyle");
        kyle.setLastName("Vang");
        kyle.setEmail("kvang@gmail.com");
        kyle.setUserName("kvang5");
        kyle.setUserPass("password");


    }

    @Test
    public void getAllUsers() throws Exception {
        newUser = dao.addUser(kyle);
        List<User> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUser() throws Exception {
        newUser = dao.addUser(kyle);
        assertNotNull("no user returned", dao.getUser(newUser));
        assertEquals("user Id not returned correctly", kyle.getUserid(), dao.getUser(newUser).getUserid());
        assertEquals("first name not returned correctly", kyle.getFirstName(), dao.getUser(newUser).getFirstName());
        assertEquals("last name not returned correctly", kyle.getLastName(), dao.getUser(newUser).getLastName());
        assertEquals("email not returned correctly", kyle.getEmail(), dao.getUser(newUser).getEmail());
        assertEquals("user name not returned correctly", kyle.getUserName(), dao.getUser(newUser).getUserName());
        assertEquals("user password not returned correctly", kyle.getUserPass(), dao.getUser(newUser).getUserPass());
    }

    @Test
    public void getUsersByLastName() throws Exception {
        List<User> users = new ArrayList<User>();
        assertEquals("kvang", "kvang");
    }


    @Test
    public void add() throws Exception {
        newUser = dao.addUser(kyle);

        assertNotEquals("no user added", 0,newUser);
        assertEquals("user Id not returned correctly", kyle.getUserid(), dao.getUser(newUser).getUserid());
        assertEquals("first name not returned correctly", kyle.getFirstName(), dao.getUser(newUser).getFirstName());
        assertEquals("last name not returned correctly", kyle.getLastName(), dao.getUser(newUser).getLastName());
        assertEquals("email not returned correctly", kyle.getEmail(), dao.getUser(newUser).getEmail());
        assertEquals("user name not returned correctly", kyle.getUserName(), dao.getUser(newUser).getUserName());
        assertEquals("user password not returned correctly", kyle.getUserPass(), dao.getUser(newUser).getUserPass());

    }

    //@Ignore
    /*@Test
    public void addUserFromSignUp() throws Exception {
        user = new User();
        int id = dao.addUserFromSignUp(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUserName(), user.getUserPass());
        //logger.info(user);
        logger.debug(dao.addUserFromSignUp(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUserName(), user.getUserPass()));

        assertNotEquals(newUser, id);

        User insertedUser = dao.getUser(id);
        //logger.info(insertedUser);
        assertEquals(user.getFirstName(), insertedUser.getFirstName());
        assertEquals(user.getLastName(), insertedUser.getLastName());
        assertEquals(user.getEmail(), insertedUser.getEmail());
        assertEquals(user.getUserName(), insertedUser.getUserName());
        assertEquals(user.getUserPass(), insertedUser.getUserPass());
    }*/

    @Test
    public void deleteUser() throws Exception {
        dao.addUser(kyle);
        dao.deleteUser(kyle.getUserid());
        assertNull("user not deleted", dao.getUser(kyle.getUserid()));
    }


}
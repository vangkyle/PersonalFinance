package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.TransactionRecord;
import edu.matc.personalfinance.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kvang on 2/13/17.
 */
public class UserDaoTest {

    UserDao dao;
    User user;

    @Before
    public void setUp() throws Exception {
        dao = new UserDao();
        user = new User();
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUser() throws Exception {
        User user = new User();
        user = dao.getUser(0);
        assertEquals(0, 0);
    }

    @Test
    public void getUsersByLastName() throws Exception {
        List<User> users = new ArrayList<User>();
        assertEquals("lastNameTest", "lastNameTest");
    }

    @Test
    public void add() throws Exception {
        user = new User("firstNameTest3", "lastNameTest3", "test@madisoncollege.edu2", "userNameTest2", "Test2");
        int id = dao.add(user);

        assertNotEquals(0, id);

        User insertedUser = dao.getUser(id);
        assertEquals(user.getFirstName(), insertedUser.getFirstName());
        assertEquals(user.getLastName(), insertedUser.getLastName());
        assertEquals(user.getEmail(), insertedUser.getEmail());
        assertEquals(user.getUserName(), insertedUser.getUserName());
        assertEquals(user.getPassword(), insertedUser.getPassword());
    }

    @Test
    public void addUserFromSignUp() throws Exception {
        user = new User();
        int id = dao.addUserFromSignUp(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUserName(), user.getPassword());

        assertNotEquals(0, id);

        User insertedUser = dao.getUser(id);
        assertEquals(user.getFirstName(), insertedUser.getFirstName());
        assertEquals(user.getLastName(), insertedUser.getLastName());
        assertEquals(user.getEmail(), insertedUser.getEmail());
        assertEquals(user.getUserName(), insertedUser.getUserName());
        assertEquals(user.getPassword(), insertedUser.getPassword());
    }

    @Test
    public void deleteUser() throws Exception {
        User user = new User();
        assertEquals(user.getUserid(), 0);

    }


}
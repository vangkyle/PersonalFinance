package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kvang on 2/13/17.
 */
public class UserDaoTest {

    UserDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new UserDao();
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUser() throws Exception {

    }

    @Test
    public void getUsersByLastName() throws Exception {

    }

    @Test
    public void add() throws Exception {
        User user = new User("firstNameTest3", "lastNameTest3", "test@madisoncollege.edu2", "userNameTest2", "Test2");
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
    public void deleteUserById() throws Exception {
        User user = new User();
        int id = dao.deleteUserById(0);

        //assertNotEquals(0, id);

        /*assertEquals(user.getFirstName(), delectedUser.getFirstName());
        assertEquals(user.getLastName(), delectedUser.getLastName());
        assertEquals(user.getEmail(), delectedUser.getEmail());
        assertEquals(user.getUserName(), delectedUser.getUserName());
        assertEquals(user.getPassword(), delectedUser.getPassword());*/

    }


}
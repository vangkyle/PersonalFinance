package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.UserRoles;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kvang on 3/25/17.
 */
public class UserRolesDaoTest {

    UserRolesDao userRolesDao;
    UserRoles userRoles;

    @Before
    public void setUp() throws Exception {
        userRolesDao = new UserRolesDao();
        userRoles = new UserRoles();
    }

    @Test
    public void getAllUserRoles() throws Exception {
        List<UserRoles> roles = userRolesDao.getAllUserRoles();
        assertTrue(roles.size() > 0);
    }

    @Test
    public void saveUserRole() throws Exception {
        userRoles.setRoleName("Administrator");

    }

}
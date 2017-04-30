package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.UserRoles;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kvang on 3/25/17.
 */
public class UserRolesDaoTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    UserRolesDao URDao;
    UserRoles role;
    int newRole = 0;

    @Before
    public void setUp() throws Exception {
        URDao = new UserRolesDao();
        role = new UserRoles();

        role.setRole_name("Administrator");
        role.setUser_name("kvang5");
    }

    @Test
    public void getAllUserRoles() throws Exception {
        newRole = URDao.addRole(role);
        List<UserRoles> roles = URDao.getAllUserRoles();
        assertTrue("roles not returned", roles.size() > 0);

    }

    @Test
    public void getUserRole() throws Exception {
        newRole = URDao.addRole(role);

        //assertNotNull("no role returned", URDao.getUserRole(newRole));
        assertEquals("role id not returned correctly", role.getRole_id(), URDao.getUserRole(newRole).getRole_id());
        assertEquals("role name not returned correctly", role.getRole_name(), URDao.getUserRole(newRole).getRole_name());
        assertEquals("user name not returned correctly", role.getUser_name(), URDao.getUserRole(newRole).getUser_name());
    }

    @Test
    public void addRole() throws Exception {
        newRole = URDao.addRole(role);

        //assertNotEquals("no role added", 0, newRole);
        assertEquals("role id not returned correctly", role.getRole_id(), URDao.getUserRole(newRole).getRole_id());
        assertEquals("role name not returned correctly", role.getRole_name(), URDao.getUserRole(newRole).getRole_name());
        assertEquals("user name not returned correctly", role.getUser_name(), URDao.getUserRole(newRole).getUser_name());
    }

    @Test
    public void deleteRole() throws Exception {
        URDao.addRole(role);
        URDao.deleteRole(role.getRole_id());
        assertNull("role not deleted", URDao.getUserRole(role.getRole_id()));
    }

    @Test
    public void updateRole() throws Exception {
        newRole = URDao.addRole(role);
        assertEquals("role id not inserted", role.getRole_id(), URDao.getUserRole(newRole).getRole_id());
        assertEquals("username not returned", role.getUser_name(), URDao.getUserRole(newRole).getUser_name());
        assertEquals("user role name not returned", role.getRole_name(), URDao.getUserRole(newRole).getRole_name());

        role.setRole_name("New role name");
        role.setUser_name("newusername");
        URDao.updateRole(role);

        assertEquals("role id not updated", role.getRole_id(), URDao.getUserRole(newRole).getRole_id());
        assertEquals("username not returned", role.getUser_name(), URDao.getUserRole(newRole).getUser_name());
        assertEquals("user role name not updated", role.getRole_name(), URDao.getUserRole(newRole).getRole_name());


    }

    @Test
    public void getRoleByUserName() throws Exception {
        newRole = URDao.addRole(role);
        assertEquals("role not found by username", role.getRole_id(), URDao.getRoleByUserName(role.getUser_name()).getRole_id());
    }


    @After
    public void tearDown() throws Exception {
        if (newRole != 0) {
            URDao.deleteRole(newRole);
        }
    }

}
package edu.matc.persistance;

import edu.matc.entity.CollectorRole;
import edu.matc.entity.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by David on 5/4/17.
 */
public class CollectorRoleDaoTest {
    CollectorRoleDao collectorRoleDao = new CollectorRoleDao();

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void getAllRoles() throws Exception {
        List<CollectorRole> roles = collectorRoleDao.getAllRoles();
        assertTrue(roles.size() > 0);
    }

    @Test
    public void getRole() throws Exception {
        String roleName = collectorRoleDao.getRole("yangdavid1985@gmail.com").getRole_name();
        assertEquals("Wrong role", "registeredCollector", roleName);
    }

    @Test
    public void addCollectorRole() throws Exception {
        CollectorRole newRole = new CollectorRole();
        newRole.setEmail("testRole@test.com");
        newRole.setRole_name("newRole");
        assertEquals("Role mismatch", "newRole", newRole.getRole_name());
    }

}
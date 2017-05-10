package edu.matc.persistance;

import edu.matc.entity.CollectorRole;
import edu.matc.entity.Collectors;
import edu.matc.persistance.CollectorsDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by David on 2/19/17.
 */
public class CollectorDaoTest {

    String testEmail = "yangdavid85@test.com";
    int newEmail = 0;
    CollectorsDao collectorsDao;

    @Before
    public void setup(){
        collectorsDao = new CollectorsDao();
    }

    @After
    public void cleanup(){
        if(newEmail != 0)
            collectorsDao.deleteUser(testEmail);
    }

    @Test
    public void getAllCollectors() throws Exception{
        List<Collectors> collectors = collectorsDao.getAllUsers();
        assertTrue(collectors.size() > 0);
    }

    @Test
    public void addCollector(){
        Collectors addCollector = new Collectors();
        newEmail++;
        addCollector.setEmail("yangdavid85@test.com");
        addCollector.setPassword("boiyaj24");
        collectorsDao.addUser(addCollector);

        assertEquals("Email incorrect", "yangdavid85@test.com", collectorsDao.getUser("yangdavid85@test.com"));
    }

    @Test
    public void checkEmailAvailability(){
        CollectorsDao check = new CollectorsDao();

        boolean testAvailable = check.checkUserAvailability("newGuy@gmail.com");
        boolean testUnavailable = check.checkUserAvailability("lsv@fireball.com");
        assertTrue(testAvailable);
        assertFalse(testUnavailable);
    }
}

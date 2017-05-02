import edu.matc.entity.CollectorRole;
import edu.matc.entity.Collectors;
import edu.matc.persistance.CollectorsDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by David on 2/19/17.
 */
public class CollectorTest {

    CollectorsDao collectorsDao;

    @Before
    public void setup(){
        collectorsDao = new CollectorsDao();
    }

    @Test
    public void getAllCollectors() throws Exception{
        List<Collectors> collectors = collectorsDao.getAllUsers();
        assertTrue(collectors.size() > 0);
    }

    //Test
    public void addCollector(){
        Collectors addCollector = new Collectors();

        addCollector.setEmail("test@gmail.com");
        addCollector.setPassword("boiyaj24");
        collectorsDao.addUser(addCollector);

        assertEquals("Email incorrect", "test@gmail.com", collectorsDao.getUser("test@gmail.com"));
    }

    //Test
    public void checkEmailAvailability(){
        CollectorsDao check = new CollectorsDao();

        boolean testAvailable = check.checkUserAvailability("yangdavid1985@gmail.com");
        boolean testUnavailable = check.checkUserAvailability("test@espngo.com");
        assertTrue(testAvailable);
        assertFalse(testUnavailable);
    }

}

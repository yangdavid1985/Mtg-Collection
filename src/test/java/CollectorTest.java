import edu.matc.entity.Collectors;
import edu.matc.persistance.CollectorsDao;
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

    // add test
    public void addCollector(){
        Collectors addCollector = new Collectors();

        addCollector.setEmail("yangdavid1985@gmail.com");
        addCollector.setPassword("boiyaj24");
        addCollector.setId(1);
        collectorsDao.addUser(addCollector);

        assertNotEquals("Id not available", 0, collectorsDao.getUser(1));
        assertEquals("Email incorrect", "yangdavid1985@gmail.com", collectorsDao.getUser(1).getEmail());
    }

}

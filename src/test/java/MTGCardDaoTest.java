import edu.matc.entity.MTGCards;
import edu.matc.persistance.MTGCardDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by David on 4/5/17.
 */
public class MTGCardDaoTest {
/**
    MTGCardDao dao;
    String email;
    ArrayList<MTGCards> cardsToDelete;

    @Before
    public void setUp() {
        dao = new MTGCardDao();
        email = "yangdavid1985@gmail.com";
        cardsToDelete = new ArrayList<>();
    }

    @After
    public void cleanUp() {
        //erase any changes to database
        for (MTGCards card : cardsToDelete) {
            //remove that card from the database
            dao.removeCard(card.getCard_name(), card.getEmail());
        }
    }

    @Test
    public void getCard() throws Exception {
        String testCardName = "island";
        dao.getCard(testCardName, email);
        cardsToDelete.add(new MTGCards(testCardName, email));
        assertEquals("Wrong card", "island", dao.getCard("island", email).getCard_name());
    }

    @Test
    public void addNewCard() throws Exception {
        String testCardName = "mountain";
        dao.addCard(testCardName, email);
        cardsToDelete.add(new MTGCards(testCardName, email));
        assertEquals("Cards not found","mountain", dao.getCard("mountain", email).getCard_name());
    }

    @Test
    public void addExistingCard() throws Exception {
        String testCardName = "island";
        MTGCards card = dao.getCard(testCardName, email);
        cardsToDelete.add(new MTGCards(testCardName, email));
        int previousQuantity = card.getQuantity();

        int newQuantity = dao.addCard(testCardName, email);

        assertEquals("Quantity not incremented", previousQuantity + 1, newQuantity);
    }

    @Test
    public void removeExistingCard() throws Exception {
        String testCardName = "swamp";
        dao.addCard(testCardName, email);
        int currentQuantity = dao.getCard(testCardName, email).getQuantity();
        dao.removeCard(testCardName, email);
        int newQuantity = dao.getCard(testCardName, email).getQuantity();

        assertEquals("Cards not removed successfully.", currentQuantity, newQuantity + 1);
    }

    @Test
    public void removeNewCard() throws Exception {
        String testCardName = "forest";
        dao.addCard(testCardName, email);
        dao.removeCard(testCardName, email);

        assertNull(dao.getCard(testCardName, email));
    }
    */

}
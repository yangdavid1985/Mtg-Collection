import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import edu.matc.entity.Cards;
import edu.matc.entity.CardsItem;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by David on 3/10/17.
 */
public class MTGServiceTest {
    @Test
    public void testMagicAPI() throws Exception {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://api.magicthegathering.io/v1/cards");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        Cards cards = mapper.readValue(response, Cards.class);

        CardsItem cardsItem = cards.getCards().get(0);
        assertEquals("wrong", "Air Elemental", cardsItem.getName());
        assertEquals("wrong card", 94, cardsItem.getMultiverseid());

    }

    @Test
    public void findCard() throws IOException {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://api.magicthegathering.io/v1/cards?name=tarmogoyf");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        Cards cards = mapper.readValue(response, Cards.class);

        String cardsItem = cards.getCards().get(1).getName();
        int cardCMC = cards.getCards().get(1).getCmc();
        int cardMultiverseId = cards.getCards().get(1).getMultiverseid();
        String setName = cards.getCards().get(1).getSetName();


        assertEquals("incorrect name", "Tarmogoyf", cardsItem);
        assertEquals("incorrect color", 2, cardCMC);
        assertEquals("incorrect multiverseId", 370404, cardMultiverseId);
        assertEquals("incorrect set name ", "Modern Masters", setName);


    }
}

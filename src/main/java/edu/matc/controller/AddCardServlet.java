package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Cards;
import edu.matc.entity.CardsItem;
import edu.matc.persistance.MTGCardDao;
import org.apache.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.TreeSet;


/**
 * Created by David on 3/13/17.
 */
@WebServlet("/addCards")
public class AddCardServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(AddCardServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = null;
        MTGCardDao dao = new MTGCardDao();

        try {
            // get current user logged in
            email = request.getRemoteUser();
        } catch (Exception e) {
            logger.warn("User isn't logged in and tried to add a card.");
            e.printStackTrace();

            //return error to user's browser
            response.setStatus(401);
            response.sendRedirect("/collection.jsp");
        }



        // if email is available, add card if it exists
        TreeSet<String> returnedCards = new TreeSet<>();
        if (!"".equals(email) && email != null) {

            String submittedName =  request.getParameter("card");
            logger.info("Checking if card with name " + submittedName + " exists.");

            try {
                returnedCards = getCard(submittedName);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // if only 1 card was found, add to users collection
            if (returnedCards.size() == 1) {
                //only 1 card was found (implied exact match)
                dao.addCard(returnedCards.first(), email);

                //return success to page
                response.setStatus(200);
                request.setAttribute("success", "Added \"" + submittedName + "\".");
                RequestDispatcher dispatcher = request.getRequestDispatcher("addCards.jsp");
                dispatcher.forward(request, response);
            } else if (returnedCards.size() == 0) {

                // no cards found, set and display error to user
                request.setAttribute("error", "No cards were found that matched \"" + submittedName + "\".");
                RequestDispatcher dispatcher = request.getRequestDispatcher("addCards.jsp");
                dispatcher.forward(request, response);
            } else {
                // found more than 1 card, return list of cards found
                request.setAttribute("error", "More than one card was found that contained \"" + submittedName
                    + "\".");
                request.setAttribute("cardsFound", returnedCards);
                RequestDispatcher dispatcher = request.getRequestDispatcher("addCards.jsp");
                dispatcher.forward(request, response);
            }
        }

    }

    /**
     *
     * @param enteredCard cardname entered by user
     * @return will return either 1 card, or multiple cards if it didn't find an exact match
     * @throws Exception
     */
    public TreeSet<String> getCard(String enteredCard) throws Exception {

        String replacedSpaces = enteredCard.replace(" ", "%20");
        String https_url = "https://api.magicthegathering.io/v1/cards?name=" + replacedSpaces;
        URL url;
        String cards = "";

        enteredCard = enteredCard.toLowerCase();

        try {
            url = new URL(https_url);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String input;

            while ((input = reader.readLine()) != null) {
                cards = cards + input;
            }
            reader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        // Convert returned JSON to POJO
        Cards cardsObject = null;
        ObjectMapper mapper = new ObjectMapper();
        cardsObject = mapper.readValue(cards, Cards.class);

        // get an array of card names from the POJO
        TreeSet<String> cardNames = new TreeSet<String>();


        // loop through the List<CardJson>
        for (CardsItem card : cardsObject.getCards()) {

            logger.info("Card with submitted word found: " + card.getName());

            // check for exact match
            if (enteredCard.equals(card.getName().toLowerCase())) {
                cardNames = new TreeSet<>();

                // check for split/flip/etc card
                String cardLayout = card.getLayout();
                String formattedCardName = "";

                if (cardLayout.equals("split")
                        || cardLayout.equals("flip")
                        || cardLayout.equals("double-faced")
                        || cardLayout.equals("meld")
                        || cardLayout .equals("aftermath")) {
                    // Add split cards together
                    formattedCardName = card.getNames().get(0) + " // " +
                            card.getNames().get(1);
                } else
                    formattedCardName = card.getName();

                cardNames.add(formattedCardName);
                break;
            }

            // display first 5 cards that matched submittedName
            if (cardNames.size() <= 4)
                cardNames.add(card.getName());
        }
        return cardNames;
    }
}
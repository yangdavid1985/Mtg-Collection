package edu.matc.controller;

import edu.matc.persistance.MTGCardDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

/**
 * Created by David on 5/1/17.
 */
@WebServlet("/updateCollection")
public class UpdateCollection extends HttpServlet {

    private final Logger logger = Logger.getLogger(IncreaseCard.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] stringQuantities = request.getParameterValues("cardQuantities[]");
        String[] cardNames = request.getParameterValues("cardNames[]");

        MTGCardDao dao = new MTGCardDao();
        String email = request.getRemoteUser();

        int cardQuantity;
        for (int i = 0; i < cardNames.length; i++) {
            cardQuantity = parseInt(stringQuantities[i]);
            dao.setQuantity(cardNames[i], cardQuantity, email);
        }
    }
}

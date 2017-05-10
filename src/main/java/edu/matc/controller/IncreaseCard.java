package edu.matc.controller;

import edu.matc.persistance.MTGCardDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by David on 5/2/17.
 */
@WebServlet("/incrementCard")
public class IncreaseCard extends HttpServlet {

    private final Logger logger = Logger.getLogger(IncreaseCard.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardName = request.getParameter("cardName");

        logger.info("incrementing " + cardName);

        MTGCardDao dao = new MTGCardDao();

        String email = request.getRemoteUser();

        logger.info("current user is : " + email);

        logger.info("incrementing card");

        dao.addCard(cardName, email);
    }
}

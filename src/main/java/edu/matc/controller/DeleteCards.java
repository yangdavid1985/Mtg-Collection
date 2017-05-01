package edu.matc.controller;

import edu.matc.persistance.MTGCardDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by David on 4/27/17.
 */
@WebServlet("/deleteCards")
public class DeleteCards extends HttpServlet {

    private final Logger logger = Logger.getLogger(DeleteCards.class);


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cardName = request.getParameter("cardName");

        logger.info("removing " + cardName + " from user's collection");

        MTGCardDao dao = new MTGCardDao();

        String email = request.getRemoteUser();
        logger.info("current user is : " + email);

        logger.info("attempting to remove card");
        dao.removeCard(cardName, email);


        request.setAttribute("user", email);
        request.setAttribute("cards", dao.getAllCardsByUsername(email));

        RequestDispatcher dispatcher = request.getRequestDispatcher("collection.jsp");
        dispatcher.forward(request, response);

    }
}

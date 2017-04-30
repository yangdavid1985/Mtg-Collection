package edu.matc.controller;

import edu.matc.entity.MTGCards;
import edu.matc.persistance.MTGCardDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by David on 4/6/17.
 */
@WebServlet("/collection")
public class CollectionServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(CollectionServlet.class);


    // display collections
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        MTGCardDao displayCards = new MTGCardDao();

        String email = request.getRemoteUser();

        logger.info(email);

        request.setAttribute("user", email);
        request.setAttribute("cards", displayCards.getAllCardsByUsername(email));
        RequestDispatcher dispatcher = request.getRequestDispatcher("collection.jsp");
        dispatcher.forward(request, resp);
    }
}

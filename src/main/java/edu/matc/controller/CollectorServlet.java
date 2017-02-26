package edu.matc.controller;

import edu.matc.entity.Collectors;
import edu.matc.persistance.CollectorsDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by David on 2/16/17.
 */
@WebServlet("/collectorServlet")
public class CollectorServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger((Collectors.class));

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");

        CollectorsDao collectorsDao = new CollectorsDao();
        Collectors collectors = new Collectors();

        collectorsDao.addUser(collectors);
        logger.info("Adding user to database");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/signupSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
package edu.matc.controller;

import edu.matc.persistance.MTGCardDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by David on 4/27/17.
 */
@WebServlet
public class DeleteCards extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MTGCardDao dao = new MTGCardDao();

        String email = request.getRemoteUser();

        String deleteCard = "";

        //dao.removeCard(, email);
    }
}

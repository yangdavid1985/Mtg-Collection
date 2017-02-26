package edu.matc.controller;

import edu.matc.entity.Collectors;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by David on 2/23/17.
 */

@WebServlet
public class LoginServlet extends HttpServlet{
    private Logger logger = Logger.getLogger(Collectors.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");



    }
}

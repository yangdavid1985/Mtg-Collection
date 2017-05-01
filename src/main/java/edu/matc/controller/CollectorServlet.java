package edu.matc.controller;

import edu.matc.entity.CollectorRole;
import edu.matc.entity.Collectors;
import edu.matc.persistance.CollectorRoleDao;
import edu.matc.persistance.CollectorsDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by David on 2/16/17.
 */
@WebServlet("/collectorServlet")
public class CollectorServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger((Collectors.class));

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collectors collectors = new Collectors();
        CollectorsDao collectorsDao = new CollectorsDao();
        CollectorRole role = new CollectorRole();
        CollectorRoleDao roleDao = new CollectorRoleDao();

        boolean emailTaken = false;
        boolean passwordMismatch = false;

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");


        // check to see if available
        if(!collectorsDao.checkUserAvailability(email)){
            emailTaken = true;
        }

        // check to see if passwords match
        if(!password.equals(rePassword)){
            passwordMismatch = true;
        }

        // If email and passwords match, insert into collectors and role
        if(emailTaken == false && passwordMismatch == false){

            collectors.setEmail(email);
            collectors.setPassword(password);

            role.setRole_name("registeredCollector");
            role.setEmail(email);

            roleDao.addCollectorRole(role);

            collectorsDao.addUser(collectors);
            logger.info("Adding " + collectors +" to database");


            RequestDispatcher dispatcher = request.getRequestDispatcher("/signupSuccess.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/signup.jsp");
            if (emailTaken) {
                request.setAttribute("emailTaken", "Email is already linked to an account.");
            }
            if (passwordMismatch) {
                request.setAttribute("passwordMismatch", "Passwords must match.");
            }
            dispatcher.forward(request, response);
        }

    }
}

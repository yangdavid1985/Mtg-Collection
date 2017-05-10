package edu.matc.persistance;

import edu.matc.entity.Collectors;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Yang on 2/19/17.
 */
public class CollectorsDao {

    private final Logger logger = Logger.getLogger(CollectorsDao.class);

    /**
     * Return a list of all users
     *
     * @return All users
     */
    public List<Collectors> getAllUsers() {
        List<Collectors> collectors = new ArrayList<Collectors>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            collectors = session.createCriteria(Collectors.class).list();
        } catch (HibernateException exception){
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }

        return collectors;
    }

    /**
     * Checks if email/username is available
     * @param email
     * @return true if available
     */
    public boolean checkUserAvailability(String email){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Collectors collectors = (Collectors) session.get(Collectors.class, email);

            if(collectors == null){
                return true;
            }
            transaction.commit();
        } catch (HibernateException exception) {
            logger.info("Email availability failed");
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }
        return false;
    }

    /**
     * delete a collector by email
     *
     * @param email the collector's email
     */
    public void deleteUser(String email) {
        Collectors collectors;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            collectors = (Collectors) session.get(Collectors.class, email);
            session.delete(collectors);
            logger.info(collectors + "deleted");
            transaction.commit();
        } catch (HibernateException exception) {
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }

    }

    /**
     * adds user to database
     *
     * @param collectors
     */
    public void addUser(Collectors collectors){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(collectors);
            logger.info(collectors + "added");
            transaction.commit();
        } catch (HibernateException exception) {
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }
    }

    public String getUser(String email){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Collectors user = (Collectors) session.get(Collectors.class, email);
            transaction.commit();
        } catch (HibernateException exception) {
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }

        return email;
    }

    /**
     * Saves user to database
     *
     * @param collectors
     */
    public void saveUser(Collectors collectors) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(collectors);
            transaction.commit();
        } catch (HibernateException exception) {
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }
    }
}



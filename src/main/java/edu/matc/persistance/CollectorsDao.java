package edu.matc.persistance;

import edu.matc.entity.Collectors;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

    /**
     * Created by David Yang on 2/19/17.
     */
public class CollectorsDao {

    private final Logger logger = Logger.getLogger(CollectorsDao.class);

    /** Return a list of all users
     *
     * @return All users
     */
    public List<Collectors> getAllUsers() {
        List<Collectors> collectors = new ArrayList<Collectors>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        collectors = session.createCriteria(Collectors.class).list();

        return collectors;
    }

    /**
     *
     * @param email
     * @return
     */

    public boolean checkUserAvailability(String email){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Collectors collectors = (Collectors) session.get(Collectors.class, email);

        if(collectors == null){
            return true;
        } else {
            return false;
        }
    }



    /**
     * retrieve a userId from database by email
     * @return users id
     */
    public Collectors getUserId(String email) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Collectors getId = (Collectors) session.get(Collectors.class, email);

        logger.info("getting user " + getId);
        transaction.commit();

        return getId;
    }

    /**
     * delete a collector by email
     * @param email the collector's email
     */
    public void deleteUser(String email) {
        Collectors collectors;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        collectors = (Collectors) session.get(Collectors.class, email);
        session.delete(collectors);
        logger.info(collectors + "deleted");
        transaction.commit();
        session.close();
    }

    /**
     *
     * @param collectors
     */
    public void addUser(Collectors collectors){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(collectors);
        logger.info(collectors + "added");
        transaction.commit();
        session.close();
    }

    /**
     *
     * @param collectors
     */
    public void saveUser(Collectors collectors) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(collectors);
        transaction.commit();
    }
}



package edu.matc.persistance;

import edu.matc.entity.Collectors;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

    /**
     * Created by David Yang on 2/19/17.
     */
public class CollectorsDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<Collectors> getAllUsers() {
        List<Collectors> users = new ArrayList<Collectors>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(Collectors.class).list();

        return users;
    }

    /**
     * retrieve a user from database by id
     * @return user
     */
    public Collectors getUser(int id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Collectors user = (Collectors) session.get(Collectors.class, id);
        transaction.commit();

        return user;
    }

    /**
     * delete a collector by id
     * @param id the collector's id
     */
    public void deleteUser(int id) {
        Collectors collectors;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        collectors = (Collectors) session.get(Collectors.class, id);
        session.delete(collectors);
        transaction.commit();
        session.close();
    }

    public void addUser(Collectors collectors){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(collectors);
        transaction.commit();
        session.close();
    }

    public void saveUser(Collectors collectors) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(collectors);
        transaction.commit();
    }
}



package edu.matc.persistance;

import edu.matc.entity.CollectorRole;
import edu.matc.entity.Collectors;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 3/6/17.
 */
public class CollectorRoleDao {
    private final Logger logger = Logger.getLogger(CollectorRoleDao.class);

    public List<CollectorRole> getAllRoles() {
        List<CollectorRole> collectorRoles = new ArrayList<CollectorRole>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            collectorRoles = session.createCriteria(CollectorRole.class).list();
        } catch (HibernateException exception) {
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }

        return collectorRoles;
    }

    public CollectorRole getRole(String email){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CollectorRole collectorRole = null;

        try {
            collectorRole = (CollectorRole) session.get(CollectorRole.class, email);
        } catch (HibernateException exception) {
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }
        return  collectorRole;
    }

    public String addCollectorRole(CollectorRole collectorRole) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        String role = "";
        try {
            transaction = session.beginTransaction();
            session.save(collectorRole);
            transaction.commit();
        } catch (HibernateException exception) {
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }

        return role;
    }
}

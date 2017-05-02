package edu.matc.persistance;

import edu.matc.entity.CollectorRole;
import edu.matc.entity.Collectors;
import org.apache.log4j.Logger;
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
        collectorRoles = session.createCriteria(CollectorRole.class).list();

        return collectorRoles;
    }

    public CollectorRole getRole(int id){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CollectorRole collectorRole;
        collectorRole = (CollectorRole) session.get(CollectorRole.class, id);
        session.close();

        return  collectorRole;
    }

    public int addCollectorRole(CollectorRole collectorRole) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = 0;
        session.save(collectorRole);
        transaction.commit();
        session.close();

        return id;
    }
}

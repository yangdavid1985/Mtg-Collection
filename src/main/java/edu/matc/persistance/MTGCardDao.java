package edu.matc.persistance;

import edu.matc.entity.CardId;
import edu.matc.entity.MTGCards;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 4/4/17.
 */
public class MTGCardDao {

    private final Logger logger = Logger.getLogger(MTGCardDao.class);

    /**
     * @param email
     * @return
     */
    public List getAllCardsByUsername(String email){
        List getCollection = new ArrayList<>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            getCollection = session.createCriteria(MTGCards.class).add(Restrictions.eq("email", email)).list();
        } catch (HibernateException exception) {
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }
        return  getCollection;
    }

    // get card owned username
    public MTGCards getCard(String card_name, String email){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        MTGCards mtgCards = null;

        try {
            mtgCards = (MTGCards) session.get(MTGCards.class, new CardId(card_name, email));
        } catch (HibernateException exception) {
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }

        return mtgCards;
    }

    /**
     * @param cardName
     * @param email
     * @return
     */
    // add card to collection
    public int addCard(String cardName, String email) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        MTGCards mtgCards = (MTGCards) session.get(MTGCards.class, new CardId(cardName, email));

        int newQuantity;

        // gets a card, increments quantity
        if (mtgCards != null) {
            logger.info("Incrementing card quantity.");
            mtgCards.incrementQuantity();
            session.update(mtgCards);
            newQuantity = mtgCards.getQuantity();
        } else {
            logger.info("Adding new card record to database.");
            // add new card to the collection
            MTGCards newCard = new MTGCards();
            newCard.setCard_id(new CardId(cardName, email));
            newCard.setQuantity(1);

            try {
                session.save(newCard);
            } catch (Exception e) {
                logger.error("Cards insertion failure.");
                e.printStackTrace();
            }
            newQuantity = 1;
        }

        transaction.commit();
        session.close();

        return newQuantity;
    }

    /**
     * @param cardName
     * @param email
     * @return
     */
    // delete card from collection by email
    public int removeCard(String cardName, String email) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        MTGCards mtgCards = (MTGCards) session.get(MTGCards.class, new CardId(cardName, email));

        int newQuantity;

        int currentQuantity = mtgCards.getQuantity();

        if (currentQuantity <= 1) {
            // delete card from database
            session.delete(mtgCards);
            newQuantity = 0;
        } else {
            // decrease card by 1
            mtgCards.decrementQuantity();
            session.update(mtgCards);
            newQuantity = mtgCards.getQuantity();
        }

        transaction.commit();
        session.close();

        return newQuantity;
    }

    /**
     * @param mtgCards
     * @return
     */
    public int removeCard(MTGCards mtgCards) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int currentQuantity = mtgCards.getQuantity();
        int newQuantity = 0;

        try {
            session.persist(mtgCards);

            if (currentQuantity <= 1) {
                // remove card from database
                session.delete(mtgCards);
            } else {
                // decrease quantity by 1
                mtgCards.decrementQuantity();
                session.update(mtgCards);
                newQuantity = mtgCards.getQuantity();
            }
            transaction.commit();
        } catch (HibernateException exception) {
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }

        return newQuantity;
    }

    /**
     * @param cardName
     * @param quantity
     * @param email
     */
    public void setQuantity(String cardName, int quantity, String email) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            MTGCards card = (MTGCards) session.get(MTGCards.class, new CardId(cardName, email));

            card.setQuantity(quantity);

            session.update(card);
            transaction.commit();
        } catch (HibernateException exception) {
            logger.error(exception.getMessage());
        } finally {
            session.close();
        }

    }

}
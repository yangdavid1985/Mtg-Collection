package edu.matc.entity;

import javax.persistence.*;

/**
 * Created by David on 4/4/17.
 */
@Entity
@Table(name = "collections")
public class MTGCards {

    @EmbeddedId
    private CardId card_id;

    @Column(name = "card_name", insertable = false, updatable = false)
    private String card_name;

    @Column(name = "email", insertable = false, updatable = false)
    private String email;

    @Column(name = "quantity")
    private int quantity;

    public MTGCards() {};

    public MTGCards(String card_name, String email){
        this.card_name =  card_name;
        this.email = email;
        this.card_id = new CardId(card_name, email);
    }

    public CardId getCard_id() {
        return card_id;
    }

    public void setCard_id(CardId card_id) {
        this.card_id = card_id;
        this.card_name = card_id.getCard_name();
        this.email = card_id.getEmail();
    }



    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public void decrementQuantity() {
        this.quantity--;
    }
}

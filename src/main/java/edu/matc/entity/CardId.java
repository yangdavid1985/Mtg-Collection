package edu.matc.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by David on 4/4/17.
 */
@Embeddable
public class CardId implements Serializable {
    private String card_name;
    private String email;


    public CardId(String card_name, String email) {
        this.card_name = card_name;
        this.email = email;
    }

    public CardId() {

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


}

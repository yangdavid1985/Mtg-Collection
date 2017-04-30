package edu.matc.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;


@Generated("com.robohorse.robopojogenerator")
public class Cards {

    @JsonProperty("cards")
    private List<CardsItem> cards;

    public void setCards(List<CardsItem> cards){
        this.cards = cards;
    }

    public List<CardsItem> getCards(){
        return cards;
    }
}
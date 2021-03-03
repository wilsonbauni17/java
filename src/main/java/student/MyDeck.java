/**
 * Classe description
 */

package student;

import ias.Deck;
import ias.GameException;

import java.util.ArrayList;
import java.util.List;

public class MyDeck implements Deck{

    private MyGame game;
    private List<Karte> cards = new ArrayList<>();

    public MyDeck(MyGame game){
        this.game = game;
    }

    @Override
    public void addCard(String cardName) throws GameException {
        boolean cardExist = false;
        for(Karte karte: this.game.getCards()){
            if(karte.getName().equals(cardName)){
                cards.add(karte);
                cardExist = true;
                break;
            }
        }
        if(!cardExist)
            throw new GameException("Card does not exists");
    }

    @Override
    public String[] getAllCards() {
        List<String> allCards = new ArrayList<>();
        for (Karte karte : this.cards){
            allCards.add(karte.getName());
        }
        return allCards.toArray(new String[0]);
    }

    @Override
    public String[] getMatchingCards(String propertyName, int value) throws GameException {
        List<String> matchingCards = new ArrayList<>();
        for (Karte karte : this.cards){
            if(karte.getEigenschaft().getName().equals(propertyName)){
                Eigenschaft property = karte.getEigenschaft();
                if(property.getType().equals("integer") && property.getIntValue() == value){
                    matchingCards.add(karte.getName());
                }
            }
        }
        return matchingCards.toArray(new String[0]);
    }

    @Override
    public String[] getMatchingCards(String propertyName, String value) throws GameException {
        List<String> matchingCards = new ArrayList<>();
        for (Karte karte : this.cards){
            if(karte.getEigenschaft().getName().equals(propertyName)){
                Eigenschaft property = karte.getEigenschaft();
                if(property.getType().equals("string") && property.getStringValue().equals(value)){
                    matchingCards.add(karte.getName());
                }
            }
        }
        return matchingCards.toArray(new String[0]);
    }

    @Override
    public String[] selectBeatingCards(String opponentCard) throws GameException {
        // TODO
        return new String[0];
    }

    public MyGame getGame() {
        return game;
    }

    public void setGame(MyGame game) {
        this.game = game;
    }

    public List<Karte> getCards() {
        return cards;
    }

    public void setCards(List<Karte> cards) {
        this.cards = cards;
    }
}
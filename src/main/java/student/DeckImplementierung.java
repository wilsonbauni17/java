package student;

import ias.Deck;
import ias.GameException;


public class DeckImplementierung implements Deck {
@Override
 public void addCard(String cardName) throws GameException {}

 @Override
 public String[] getAllCards() {
    return new String[] {""};
 }

 @Override
 public String[] getMatchingCards(String propertyName, int value) throws GameException {
    return new String[] {""};
 }

 @Override
public String[] getMatchingCards(String propertyName, String value) throws GameException {
     return new String[0];
 }

@Override
public String[] selectBeatingCards(String opponentCard) throws GameException {
    return new String[0];
}


}

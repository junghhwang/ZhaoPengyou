package jung.h.hwang;

import java.util.ArrayList;

import static jung.h.hwang.Suit.*;

/**Description of the class Deck
 *
 * Deck contains an ArrayList of cards that can be used in a card game. It has a "shuffle" method which shuffles the
 * remaining card in the deck. It can also contain multiple complete decks of trump cards; you may tell the class
 * how many decks it should contain in the parameters of the constructor.
 *
 * Created by Jung.H.Hwang on 10/6/2016.
 */
public class Deck {
    private ArrayList<Card> deck;

    /**
     * @param numDeck accounts for number of
     * @param addBlackJoker
     * @param addBothJokers
     */
    public Deck(int numDeck, boolean addBlackJoker, boolean addBothJokers) {
        deck = new ArrayList<>();
        int deckCtr = 0;
        while (deckCtr < numDeck) {
            for (int i = 1; i <= 13; i++){
                deck.add(new Card(i, CLUBS, true));
                deck.add(new Card(i, SPADES, true));
                deck.add(new Card(i, DIAMONDS, false));
                deck.add(new Card(i, HEARTS, false));
            }
            if (addBothJokers) {
                deck.add(new Card(0, JOKER, true));
                deck.add(new Card(0, JOKER, false));
            }
            else if (addBlackJoker) {
                deck.add(new Card(0, JOKER, true));
            }
            deckCtr++;
        }
    }

    /**
     * @return true if the deck is empty, false otherwise
     */
    public boolean isEmpty() {
        return deck.isEmpty();
    }

    /**
     * @return the size of the remaining deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * @return the card at index 0 and removes that card from the deck. catches IndexOutOfBoundsException
     */
    public Card draw() {
        try {
            return deck.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No more cards left!");
        }
        return null;
    }

    /**
     * @param numCards number of cards that we're trying to draw
     * @return the arraylist of cards that are drawn. If there are not enough cards in the deck, it draws whatever there
     * is to draw
     */
    public ArrayList<Card> drawMultiple(int numCards) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            try {
                cards.add(deck.remove(0));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Not enough cards left. Player drew " + cards.size() + " cards only.");
                break;
            }
        }
        return cards;
    }

    /**
     * Randomly shuffles the deck
     */
    public void shuffle() {
        ArrayList<Card> newDeck = new ArrayList<>();
        for (int i = deck.size(); i > 0; i--) {
            Card selectedCard = deck.remove((int) (i * Math.random()));
            deck.add(selectedCard);
        }
    }
}

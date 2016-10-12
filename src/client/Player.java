package client;

import java.util.ArrayList;

/**
 * Created by Jung.H.Hwang on 10/6/2016.
 */
public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int points;

    /**
     * @param name is the name of the player
     */
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    /**
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * @return the player's hand in forms of ArrayList of Cards
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * @return the number of points the player earned
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param extraPoints is the number of points that is being added to the player
     */
    public void addPoints(int extraPoints) {
        points += extraPoints;
}

    /**
     * @param card is the card that's being added to the player's hand
     */
    public void addToHand(Card card) {
        hand.add(card);
    }

    /**
     * @param cards is the arraylist of cards that's being added to the player's hand
     */
    public void addMultipleToHand(ArrayList<Card> cards) {
        hand.addAll(cards);
    }

    /**
     * @param value is the input value of int. Must be in between 0 and 13 (otherwise it will return 0 all the time)
     * @return the number of cards in the player's hand that matches the input value
     */
    public int numCardsWithGivenValue(int value) {
        int ctr = 0;
        for (Card card : hand) {
            if (card.getValue() == value) {
                ctr++;
            }
        }
        return ctr;
    }

    /**
     * @param value is the input value of int. All cards with the value in the player's hand will be discarded
     * @return the ArrayList of cards that was discarded from the player's hand
     */
    public ArrayList<Card> discardCardsWithGivenValue(int value) {
        ArrayList<Card> cardsWithGivenValue = new ArrayList<>();
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getValue() == value) {
                cardsWithGivenValue.add(hand.remove(i));
                i--;
            }
        }
        return cardsWithGivenValue;
    }
}
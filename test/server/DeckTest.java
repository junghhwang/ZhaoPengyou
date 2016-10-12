package server;

import lib.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by solmoms on 10/11/2016.
 */
public class DeckTest {

    Deck deck;

    @Before
    public void setDeck() throws Exception {
        deck = new Deck(1, false, false); //should contain 52 cards precisely
    }

    @Test
    public void draw() throws Exception {
        deck.draw();
        assertEquals(deck.size(), 51);
    }

    @Test
    public void drawEmptyDeck() throws Exception {
        deck.drawMultiple(52);
        Card card = deck.draw(); // this should print out the error message
        assertEquals(card, null);
    }

    @Test
    public void drawMultiple() throws Exception {
        deck.drawMultiple(5);
        assertEquals(deck.size(), 47);
    }

    @Test
    public void drawMoreThanDeck() throws Exception {
        ArrayList<Card> drawAll = deck.drawMultiple(56); // this should print out the error message
        assertEquals(drawAll.size(), 52);
    }

    @Test
    public void shuffle() throws Exception {
        deck.shuffle();
        assertEquals(deck.size(), 52);
    }

    @Test
    public void multipleDecks() throws Exception {
        deck = new Deck(3, true, true); //both jokers are there
        assertEquals(deck.size(), 54 * 3);
    }

    @Test
    public void deckWithOneJoker() throws Exception {
        deck = new Deck(2, true, false);
        assertEquals(deck.size(), 53 * 2);
    }
}
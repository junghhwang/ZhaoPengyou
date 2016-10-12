package client;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by solmoms on 10/7/2016.
 */
public class PlayerTest {

    Player player;
    Deck deck;

    @Before
    public void setPlayer() {
        player = new Player("Player1");
        deck = new Deck(1, false, false); //this deck will be in order
        player.addMultipleToHand(deck.drawMultiple(5)); // player's hand will have all ACEs and 2 of CLUBS
    }

    @Test
    public void getName() throws Exception {
        assertEquals(player.getName(), "Player1");
    }

    @Test
    public void getHand() throws Exception {
        assertEquals(player.getHand().size(), 5);
    }

    @Test
    public void getPoints() throws Exception {
        assertEquals(player.getPoints(), 0);
    }

    @Test
    public void addPoints() throws Exception {
        player.addPoints(12);
        player.addPoints(-2);
        assertEquals(player.getPoints(), 10);
    }

    @Test
    public void addToHand() throws Exception {
        player.addToHand(deck.draw());
        assertEquals(player.getHand().size(), 6);
    }

    @Test
    public void addMultipleToHand() throws Exception {
        player.addMultipleToHand(deck.drawMultiple(10));
        assertEquals(player.getHand().size(), 15);
    }

    @Test
    public void numCardsWithGivenValue() throws Exception {
        assertEquals(player.numCardsWithGivenValue(1), 4);
    }

    @Test
    public void discardCardsWithGivenValue() throws Exception {
        player.discardCardsWithGivenValue(1);
        assertEquals(player.getHand().size(), 1);
    }

    @Test
    public void equalsTrue() throws Exception {
        Player other = player;
        assertEquals(player, other);
    }

    @Test
    public void equalsFalse() throws Exception {
        Player other = new Player("Player2");
        assertFalse(other.equals(player));
    }
}
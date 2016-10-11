package jung.h.hwang;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by solmoms on 10/7/2016.
 */
public class CardTest {
    Card card;

    @Before
    public void setUpCard() throws Exception {
        card = new Card(7, Suit.SPADES, true);
    }

    @Test
    public void getClassOfCard() throws Exception {
        assertEquals(card.getClassOfCard(), "SEVEN");
    }

    @Test
    public void getValue() throws Exception {
        assertEquals(card.getValue(), 7);
    }


    @Test
    public void getSuit() throws Exception {
        assertEquals(card.getSuit(), Suit.SPADES);
    }

    @Test
    public void isTheCardBlack() throws Exception {
        assert(card.isTheCardBlack());
    }

    @Test
    public void equalsReturnTrue() throws Exception {
        Card other = new Card(7, Suit.SPADES, false); //Although they have different colors, the method should return true
        assertEquals(card, other);
    }

    @Test
    public void getCorresPondingClassJoker() throws Exception {
        assertEquals(Card.getCorrespondingClass(0), "JOKER");
    }

    @Test
    public void getCorresPondingClassAce() throws Exception {
        assertEquals(Card.getCorrespondingClass(1), "ACE");
    }

    @Test
    public void getCorresPondingClassNumber() throws Exception {
        assertEquals(Card.getCorrespondingClass(7), "SEVEN");
    }

    @Test
    public void getCorresPondingClassQueen() throws Exception {
        assertEquals(Card.getCorrespondingClass(12), "QUEEN");
    }

    @Test
    public void equalsReturnFalse() throws Exception {
        Card other = new Card(7, Suit.HEARTS, true);
        assertFalse(card.equals(other));
    }
}
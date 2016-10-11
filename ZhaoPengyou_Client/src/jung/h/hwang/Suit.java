package jung.h.hwang;

/**
 * Created by solmoms on 10/6/2016.
 */
public enum Suit {
    CLUBS, HEARTS, DIAMONDS, SPADES, JOKER;

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
package lib;

/**Description of the class Card
 * Card is an object that contains the information of a trump card.
 */
public class Card {
    private int value; //Ace is 1 Jack is 11, Queen is 12, King is 13, and Joker is 0
    private Suit suit;
    private boolean isBlack;
    private static final String[] correspondingClasses = {/*0*/ "JOKER", /*1*/ "ACE", "TWO", "THREE", "FOUR", "FIVE",
                                 "SIX", "SEVEN", "EIGHT", "NINE", "TEN", /*11*/ "JACK", /*12*/ "QUEEN", /*13*/ "KING"};

    /**
     * @param value is the value of the card. Joker has a value of 0
     * @param suit is the suit of the class. Joker has a suit of Suit.JOKER
     * @param isBlack denotes if the card is black. only SPADES and CLUBS should be black
     */
    public Card(int value, Suit suit, boolean isBlack) {
        assert(value >= 0 && value <= 13);
        this.value = value;
        this.suit = suit;
        this.isBlack = isBlack;
    }

    /**
     * @return the class of card, according to the value of the card
     */
    public String getClassOfCard() {
        return correspondingClasses[value];
    }

    /**
     * @return the integer value of the card. Again, JOKER has a value of 0
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the suit of the card. Joker has a suit of Suit.JOKER
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return the boolean flag that tells us if the card is black
     */
    public boolean isTheCardBlack() {
        return isBlack;
    }

    /**
     * @param value is the value that we're trying to convert into a class of Card
     * @return a String representation of the card value, if exists
     */
    public static String getCorrespondingClass(int value) {
        try {
            return correspondingClasses[value];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No such value exists in trump card!");
            return null;
        }
    }

    /**
     * @param obj object that is being compared to
     * @return true if the value and the suit are equal (color doesn't matter)
     */
    @Override
    public boolean equals (Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
        return ((other.value == this.value) && other.suit.equals(this.suit));
    }
}

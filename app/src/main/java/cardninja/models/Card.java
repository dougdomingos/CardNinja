package cardninja.models;

/**
 * Implementation of a Card
 * <p>
 * A card has a power level and an element. The power level of a card determines
 * the amount of points the player gets when winning an round with that card.
 * The element of a card determines which elements the card wins and loses
 * against and has precedence over the power level.
 */
public class Card implements Comparable<Card> {

    /**
     * The power level of the card. May assume the following values:
     * {@code 2}, {@code 5}, {@code 7}
     */
    private byte power;

    /**
     * The element of the card. May assume the following values:
     * {@code fire}, {@code water}, {@code nature}, {@code metal}, {@code earth}
     */
    private String element;

    /**
     * Creates a new card.
     * 
     * @param power   The power level of the card
     * @param element The element of the card
     */
    public Card(int power, String element) {
        setPower(power);
        setElement(element);
    }

    /**
     * Returns the power level of the card.
     * 
     * @return the power of the card
     */
    public byte getPower() {
        return this.power;
    }

    /**
     * Returns the element of the card.
     * 
     * @return the element of the card
     */
    public String getElement() {
        return this.element;
    }

    /**
     * Sets the power level of the card to a specific value. The value must be
     * either 2, 5, or 7
     * 
     * @param power The power level of the card.
     * @throws IllegalArgumentException Thrown if the passed power level value is
     *                                  invalid
     */
    private void setPower(int power) throws IllegalArgumentException {
        if (!(power == 2 || power == 5 || power == 7)) {
            throw new IllegalArgumentException("Invalid power level was passed!");
        }

        this.power = (byte) power;
    }

    /**
     * Sets the element of the card to a specific value. The value must be
     * one of the following: fire, water, nature, metal or earth
     * 
     * @param element The element of the card
     * @throws IllegalArgumentException Thrown if the passed element value is
     *                                  invalid
     */
    private void setElement(String element) throws IllegalArgumentException {
        if (element == null || !element.matches("^(fire|water|nature|metal|earth)$")) {
            throw new IllegalArgumentException("Unknown element was passed!");
        }

        this.element = element;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + power;
        result = prime * result + ((element == null) ? 0 : element.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card))
            return false;

        Card otherCard = (Card) obj;

        if (this.power != otherCard.power)
            return false;

        else if (otherCard.element == null || !this.element.equals(otherCard.element))
            return false;

        return true;
    }

    @Override
    public int compareTo(Card card) {
        return this.power - card.power;
    }

    @Override
    public String toString() {
        return this.element.toUpperCase() + " - " + this.power;
    }
}

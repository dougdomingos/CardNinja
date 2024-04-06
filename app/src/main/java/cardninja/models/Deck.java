package cardninja.models;

/**
 * Implementation of a deck.
 * <p>
 * The deck contains 14 cards, and works as a circular array. The first 5 cards
 * are the player's hand, from which the player can choose one card to play
 * per round.
 * <p>
 * After a card is played, the deck "bubbles" that card to the end of the array.
 * The number of cards in the deck and the number of rounds per match ensures
 * that the player won't be able to play the same card twice in the same match.
 * 
 * @author dougdomingos
 */
public class Deck {

    /**
     * The array of cards that represents the deck.
     */
    private Card[] cards;

    /**
     * Creates a new deck.
     * 
     * @param deck The cards of the new deck
     */
    public Deck(Card[] cards) {
        setCards(cards);
    }

    /**
     * Handles the action of playing a card from the player's hand. Played cards
     * are moved to the end of the deck.
     * 
     * @param index The index of the card that will be played
     * @return The card object at the given index
     * @throws IndexOutOfBoundsException Thrown if the provided index is out of
     *                                   the hand bounds
     */
    public Card playCard(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > 4)
            throw new IndexOutOfBoundsException("Provided index is out of the hand bounds!");

        Card playedCard = this.cards[index];
        bubbleCard(index);

        return playedCard;
    }

    /**
     * Replace a card from the player's hand.
     * 
     * @param index   The index of the card to be replaced
     * @param newCard The new card to be inserted
     * @throws IndexOutOfBoundsException Thrown if the provided index is out of
     *                                   of the deck bounds
     */
    public void replaceCardFromHand(int index, Card newCard) throws IndexOutOfBoundsException {
        if (index < 0 || index > 4)
            throw new IndexOutOfBoundsException("Provided index is out of the hand bounds!");

        this.cards[index] = newCard;
    }

    /**
     * Returns the current deck.
     * 
     * @return The current deck
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Moves the card at the provided index to the end of the deck, shifting all
     * the cards at its right to the left.
     * 
     * @param index The index of the played card
     */
    private void bubbleCard(int index) {
        for (int i = index; i < cards.length - 1; i++) {
            swap(i, i + 1);
        }
    }

    /**
     * Swaps the positions of two cards in the deck.
     * 
     * @param i The index of the 1st card
     * @param j The index of the 2nd card
     */
    private void swap(int i, int j) {
        Card tmpCard = cards[i];
        cards[i] = cards[j];
        cards[j] = tmpCard;
    }

    /**
     * Set the card array to a new set of cards. The array must have 14 cards.
     * 
     * @param newCards The new set of cards of the deck.
     * @throws IllegalArgumentException Thrown if the provided card array has an
     *                                  invalid size
     */
    private void setCards(Card[] newCards) throws IllegalArgumentException {
        if (newCards == null || newCards.length != 14)
            throw new IllegalArgumentException("Provided card list is invalid!");

        this.cards = newCards;
    }
}

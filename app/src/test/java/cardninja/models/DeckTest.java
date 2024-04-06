package cardninja.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for Deck implementation
 */
public class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        this.deck = new Deck(Arrays.copyOf(gerenateCards(), 14));
    }

    /**
     * Test if decks failed to be created with an invalid number of cards.
     */
    @Test
    void testCreateDeck() {
        assertThrows(IllegalArgumentException.class, () -> new Deck(null));
        assertThrows(IllegalArgumentException.class, () -> new Deck(new Card[] {}));
        assertThrows(IllegalArgumentException.class, () -> new Deck(gerenateCards()));
    }

    /**
     * Test if the playCard functionality works as expected.
     */
    @Test
    void testPlayCard() {
        int deckLength = deck.getCards().length;

        Card playedCard = deck.playCard(0);
        assertInstanceOf(Card.class, playedCard);
        assertEquals(playedCard, deck.getCards()[deckLength - 1]);
    }

    /**
     * Test if the deck fails to play a card out of the player's hand.
     */
    @Test
    void testPlayCardInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> deck.playCard(-1));

        assertThrows(IndexOutOfBoundsException.class,
                () -> deck.playCard(5));

        assertThrows(IndexOutOfBoundsException.class,
                () -> deck.playCard(100));
    }

    /**
     * Test if the deck allows a card to be replaced from the player's hand.
     */
    @Test
    void testReplaceCardFromHand() {
        Card newCard = new Card(7, "earth");
        deck.replaceCardFromHand(0, newCard);
        assertEquals(deck.getCards()[0], newCard);
    }

    /**
     * Test if the deck fails to replace a card out of the player's hand.
     */
    @Test
    void testReplaceCardFromHandInvalidIndex() {
        Card newCard = new Card(7, "earth");

        assertThrows(IndexOutOfBoundsException.class,
                () -> deck.replaceCardFromHand(-1, newCard));

        assertThrows(IndexOutOfBoundsException.class,
                () -> deck.replaceCardFromHand(5, newCard));

        assertThrows(IndexOutOfBoundsException.class,
                () -> deck.replaceCardFromHand(100, newCard));
    }

    /**
     * Utility function to generate all the cards of the game (total of 18).
     * 
     * @return An array of template cards
     */
    private Card[] gerenateCards() {
        int[] powers = new int[] { 2, 5, 7 };
        String[] elements = new String[] { "fire", "water", "nature", "wind", "earth", "lightning" };
        Card[] cards = new Card[powers.length * elements.length];

        int index = 0;
        for (int i = 0; i < powers.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                cards[index++] = new Card(powers[i], elements[j]);
            }
        }
        
        return cards;
    }
}

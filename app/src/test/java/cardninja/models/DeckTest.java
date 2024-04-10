package cardninja.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cardninja.utils.Utils;

/**
 * Test class for Deck implementation
 */
public class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        this.deck = new Deck(Arrays.copyOf(Utils.generateCards(), 14));
    }

    /**
     * Test if decks failed to be created with an invalid number of cards.
     */
    @Test
    void testCreateDeck() {
        assertThrows(IllegalArgumentException.class,
                () -> new Deck(null));
        assertThrows(IllegalArgumentException.class,
                () -> new Deck(new Card[] {}));
        assertThrows(IllegalArgumentException.class,
                () -> new Deck(Utils.generateCards()));
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
        Card newCard = new Card(7, Element.EARTH);
        deck.replaceCardFromHand(0, newCard);
        assertEquals(deck.getCards()[0], newCard);
    }

    /**
     * Test if the deck fails to replace a card out of the player's hand.
     */
    @Test
    void testReplaceCardFromHandInvalidIndex() {
        Card newCard = new Card(7, Element.EARTH);

        assertThrows(IndexOutOfBoundsException.class,
                () -> deck.replaceCardFromHand(-1, newCard));

        assertThrows(IndexOutOfBoundsException.class,
                () -> deck.replaceCardFromHand(5, newCard));

        assertThrows(IndexOutOfBoundsException.class,
                () -> deck.replaceCardFromHand(100, newCard));
    }
}

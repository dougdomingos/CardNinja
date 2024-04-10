package cardninja.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for Card implementation
 */
public class CardTest {

    private Card card1;
    private Card card2;
    private Card card3;

    @BeforeEach
    void setup() {
        this.card1 = new Card(5, Element.NATURE);
        this.card2 = new Card(2, Element.WATER);
        this.card3 = new Card(5, Element.EARTH);
    }

    /**
     * Test if cards are created successfully
     */
    @Test
    void testCreateCard() {
        assertDoesNotThrow(() -> new Card(2, Element.FIRE));
        assertDoesNotThrow(() -> new Card(5, Element.WATER));
        assertDoesNotThrow(() -> new Card(7, Element.NATURE));
        assertDoesNotThrow(() -> new Card(2, Element.WIND));
        assertDoesNotThrow(() -> new Card(5, Element.EARTH));
        assertDoesNotThrow(() -> new Card(7, Element.LIGHTNING));
    }

    /**
     * Test if cards fails to be created with invalid power levels
     */
    @Test
    void testCreateCardInvalidPower() {
        assertDoesNotThrow(() -> new Card(2, Element.WIND));
        assertThrows(IllegalArgumentException.class, () -> new Card(10, Element.FIRE));
    }

    /**
     * Test if cards fails to be created with invalid elements
     */
    @Test
    void testCreateCardInvalidElement() {
        assertThrows(IllegalArgumentException.class, () -> new Card(2, null));
    }

    /**
     * Test if cards with the same power level and element are considered equal
     */
    @Test
    void testEquals() {
        assertTrue(card1.equals(card1));
        assertFalse(card1.equals(card2));
        assertFalse(card1.equals(card3));
        assertFalse(card1.equals(new Card(7, Element.NATURE)));
    }

    /**
     * Test if cards are correctly comparated by their power levels
     */
    @Test
    void testCompareTo() {
        assertEquals(3, card1.compareTo(card2));
        assertEquals(-3, card2.compareTo(card1));
        assertEquals(0, card1.compareTo(card3));
    }

    /**
     * Test if a card is correctly displayed
     */
    @Test
    void testToString() {
        assertEquals("NATURE - 5", card1.toString());
    }
}

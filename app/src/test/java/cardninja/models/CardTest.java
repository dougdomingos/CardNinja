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
        this.card1 = new Card(5, "nature");
        this.card2 = new Card(2, "water");
        this.card3 = new Card(5, "earth");
    }

    /**
     * Test if cards are created successfully
     */
    @Test
    void testCreateCard() {
        assertDoesNotThrow(() -> new Card(2, "fire"));
        assertDoesNotThrow(() -> new Card(5, "water"));
        assertDoesNotThrow(() -> new Card(7, "nature"));
        assertDoesNotThrow(() -> new Card(2, "wind"));
        assertDoesNotThrow(() -> new Card(5, "earth"));
        assertDoesNotThrow(() -> new Card(7, "lightning"));
    }

    /**
     * Test if cards fails to be created with invalid power levels
     */
    @Test
    void testCreateCardInvalidPower() {
        assertDoesNotThrow(() -> new Card(2, "wind"));
        assertThrows(IllegalArgumentException.class, () -> new Card(10, "fire"));
    }

    /**
     * Test if cards fails to be created with invalid elements
     */
    @Test
    void testCreateCardInvalidElement() {
        assertThrows(IllegalArgumentException.class, () -> new Card(2, "abc"));
        assertThrows(IllegalArgumentException.class, () -> new Card(2, ""));
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
        assertFalse(card1.equals(new Card(7, "nature")));
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

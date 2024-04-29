package cardninja.states;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cardninja.models.Card;
import cardninja.models.Deck;
import cardninja.utils.Utils;

/**
 * Test class for BattleState implementation.
 */
public class BattleStateTest {

    /**
     * An array of cards for building decks.
     */
    private Card[] cards;

    @BeforeEach
    void setup() {
        this.cards = Arrays.copyOf(Utils.generateCards(), 14);
    }

    /**
     * Test if the BattleState is created successfully.
     */
    @Test
    void createBattleStateTest() {
        BattleState test = new BattleState(1, 0, new Deck(cards), 0, new Deck(cards));

        assertEquals(1, test.getRound());
        assertEquals(0, test.getPlayerScore());
        assertInstanceOf(Deck.class, test.getPlayerDeck());
        assertEquals(0, test.getBotScore());
        assertInstanceOf(Deck.class, test.getBotDeck());
    }

    /**
     * Test if creating a BattleState with invalid values throws an exception.
     */
    @Test
    void createBattleStateTestInvalid() {
        // Invalid round values
        assertThrows(IllegalArgumentException.class,
                () -> new BattleState(0, 0, new Deck(cards), 0, new Deck(cards)));
        assertThrows(IllegalArgumentException.class,
                () -> new BattleState(-1, 0, new Deck(cards), 0, new Deck(cards)));
        assertThrows(IllegalArgumentException.class,
                () -> new BattleState(11, 0, new Deck(cards), 0, new Deck(cards)));

        // Invalid scores
        assertThrows(IllegalArgumentException.class,
                () -> new BattleState(1, -1, new Deck(cards), 0, new Deck(cards)));
        assertThrows(IllegalArgumentException.class,
                () -> new BattleState(1, 0, new Deck(cards), -1, new Deck(cards)));

        // Null decks
        assertThrows(IllegalArgumentException.class,
                () -> new BattleState(1, 0, null, 0, new Deck(cards)));
        assertThrows(IllegalArgumentException.class,
                () -> new BattleState(1, 0, new Deck(cards), 0, null));
    }
}

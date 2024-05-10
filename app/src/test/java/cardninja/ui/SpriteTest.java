package cardninja.ui;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Test class for Sprite implementation.
 */
public class SpriteTest {

    /**
     * Assert that all card sprites are loaded correctly.
     */
    @Test
    void testLoadCardSprites() {
        assertDoesNotThrow(() -> new Sprite("cards/fire"));
        assertDoesNotThrow(() -> new Sprite("cards/nature"));
        assertDoesNotThrow(() -> new Sprite("cards/wind"));
        assertDoesNotThrow(() -> new Sprite("cards/lightning"));
        assertDoesNotThrow(() -> new Sprite("cards/earth"));
        assertDoesNotThrow(() -> new Sprite("cards/water"));
    }

    /**
     * Assert that all enemy sprites are loaded correctly.
     */
    @Test
    void testLoadEnemySprites() {
        assertDoesNotThrow(() -> new Sprite("enemies/ninja"));
        assertDoesNotThrow(() -> new Sprite("enemies/ronin"));
        assertDoesNotThrow(() -> new Sprite("enemies/monk"));
        assertDoesNotThrow(() -> new Sprite("enemies/samurai"));
        assertDoesNotThrow(() -> new Sprite("enemies/dragon"));
    }

    /**
     * Assert that all screen sprites are loaded correctly.
     */
    @Test
    void testLoadScreenSprites() {
        assertDoesNotThrow(() -> new Sprite("views/start"));
        assertDoesNotThrow(() -> new Sprite("views/ranking"));
        assertDoesNotThrow(() -> new Sprite("views/credits"));
        assertDoesNotThrow(() -> new Sprite("views/new_campaign"));
        assertDoesNotThrow(() -> new Sprite("views/battle"));
        assertDoesNotThrow(() -> new Sprite("views/comparing"));
        assertDoesNotThrow(() -> new Sprite("views/round_win"));
        assertDoesNotThrow(() -> new Sprite("views/round_lose"));
        assertDoesNotThrow(() -> new Sprite("views/round_draw"));
        assertDoesNotThrow(() -> new Sprite("views/match_win"));
        assertDoesNotThrow(() -> new Sprite("views/match_draw"));
        assertDoesNotThrow(() -> new Sprite("views/match_lose"));
        assertDoesNotThrow(() -> new Sprite("views/game_clear"));
        assertDoesNotThrow(() -> new Sprite("views/game_over"));
    }

    /**
     * Assert that an character of the sprite can be replaced.
     */
    @Test
    void testReplaceCharAt() {
        Sprite testSprite = new Sprite("cards/fire");
        assertNotEquals('$', testSprite.getSprite()[0][0]);

        testSprite.replaceCharAt(0, 0, '$');
        assertEquals('$', testSprite.getSprite()[0][0]);
    }

    /**
     * Assert that replacing a character at an invalid coordinate throws an
     * exception.
     */
    @Test
    void testReplaceCharAtInvalidCoordinates() {
        Sprite testSprite = new Sprite("cards/fire");

        assertThrows(IndexOutOfBoundsException.class, () -> testSprite.replaceCharAt(-1, 0, '$'));
        assertThrows(IndexOutOfBoundsException.class, () -> testSprite.replaceCharAt(999, 0, '$'));
        assertThrows(IndexOutOfBoundsException.class, () -> testSprite.replaceCharAt(0, -1, '$'));
        assertThrows(IndexOutOfBoundsException.class, () -> testSprite.replaceCharAt(0, 999, '$'));
        assertThrows(IndexOutOfBoundsException.class, () -> testSprite.replaceCharAt(-1, -1, '$'));
        assertThrows(IndexOutOfBoundsException.class, () -> testSprite.replaceCharAt(999, 999, '$'));
    }

    /**
     * Assert that passing a filepath with ".txt" suffix throws an exception.
     */
    @Test
    void testLoadInvalidFilePath() {
        assertThrows(IllegalArgumentException.class, () -> new Sprite("cards/test.txt"));
    }

    /**
     * Assert that passing a non-existent filepath throws an exception.
     */
    @Test
    void testLoadNonExistentFile() {
        assertThrows(NullPointerException.class, () -> new Sprite("cards/test"));
    }
}

package cardninja.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for ScreenManager implementation
 */
public class ScreenManagerTest {

    private ScreenManager screenManager;

    @BeforeEach
    void setUp() {
        this.screenManager = new ScreenManager();
    }

    /**
     * Asserts that the game starts at the START view.
     */
    @Test
    void testInitAtStartView() {
        assertEquals(View.START, screenManager.getCurrentView());
    }

    /**
     * Asserts that the current view does not change when no match is found for the
     * given input.
     */
    @Test
    void testNoMatchToInput() {
        screenManager.goToNextView("abc");
        assertEquals(View.START, screenManager.getCurrentView());
    }

}

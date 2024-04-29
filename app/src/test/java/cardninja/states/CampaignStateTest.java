package cardninja.states;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Test class for CampaignState implementation.
 */
public class CampaignStateTest {

    /**
     * Test if the CampaignState is created successfully.
     */
    @Test
    void createCampaignStateTest() {
        CampaignState test = new CampaignState("Test", 0, 0, 1);

        assertEquals("Test", test.getName());
        assertEquals(0, test.getTotalScore());
        assertEquals(0, test.getLifePoints());
        assertEquals(1, test.getCampaignLevel());
    }

    /**
     * Test if creating a CampaignState with invalid values throws an exception.
     */
    @Test
    void createCampaignStateTestInvalid() {
        // Invalid names
        assertThrows(IllegalArgumentException.class,
                () -> new CampaignState("", 0, 0, 1));
        assertThrows(IllegalArgumentException.class,
                () -> new CampaignState(null, 0, 0, 1));
        assertThrows(IllegalArgumentException.class,
                () -> new CampaignState("   ", 0, 0, 1));

        // Invalid score
        assertThrows(IllegalArgumentException.class,
                () -> new CampaignState("Test", -1, 0, 1));

        // Invalid life points
        assertThrows(IllegalArgumentException.class,
                () -> new CampaignState("Test", 0, -1, 1));

        // Invalid campaign levels
        assertThrows(IllegalArgumentException.class,
                () -> new CampaignState("Test", 0, 0, -1));
        assertThrows(IllegalArgumentException.class,
                () -> new CampaignState("Test", 0, 0, 10));
    }
}

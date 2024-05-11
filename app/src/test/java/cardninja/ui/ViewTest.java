package cardninja.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test class for View implementation
 */
public class ViewTest {

    /**
     * Test if the transition key of the START view works as expected
     */
    @Test
    void testInputMatchesKeyStart() {
        assertTrue(View.START.inputMatchesKey("v"));
        assertTrue(View.START.inputMatchesKey("V"));
        assertTrue(View.START.inputMatchesKey("start"));
        assertTrue(View.START.inputMatchesKey("START"));
        assertFalse(View.START.inputMatchesKey("vSTART"));
        assertFalse(View.START.inputMatchesKey("STARTv"));
        assertFalse(View.START.inputMatchesKey("abc"));
        assertFalse(View.START.inputMatchesKey("123"));
        assertFalse(View.START.inputMatchesKey(""));
        assertFalse(View.START.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the CREDITS view works as expected
     */
    @Test
    void testInputMatchesKeyCredits() {
        assertTrue(View.CREDITS.inputMatchesKey("c"));
        assertTrue(View.CREDITS.inputMatchesKey("C"));
        assertFalse(View.CREDITS.inputMatchesKey("cabc"));
        assertFalse(View.CREDITS.inputMatchesKey("abcv"));
        assertFalse(View.CREDITS.inputMatchesKey("123"));
        assertFalse(View.CREDITS.inputMatchesKey(""));
        assertFalse(View.CREDITS.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the RANKING view works as expected
     */
    @Test
    void testInputMatchesKeyRanking() {
        assertTrue(View.RANKING.inputMatchesKey("r"));
        assertTrue(View.RANKING.inputMatchesKey("R"));
        assertFalse(View.RANKING.inputMatchesKey("rabc"));
        assertFalse(View.RANKING.inputMatchesKey("abcr"));
        assertFalse(View.RANKING.inputMatchesKey("123"));
        assertFalse(View.RANKING.inputMatchesKey(""));
        assertFalse(View.RANKING.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the NEW_CAMPAIGN view works as expected
     */
    @Test
    void testInputMatchesKeyNewCampaign() {
        assertTrue(View.NEW_CAMPAIGN.inputMatchesKey("i"));
        assertTrue(View.NEW_CAMPAIGN.inputMatchesKey("I"));
        assertFalse(View.NEW_CAMPAIGN.inputMatchesKey("iabc"));
        assertFalse(View.NEW_CAMPAIGN.inputMatchesKey("abci"));
        assertFalse(View.NEW_CAMPAIGN.inputMatchesKey("123"));
        assertFalse(View.NEW_CAMPAIGN.inputMatchesKey(""));
        assertFalse(View.NEW_CAMPAIGN.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the BATTLE view works as expected
     */
    @Test
    void testInputMatchesKeyBattle() {
        assertTrue(View.BATTLE.inputMatchesKey("battle_start"));
        assertTrue(View.BATTLE.inputMatchesKey("BATTLE_START"));
        assertTrue(View.BATTLE.inputMatchesKey("6"));
        assertTrue(View.BATTLE.inputMatchesKey("7"));
        assertTrue(View.BATTLE.inputMatchesKey("8"));
        assertTrue(View.BATTLE.inputMatchesKey("t"));
        assertTrue(View.BATTLE.inputMatchesKey("T"));
        assertFalse(View.BATTLE.inputMatchesKey("abc"));
        assertFalse(View.BATTLE.inputMatchesKey("123"));
        assertFalse(View.BATTLE.inputMatchesKey(""));
        assertFalse(View.BATTLE.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the COMPARING view works as expected
     */
    @Test
    void testInputMatchesKeyComparing() {
        assertTrue(View.COMPARING.inputMatchesKey("1"));
        assertTrue(View.COMPARING.inputMatchesKey("2"));
        assertTrue(View.COMPARING.inputMatchesKey("3"));
        assertTrue(View.COMPARING.inputMatchesKey("4"));
        assertTrue(View.COMPARING.inputMatchesKey("5"));
        assertFalse(View.COMPARING.inputMatchesKey("abc"));
        assertFalse(View.COMPARING.inputMatchesKey("123"));
        assertFalse(View.COMPARING.inputMatchesKey(""));
        assertFalse(View.COMPARING.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the ROUND_WIN view works as expected
     */
    @Test
    void testInputMatchesKeyRoundWin() {
        assertTrue(View.ROUND_WIN.inputMatchesKey("round_win"));
        assertTrue(View.ROUND_WIN.inputMatchesKey("ROUND_WIN"));
        assertFalse(View.ROUND_WIN.inputMatchesKey("abc"));
        assertFalse(View.ROUND_WIN.inputMatchesKey("123"));
        assertFalse(View.ROUND_WIN.inputMatchesKey(""));
        assertFalse(View.ROUND_WIN.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the ROUND_LOSE view works as expected
     */
    @Test
    void testInputMatchesKeyRoundLose() {
        assertTrue(View.ROUND_LOSE.inputMatchesKey("round_lose"));
        assertTrue(View.ROUND_LOSE.inputMatchesKey("ROUND_LOSE"));
        assertFalse(View.ROUND_LOSE.inputMatchesKey("abc"));
        assertFalse(View.ROUND_LOSE.inputMatchesKey("123"));
        assertFalse(View.ROUND_LOSE.inputMatchesKey(""));
        assertFalse(View.ROUND_LOSE.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the ROUND_DRAW view works as expected
     */
    @Test
    void testInputMatchesKeyRoundDraw() {
        assertTrue(View.ROUND_DRAW.inputMatchesKey("round_draw"));
        assertTrue(View.ROUND_DRAW.inputMatchesKey("ROUND_DRAW"));
        assertFalse(View.ROUND_DRAW.inputMatchesKey("abc"));
        assertFalse(View.ROUND_DRAW.inputMatchesKey("123"));
        assertFalse(View.ROUND_DRAW.inputMatchesKey(""));
        assertFalse(View.ROUND_DRAW.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the MATCH_WIN view works as expected
     */
    @Test
    void testInputMatchesKeyMatchWin() {
        assertTrue(View.MATCH_WIN.inputMatchesKey("match_win"));
        assertTrue(View.MATCH_WIN.inputMatchesKey("MATCH_WIN"));
        assertFalse(View.MATCH_WIN.inputMatchesKey("abc"));
        assertFalse(View.MATCH_WIN.inputMatchesKey("123"));
        assertFalse(View.MATCH_WIN.inputMatchesKey(""));
        assertFalse(View.MATCH_WIN.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the MATCH_LOSE view works as expected
     */
    @Test
    void testInputMatchesKeyMatchLose() {
        assertTrue(View.MATCH_LOSE.inputMatchesKey("match_lose"));
        assertTrue(View.MATCH_LOSE.inputMatchesKey("MATCH_LOSE"));
        assertFalse(View.MATCH_LOSE.inputMatchesKey("abc"));
        assertFalse(View.MATCH_LOSE.inputMatchesKey("123"));
        assertFalse(View.MATCH_LOSE.inputMatchesKey(""));
        assertFalse(View.MATCH_LOSE.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the MATCH_DRAW view works as expected
     */
    @Test
    void testInputMatchesKeyMatchDraw() {
        assertTrue(View.MATCH_DRAW.inputMatchesKey("match_draw"));
        assertTrue(View.MATCH_DRAW.inputMatchesKey("MATCH_DRAW"));
        assertFalse(View.MATCH_DRAW.inputMatchesKey("abc"));
        assertFalse(View.MATCH_DRAW.inputMatchesKey("123"));
        assertFalse(View.MATCH_DRAW.inputMatchesKey(""));
        assertFalse(View.MATCH_DRAW.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the GAME_CLEAR view works as expected
     */
    @Test
    void testInputMatchesKeyGameClear() {
        assertTrue(View.GAME_CLEAR.inputMatchesKey("game_clear"));
        assertTrue(View.GAME_CLEAR.inputMatchesKey("GAME_CLEAR"));
        assertFalse(View.GAME_CLEAR.inputMatchesKey("abc"));
        assertFalse(View.GAME_CLEAR.inputMatchesKey("123"));
        assertFalse(View.GAME_CLEAR.inputMatchesKey(""));
        assertFalse(View.GAME_CLEAR.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the GAME_OVER view works as expected
     */
    @Test
    void testInputMatchesKeyGameOver() {
        assertTrue(View.GAME_OVER.inputMatchesKey("game_over"));
        assertTrue(View.GAME_OVER.inputMatchesKey("GAME_OVER"));
        assertFalse(View.GAME_OVER.inputMatchesKey("abc"));
        assertFalse(View.GAME_OVER.inputMatchesKey("123"));
        assertFalse(View.GAME_OVER.inputMatchesKey(""));
        assertFalse(View.GAME_OVER.inputMatchesKey(" "));
    }

    /**
     * Test if the transition key of the QUIT view works as expected
     */
    @Test
    void testInputMatchesKeyQuit() {
        assertTrue(View.QUIT.inputMatchesKey("q"));
        assertTrue(View.QUIT.inputMatchesKey("Q"));
        assertFalse(View.QUIT.inputMatchesKey("abc"));
        assertFalse(View.QUIT.inputMatchesKey("123"));
        assertFalse(View.QUIT.inputMatchesKey(""));
        assertFalse(View.QUIT.inputMatchesKey(" "));
    }
}

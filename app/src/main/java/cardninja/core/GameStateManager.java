package cardninja.core;

import cardninja.states.BattleState;
import cardninja.states.CampaignState;

/**
 * Implementation of the game state.
 * <p>
 * The game state is a Singleton class that stores data to be used in different
 * parts of the application. The game state is composed of the following states:
 * <ul>
 * <li>{@code CampaignState}: Data related to the ongoing campaign</li>
 * <li>{@code BattleState}: Data related to the ongoing battle</li>
 * </ul>
 * 
 * @see cardninja.states.CampaignState
 * @see cardninja.states.BattleState
 */
public class GameStateManager {

    /**
     * The current campaign state. It's value is initialized at the start of
     * a new campaign.
     */
    private CampaignState campaignState;

    /**
     * The current battle state. It's value is initialized at the start of
     * each battle.
     */
    private BattleState battleState;

    /**
     * Create a new game state.
     */
    public GameStateManager() {
        this.campaignState = null;
        this.battleState = null;
    }

    /**
     * Returns the current campaign state.
     * 
     * @return The current campaign state
     */
    public CampaignState getCampaignState() {
        return campaignState;
    }

    /**
     * Returns the current battle state.
     * 
     * @return The current battle state
     */
    public BattleState getBattleState() {
        return battleState;
    }

    /**
     * Updates the campaign state to a new state value.
     * 
     * @param campaignState The new campaign state value
     */
    public void setCampaignState(CampaignState campaignState) {
        this.campaignState = campaignState;
    }

    /**
     * Updates the battle state to a new state value.
     * 
     * @param battleState The new battle state value
     */
    public void setBattleState(BattleState battleState) {
        this.battleState = battleState;
    }

}

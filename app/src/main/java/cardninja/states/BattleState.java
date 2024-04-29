package cardninja.states;

import cardninja.models.Deck;

/**
 * Representation of a Battle state object.
 */
public class BattleState {

    /**
     * The current round of the battle.
     */
    private final int round;

    /**
     * The score of the player.
     */
    private final int playerScore;

    /**
     * The deck of the player.
     */
    private final Deck playerDeck;

    /**
     * The score of the bot.
     */
    private final int botScore;

    /**
     * The deck of the bot.
     */
    private final Deck botDeck;

    /**
     * Create a new Battle State object.
     * 
     * @param round       The current round of the battle
     * @param playerScore The score of the player
     * @param playerDeck  The deck of the player
     * @param botScore    The score of the bot
     * @param botDeck     The deck of the bot
     */
    public BattleState(int round, int playerScore, Deck playerDeck, int botScore, Deck botDeck)
            throws IllegalArgumentException {
        if (!isBattleStateValid(round, playerScore, playerDeck, botScore, botDeck))
            throw new IllegalArgumentException("Provided data is invalid!");

        this.round = round;
        this.playerScore = playerScore;
        this.playerDeck = playerDeck;
        this.botScore = botScore;
        this.botDeck = botDeck;
    }

    /**
     * Returns the round of the battle.
     * 
     * @return The round of the battle
     */
    public int getRound() {
        return round;
    }

    /**
     * Returns the score of the player.
     * 
     * @return The score of the player
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * Returns the deck of the player.
     * 
     * @return The deck of the player
     */
    public Deck getPlayerDeck() {
        return playerDeck;
    }

    /**
     * Returns the score of the bot.
     * 
     * @return The score of the bot
     */
    public int getBotScore() {
        return botScore;
    }

    /**
     * Returns the deck of the bot.
     * 
     * @return The deck of the bot
     */
    public Deck getBotDeck() {
        return botDeck;
    }

    private boolean isBattleStateValid(int round, int playerScore, Deck playerDeck, int botScore, Deck botDeck) {
        boolean isValid = true;

        if (round <= 0 || round > 10) {
            // Checks if the round of the battle name is out of the accepted range
            isValid = false;
        } else if (playerScore < 0 || botScore < 0) {
            // Checks if the player or bot have a negative score
            isValid = false;
        } else if (playerDeck == null || botDeck == null) {
            // Checks if the player or bot do not have a deck
            isValid = false;
        }

        return isValid;
    }

}

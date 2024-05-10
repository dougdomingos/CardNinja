package cardninja.ui;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * All the available views of the game.
 */
public enum View {

    /**
     * Initial view of the game.
     */
    START("(V|START)", "views/start"),

    /**
     * Credits view. Displays the developers of the game.
     */
    CREDITS("C", "views/credits"),

    /**
     * Ranking view. Displays the six best campaigns of the player.
     */
    RANKING("R", "views/ranking"),

    /**
     * New Campaign view. Displayed when the user starts a new campaign.
     */
    NEW_CAMPAIGN("I", "views/new_campaign"),

    /**
     * Battle view. Displayed when the user is making its play.
     */
    BATTLE("BATTLE_START", "views/battle"),

    /**
     * Comparing view. Displayed during card comparison, before showing the round
     * results.
     */
    COMPARING("([1-8]|T)", "views/comparing"),

    /**
     * Round end view. Displayed when the user wins the current round.
     */
    ROUND_WIN("ROUND_WIN", "views/round_win"),

    /**
     * Round end view. Displayed when the user loses the current round.
     */
    ROUND_LOSE("ROUND_LOSE", "views/round_lose"),

    /**
     * Round end view. Displayed when the user draws against the bot.
     */
    ROUND_DRAW("ROUND_DRAW", "views/round_draw"),

    /**
     * Match end view. Displayed when the user wins the match.
     */
    MATCH_WIN("MATCH_WIN", "views/match_win"),

    /**
     * Match end view. Displayed when the user loses the match.
     */
    MATCH_LOSE("MATCH_LOSE", "views/match_lose"),

    /**
     * Match end view. Displayed when the user draws against the bot.
     */
    MATCH_DRAW("MATCH_DRAW", "views/match_draw"),

    /**
     * Campaign end view. Displayed when the user finishes the campaign.
     */
    GAME_CLEAR("GAME_CLEAR", "views/game_clear"),

    /**
     * Campaign end view. Displayed when the user runs out of Life Points in a
     * campaign.
     */
    GAME_OVER("GAME_OVER", "views/game_over"),

    /**
     * The end view. Represents the end of the game's execution.
     */
    QUIT("Q");

    /**
     * Used to control view transitions. The game should only transition
     * to a view if the user input (or game code) matches the transition key.
     */
    private Pattern transitionKey;

    /**
     * The sprite that represents the view.
     */
    private Sprite viewSprite;

    /**
     * A set of views that are subsequent to this one. Represents the possible
     * views the game may transition to.
     */
    private Set<View> nextViews;

    /**
     * Create a new view without any sprite.
     * 
     * @param transitionKey The RegEx pattern that represents the transition key of
     *                      the view
     */
    View(String transitionKey) {
        this.transitionKey = Pattern.compile(transitionKey, Pattern.CASE_INSENSITIVE);
        this.viewSprite = null;
        this.nextViews = null;
    }

    /**
     * Creates a new view.
     * 
     * @param transitionKey The RegEx pattern that represents the transition key of
     *                      the view
     * @param spritePath    The file path to the sprite of the view
     */
    View(String transitionKey, String spritePath) {
        this.transitionKey = Pattern.compile(transitionKey, Pattern.CASE_INSENSITIVE);
        this.viewSprite = new Sprite(spritePath);
        this.nextViews = new HashSet<>();
    }

    /**
     * Checks if a given input (from the game or the player) matches the transition
     * key.
     * 
     * @param input The input of the game or the player
     * @return A boolean value; true if the input matches the pattern, false
     *         otherwise
     */
    public boolean inputMatchesKey(String input) {
        Matcher matcher = this.transitionKey.matcher(input);
        return matcher.matches();
    }

    /**
     * Returns the sprite of the view.
     * 
     * @return The sprite of the view
     */
    public Sprite getViewSprite() {
        return this.viewSprite;
    }

    /**
     * Add a new transition to another view.
     * 
     * @param nextView The view which the transition points to
     */
    public void addTransitionTo(View nextView) {
        this.nextViews.add(nextView);
    }

    /**
     * Returns the set of subsequent views relative to this one.
     * 
     * @return The set of subsequent views
     */
    public Set<View> getNextViews() {
        return this.nextViews;
    }

}

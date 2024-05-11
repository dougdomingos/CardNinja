package cardninja.ui;

import java.util.Iterator;
import java.util.Set;

/**
 * Class responsible for managing view transitions based on user input and
 * game status.
 */
public class ScreenManager {

    /**
     * The current view displayed to the user.
     */
    private View currentView;

    /**
     * Create a new screen manager.
     */
    public ScreenManager() {
        setUpViewTransitions();
        this.currentView = View.START;
    }

    /**
     * Returns the current view.
     * 
     * @return The current view object
     */
    public View getCurrentView() {
        return this.currentView;
    }

    /**
     * Update the current view based on input.
     * 
     * @param input The key to be matched with a view
     */
    public void goToNextView(String input) {
        View nextView = null;
        Set<View> nextViews = this.currentView.getNextViews();

        // Saves the first view that matches the input
        boolean foundView = false;
        Iterator<View> cursor = nextViews.iterator();
        while (!foundView && cursor.hasNext()) {
            nextView = cursor.next();

            if (nextView.inputMatchesKey(input))
                foundView = true;
        }

        // Only updates the current view if a match was found
        this.currentView = foundView ? nextView : this.currentView;
    }

    /**
     * Setup the transitions of each view in the game.
     */
    private void setUpViewTransitions() {
        // START view transitions
        View.START.addTransitionTo(View.NEW_CAMPAIGN);
        View.START.addTransitionTo(View.RANKING);
        View.START.addTransitionTo(View.CREDITS);
        View.START.addTransitionTo(View.QUIT);

        // RANKING view transitions
        View.RANKING.addTransitionTo(View.START);

        // CREDITS view transitions
        View.CREDITS.addTransitionTo(View.START);

        // NEW_CAMPAIGN view transitions
        View.NEW_CAMPAIGN.addTransitionTo(View.BATTLE);

        // BATTLE view transitions
        View.BATTLE.addTransitionTo(View.BATTLE);
        View.BATTLE.addTransitionTo(View.COMPARING);

        // COMPARING view transitions
        View.COMPARING.addTransitionTo(View.ROUND_WIN);
        View.COMPARING.addTransitionTo(View.ROUND_LOSE);
        View.COMPARING.addTransitionTo(View.ROUND_DRAW);

        // ROUND_WIN view transitions
        View.ROUND_WIN.addTransitionTo(View.BATTLE);
        View.ROUND_WIN.addTransitionTo(View.MATCH_WIN);
        View.ROUND_WIN.addTransitionTo(View.MATCH_DRAW);

        // ROUND_LOSE view transitions
        View.ROUND_LOSE.addTransitionTo(View.BATTLE);
        View.ROUND_LOSE.addTransitionTo(View.MATCH_LOSE);
        View.ROUND_LOSE.addTransitionTo(View.MATCH_DRAW);

        // ROUND_DRAW view transitions
        View.ROUND_DRAW.addTransitionTo(View.BATTLE);
        View.ROUND_DRAW.addTransitionTo(View.MATCH_WIN);
        View.ROUND_DRAW.addTransitionTo(View.MATCH_LOSE);
        View.ROUND_DRAW.addTransitionTo(View.MATCH_DRAW);

        // MATCH_WIN view transitions
        View.MATCH_WIN.addTransitionTo(View.BATTLE);
        View.MATCH_WIN.addTransitionTo(View.GAME_CLEAR);

        // MATCH_LOSE view transitions
        View.MATCH_LOSE.addTransitionTo(View.BATTLE);
        View.MATCH_LOSE.addTransitionTo(View.GAME_OVER);

        // MATCH_DRAW view transitions
        View.MATCH_DRAW.addTransitionTo(View.BATTLE);
        View.MATCH_DRAW.addTransitionTo(View.GAME_CLEAR);
        View.MATCH_DRAW.addTransitionTo(View.GAME_OVER);

        // GAME_CLEAR view transitions
        View.GAME_CLEAR.addTransitionTo(View.START);

        // GAME_OVER view transitions
        View.GAME_OVER.addTransitionTo(View.START);
    }

}

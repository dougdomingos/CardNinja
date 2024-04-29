package cardninja.states;

/**
 * Representation of a Campaign state object.
 */
public class CampaignState {

    /**
     * The unique identifier of the campaign.
     */
    private final String name;

    /**
     * The sum of scores of the campaign.
     */
    private final int totalScore;

    /**
     * The remaining life points of the player.
     */
    private final int lifePoints;

    /**
     * The level of the player in the campaign.
     */
    private final int campaignLevel;

    /**
     * Create a new Campaign State object.
     * 
     * @param name          The name of the campaign
     * @param totalScore    The total score of the campaign
     * @param lifePoints    The remaining life points of the player
     * @param campaignLevel The level of the player in the campaign
     * @throws IllegalArgumentException Thrown if the provided data is invalid
     */
    public CampaignState(String name, int totalScore, int lifePoints, int campaignLevel)
            throws IllegalArgumentException {
        if (!isCampaignStateValid(name, totalScore, lifePoints, campaignLevel))
            throw new IllegalArgumentException("Provided data is invalid!");

        this.name = name;
        this.totalScore = totalScore;
        this.lifePoints = lifePoints;
        this.campaignLevel = campaignLevel;
    }

    /**
     * Returns the name of the campaign.
     * 
     * @return The name of the campaign
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the total score of the campaign.
     * 
     * @return The total score of the campaign
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Returns the life points of the campaign.
     * 
     * @return The life points of the campaign
     */
    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * Returns the level of the campaign.
     * 
     * @return The level of the campaign
     */
    public int getCampaignLevel() {
        return campaignLevel;
    }

    private boolean isCampaignStateValid(String name, int totalScore, int lifePoints, int campaignLevel) {
        boolean isValid = true;

        if (name == null || name.isBlank() || name.isEmpty()) {
            // Checks if the campaign name is invalid
            isValid = false;

        } else if (totalScore < 0 || lifePoints < 0) {
            // Checks if the campaign score or life points are negative
            isValid = false;

        } else if (campaignLevel <= 0 || campaignLevel > 5) {
            // Checks if the campaign level is out of the accepted range
            isValid = false;
        }

        return isValid;
    }

}
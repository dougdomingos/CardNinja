package cardninja.models;

/**
 * Existent elements in the game.
 */
public enum Element {

    /**
     * The Fire element. Wins against Nature and Wind, and draws with Lightning.
     */
    FIRE,

    /**
     * The Nature element. Wins against Wind and Lightning, and draws with Earth.
     */
    NATURE,

    /**
     * The Wind element. Wins against Lightning and Earth, and draws with Water.
     */
    WIND,

    /**
     * The Lightning element. Wins against Earth and Water, and draws with Fire.
     */
    LIGHTNING,

    /**
     * The Earth element. Wins against Water and Fire, and draws with Nature.
     */
    EARTH,

    /**
     * The Water element. Wins against Fire and Nature, and draws with Wind.
     */
    WATER;

    /**
     * Determines if this element instance wins against another element.
     * 
     * @param element The element this element instance will be compared to
     * @return A boolean value; {@code true} if this element wins against the other,
     *         {@code false} otherwise
     */
    public boolean winsAgainst(Element element) {
        boolean winsAgainstElement;

        switch (this) {
            case FIRE:
                winsAgainstElement = element == NATURE || element == WIND ? true : false;
                break;

            case NATURE:
                winsAgainstElement = element == WIND || element == LIGHTNING ? true : false;
                break;

            case WIND:
                winsAgainstElement = element == LIGHTNING || element == EARTH ? true : false;
                break;

            case LIGHTNING:
                winsAgainstElement = element == EARTH || element == WATER ? true : false;
                break;

            case EARTH:
                winsAgainstElement = element == WATER || element == FIRE ? true : false;
                break;

            case WATER:
                winsAgainstElement = element == FIRE || element == NATURE ? true : false;
                break;

            default:
                winsAgainstElement = false;
                break;
        }

        return winsAgainstElement;
    }

    /**
     * Determines if this element instance draws against another element.
     * 
     * @param element The element this element instance will be compared to
     * @return A boolean value; {@code true} if this element draws against the other,
     *         {@code false} otherwise
     */
    public boolean drawsAgainst(Element element) {
        boolean drawsAgainst;

        switch (this) {
            case FIRE:
                drawsAgainst = element == LIGHTNING || element == FIRE ? true : false;
                break;

            case NATURE:
                drawsAgainst = element == EARTH || element == NATURE ? true : false;
                break;

            case WIND:
                drawsAgainst = element == WATER || element == WIND ? true : false;
                break;

            case LIGHTNING:
                drawsAgainst = element == FIRE || element == LIGHTNING ? true : false;
                break;

            case EARTH:
                drawsAgainst = element == NATURE || element == EARTH ? true : false;
                break;

            case WATER:
                drawsAgainst = element == WIND || element == WATER ? true : false;
                break;

            default:
                drawsAgainst = this == element ? true : false;
                break;
        }

        return drawsAgainst;
    }
}

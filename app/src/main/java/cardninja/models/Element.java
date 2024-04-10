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
     * The Water element. Wins against Fire and Nature, and draws with Wind.
     */
    WATER,

    /**
     * The Nature element. Wins against Wind and Lightning, and draws with Earth.
     */
    NATURE,

    /**
     * The Wind element. Wins against Lightning and Earth, and draws with Water.
     */
    WIND,

    /**
     * The Earth element. Wins against Water and Fire, and draws with Nature.
     */
    EARTH,

    /**
     * The Lightning element. Wins against Earth and Water, and draws with Fire.
     */
    LIGHTNING
}

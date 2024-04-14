package cardninja.models;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test class for Element implementation
 */
public class ElementTest {

    /**
     * Test if the {@code FIRE} and {@code LIGHTNING} elements are equivalent.
     * 
     * @see cardninja.models.Element#FIRE
     * @see cardninja.models.Element#LIGHTNING
     */
    @Test
    void testFireAndLightningDrawsAgainst() {
        assertTrue(Element.FIRE.drawsAgainst(Element.FIRE));
        assertTrue(Element.LIGHTNING.drawsAgainst(Element.LIGHTNING));
        assertTrue(Element.FIRE.drawsAgainst(Element.LIGHTNING));
    }

    /**
     * Test if the {@code NATURE} and {@code EARTH} elements are equivalent.
     * 
     * @see cardninja.models.Element#NATURE
     * @see cardninja.models.Element#EARTH
     */
    @Test
    void testNatureAndEarthDrawsAgainst() {
        assertTrue(Element.NATURE.drawsAgainst(Element.NATURE));
        assertTrue(Element.EARTH.drawsAgainst(Element.EARTH));
        assertTrue(Element.NATURE.drawsAgainst(Element.EARTH));
    }

    /**
     * Test if the {@code WIND} and {@code WATER} elements are equivalent.
     * 
     * @see cardninja.models.Element#WIND
     * @see cardninja.models.Element#WATER
     */
    @Test
    void testWindAndWaterDrawsAgainst() {
        assertTrue(Element.WIND.drawsAgainst(Element.WIND));
        assertTrue(Element.WATER.drawsAgainst(Element.WATER));
        assertTrue(Element.WIND.drawsAgainst(Element.WATER));
    }

    /**
     * Test if the {@code FIRE} element wins against {@code NATURE} and
     * {@code WIND} as expected.
     * 
     * @see cardninja.models.Element#FIRE
     * @see cardninja.models.Element#NATURE
     * @see cardninja.models.Element#WIND
     */
    @Test
    void testFireWinsAgainst() {
        assertTrue(Element.FIRE.winsAgainst(Element.NATURE));
        assertTrue(Element.FIRE.winsAgainst(Element.WIND));
    }

    /**
     * Test if the {@code NATURE} element wins against {@code WIND} and
     * {@code LIGHTNING} as expected.
     * 
     * @see cardninja.models.Element#NATURE
     * @see cardninja.models.Element#WIND
     * @see cardninja.models.Element#LIGHTNING
     */
    @Test
    void testNatureWinsAgainst() {
        assertTrue(Element.NATURE.winsAgainst(Element.WIND));
        assertTrue(Element.NATURE.winsAgainst(Element.LIGHTNING));
    }

    /**
     * Test if the {@code WIND} element wins against {@code LIGHTNING} and
     * {@code EARTH} as expected.
     * 
     * @see cardninja.models.Element#WIND
     * @see cardninja.models.Element#LIGHTNING
     * @see cardninja.models.Element#EARTH
     */
    @Test
    void testWindWinsAgainst() {
        assertTrue(Element.WIND.winsAgainst(Element.LIGHTNING));
        assertTrue(Element.WIND.winsAgainst(Element.EARTH));
    }

    /**
     * Test if the {@code LIGHTNING} element wins against {@code EARTH} and
     * {@code WATER} as expected.
     * 
     * @see cardninja.models.Element#LIGHTNING
     * @see cardninja.models.Element#EARTH
     * @see cardninja.models.Element#WATER
     */
    @Test
    void testLightningWinsAgainst() {
        assertTrue(Element.LIGHTNING.winsAgainst(Element.EARTH));
        assertTrue(Element.LIGHTNING.winsAgainst(Element.WATER));
    }

    /**
     * Test if the {@code EARTH} element wins against {@code WATER} and
     * {@code FIRE} as expected.
     * 
     * @see cardninja.models.Element#EARTH
     * @see cardninja.models.Element#WATER
     * @see cardninja.models.Element#FIRE
     */
    @Test
    void testEarthWinsAgainst() {
        assertTrue(Element.EARTH.winsAgainst(Element.WATER));
        assertTrue(Element.EARTH.winsAgainst(Element.FIRE));
    }

    /**
     * Test if the {@code WATER} element wins against {@code FIRE} and
     * {@code NATURE} as expected.
     * 
     * @see cardninja.models.Element#WATER
     * @see cardninja.models.Element#FIRE
     * @see cardninja.models.Element#NATURE
     */
    @Test
    void testWaterWinsAgainst() {
        assertTrue(Element.WATER.winsAgainst(Element.FIRE));
        assertTrue(Element.WATER.winsAgainst(Element.NATURE));
    }

}

package cardninja.utils;

import java.util.Random;

import cardninja.models.Card;
import cardninja.models.Element;

/**
 * Class containing a collection of useful methods.
 */
public class Utils {

    /**
     * Generate an array of all the cards of the game.
     * 
     * @return An array containing all the cards of the game
     */
    public static Card[] generateCards() {
        Element[] elements = Element.values();
        int[] powers = new int[] { 2, 5, 7 };
        Card[] cards = new Card[powers.length * elements.length];

        int index = 0;
        for (int i = 0; i < powers.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                cards[index++] = new Card(powers[i], elements[j]);
            }
        }

        return cards;
    }

    /**
     * Pushes an element to the end of the array, shifting all the following
     * elements in one position to the left.
     * 
     * @param <T>   The type of elements in the array
     * @param index The index of the element to be pushed
     * @param array The array to be manipulated
     */
    public static <T> void pushElementToEnd(int index, T[] array) {
        if (index >= 0 && index < array.length) {
            for (int i = index; i < array.length - 1; i++) {
                swap(i, i + 1, array);
            }
        }
    }

    /**
     * Returns a shuffled version of a given array.
     * 
     * @param <T>   The type of elements in the array
     * @param array The array to be shuffled
     * @return The new shuffled array
     */
    public static <T> T[] shuffleArray(T[] array) {
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            swap(i, random.nextInt(i + 1), array);
        }

        return array;
    }

    /**
     * Swap the positions of two elements in an array.
     * 
     * @param <T>   The type of elements in the array
     * @param i     The index of the first element
     * @param j     The index of the second element
     * @param array The array containing the elements
     */
    private static <T> void swap(int i, int j, T[] array) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

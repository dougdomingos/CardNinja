package cardninja.ui;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Implementation of a game sprite.
 * <p>
 * A sprite is represented as an 2D matrix of chars. Sprites may also contain
 * placeholders for data to be inserted or to combine other sprites.
 */
public class Sprite {

    /**
     * A 2D matrix of chars representing the sprite.
     */
    private char[][] sprite;

    /**
     * Create a new sprite directly from a sprite file.
     * 
     * @param spriteFilePath
     */
    public Sprite(String spriteFilePath) {
        this.sprite = loadSpriteFromFile(spriteFilePath);
    }

    /**
     * Replaces a character at a specific coordinate in the sprite.
     * 
     * @param x       The row of the the character to be replaced
     * @param y       The column of the the character to be replaced
     * @param newChar The character to be inserted in the given coordinate
     * @throws IndexOutOfBoundsException Thrown if the provided coordinates are out
     *                                   the sprite's matrix bounds
     */
    public void replaceCharAt(int x, int y, char newChar) throws IndexOutOfBoundsException {
        int numRows = getSpriteRows();
        int numCols = getSpriteColumns();

        if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
            throw new IndexOutOfBoundsException("Invalid coordinates provided!");

        this.sprite[x][y] = newChar;
    }

    /**
     * Returns the number of rows in the sprite.
     * 
     * @return The number of rows in the sprite
     */
    public int getSpriteRows() {
        return this.sprite.length;
    }

    /**
     * Returns the number of columns in the sprite.
     * 
     * @return The number of columns in the sprite
     */
    public int getSpriteColumns() {
        return this.sprite[0].length;
    }

    /**
     * Returns the 2D matrix that represents the sprite.
     * 
     * @return The 2D matrix that represents the sprite
     */
    public char[][] getSprite() {
        return this.sprite;
    }

    /**
     * Reads an sprite file and loads it as an array of strings (lines).
     * 
     * @param filePath Path to the sprite file. The path is relative to the
     *                 {@code resources/sprites/} directory and must not include the
     *                 {@code .txt} extension
     * @throws NullPointerException     Thrown if the provided filepath does not
     *                                  exist
     * @throws IllegalArgumentException Thrown if the provided filepath is invalid
     * @return The 2D matrix of chars representing the sprite
     */
    private char[][] loadSpriteFromFile(String filePath) throws NullPointerException, IllegalArgumentException {
        if (filePath.endsWith(".txt"))
            throw new IllegalArgumentException("File must not include '.txt' extension!");

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("sprites/" + filePath + ".txt");
        Scanner reader = new Scanner(inputStream);

        ArrayList<char[]> lines = new ArrayList<>();
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            lines.add(line.toCharArray());
        }

        reader.close();

        return lines.toArray(new char[0][]);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < sprite.length; i++) {
            for (int j = 0; j < sprite[i].length; j++) {
                out.append(sprite[i][j]);
            }

            out.append('\n');
        }

        return out.toString();
    }

}

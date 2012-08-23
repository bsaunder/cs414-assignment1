/**
 * 
 */
package cs414.a1.btsaunde;

import java.util.ArrayList;

/**
 * Implements a N*M Grid with wrapping. Conceptually, this makes a
 * doughnut-shaped world: if you keep going "North" you eventually wrap back
 * around to where you were, and if you keep going "East" you similarly wrap
 * back around. Note that going North is the +y direction, and going East is the
 * +x direction.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class World extends ArrayList<Object> {

    /**
     * Default Serial ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Width of the Grid.
     */
    private final Integer width;

    /**
     * Height of the Grid.
     */
    private final Integer height;

    /**
     * Creates a Height * Width Grid.
     * 
     * @param pHeight
     *            Height of the Grid
     * @param pWidth
     *            Width of the Grid
     */
    public World(final Integer pWidth, final Integer pHeight) {
        this.width = pWidth;
        this.height = pHeight;

        this.initArray();
    }

    /**
     * Creates a Size * Size Grid.
     * 
     * @param pSize
     *            Size of the Grid
     */
    public World(final Integer pSize) {
        this(pSize, pSize);
    }

    /**
     * Get Grid Width.
     * 
     * @return the width
     */
    public final Integer getWidth() {
        return this.width;
    }

    /**
     * Get Grid Height.
     * 
     * @return the height
     */
    public final Integer getHeight() {
        return this.height;
    }

    /**
     * Gets the object stored at the specified position.
     * 
     * @param x
     *            X Position
     * @param y
     *            Y Position
     * @return Object stored at this position
     */
    protected final Object get(final Integer x, final Integer y) {
        final Integer index = this.getIndex(x, y);
        return this.get(index);
    }

    /**
     * Initialize the Array.
     */
    private void initArray() {
        final Integer gridSize = this.height * this.width;
        for (Integer i = 0; i < gridSize; i++) {
            this.add(i, null);
        }
    }

    /**
     * Gets the Index of a cell in a list based on the X/Y coordinate and the
     * row size.
     * 
     * @param xCoord
     *            X Coordinate
     * @param yCoord
     *            Y Coordinate
     * @return Index of the position
     */
    private Integer getIndex(final Integer xCoord, final Integer yCoord) {
        final Integer rowWidth = this.getWidth();
        final Integer index = (yCoord * rowWidth) + xCoord;
        return index;
    }

    /**
     * Puts the Object into the World at the Specified Coordinates.
     * 
     * @param xCoord
     *            X Coordinate
     * @param yCoord
     *            Y Coordinate
     * @param dataObject
     *            Object to insert
     */
    protected final void put(final Integer xCoord, final Integer yCoord,
            final Object dataObject) {
        final Integer index = this.getIndex(xCoord, yCoord);
        this.add(index, dataObject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final Integer width = this.getWidth();
        final Integer height = this.getHeight();
        return "World(" + width + "," + height + ")";
    }

    /**
     * Places the Object in the World at the X,Y Coordinates represented by the
     * Coordinate.
     * 
     * @param coord
     *            Coordinate to place the object at
     * @param dataObject
     *            Object to place
     */
    public final void put(final Coordinate coord, final Object dataObject) {
        final Integer x = coord.getX();
        final Integer y = coord.getY();
        final Integer index = this.getIndex(x, y);
        this.add(index, dataObject);
    }

    /**
     * Gets the Object that the given Coordinate points to on the world the
     * Coordinate references, NOT the world the method was called on. Returns
     * Null if no object exists.
     * 
     * @param coordinate Coordinate to get object from
     * @return Retrieved Object, or null if no object exists
     */
    public final Object get(final Coordinate coordinate) {
        return coordinate.get();
    }

}

/**
 * 
 */
package cs414.a1.btsaunde;

/**
 * Represents an X,Y Coordinate in a Given World.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class Coordinate {

    /**
     * X Coordinate.
     */
    private Integer x;

    /**
     * Y Coordinate.
     */
    private Integer y;

    /**
     * World that contains coordinates.
     */
    private World world;

    /**
     * Creates a Coordinate for the specified coordinates in the given world.
     * 
     * @param pX
     *            X Coordinate
     * @param pY
     *            Y Coordinate
     * @param pWorld
     *            World that contains Coordinates
     */
    public Coordinate(final Integer pX, final Integer pY, final World pWorld) {
        this.world = pWorld;

        this.x = this.wrapX(pX);
        this.y = this.wrapY(pY);

    }
    
    /**
     * Wraps an X Coordinate.
     * 
     * @param pX
     *            X Coordinate to wrap
     * @return Wrapped X Coordinate
     */
    private Integer wrapX(final Integer pX) {
        Integer result = pX;

        Integer worldWidth = this.world.getWidth();
        if (pX >= worldWidth) {
            // Wrapping East
            result = pX % worldWidth;
        } else if (pX < 0) {
            // Wrapping West
            // TODO Gotta be a better way...
            while (result < 0) {
                result += worldWidth;
            }
        }

        return result;
    }

    /**
     * Wraps an Y Coordinate.
     * 
     * @param pY
     *            Y Coordinate to wrap
     * @return Wrapped Y Coordinate
     */
    private Integer wrapY(final Integer pY) {
        Integer result = pY;

        Integer worldHeight = this.world.getHeight();
        if (pY >= worldHeight) {
            // Wrapping North
            result = pY % worldHeight;
        } else if (pY < 0) {
            // Wrapping South
            // TODO Gotta be a better way...
            while (result < 0) {
                result += worldHeight;
            }
        }

        return result;
    }

    /**
     * Get X Coordinate.
     * 
     * @return the x
     */
    public final Integer getX() {
        return this.x;
    }

    /**
     * Get Y Coordinate.
     * 
     * @return the y
     */
    public final Integer getY() {
        return this.y;
    }

    /**
     * Gets the World.
     * 
     * @return the world
     */
    public final World getWorld() {
        return this.world;
    }

}

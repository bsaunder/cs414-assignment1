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
	private final Integer xCoord;

	/**
	 * Y Coordinate.
	 */
	private final Integer yCoord;

	/**
	 * World that contains coordinates.
	 */
	private final World world;

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

		this.xCoord = this.wrapX(pX);
		this.yCoord = this.wrapY(pY);

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

		final Integer worldWidth = this.world.getWidth();
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

		final Integer worldHeight = this.world.getHeight();
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
		return this.xCoord;
	}

	/**
	 * Get Y Coordinate.
	 * 
	 * @return the y
	 */
	public final Integer getY() {
		return this.yCoord;
	}

	/**
	 * Gets the World.
	 * 
	 * @return the world
	 */
	public final World getWorld() {
		return this.world;
	}

	/**
	 * Gets the this Coordinate Represents from its World.
	 * 
	 * @return Object from World.
	 */
	public final Object get() {
		final Integer x = this.getX();
		final Integer y = this.getY();
		return this.world.get(x, y);
	}

	/**
	 * Puts the given object into the World at this Coordinate.
	 * 
	 * @param dataObject
	 *            Object to insert.
	 */
	public final void put(final String dataObject) {
		final Integer x = this.getX();
		final Integer y = this.getY();
		this.world.put(x, y, dataObject);
	}

	/**
	 * Two coordinates are equal if and only if they have the same x & y values,
	 * and they reference the same world object.
	 */
	@Override
	public final boolean equals(final Object obj) {
		boolean result = false;

		if (obj instanceof Coordinate) {
			final Coordinate coordinate = (Coordinate) obj;
			if (this.world == coordinate.getWorld()) {
				if (this.xCoord == coordinate.getX()
						&& this.yCoord == coordinate.getY()) {
					result = true;
				}
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return this.xCoord + this.yCoord + this.world.hashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Coordinate(" + this.xCoord + "," + this.yCoord + ") in "
				+ this.world.toString();
	}

	/**
	 * Gets the Coordinate to the East of this Coordinate.
	 * 
	 * @return Eastern Coordinate
	 */
	public final Coordinate east() {
		Integer newX = this.getX() + 1;
		newX = this.wrapX(newX);

		final Integer newY = this.getY();

		return new Coordinate(newX, newY, this.getWorld());
	}
	
	/**
	 * Gets the Coordinate to the West of this Coordinate.
	 * 
	 * @return Western Coordinate
	 */
	public final Coordinate west() {
		Integer newX = this.getX() - 1;
		newX = this.wrapX(newX);

		final Integer newY = this.getY();

		return new Coordinate(newX, newY, this.getWorld());
	}
	
	/**
	 * Gets the Coordinate to the North of this Coordinate.
	 * 
	 * @return Northern Coordinate
	 */
	public final Coordinate north() {
		final Integer newX = this.getX();

		Integer newY = this.getY() + 1;
		newY = this.wrapY(newY);

		return new Coordinate(newX, newY, this.getWorld());
	}
	
	/**
	 * Gets the Coordinate to the South of this Coordinate.
	 * 
	 * @return Southern Coordinate
	 */
	public final Coordinate south() {
		final Integer newX = this.getX();

		Integer newY = this.getY() - 1;
		newY = this.wrapY(newY);

		return new Coordinate(newX, newY, this.getWorld());
	}

}

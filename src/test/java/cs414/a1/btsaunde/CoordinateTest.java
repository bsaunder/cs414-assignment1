/**
 * 
 */
package cs414.a1.btsaunde;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit Tests for Coordinate Object.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class CoordinateTest {

	/**
	 * Tests that a Coordinate Object can be Created.
	 */
	@Test
	public final void ifObjectCreatedThenPass() {
		// given
		final Integer x = 2;
		final Integer y = 2;
		final Integer size = 3;
		final World world = new World(size);

		// when
		final Coordinate coord = new Coordinate(x, y, world);

		// then
		assertNotNull(coord);
		assertEquals(world, coord.getWorld());
		assertEquals(x, coord.getX());
		assertEquals(y, coord.getY());
	}

	/**
	 * Tests that Coordinates are Properly Wrapped when an Object is Created.
	 */
	@Test
	public final void ifCoordinatesWrappedNorthThenPass() {
		// given
		final Integer x = 2;
		final World world = new World(3);

		// when/then
		Coordinate coord = new Coordinate(x, 3, world);
		assertEquals(new Integer(0), coord.getY());

		coord = new Coordinate(x, 4, world);
		assertEquals(new Integer(1), coord.getY());

		coord = new Coordinate(x, 5, world);
		assertEquals(new Integer(2), coord.getY());

		coord = new Coordinate(x, 6, world);
		assertEquals(new Integer(0), coord.getY());
	}

	/**
	 * Tests that Coordinates are Properly Wrapped when an Object is Created.
	 */
	@Test
	public final void ifCoordinatesWrappedSouthThenPass() {
		// given
		final Integer x = 2;
		final World world = new World(3);

		// when/then
		Coordinate coord = new Coordinate(x, -1, world);
		assertEquals(new Integer(2), coord.getY());

		coord = new Coordinate(x, -2, world);
		assertEquals(new Integer(1), coord.getY());

		coord = new Coordinate(x, -3, world);
		assertEquals(new Integer(0), coord.getY());

		coord = new Coordinate(x, -4, world);
		assertEquals(new Integer(2), coord.getY());
	}

	/**
	 * Tests that Coordinates are Properly Wrapped when an Object is Created.
	 */
	@Test
	public final void ifCoordinatesWrappedEastThenPass() {
		// given
		final Integer y = 2;
		final World world = new World(3);

		// when/then
		Coordinate coord = new Coordinate(3, y, world);
		assertEquals(new Integer(0), coord.getX());

		coord = new Coordinate(4, y, world);
		assertEquals(new Integer(1), coord.getX());

		coord = new Coordinate(5, y, world);
		assertEquals(new Integer(2), coord.getX());

		coord = new Coordinate(6, y, world);
		assertEquals(new Integer(0), coord.getX());
	}

	/**
	 * Tests that Coordinates are Properly Wrapped when an Object is Created.
	 */
	@Test
	public final void ifCoordinatesWrappedWestThenPass() {
		// given
		final Integer y = 2;
		final World world = new World(3);

		// when/then
		Coordinate coord = new Coordinate(-1, y, world);
		assertEquals(new Integer(2), coord.getX());

		coord = new Coordinate(-2, y, world);
		assertEquals(new Integer(1), coord.getX());

		coord = new Coordinate(-3, y, world);
		assertEquals(new Integer(0), coord.getX());

		coord = new Coordinate(-4, y, world);
		assertEquals(new Integer(2), coord.getX());
	}

	/**
	 * Tests that the get method gets the correct object.
	 */
	@Test
	public final void ifObjectExistsThenGetObject() {
		// given
		final Integer x = 2;
		final Integer y = 2;
		final Integer size = 3;
		final World world = new World(size);
		final String strObject = new String("String");
		world.put(x, y, strObject);

		// when
		final Coordinate coord = new Coordinate(x, y, world);
		final Object object = coord.get();

		// then
		assertNotNull(object);
		assertEquals(object, strObject);
	}

	/**
	 * Tests that the get method gets the correct object.
	 */
	@Test
	public final void ifObjectDoesntExistThenGetNull() {
		// given
		final Integer x = 2;
		final Integer y = 1;
		final Integer size = 3;
		final World world = new World(size);

		// when
		final Coordinate coord = new Coordinate(x, y, world);
		final Object object = coord.get();

		// then
		assertNull(object);
	}

	/**
	 * Tests that the put method inserts the object.
	 */
	@Test
	public final void ifObjectInsertedThenPass() {
		// given
		final Integer x = 2;
		final Integer y = 2;
		final Integer size = 3;
		final World world = new World(size);
		final String strObject = new String("String");

		// when
		final Coordinate coord = new Coordinate(x, y, world);
		coord.put(strObject);

		// then
		final Object object = world.get(x, y);
		assertNotNull(object);
		assertEquals(strObject, object);
	}

	/**
	 * Tests if the Coordinates are Equal.
	 */
	@Test
	public final void ifCoordinatesAndWorldSameThenEqual() {
		// given
		final Integer x = 2;
		final Integer y = 2;
		final Integer size = 3;
		final World world = new World(size);

		// when
		final Coordinate coord1 = new Coordinate(x, y, world);
		final Coordinate coord2 = new Coordinate(x, y, world);

		// then
		assertEquals(coord1, coord2);
		assertTrue(coord1.equals(coord2));
		assertTrue(coord2.equals(coord1));
	}

	/**
	 * Tests if the Coordinates are Equal when they have Different Coords.
	 */
	@Test
	public final void ifSameWorldDifferentCoordsThenNotEqual() {
		// given
		final Integer x1 = 2;
		final Integer y1 = 2;
		final Integer x2 = 1;
		final Integer y2 = 1;

		final Integer size = 3;
		final World world = new World(size);

		// when
		final Coordinate coord1 = new Coordinate(x1, y1, world);
		final Coordinate coord2 = new Coordinate(x2, y2, world);

		// then
		assertFalse(coord1.equals(coord2));
		assertFalse(coord2.equals(coord1));
	}

	/**
	 * Tests if the Coordinates are Equal when they have Different Worlds.
	 */
	@Test
	public final void ifSameCoordsDifferentWorldThenNotEqual() {
		// given
		final Integer x = 2;
		final Integer y = 2;

		final Integer size = 3;
		final World world1 = new World(size);
		final World world2 = new World(size);

		// when
		final Coordinate coord1 = new Coordinate(x, y, world1);
		final Coordinate coord2 = new Coordinate(x, y, world2);

		// then
		assertFalse(coord1.equals(coord2));
		assertFalse(coord2.equals(coord1));
	}

	/**
	 * Tests for the correct Hashcode.
	 */
	@Test
	public final void ifHashCodeCorrectThenPass() {
		// given
		final Integer x = 2;
		final Integer y = 2;
		final Integer size = 3;
		final World world = new World(size);
		final Integer expectedHash = x + y + world.hashCode();

		// when
		final Coordinate coord = new Coordinate(x, y, world);
		final Integer hashCode = coord.hashCode();

		// then
		assertEquals(expectedHash, hashCode);
	}

	/**
	 * Tests toString.
	 */
	@Test
	public final void ifCorrectStringGeneratedThenPass() {
		// given
		final Integer x = 2;
		final Integer y = 2;
		final Integer size = 3;

		// when
		final World world = new World(size);
		final Coordinate coord = new Coordinate(x, y, world);

		// then
		assertEquals("Coordinate(2,2) in World(3,3)", coord.toString());
	}

	/**
	 * Tests that north returns the correct Coordinate.
	 */
	@Test
	public void ifNorthernCoordinateCorrectThenPass() {
		// given
		final Integer x = 2;
		final Integer y = 2;
		final Integer size = 3;
		final World world = new World(size);

		// when
		final Coordinate coord = new Coordinate(x, y, world);
		final Coordinate northernCoord = coord.north();

		// then
		assertEquals(x, northernCoord.getX());
		assertEquals(new Integer(0), northernCoord.getY());
	}

	/**
	 * Tests that south returns the correct Coordinate.
	 */
	@Test
	public void ifSouthernCoordinateCorrectThenPass() {
		// given
		final Integer x = 2;
		final Integer y = 2;
		final Integer size = 3;
		final World world = new World(size);

		// when
		final Coordinate coord = new Coordinate(x, y, world);
		final Coordinate southernCoord = coord.south();

		// then
		assertEquals(x, southernCoord.getX());
		assertEquals(new Integer(1), southernCoord.getY());
	}

	/**
	 * Tests that east returns the correct Coordinate.
	 */
	@Test
	public void ifEasternCoordinateCorrectThenPass() {
		// given
		final Integer x = 2;
		final Integer y = 2;
		final Integer size = 3;
		final World world = new World(size);

		// when
		final Coordinate coord = new Coordinate(x, y, world);
		final Coordinate easternCoord = coord.east();

		// then
		assertEquals(new Integer(0), easternCoord.getX());
		assertEquals(y, easternCoord.getY());
	}

	/**
	 * Tests that west returns the correct Coordinate.
	 */
	@Test
	public void ifWesternCoordinateCorrectThenPass() {
		// given
		final Integer x = 2;
		final Integer y = 2;
		final Integer size = 3;
		final World world = new World(size);

		// when
		final Coordinate coord = new Coordinate(x, y, world);
		final Coordinate westernCoord = coord.west();

		// then
		assertEquals(new Integer(1), westernCoord.getX());
		assertEquals(y, westernCoord.getY());
	}

}

/**
 * 
 */
package cs414.a1.btsaunde;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Unit Tests for World Object.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class WorldTest {

    /**
     * Tests Creation of a 2x3 World.
     */
    @Test
    public final void if2by3ObjectCreatedThenPass() {
        // given
        final Integer width = 2;
        final Integer height = 3;

        // when
        final World world = new World(width, height);

        // then
        assertNotNull(world);
        assertEquals(width, world.getWidth());
        assertEquals(height, world.getHeight());
    }

    /**
     * Tests Creation of a 2x2 World.
     */
    @Test
    public final void if2by2ObjectCreatedThenPass() {
        // given
        final Integer size = 2;

        // when
        final World world = new World(size);

        // then
        assertNotNull(world);
        assertEquals(size, world.getWidth());
        assertEquals(size, world.getHeight());
    }

    /**
     * Tests Getting an Object from a Grid.
     */
    @Test
    public final void ifValidCoordinateThenGetObject() {
        // given
        final Integer x = 2;
        final Integer y = 2;
        final Integer size = 3;

        // when
        final World world = new World(size);
        final Object object = world.get(x, y);

        // then
        assertNull(object); // Should be null b/c the grid is empty
    }

    /**
     * Tests Getting an Object from a Grid with Invalid Coordinates.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public final void ifInvalidCoordinateThenGetThrowsIndexOutOfBoundsException() {
        // given
        final Integer x = 2;
        final Integer y = 3;
        final Integer size = 3;

        // when
        final World world = new World(size);
        final Object object = world.get(x, y);

        // then
        fail("Expecting IndexOutOfBoundsException");
    }

    /**
     * Tests Getting an Object from a Grid.
     */
    @Test
    public final void ifValidCoordinateThenPutObject() {
        // given
        final Integer x = 2;
        final Integer y = 2;
        final Integer size = 3;
        final String strObject = new String("Hello!");

        // when
        final World world = new World(size);
        world.put(x, y, strObject);
        final Object object = world.get(x, y);

        // then
        assertNotNull(object);
        assertEquals(strObject, object);
    }

    /**
     * Tests Getting an Object from a Grid with Invalid Coordinates.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public final void ifInvalidCoordinateThenPutThrowsIndexOutOfBoundsException() {
        // given
        final Integer x = 2;
        final Integer y = 3;
        final Integer size = 3;
        final String strObject = new String("World!");

        // when
        final World world = new World(size);
        world.put(x, y, strObject);

        // then
        fail("Expecting IndexOutOfBoundsException");
    }

    /**
     * Tests toString.
     */
    @Test
    public final void ifCorrectStringGeneratedThenPass() {
        // given
        final Integer size = 3;

        // when
        final World world = new World(size);

        // then
        assertEquals("World(3,3)", world.toString());
    }

    /**
     * Tests the Worlds get Method.
     */
    @Test
    public final void ifObjectRetrievedFromCoordinateThenPass() {
        // given
        final Integer x = 2;
        final Integer y = 2;
        final Integer size = 3;
        final String strObject = new String("String!");

        final World world = new World(size);
        final Coordinate coord = new Coordinate(x, y, world);
        world.put(coord, strObject);

        // when
        final Object object = world.get(coord);

        // then
        assertNotNull(object);
        assertEquals(strObject, object);
    }

    /**
     * Tests that World.get(Coordinate) is getting the Object from World on the
     * Coordinate, NOT the World that get() was called on.
     */
    @Test
    public final void ifObjectRetrievedFromCorrectWorldThenPass() {
        // given
        final Integer x = 2;
        final Integer y = 2;
        final Integer size = 3;

        final String earthObject = new String("Earth!");
        final String plutoObject = new String("Pluto!");

        final World earth = new World(size);
        final World pluto = new World(size);

        final Coordinate earthCoordinate = new Coordinate(x, y, earth);
        final Coordinate plutoCoordinate = new Coordinate(x, y, pluto);

        earth.put(earthCoordinate, earthObject);
        pluto.put(plutoCoordinate, plutoObject);

        // when
        final Object retrievedEarthObject = earth.get(plutoCoordinate);
        final Object retrievedPlutoObject = pluto.get(earthCoordinate);

        // then
        assertNotNull(retrievedEarthObject);
        assertNotNull(retrievedPlutoObject);
        assertEquals(plutoObject, retrievedEarthObject);
        assertEquals(retrievedPlutoObject, earthObject);
    }

    /**
     * Tests the Worlds put Method.
     */
    @Test
    public final void ifObjectPutAtCoordinateThenPass() {
        // given
        final Integer x = 2;
        final Integer y = 2;
        final Integer size = 3;
        final String strObject = new String("String!");
        final World world = new World(size);

        // when
        final Coordinate coord = new Coordinate(x, y, world);
        world.put(coord, strObject);

        // then
        final Object object = world.get(x, y);
        assertNotNull(object);
        assertEquals(strObject, object);
    }

}

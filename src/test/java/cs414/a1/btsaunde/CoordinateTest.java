/**
 * 
 */
package cs414.a1.btsaunde;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        Integer x = 2;
        Integer y = 2;
        Integer size = 3;
        World world = new World(size);

        // when
        Coordinate coord = new Coordinate(x, y, world);

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
        Integer x = 2;
        World world = new World(3);

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
        Integer x = 2;
        World world = new World(3);

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
        Integer y = 2;
        World world = new World(3);

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
        Integer y = 2;
        World world = new World(3);

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
}

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
        Integer width = 2;
        Integer height = 3;

        // when
        World world = new World(width, height);

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
        Integer size = 2;

        // when
        World world = new World(size);

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
        Integer x = 2;
        Integer y = 2;
        Integer size = 3;

        // when
        World world = new World(size);
        Object object = world.get(x, y);

        // then
        assertNull(object); // Should be null b/c the grid is empty
    }

    /**
     * Tests Getting an Object from a Grid with Invalid Coordinates.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public final void ifInvalidCoordinateThenGetThrowsIndexOutOfBoundsException() {
        // given
        Integer x = 2;
        Integer y = 3;
        Integer size = 3;

        // when
        World world = new World(size);
        Object object = world.get(x, y);

        // then
        fail("Expecting IndexOutOfBoundsException");
    }

    /**
     * Tests Getting an Object from a Grid.
     */
    @Test
    public final void ifValidCoordinateThenPutObject() {
        // given
        Integer x = 2;
        Integer y = 2;
        Integer size = 3;
        String strObject = new String("Hello!");

        // when
        World world = new World(size);
        world.put(x, y, strObject);
        Object object = world.get(x, y);

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
        Integer x = 2;
        Integer y = 3;
        Integer size = 3;
        String strObject = new String("World!");

        // when
        World world = new World(size);
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
        Integer size = 3;

        // when
        World world = new World(size);

        // then
        assertEquals("World(3,3)", world.toString());
    }
    
    /**
     * Tests the Worlds get Method.
     */
    @Test
    public final void testGet(){
    	// give it a method get(Coordinate c) which returns the object at c, implemented in terms of the get() method in the Coordinate class.
    	fail("Not yet implemented.");
    }
    
    /**
     * Tests the Worlds put Method.
     */
    @Test
    public final void testPut(){
    	// give it a method put(Coordinate c, Object o) which puts the object o at the x,y position indicated by Coordinate c.
    	fail("Not yet implemented.");
    }

}

/**
 * 
 */
package cs414.a1.btsaunde;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class TACoordinateTest {

	private static Coordinate c1;
	private static World w1;
	private Coordinate c2, c3;
	private World w2, w3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		w1 = new World(4, 5);
		c1 = new Coordinate(2, 4, w1);
	}

	@Before
	public void setUp() throws Exception {
		w2 = new World(6, 8);
	}

	@Test
	public void hashTest1() {
		c2 = new Coordinate(3, 4, w1);
		int hs = 3 + 4 + w1.hashCode();
		assertEquals(hs, c2.hashCode());
	}

	@Test
	public void negativeCoordinates() {
		c2 = new Coordinate(-4, 5, w1);
		c2 = new Coordinate(4, -5, w1);
		c2 = new Coordinate(-4, -5, w1);
	}

}

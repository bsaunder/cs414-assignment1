
import java.text.DecimalFormat;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoordinateTestg {
	
	private static Coordinate c1;
	private static World w1;
	private Coordinate c2, c3;
	private World w2, w3;
	
	private static float points = 0;
	private static int passed = 0;
	private static final int tests = 34;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println ("********** Start of Coordinate Tests **********");
		System.out.println ("***** Start of FYI *****\n");
		System.out.println ("Declarations: ");
		System.out.println ("\t'private static Coordinate c1;'");
		System.out.println ("\t'private static World w1;'");
		System.out.println ("\t'private Coordinate c2, c3;'");
		System.out.println ("\t'private World w2, w3;'");
		
		System.out.println ("\nInitialisation in setUpBeforeClass() method");
		System.out.println ("\t'w1 = new World(4, 5);'");
		System.out.println ("\t'c1 = new Coordinate (w1, 2, 4);'\n");
		
		w1 = new World(4, 5);
		c1 = new Coordinate (w1, 2, 4);
		
		System.out.println ("Before every test reinitialise: 'w2 = new World(6, 8);'\n");
		System.out.println ("***** End of FYI *****\n\n\n***** TESTS *****\n");
	}

	@Before
	public void setUp() throws Exception {
		w2 = new World(6, 8);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		DecimalFormat df = new DecimalFormat("#0.00");
		System.out.println("Total Tests: " + tests);
		System.out.println("Tests Passed: " + passed);
		System.out.println("Tests Failed: " + (tests-passed));
		System.out.println("Total points possible from grader's tests: " + df.format(((float) tests/10)));
		System.out.println("Total points received from grader's tests: " + df.format(points));
		System.out.println ("********** End of Coordinate Tests **********");
		System.out.println();
		System.out.print("Functionality of Coordinate Class: ");
		System.out.println(df.format((float) passed/tests *5) + "/5.0 points");
		points += (float) passed/tests *5;
		
		 
	}
	
	/************************************************************
	 * 			Automatic TESTS
	 ************************************************************/
	
	/***************Constructor***********************************/
	
	@Test (expected=NullPointerException.class)
	public void newCoordinateUniitialisedWorld () {
		System.out.println("Test: Create new Coordinate with uninitialised world.");
		System.out.println("\tExpected result: NullPointerException");
		try {
			System.out.println("\tExecuting: 'c2 = new Coordinate (w3, 2, 3);' with w3 = null");
			c2 = new Coordinate (w3, 2, 3); 
		}
		finally {
			if (c2 == null) {
				System.out.println("\tTest passed: +0.1/0.1 points\n");
				points += 0.1;
				passed +=1;
			}
			else
			System.out.println("\tTest failed: 0.0/0.1 points\n");
		}
	}	 
	
	@Test
	public void newCoordinateWrap () {
		System.out.println("Test: Create new Coordinate with x and y positive, and both larger than dimensions of world.");
		System.out.println("\tExpected result: Coordinate will be created");
		try{
			System.out.println("\tExecuting: 'c2 = new Coordinate (w1, 6, 7);'");
			c2 = new Coordinate (w1, 6, 7);
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		catch (Exception e) {
			System.out.println("\tTest failed: 0.0/0.1 points\n");
		}
	}
	
	@Test
	public void newCoordinateWrapBorderX () {
		System.out.println("Test: Create new Coordinate with wrapping on x dimension border");
		System.out.println("\tExpected result: Coordinate will be created");
		try{
			System.out.println("\tExecuting: 'c2 = new Coordinate (w1, 4, 4);'");
			c2 = new Coordinate (w1, 4, 4);
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		catch (Exception e) {
			System.out.println("\tTest failed: 0.0/0.1 points\n");
		}
	}
	
	@Test
	public void newCoordinateWrapBorderY () {
		System.out.println("Test: Create new Coordinate with wrapping on y dimension border");
		System.out.println("\tExpected result: Coordinate will be created");
		try{
			System.out.println("\tExecuting: 'c2 = new Coordinate (w1, 3, 5);'");
			c2 = new Coordinate (w1, 3, 5);
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		catch (Exception e) {
			System.out.println("\tTest failed: 0.0/0.1 points\n");
		}
	}
	
	@Test
	public void newCoordinateWrapBorderXY () {
		System.out.println("Test: Create new Coordinate with wrapping on both x and y dimension border");
		System.out.println("\tExpected result: Coordinate will be created");
		try{
			System.out.println("\tExecuting: 'c2 = new Coordinate (w1, 4, 5);'");
			c2 = new Coordinate (w1, 4, 5);
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		catch (Exception e) {
			System.out.println("\tTest failed: 0.0/0.1 points\n");
		}
	}
	
	/***************Get and Put***********************************/
	@Test (expected=NullPointerException.class)
	public void getFromUniitialisedCoordinate () {
		Object o = null;
		System.out.println("Test: Get from uninitialised Coordinate");
		System.out.println("\tExpected result: NullPointerException");
		try{
			System.out.println("\tExecuting: 'c2.get();'");
			o = c2.get();
		}
		finally {
			if (o == null) {
				System.out.println("\tTest passed: +0.1/0.1 points\n");
				points += 0.1;
				passed +=1;
			}
			else
			System.out.println("\tTest failed: 0.0/0.1 points\n");
		}
	}
	
	@Test (expected=NullPointerException.class)
	public void putInUniitialisedCoordinate () {
		Integer obj = 5;
		System.out.println("Test: Put into uninitialised Coordinate");
		System.out.println("\tExpected result: NullPointerException");
		try{
			System.out.println("\tExecuting: 'c2.put(obj);'");
			c2.put(obj);
			System.out.println("\tTest failed: 0/0.1 points\n");
			}
		catch (NullPointerException npe) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
			c2.put(obj); // workaround: throw the exception again so that the test will pass...
		}
	}
	
	@Test 
	public void put () {
		System.out.println("Test: Put an object using a valid Coordinate, c1");
		System.out.println("\tExpected result: No Exception thrown");
		Integer obj = 5;
		try{
			c1.put(obj);
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		catch (Exception e) {
			System.out.println("\tTest failed: 0/0.1 points\n");
			c1.put(obj); // workaround: throw the exception again so that the test will pass...
		}
			
	}
	
	@Test
	public void putOverwrite () {
		System.out.println("Test: Overwrite object in c1");
		System.out.println("\tExpected result: The Integer Object with value 6 is stored");
		System.out.println("\tExecuting: \n\t\t'Integer obj = 5;'");
		System.out.println("\t\t'c1.put(obj);'");
		System.out.println("\t\t'Integer obj2 = 6;'");
		System.out.println("\t\t'c1.put(obj2);'");
		Integer obj = 5;
		
		try{
			c1.put(obj);
			Integer obj2 = 6;
			c1.put(obj2);
			
			Integer expected = (Integer) c1.get();
			System.out.println("\tObject in c1: " + expected );
			
			if (expected.equals(obj2)) {
				System.out.println("\tTest passed: +0.1/0.1 points\n");
				points += 0.1;
				passed +=1;
			}
			else 
				System.out.println("\tTest failed: 0/0.1 points\n");

			assertTrue(expected.equals(obj2)); // this will show if test is passed
		}
		catch (Exception e) {
			System.out.println("\tTest failed: 0/0.1 points\n");
			c1.put(obj); // workaround: throw the exception again so that the test will pass...
		}
	}	
	
	@Test 
	public void putAndGetWrapping () {
		System.out.println("Test: Put and Get an object using wrapping");
		System.out.println("\tExpected result: The Integer Object with value 8 is stored and retrieved");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 4, 5);'");
		System.out.println("\t\t'Integer obj = 8;'");
		System.out.println("\t\t'c2.put(obj);'");
		System.out.println("\t\t'c3 = new Coordinate (w1, 0, 0);'");
		
		c2 = new Coordinate (w1, 4, 5);
		Integer obj = 8;
		c2.put(obj);
		c3 = new Coordinate (w1, 0, 0);
		Integer expected = (Integer) c3.get();
		
		System.out.println("\tObject in c3: " + expected );
		
		if (expected.equals(obj)) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(expected.equals(obj));
	}
	
	/***************equals***********************************/
	@Test 
	public void equalCoordinatesCorrect () {
		System.out.println("Test: Testing equals() using wrapping 1");
		System.out.println("\tExpected result: Both Coordinates created will be equal");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 4, 5);'");
		System.out.println("\t\t'c3 = new Coordinate (w1, 0, 0);'");
		System.out.println("\t\t'assertTrue(c2.equals(c3));'");
		
		c2 = new Coordinate (w1, 4, 5);
		c3 = new Coordinate (w1, 0, 0);
		
		if (c2.equals(c3)) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(c2.equals(c3));
	}
	
	@Test 
	public void equalCoordinatesIncorrectSameWorld () {
		System.out.println("Test: Testing equals() using wrapping 2");
		System.out.println("\tExpected result: Both Coordinates created will not be equal");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 4, 5);'");
		System.out.println("\t\t'c3 = new Coordinate (w1, 10, 2);'");
		System.out.println("\t\t'assertTrue(!c2.equals(c3));'");
		
		c2 = new Coordinate (w1, 4, 5);
		c3 = new Coordinate (w1, 10, 2);
		
		if (!c2.equals(c3)) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(!c2.equals(c3));
	}
	
	@Test 
	public void equalCoordinatesIncorrectDiffWorld () {
		System.out.println("Test: Testing equals() using Coordinates in different worlds");
		System.out.println("\tExpected result: Both Coordinates created will not be equal");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 4, 5);'");
		System.out.println("\t\t'c3 = new Coordinate (w1, 4, 5);'");
		System.out.println("\t\t'assertTrue(!c2.equals(c3));'");
		
		c2 = new Coordinate (w1, 4, 5);
		c3 = new Coordinate (w2, 4, 5);
		
		if (!c2.equals(c3)) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(!c2.equals(c3));
	}
	
	@Test
	public void equalCoordinatesIncorrectObject () {
		System.out.println("Test: Testing equals() using a Coordinate and an Integer object");
		System.out.println("\tExpected result: Equals returns false");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 4, 5);'");
		System.out.println("\t\t'Integer c3 = 5;'");
		System.out.println("\t\t'assertTrue(!c2.equals(c3));'");
		
		c2 = new Coordinate (w1, 4, 5);
		Integer c3 = 5;
		
		if (!c2.equals(c3)) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(!c2.equals(c3));
	}

	/***************hashcode***********************************/
	@Test
	public void hashCodeCorrect () {
		int hs = 3+4+w1.hashCode();
		
		System.out.println("Test: Testing hashCode() - test #1");
		System.out.println("\tExpected result: hashcode returns " + hs);
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 3, 4);'");
		System.out.println("\t\t'int hs = 3+4+w1.hashCode();'");
		System.out.println("\t\t'assertEquals(hs,c2.hashCode());'");
		
		c2 = new Coordinate (w1, 3, 4);
		
		if (hs == c2.hashCode()) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertEquals(hs,c2.hashCode());
	}
	
	@Test (expected=AssertionError.class)
	public void hashCodeInCorrect () {
		int hs = 4+5+w1.hashCode()+1;
		
		System.out.println("Test: Testing hashCode() test #2");
		System.out.println("\tExpected result: AssertionError");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 3, 4);'");
		System.out.println("\t\t'int hs = 3+4+w1.hashCode()+1;'");
		System.out.println("\t\t'assertEquals(hs,c2.hashCode());'");
		
		c2 = new Coordinate (w1, 3, 4);
		
		if (hs != c2.hashCode()) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertEquals(hs,c2.hashCode());
	}
	
	@Test
	public void hashCodeCorrectWrapX () {
		int hs = 4+w1.hashCode();
		
		System.out.println("Test: Testing hashCode() with wrapping on x dimension - test #1");
		System.out.println("\tExpected result: hashcode returns " + hs);
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 4, 4);'");
		System.out.println("\t\t'int hs = 4+w1.hashCode();'");
		System.out.println("\t\t'assertEquals(hs,c2.hashCode());'");
		
		c2 = new Coordinate (w1, 4, 4); //wrapping will give x=0, y=4
		
		if (hs == c2.hashCode()) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertEquals(hs,c2.hashCode());
	}
	
	@Test (expected=AssertionError.class)
	public void hashCodeInCorrectWrapX () {
		
		System.out.println("Test: Testing hashCode() with wrapping on x dimension - test #2");
		System.out.println("\tExpected result:Assertion Error");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 4, 4);'");
		System.out.println("\t\t'int hs = 4+5w1.hashCode();'");
		System.out.println("\t\t'assertEquals(hs,c2.hashCode());'");
		
		c2 = new Coordinate (w1, 4, 4); //wrapping will give x=0, y=4
		int hs = 4+5+w1.hashCode();
		
		if (hs != c2.hashCode()) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertEquals(hs,c2.hashCode());
	}
	
	@Test
	public void hashCodeCorrectWrapY () {
		int hs = 3+w1.hashCode();
		
		System.out.println("Test: Testing hashCode() with wrapping on y dimension");
		System.out.println("\tExpected result: hashcode returns " + hs);
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 3, 5);'");
		System.out.println("\t\t'int hs = 3+w1.hashCode();'");
		System.out.println("\t\t'assertEquals(hs,c2.hashCode());'");
		
		c2 = new Coordinate (w1, 3, 5); //wrapping will give x=3, y=0
		
		if (hs == c2.hashCode()) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertEquals(hs,c2.hashCode());
	}
	
	@Test (expected=AssertionError.class)
	public void hashCodeInCorrectWrapY () {
		
		System.out.println("Test: Testing hashCode() with wrapping on y dimension - test #2");
		System.out.println("\tExpected result: AssertionError");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 3, 5);'");
		System.out.println("\t\t'int hs = 4+5+w1.hashCode();'");
		System.out.println("\t\t'assertEquals(hs,c2.hashCode());'");
		
		c2 = new Coordinate (w1, 3, 5); //wrapping will give x=3, y=0
		int hs = 4+5+w1.hashCode();
		
		if (hs != c2.hashCode()) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertEquals(hs,c2.hashCode());
	}
	
	@Test
	public void hashCodeCorrectWrapXY () {
		int hs = w1.hashCode();
		
		System.out.println("Test: Testing hashCode() with wrapping on both x and y dimensions");
		System.out.println("\tExpected result: hashcode returns " + hs);
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 4, 5);'");
		System.out.println("\t\t'int hs = w1.hashCode();'");
		System.out.println("\t\t'assertEquals(hs,c2.hashCode());'");
		
		c2 = new Coordinate (w1, 4, 5); //wrapping will give x=0, y=0
		
		if (hs == c2.hashCode()) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertEquals(hs,c2.hashCode());
	}
	
	
	@Test (expected=AssertionError.class)
	public void hashCodeInCorrectWrapXY () {
		System.out.println("Test: Testing hashCode() with wrapping on both x and y dimensions");
		System.out.println("\tExpected result: AssertionError");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 4, 5);'");
		System.out.println("\t\t'int hs = 4+5+w1.hashCode();'");
		System.out.println("\t\t'assertEquals(hs,c2.hashCode());'");
		
		c2 = new Coordinate (w1, 4, 5); //wrapping will give x=0, y=0
		int hs = 4+5+w1.hashCode();
		
		if (hs != c2.hashCode()) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertEquals(hs,c2.hashCode());
	}
	
	/***************North, East, South, and West****************/
	
	@Test 
	public void checkNorth () {
		System.out.println("Test: Testing north() ");
		System.out.println("\tExpected result: Coordinate returned will be correct");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 2, 3);'");
		System.out.println("\t\t'Coordinate expected = new Coordinate (w1, 2,4);'");
		System.out.println("\t\t'assertTrue(expected.equals(c2.north()));'");
		
		c2 = new Coordinate (w1, 2, 3);
		Coordinate expected = new Coordinate (w1, 2,4);
		
		if (expected.equals(c2.north())) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(expected.equals(c2.north()));
	}
	
	@Test 
	public void checkEast () {
		System.out.println("Test: Testing east() ");
		System.out.println("\tExpected result: Coordinate returned will be correct");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 2, 3);'");
		System.out.println("\t\t'Coordinate expected = new Coordinate (w1, 3, 3);'");
		System.out.println("\t\t'assertTrue(expected.equals(c2.east()));'");
		
		c2 = new Coordinate (w1, 2, 3);
		Coordinate expected = new Coordinate (w1, 3, 3);
		
		if (expected.equals(c2.east())) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(expected.equals(c2.east()));
	}
	
	@Test 
	public void checkSouth () {
		System.out.println("Test: Testing south() ");
		System.out.println("\tExpected result: Coordinate returned will be correct");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 2, 3);'");
		System.out.println("\t\t'Coordinate expected = new Coordinate (w1, 2, 2);'");
		System.out.println("\t\t'assertTrue(expected.equals(c2.south()));'");
		
		c2 = new Coordinate (w1, 2, 3);
		Coordinate expected = new Coordinate (w1, 2, 2);
		
		if (expected.equals(c2.south())) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(expected.equals(c2.south()));
	}
	
	@Test 
	public void checkWest () {
		System.out.println("Test: Testing south() ");
		System.out.println("\tExpected result: Coordinate returned will be correct");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 2, 3);'");
		System.out.println("\t\t'Coordinate expected = new Coordinate (w1, 1, 3);'");
		System.out.println("\t\t'assertTrue(expected.equals(c2.west()));'");
		
		
		c2 = new Coordinate (w1, 2, 3);
		Coordinate expected = new Coordinate (w1, 1, 3);
		
		if (expected.equals(c2.west())) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(expected.equals(c2.west()));
	}
	
	
	
	@Test 
	public void souththEastNorthWestLLBoundary () { // lower left boundary
		System.out.println("Test: Testing lower Left boundary ");
		System.out.println("\tExpected result: Coordinate returned will be correct");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 0, 0);'");
		System.out.println("\t\t'assertTrue(c2.equals(c2.south().east().north().west()));'");
		
		c2 = new Coordinate (w1, 0, 0);
		
		if (c2.equals(c2.south().east().north().west())) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(c2.equals(c2.south().east().north().west()));
	}
	
	@Test 
	public void southEastNorthWestLRBoundary () { // lower right boundary
		System.out.println("Test: Testing lower Right boundary ");
		System.out.println("\tExpected result: Coordinate returned will be correct");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 0, 4);'");
		System.out.println("\t\t'assertTrue(c2.equals(c2.south().east().north().west()));'");
		
		c2 = new Coordinate (w1, 0, 4);
		
		if (c2.equals(c2.south().east().north().west())) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(c2.equals(c2.south().east().north().west()));
	}
	
	@Test 
	public void northEastSouthWestULBoundary () { // Upper left boundary
		System.out.println("Test: Testing Upper Left boundary ");
		System.out.println("\tExpected result: Coordinate returned will be correct");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 3, 0);'");
		System.out.println("\t\t'assertTrue(c2.equals(c2.north().east().south().west()));'");
		
		c2 = new Coordinate (w1, 3, 0);
		
		if (c2.equals(c2.north().east().south().west())) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(c2.equals(c2.north().east().south().west()));
	}
	
	@Test 
	public void northEastSouthWestURBoundary () { // upper right boundary
		System.out.println("Test: Testing Upper Right boundary ");
		System.out.println("\tExpected result: Coordinate returned will be correct");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c2 = new Coordinate (w1, 3, 4);'");
		System.out.println("\t\t'assertTrue(c2.equals(c2.north().east().south().west()));'");
		
		c2 = new Coordinate (w1, 3, 4);
		
		if (c2.equals(c2.north().east().south().west())) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");
		
		assertTrue(c2.equals(c2.north().east().south().west()));
	}
	
	/***************toString()****************/
	
	@Test (expected=NullPointerException.class)
	public void toStringNullCoordinate () { // upper right boundary
		System.out.println("Test: Testing toString() on a null Coordinate" );
		System.out.println("\tExpected result: NullPointerException");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'String s3 = c3.toString();");
		
		try {
			String s3 = c3.toString();
		}
		catch (NullPointerException npe) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points+= 0.1;
			passed +=1;
			String s3 = c3.toString(); // throw error again
			//System.out.println(s3);
		}
		System.out.println("\tTest failed: 0.0/0.1 points\n");
	}
	
	@Test //(expected=NullPointerException.class)
	public void toStringNotNullCoordinate () { // upper right boundary
		System.out.println("Test: Testing toString() on a non-null Coordinate" );
		System.out.println("\tExpected result: returned string in not null");
		System.out.println("\tExecuting: ");
		System.out.println("\t\t'c3 = new Coordinate (w1, 3, 4);");
		System.out.println("\t\t'String s3 = c3.toString();");
		System.out.println("\t\t'assertTrue (!s3.equals(null));");
		
		c3 = new Coordinate (w1, 3, 4);
		String s3 = c3.toString();
		
		if (!s3.equals(null)) {
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points += 0.1;
			passed +=1;
		}
		else 
			System.out.println("\tTest failed: 0/0.1 points\n");

		assertTrue (!s3.equals(null));
	}
	
	
	/***************toString***********************************/
	
	
	/************************************************************
	 * 			Manual TESTS
	 ************************************************************/
	@Test
	public void newCoordinateNegativeXorY () {
		System.out.println("Test: Create new Coordinate with negative x, or y, or both.");
		System.out.println("\tExpected result: IllegalArgumentException");
		try {
			System.out.println("\tExecuting: Has student identified that any of the following should be handled?");
			System.out.println("\t\t'c2 = new Coordinate (w1, -4, 5);' ");
			System.out.println("\t\t'c2 = new Coordinate (w1, 4, -5);' ");
			System.out.println("\t\t'c2 = new Coordinate (w1, -4, -5);' "); 
		}
		finally {
			//Manually check if student dealt with these cases and delete line that is not applicable
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points+= 0.1;
			passed +=1;
			//System.out.println("\tTest failed: 0.0/0.1 points\n");
			////Remember to subtract points from the total if this test fails
		}
	}	
	

	
	@Test
	public void getAndPutNullObjects () {
		System.out.println("Test: Get/Put null Object");
		System.out.println("\tExpected result: NullPointerException/ IllegalArgementException");
		try {
			System.out.println("\tExecuting: Does student identify that nulls have to be dealt with");
		}
		finally {
			//Manually check if student dealt with these cases and delete line that is not applicable
			System.out.println("\tTest passed: +0.1/0.1 points\n");
			points+= 0.1;
			passed +=1;
			
			//System.out.println("\tTest failed: 0.0/0.1 points\n");
			//Remember to subtract points from the total if this test fails
		}
	}	
	
	
	
	/************************************************************
	 * 			RUN TESTS
	 ************************************************************/
	public static void main (String args[]) {
		org.junit.runner.JUnitCore.main(CoordinateTestg.class.getName());
	}
}
package src;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlgorithmicsTest {

	@Test
	public void testFactorial() {
		assertEquals(720, Algorithms.factorial(6));
	}
	
	@Test
	public void testFactorialRecursive() {
		assertEquals (720, Algorithms.factorialRec(6));
	}
	
	@Test
	public void testPow() {
		assertEquals (1099511627776L, Algorithms.pow(40));
	}
	
	@Test
	public void testPow1() {
		assertEquals (4L, Algorithms.powRec1(2));
	}
	
	@Test
	public void testPowRecursive2() {
		assertEquals (1099511627776L, Algorithms.powRec2(40));
	}
	
	@Test
	public void testPowRecursive3() {
		assertEquals (1099511627776L, Algorithms.powRec3(40));
	}
	
	@Test
	public void testPowRecursive4() {
		assertEquals (1099511627776L, Algorithms.powRec3(40));
	}

}

package src.graphs.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.graphs.Container;


public class ContainerTest {

	Container<String> StringContainer = null;
	Container<Integer> IntegerContainer = null;
	Container<Character> CharContainer = null;
	
	@Before
	public void setUp() {
		StringContainer = new Container<String>("");
		IntegerContainer = new Container<Integer>(2);
		CharContainer = new Container<Character>('A');
	}
	
	@Test
	public void setStringElementTest() {
		StringContainer.setElement("Hola caracola");
		assertEquals("Hola caracola", StringContainer.getElement());
		StringContainer.setElement(null);
		assertEquals("Hola caracola", StringContainer.getElement());
		StringContainer.setElement("");
		assertEquals("", StringContainer.getElement());
	}
	
	@Test
	public void setIntegerElementTest() {
		IntegerContainer.setElement(5);
		assertEquals(5, (int) IntegerContainer.getElement());
		IntegerContainer.setElement(null);
		assertEquals(5, (int) IntegerContainer.getElement());
		IntegerContainer.setElement(4);
		assertEquals(4, (int) IntegerContainer.getElement());
	}
	@Test
	public void setCharElementTest() {
		CharContainer.setElement('B');
		assertEquals('B', (char) CharContainer.getElement());
		CharContainer.setElement(null);
		assertEquals('B', (char) CharContainer.getElement());
		CharContainer.setElement('C');
		assertEquals('C', (int) CharContainer.getElement());
	}

	@Test
	public void getStringElementTest() {
		StringContainer.setElement("Hola caracola");
		assertEquals("Hola caracola", StringContainer.getElement());
	}
	
	@Test
	public void getIntegerElementTest() {
		IntegerContainer.setElement(5);
		assertEquals(5, (int) IntegerContainer.getElement());
	}
	
	@Test
	public void getCharElementTest() {
		CharContainer.setElement('D');
		assertEquals('D', (char) CharContainer.getElement());
	}
	
	@Test
	public void toStringTest() {
		StringContainer.setElement("Hola caracola");
		IntegerContainer.setElement(5);
		CharContainer.setElement('G');
		assertEquals("Hola caracola", StringContainer.toString());
		assertEquals("5", IntegerContainer.toString());
		assertEquals("G", CharContainer.toString());
	}
}

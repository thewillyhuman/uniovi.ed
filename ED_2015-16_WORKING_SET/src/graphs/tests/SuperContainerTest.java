package graphs.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import graphs.Container;
import graphs.SuperContainer;

public class SuperContainerTest<T, U> {

	private SuperContainer<Container<String>, String> StringStringSuperContainer;
	private SuperContainer<Container<String>, Integer> StringIntegerSuperContainer;
	private SuperContainer<Container<String>, Character> StringCharSuperContainer;

	private SuperContainer<Container<Integer>, String> IntegerStringSuperContainer;
	private SuperContainer<Container<Integer>, Integer> IntegerIntegerSuperContainer;
	private SuperContainer<Container<Integer>, Character> IntegerCharSuperContainer;

	private SuperContainer<Container<Character>, String> CharStringSuperContainer;
	private SuperContainer<Container<Character>, Integer> CharIntegerSuperContainer;
	private SuperContainer<Container<Character>, Character> CharCharSuperContainer;
	
	//private SuperContainer<GenericDataStructure<U>, String> whatEver;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
	public void setUp() {
		// Container<String>
		Container StringContainer = new Container("A");
		StringStringSuperContainer = new SuperContainer<Container<String>, String>(StringContainer, "B", 1);
		StringIntegerSuperContainer = new SuperContainer<Container<String>, Integer>(StringContainer, 1, 1);
		StringCharSuperContainer = new SuperContainer<Container<String>, Character>(StringContainer, 'B', 1);

		// Container<Integer>
		Container IntegerContainer = new Container(1);
		IntegerStringSuperContainer = new SuperContainer<Container<Integer>, String>(IntegerContainer, "B", 1);
		IntegerIntegerSuperContainer = new SuperContainer<Container<Integer>, Integer>(IntegerContainer, 1, 1);
		IntegerCharSuperContainer = new SuperContainer<Container<Integer>, Character>(IntegerContainer, 'B', 1);

		// Container<Character>
		Container CharContainer = new Container('A');
		CharStringSuperContainer = new SuperContainer<Container<Character>, String>(CharContainer, "B", 1);
		CharIntegerSuperContainer = new SuperContainer<Container<Character>, Integer>(CharContainer, 1, 1);
		CharCharSuperContainer = new SuperContainer<Container<Character>, Character>(CharContainer, 'B', 1);
		
		//Development...
		//Container<T> TContainer = new Container("pepe");
		//whatEver = new SuperContainer<GenericDataStructure<U>, String>(TContainer, "B", 1);
	}

	@Test
	public void getContainerTest() {
		// Container<String>
		assertEquals("A", StringStringSuperContainer.getContainer().getElement());
		assertEquals("A", StringIntegerSuperContainer.getContainer().getElement());
		assertEquals("A", StringCharSuperContainer.getContainer().getElement());

		// Container<Integer>
		assertEquals(1, IntegerStringSuperContainer.getContainer().getElement());
		assertEquals(1, IntegerIntegerSuperContainer.getContainer().getElement());
		assertEquals(1, IntegerCharSuperContainer.getContainer().getElement());

		// Container<Integer>
		assertEquals('A', CharStringSuperContainer.getContainer().getElement());
		assertEquals('A', CharIntegerSuperContainer.getContainer().getElement());
		assertEquals('A', CharCharSuperContainer.getContainer().getElement());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void setContainerTest() {
		// Container<String>
		// -String
		assertEquals("A", StringStringSuperContainer.getContainer().getElement());
		StringStringSuperContainer.setContainer(new Container("B"));
		assertEquals("B", StringStringSuperContainer.getContainer().getElement());

		// -Integer
		assertEquals("A", StringIntegerSuperContainer.getContainer().getElement());
		StringIntegerSuperContainer.setContainer(new Container("B"));
		assertEquals("B", StringIntegerSuperContainer.getContainer().getElement());

		// -Character
		assertEquals("A", StringCharSuperContainer.getContainer().getElement());
		StringCharSuperContainer.setContainer(new Container("B"));
		assertEquals("B", StringCharSuperContainer.getContainer().getElement());

		// Container<Integer>
		// -String
		assertEquals(1, IntegerStringSuperContainer.getContainer().getElement());
		IntegerStringSuperContainer.setContainer(new Container(2));
		assertEquals(2, IntegerStringSuperContainer.getContainer().getElement());

		// -Integer
		assertEquals(1, IntegerIntegerSuperContainer.getContainer().getElement());
		IntegerIntegerSuperContainer.setContainer(new Container(2));
		assertEquals(2, IntegerIntegerSuperContainer.getContainer().getElement());

		// -Character
		assertEquals(1, IntegerCharSuperContainer.getContainer().getElement());
		IntegerCharSuperContainer.setContainer(new Container(2));
		assertEquals(2, IntegerCharSuperContainer.getContainer().getElement());

		// Container<Integer>
		// -String
		assertEquals('A', CharStringSuperContainer.getContainer().getElement());
		CharStringSuperContainer.setContainer(new Container('B'));
		assertEquals('B', CharStringSuperContainer.getContainer().getElement());

		// -Integer
		assertEquals('A', CharIntegerSuperContainer.getContainer().getElement());
		CharIntegerSuperContainer.setContainer(new Container('B'));
		assertEquals('B', CharIntegerSuperContainer.getContainer().getElement());

		// -Character
		assertEquals('A', CharCharSuperContainer.getContainer().getElement());
		CharCharSuperContainer.setContainer(new Container('B'));
		assertEquals('B', CharCharSuperContainer.getContainer().getElement());
	}

	@Test
	public void getInfoTest() {
		// Container<String>
		assertEquals("B", StringStringSuperContainer.getInfo());
		assertEquals(1, (int) StringIntegerSuperContainer.getInfo());
		assertEquals('B', (char) StringCharSuperContainer.getInfo());

		// Container<Integer>
		assertEquals("B", IntegerStringSuperContainer.getInfo());
		assertEquals(1, (int) IntegerIntegerSuperContainer.getInfo());
		assertEquals('B', (char) IntegerCharSuperContainer.getInfo());

		// Container<Integer>
		assertEquals("B", CharStringSuperContainer.getInfo());
		assertEquals(1, (int) CharIntegerSuperContainer.getInfo());
		assertEquals('B', (char) CharCharSuperContainer.getInfo());
	}

	@Test
	public void setInfoTest() {
		// Container<String>
		// -String
		assertEquals("B", StringStringSuperContainer.getInfo());
		StringStringSuperContainer.setInfo("C");
		assertEquals("C", StringStringSuperContainer.getInfo());

		// -Integer
		assertEquals(1, (int) StringIntegerSuperContainer.getInfo());
		StringIntegerSuperContainer.setInfo(2);
		assertEquals(2, (int) StringIntegerSuperContainer.getInfo());

		// -Character
		assertEquals('B', (char) StringCharSuperContainer.getInfo());
		StringCharSuperContainer.setInfo('C');
		assertEquals('C', (char) StringCharSuperContainer.getInfo());

		// Container<Integer>
		// -String
		assertEquals("B", IntegerStringSuperContainer.getInfo());
		IntegerStringSuperContainer.setInfo("C");
		assertEquals("C", IntegerStringSuperContainer.getInfo());

		// -Integer
		assertEquals(1, (int) IntegerIntegerSuperContainer.getInfo());
		IntegerIntegerSuperContainer.setInfo(2);
		assertEquals(2, (int) IntegerIntegerSuperContainer.getInfo());

		// -Character
		assertEquals('B', (char) IntegerCharSuperContainer.getInfo());
		IntegerCharSuperContainer.setInfo('C');
		assertEquals('C', (char) IntegerCharSuperContainer.getInfo());

		// Container<Integer>
		// -String
		assertEquals("B", CharStringSuperContainer.getInfo());
		CharStringSuperContainer.setInfo("C");
		assertEquals("C", CharStringSuperContainer.getInfo());

		// -Integer
		assertEquals(1, (int) CharIntegerSuperContainer.getInfo());
		CharIntegerSuperContainer.setInfo(2);
		assertEquals(2, (int) CharIntegerSuperContainer.getInfo());

		// -Character
		assertEquals('B', (char) CharCharSuperContainer.getInfo());
		CharCharSuperContainer.setInfo('C');
		assertEquals('C', (char) CharCharSuperContainer.getInfo());

	}

	@Test
	public void getKeyTest() {
		// Container<String>
		assertEquals(1, StringStringSuperContainer.getKey());
		assertEquals(1, (int) StringIntegerSuperContainer.getKey());
		assertEquals(1, (char) StringCharSuperContainer.getKey());

		// Container<Integer>
		assertEquals(1, IntegerStringSuperContainer.getKey());
		assertEquals(1, (int) IntegerIntegerSuperContainer.getKey());
		assertEquals(1, (char) IntegerCharSuperContainer.getKey());

		// Container<Integer>
		assertEquals(1, CharStringSuperContainer.getKey());
		assertEquals(1, (int) CharIntegerSuperContainer.getKey());
		assertEquals(1, (char) CharCharSuperContainer.getKey());
	}

	@Test
	public void setKeyTest() {
		// Container<String>
		// -String
		assertEquals(1, StringStringSuperContainer.getKey());
		StringStringSuperContainer.setKey(2);
		assertEquals(2, StringStringSuperContainer.getKey());

		// -Integer
		assertEquals(1, StringIntegerSuperContainer.getKey());
		StringIntegerSuperContainer.setKey(2);
		assertEquals(2, (int) StringIntegerSuperContainer.getKey());

		// -Character
		assertEquals(1, StringCharSuperContainer.getKey());
		StringCharSuperContainer.setKey(2);
		assertEquals(2, StringCharSuperContainer.getKey());

		// Container<Integer>
		// -String
		assertEquals(1, IntegerStringSuperContainer.getKey());
		IntegerStringSuperContainer.setKey(2);
		assertEquals(2, IntegerStringSuperContainer.getKey());

		// -Integer
		assertEquals(1, IntegerIntegerSuperContainer.getKey());
		IntegerIntegerSuperContainer.setKey(2);
		assertEquals(2, (int) IntegerIntegerSuperContainer.getKey());

		// -Character
		assertEquals(1, IntegerCharSuperContainer.getKey());
		IntegerCharSuperContainer.setKey(2);
		assertEquals(2, (char) IntegerCharSuperContainer.getKey());

		// Container<Integer>
		// -String
		assertEquals(1, CharStringSuperContainer.getKey());
		CharStringSuperContainer.setKey(2);
		assertEquals(2, CharStringSuperContainer.getKey());

		// -Integer
		assertEquals(1, CharIntegerSuperContainer.getKey());
		CharIntegerSuperContainer.setKey(2);
		assertEquals(2, CharIntegerSuperContainer.getKey());

		// -Character
		assertEquals(1, CharCharSuperContainer.getKey());
		CharCharSuperContainer.setKey(2);
		assertEquals(2, CharCharSuperContainer.getKey());
	}

	@Test
	public void toStringTest() {
		// Container<String>
		assertEquals("A, B, 1", StringStringSuperContainer.toString());
		assertEquals("A, 1, 1", StringIntegerSuperContainer.toString());
		assertEquals("A, B, 1", StringCharSuperContainer.toString());

		// Container<Integer>
		assertEquals("1, B, 1", IntegerStringSuperContainer.toString());
		assertEquals("1, 1, 1", IntegerIntegerSuperContainer.toString());
		assertEquals("1, B, 1", IntegerCharSuperContainer.toString());

		// Container<Integer>
		assertEquals("A, B, 1", CharStringSuperContainer.toString());
		assertEquals("A, 1, 1", CharIntegerSuperContainer.toString());
		assertEquals("A, B, 1", CharCharSuperContainer.toString());
	}

}

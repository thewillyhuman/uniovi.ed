package avlTrees.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import avlTrees.AVLTree;

public class AVLTreeTest {

	AVLTree<String> stringTree;
	AVLTree<Integer> integerTree;
	AVLTree<Character> charTree;

	@Before
	public void setUp() {
		stringTree = new AVLTree<String>();
		integerTree = new AVLTree<Integer>();
		charTree = new AVLTree<Character>();
	}

	@Test
	public void addTest() {

		// Chars...
		assertEquals("-", charTree.toString());
		charTree.add('b');
		assertEquals("b--", charTree.toString());
		charTree.add('a');
		assertEquals("ba---", charTree.toString());
		charTree.add('d');
		assertEquals("ba--d--", charTree.toString());
		charTree.add('c');
		assertEquals("ba--dc---", charTree.toString());
		charTree.add('g');
		assertEquals("ba--dc--g--", charTree.toString());
		charTree.add('i');
		assertEquals("ba--dc--g-i--", charTree.toString());
		charTree.add('h');
		assertEquals("ba--dc--g-ih---", charTree.toString());

		// Testing Exceptions...
		try {
			stringTree.add(null);
			integerTree.add(null);
			charTree.add(null);
			fail("An exception should be thrown when adding null objects");
		} catch (Exception e) {
			System.out.println(e + " | DON'T WORRY IT'S A TEST");
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void addIterativeTest() {

		// Chars...
		assertEquals("-", charTree.toString());
		charTree.addIterative('b');
		assertEquals("b--", charTree.toString());
		charTree.addIterative('a');
		assertEquals("ba---", charTree.toString());
		charTree.addIterative('d');
		assertEquals("ba--d--", charTree.toString());
		charTree.addIterative('c');
		assertEquals("ba--dc---", charTree.toString());
		charTree.addIterative('g');
		assertEquals("ba--dc--g--", charTree.toString());
		charTree.addIterative('i');
		assertEquals("ba--dc--g-i--", charTree.toString());
		charTree.addIterative('h');
		assertEquals("ba--dc--g-ih---", charTree.toString());

		// Testing Exceptions...
		try {
			stringTree.addIterative(null);
			integerTree.addIterative(null);
			charTree.addIterative(null);
			fail("An exception should be thrown when adding null objects");
		} catch (Exception e) {
			System.out.println(e + " | DON'T WORRY IT'S A TEST");
		}
	}

	@Test
	public void searchTest() {

		// Chars...
		charTree.add('b');
		charTree.add('a');
		charTree.add('d');
		charTree.add('c');
		charTree.add('g');
		charTree.add('i');
		charTree.add('h');

		assertEquals(true, charTree.search('i'));
		assertEquals(false, charTree.search('f'));

		// Empty tree.
		assertEquals(false, integerTree.search(1));

		integerTree.add(9);
		integerTree.add(8);
		integerTree.add(7);
		integerTree.add(6);
		integerTree.add(5);
		integerTree.add(4);
		integerTree.add(3);
		integerTree.add(2);
		integerTree.add(1);
		assertEquals(true, integerTree.search(1));
		assertEquals(false, integerTree.search(10));

		stringTree.add("a");
		stringTree.add("b");
		stringTree.add("c");
		stringTree.add("d");
		stringTree.add("e");
		stringTree.add("f");
		stringTree.add("g");
		stringTree.add("h");
		assertEquals(true, stringTree.search("h"));
		assertEquals(false, stringTree.search("j"));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void searchIterativeTest() {

		// Chars...
		charTree.add('b');
		charTree.add('a');
		charTree.add('d');
		charTree.add('c');
		charTree.add('g');
		charTree.add('i');
		charTree.add('h');

		assertEquals(true, charTree.searchIterative('i'));
		assertEquals(false, charTree.searchIterative('f'));

		// Integers...
		// Empty tree.
		assertEquals(false, integerTree.searchIterative(1));

		integerTree.add(9);
		integerTree.add(8);
		integerTree.add(7);
		integerTree.add(6);
		integerTree.add(5);
		integerTree.add(4);
		integerTree.add(3);
		integerTree.add(2);
		integerTree.add(1);
		assertEquals(true, integerTree.searchIterative(1));
		assertEquals(false, integerTree.searchIterative(10));

		// Strings...
		stringTree.add("a");
		stringTree.add("b");
		stringTree.add("c");
		stringTree.add("d");
		stringTree.add("e");
		stringTree.add("f");
		stringTree.add("g");
		stringTree.add("h");
		// Elements in and out the tree.
		assertEquals(true, stringTree.searchIterative("h"));
		assertEquals(false, stringTree.searchIterative("j"));
	}

	@Test
	public void getMaxTest() {

		// Complete tree
		charTree.add('b');
		charTree.add('a');
		charTree.add('d');
		charTree.add('c');
		charTree.add('g');
		charTree.add('i');
		charTree.add('h');
		assertEquals('i', (char) charTree.getMax());

		// Empty tree
		assertEquals(null, integerTree.getMax());

	}

	@Test
	public void inOrderTraversalTest() {
		// Complete tree.
		integerTree.add(5);
		integerTree.add(3);
		integerTree.add(7);
		integerTree.add(6);
		integerTree.add(9);
		assertEquals("-3-5-6-7-9-", integerTree.inOrderTraversal());

		// Empty tree
		assertEquals("-", stringTree.inOrderTraversal());

		// Only one element
		charTree.add('a');
		assertEquals("-a-", charTree.inOrderTraversal());
	}

	@Test
	public void postOrderTraversalTest() {
		// Complete tree.
		integerTree.add(5);
		integerTree.add(3);
		integerTree.add(7);
		integerTree.add(6);
		integerTree.add(9);

		assertEquals("--3--6--975", integerTree.postOrderTraversal());

		// Empty tree
		assertEquals("-", stringTree.postOrderTraversal());

		// Only one element
		charTree.add('a');
		assertEquals("--a", charTree.postOrderTraversal());
	}

}

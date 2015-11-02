package com.guille.ed.avlTrees.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.guille.ed.avlTrees.AVLTree;

/**
 * 
 * @author Guillermo facundo Colunga
 * @version carlos.2
 */
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
	
	/**
	 * Test for the search method. Creates a new AVL tree, adds some nodes and runs the method for some of them that exists
	 * and also for some of them that does not exists and for some exceptions.
	 * @throws Exception
	 */
	@Test
	public void searchSecondTest() throws Exception {
		System.out.println("------------- Inicializing the searchTest() method -------------\n");
		//Creating a tree.
		AVLTree<Character> b = new AVLTree<Character>();
		
		//Some nodes to the AVL tree b.
		b.add('b');
		b.add('a');
		b.add('c');
		b.add('f');
		System.out.println("Current working tree: "+b.toString()+"\n");
		assertEquals ("ba--c-f--", b.toString());
		
		//Possitive testing
		System.out.println("Positive testing starting... ");
		assertEquals(true, b.search('c'));
		System.out.println("The result of searching 'c' is.... "+b.search('c')+" | assertEquals : true");
		assertEquals(true, b.search('b'));
		System.out.println("The result of searching 'b' is.... "+b.search('b')+" | assertEquals : true");
		assertEquals(true, b.search('a'));
		System.out.println("The result of searching 'a' is.... "+b.search('a')+" | assertEquals : true");
		assertEquals(true, b.search('f'));
		System.out.println("The result of searching 'f' is.... "+b.search('f')+" | assertEquals : true"+"\n");
		
		//Negative testing
			//1srt - Part with assertNotEquals.
		System.out.println("Negative testing starting... ");
		System.out.println("1srt - Part ");
		assertNotSame(false, b.search('c'));
		System.out.println("The result of searching 'c' is.... "+b.search('c')+" | assertNotSame : false");
		assertNotSame(false, b.search('b'));
		System.out.println("The result of searching 'b' is.... "+b.search('b')+" | assertNotSame : false");
		assertNotSame(false, b.search('a'));
		System.out.println("The result of searching 'a' is.... "+b.search('a')+" | assertNotSame : false");
		assertNotSame(false, b.search('f'));
		System.out.println("The result of searching 'f' is.... "+b.search('f')+" | assertNotSame : false"+"\n");
		
		//2nd - Part with assertEquals and trying exceptions.
		System.out.println("2nd - Part ");
		assertEquals(false, b.search('g'));
		System.out.println("The result of searching 'g' is....  "+b.search('g')+" | assertEquals : false");
		assertEquals(false, b.search(null));
		System.out.println("The result of searching 'null' is.... "+b.search(null)+" | assertEquals : false");
		assertEquals(false, b.search(' '));
		System.out.println("The result of searching ' ' is.... "+b.search(' ')+" | assertEquals : false");
		assertEquals(false, b.search('0'));
		System.out.println("The result of searching '0' is.... "+b.search('0')+" | assertEquals : false");
		assertEquals(false, b.search('/'));
		System.out.println("The result of searching '/' is.... "+b.search('/')+" | assertEquals : false");
		assertEquals(false, b.search('@'));
		System.out.println("The result of searching '@' is.... "+b.search('@')+" | assertEquals : false"+"\n");
		
		System.out.println("------------- Ending OK the searchTest() method -------------\n");
	}
	
	@Test
	public void searchReturnTest() throws Exception {
		System.out.println("------------- Inicializing the searchReturnTest() method -------------\n");
		//Creating a tree.
		AVLTree<Character> c = new AVLTree<Character>();
		
		//Some nodes to the AVL tree c.
		c.add('b');
		c.add('a');
		c.add('c');
		c.add('f');
		System.out.println("Current working tree: "+c.toString()+"\n");
		assertEquals ("ba--c-f--", c.toString());
		
		//Positive testing
		System.out.print("Positive testing starting... ");
		assertEquals(c.getRoot().getElement(), c.searchReturn('b'));
		assertEquals(c.getRoot().getLeft().getElement(), c.searchReturn('a'));
		assertEquals(c.getRoot().getRight().getElement(), c.searchReturn('c'));
		assertEquals(c.getRoot().getRight().getRight().getElement(), c.searchReturn('f'));
		System.out.println("PASSED");
		
		//Negative testing
		System.out.print("Negative testing starting... ");
		assertNotSame(c.getRoot().getElement(), c.searchReturn('c'));
		assertNotSame(c.getRoot().getElement(), c.searchReturn('a'));
		assertNotSame(c.getRoot().getRight().getRight().getElement(), c.searchReturn('b'));
		System.out.println("PASSED");
		
		//All test OK
		System.out.println("Possitive and negative tests... PASSED\n");
		
		System.out.println("------------- Ending OK the searchReturnTest() method -------------\n");
	}
	
	@Test
	public void getMaxSecondTest()
	{
		System.out.println("------------- Inicializing the getMaxTest() method -------------\n");
		//Creating a tree.
		AVLTree<Character> d = new AVLTree<Character>();
	
		//Some nodes to the AVL tree c.
		d.add('b');
		d.add('a');
		d.add('d');
		d.add('c');
		System.out.println("Current working tree: "+d.toString()+"\n");
		
		//Positive testing
		System.out.print("Positive testing starting... ");
		assertEquals('d', (char) d.getMax());
		System.out.println("PASSED");
		
		//Negative Testing
		System.out.print("Negative testing starting... ");
		assertNotSame('a', (char) d.getMax());
		assertNotSame('b', (char) d.getMax());
		assertNotSame('c', (char) d.getMax());
		System.out.println("PASSED\n");
		
		System.out.println("------------- Ending OK the getMaxTest() method -------------\n");
	}

}

package com.guille.ed.avlTrees.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.guille.ed.avlTrees.AVLTree;


public class L6_ALVTreeTestOptionalHomework {

	@SuppressWarnings("deprecation")
	@Test
	public void testAddIterative() {
		AVLTree<String> t = new AVLTree<String>();
		t.addIterative("b");
		assertEquals("b--", t.toString());
	
		t.addIterative("a");
		assertEquals("ba---", t.toString());
		
		t.addIterative("d");
		assertEquals("ba--d--", t.toString());
		
		t.addIterative("c");
		assertEquals("ba--dc---", t.toString());
		
		t.addIterative("g");
		assertEquals("ba--dc--g--", t.toString());
		
		t.addIterative("i");
		assertEquals("ba--dc--g-i--", t.toString());
		
		t.addIterative("h");
		assertEquals("ba--dc--g-ih---", t.toString());

		
		try{
			t.add("a");
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSearchIterative(){
		AVLTree<String> t = new AVLTree<String>();
		
		// Searching in an empty tree
		// -
		assertEquals(false, t.search("a"));
		
		t.add("b");
		/*
		 * 		b
		 * 	-		-
		 * 	
		 */
		assertEquals(true, t.searchIterative("b"));
		assertEquals(false, t.searchIterative("a"));
		assertEquals(false, t.searchIterative("c"));
		
		t.add("a");
		/*
		 * 			b
		 *
		 * 		a		-
		 *
		 * 	-		-
		 * 
		 */
		assertEquals(true, t.searchIterative("a"));
		assertEquals(true, t.searchIterative("b"));
		assertEquals(false, t.searchIterative("c"));
		
		t.add("d");
		/*
		 * 				b
		 *
		 * 		a				d
		 *
		 * 	-		-		-		-
		 * 
		 */
		assertEquals(true, t.searchIterative("d"));
		assertEquals(true, t.searchIterative("a"));
		assertEquals(true, t.searchIterative("b"));
		assertEquals(false, t.searchIterative("c"));
		assertEquals(false, t.searchIterative("e"));
		
		t.add("c");
		/*
		 * 					b
		 * 
		 * 			a					d
		 * 
		 * 		-		-			c		-
		 * 
		 * 						-		-
		 * 
		 */
		assertEquals(true, t.searchIterative("d"));
		assertEquals(true,t.searchIterative("a"));
		assertEquals(true, t.searchIterative("b"));
		assertEquals(true, t.searchIterative("c"));
		assertEquals(false, t.searchIterative("e"));
		
		t.add("g");
		/*
		 * 						b
		 * 
		 * 			a						d
		 * 
		 * 		-		-			c				g
		 * 
		 * 						-		-		-		-
		 * 
		 */
		assertEquals(true, t.searchIterative("d"));
		assertEquals(true, t.searchIterative("a"));
		assertEquals(true, t.searchIterative("b"));
		assertEquals(true, t.searchIterative("c"));
		assertEquals(true, t.searchIterative("g"));
		assertEquals(false, t.searchIterative("e"));
		assertEquals(false, t.searchIterative("h"));
		
		
		t.add("i");
		/*
		 * 						b
		 * 
		 * 			a						d
		 *
		 * 		-		-			c				g
		 * 
		 * 						-		-		-		i
		 * 
		 * 											-		-
		 * 
		 */
		assertEquals(true, t.searchIterative("d"));
		assertEquals(true, t.searchIterative("a"));
		assertEquals(true, t.searchIterative("b"));
		assertEquals(true, t.searchIterative("c"));
		assertEquals(true, t.searchIterative("g"));
		assertEquals(true, t.searchIterative("i"));
		assertEquals(false, t.searchIterative("e"));
		assertEquals(false, t.searchIterative("h"));
		assertEquals(false, t.searchIterative("j"));
		
		t.add("h");
		/*
		 * 						b
		 * 
		 * 			a						d
		 *
		 * 		-		-			c					g
		 * 
		 * 						-		-			-			i
		 * 
		 * 													h		-
		 * 						
		 * 												-		-
		 * 
		 */
		assertEquals(true, t.searchIterative("d"));
		assertEquals(true, t.searchIterative("a"));
		assertEquals(true, t.searchIterative("b"));
		assertEquals(true, t.searchIterative("c"));
		assertEquals(true, t.searchIterative("g"));
		assertEquals(true, t.searchIterative("i"));
		assertEquals(true, t.searchIterative("h"));
		assertEquals(false, t.searchIterative("e"));
		assertEquals(false, t.searchIterative("j"));
		
	}

	
	@Test
	public void testTraversals() {
		AVLTree<String> t = new AVLTree<String>();
		t.add("b");
		assertEquals("b--", t.toString());
	
		t.add("a");
		assertEquals("ba---", t.toString());
		
		t.add("d");
		assertEquals("ba--d--", t.toString());
		
		t.add("c");
		assertEquals("ba--dc---", t.toString());
		
		t.add("g");
		assertEquals("ba--dc--g--", t.toString());
		
		t.add("i");
		assertEquals("ba--dc--g-i--", t.toString());
		
		t.add("h");
		assertEquals("ba--dc--g-ih---", t.toString());

		assertEquals("-a-b-c-d-g-h-i-", t.inOrderTraversal());
		assertEquals("--a--c---h-igdb", t.postOrderTraversal());

	}
	
	
}

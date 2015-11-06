package com.guille.ed.avlTrees.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.guille.ed.avlTrees.AVLTree;


public class L6_ALVTreeTestBasicOperations {

	@Test
	public void testAdd() {
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
		
		//t.remove("b");
		//assertEquals ("a-dc--g-ih---", t.toString());
		//t.remove("g");
		//assertEquals ("a-dc--ih---", t.toString());

		
		try{
			t.add("a");
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	
	
	@Test
	public void testSearch(){
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
		assertEquals(true, t.search("b"));
		assertEquals(false, t.search("a"));
		assertEquals(false, t.search("c"));
		
		t.add("a");
		/*
		 * 			b
		 *
		 * 		a		-
		 *
		 * 	-		-
		 * 
		 */
		assertEquals(true, t.search("a"));
		assertEquals(true, t.search("b"));
		assertEquals(false, t.search("c"));
		
		t.add("d");
		/*
		 * 				b
		 *
		 * 		a				d
		 *
		 * 	-		-		-		-
		 * 
		 */
		assertEquals(true, t.search("d"));
		assertEquals(true, t.search("a"));
		assertEquals(true, t.search("b"));
		assertEquals(false, t.search("c"));
		assertEquals(false, t.search("e"));
		
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
		assertEquals(true, t.search("d"));
		assertEquals(true,t.search("a"));
		assertEquals(true, t.search("b"));
		assertEquals(true, t.search("c"));
		assertEquals(false, t.search("e"));
		
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
		assertEquals(true, t.search("d"));
		assertEquals(true, t.search("a"));
		assertEquals(true, t.search("b"));
		assertEquals(true, t.search("c"));
		assertEquals(true, t.search("g"));
		assertEquals(false, t.search("e"));
		assertEquals(false, t.search("h"));
		
		
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
		assertEquals(true, t.search("d"));
		assertEquals(true, t.search("a"));
		assertEquals(true, t.search("b"));
		assertEquals(true, t.search("c"));
		assertEquals(true, t.search("g"));
		assertEquals(true, t.search("i"));
		assertEquals(false, t.search("e"));
		assertEquals(false, t.search("h"));
		assertEquals(false, t.search("j"));
		
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
		assertEquals(true, t.search("d"));
		assertEquals(true, t.search("a"));
		assertEquals(true, t.search("b"));
		assertEquals(true, t.search("c"));
		assertEquals(true, t.search("g"));
		assertEquals(true, t.search("i"));
		assertEquals(true, t.search("h"));
		assertEquals(false, t.search("e"));
		assertEquals(false, t.search("j"));
		
	}
	
	
	
	
	@Test
	public void testGetMax(){
		
		AVLTree<String> t = new AVLTree<String>();
		
		// getMax on an empty tree
		assertEquals(null, t.getMax(t.getRoot()));

		t.add("b");
		t.add("a");
		t.add("d");
		t.add("c");
		t.add("g");
		t.add("i");
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
		
		assertEquals("i", t.getMax(t.getRoot()));
		assertEquals("a", t.getMax(t.getRoot().getLeft()));
		assertEquals("c", t.getMax(t.getRoot().getRight().getLeft()));
		assertEquals("h", t.getMax(t.getRoot().getRight().getRight().getRight().getLeft()));
		assertEquals("i", t.getMax(t.getRoot().getRight()));
		assertEquals(null, t.getRoot().getLeft().getLeft());
	}
	
	
}

package com.guille.ed.avlTrees.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.guille.ed.avlTrees.AVLTree;


public class L6_ALVTreeTestBasicOperations {

	@Test
	public void testAdd() {
		AVLTree<String> t = new AVLTree<String>();
		t.add("b");
		assertEquals("b(0)--", t.toString());
	
		t.add("a");
		assertEquals("b(1)a(0)---", t.toString());
		
		t.add("d");
		assertEquals("b(1)a(0)--d(0)--", t.toString());
		
		t.add("c");
		assertEquals("b(2)a(0)--d(1)c(0)---", t.toString());
		
		t.add("g");
		assertEquals("b(2)a(0)--d(1)c(0)--g(0)--", t.toString());
		
		t.add("i");
		assertEquals("b(3)a(0)--d(2)c(0)--g(1)-i(0)--", t.toString());
		
		t.add("h");
		assertEquals("b(4)a(0)--d(3)c(0)--g(2)-i(1)h(0)---", t.toString());
		
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

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
		assertEquals("b(-1)a(0)---", t.toString());
		
		t.add("d");
		assertEquals("b(0)a(0)--d(0)--", t.toString());
		
		t.add("c");
		assertEquals("b(1)a(0)--d(-1)c(0)---", t.toString());
		
		t.add("g");
		assertEquals("b(1)a(0)--d(0)c(0)--g(0)--", t.toString());
		
		t.add("i");
		assertEquals("d(0)b(0)a(0)--c(0)--g(1)-i(0)--", t.toString());
		
		t.add("h");
		assertEquals("d(0)b(0)a(0)--c(0)--h(0)g(0)--i(0)--", t.toString());


		
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
		assertEquals(true, t.search("b"));
		assertEquals(false, t.search("a"));
		assertEquals(false, t.search("c"));
		
		t.add("a");
		assertEquals(true, t.search("a"));
		assertEquals(true, t.search("b"));
		assertEquals(false, t.search("c"));
		
		t.add("d");
		assertEquals(true, t.search("d"));
		assertEquals(true, t.search("a"));
		assertEquals(true, t.search("b"));
		assertEquals(false, t.search("c"));
		assertEquals(false, t.search("e"));
		
		t.add("c");
		assertEquals(true, t.search("d"));
		assertEquals(true,t.search("a"));
		assertEquals(true, t.search("b"));
		assertEquals(true, t.search("c"));
		assertEquals(false, t.search("e"));
		
		t.add("g");
		assertEquals(true, t.search("d"));
		assertEquals(true, t.search("a"));
		assertEquals(true, t.search("b"));
		assertEquals(true, t.search("c"));
		assertEquals(true, t.search("g"));
		assertEquals(false, t.search("e"));
		assertEquals(false, t.search("h"));
		
		
		t.add("i");
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
		
		assertEquals("i", t.getMax(t.getRoot()));
		assertEquals("c", t.getMax(t.getRoot().getLeft()));
		assertEquals("g", t.getMax(t.getRoot().getRight().getLeft()));
		assertEquals("i", t.getMax(t.getRoot().getRight()));
		assertEquals("a(0)", t.getRoot().getLeft().getLeft().toString());
	}
	
	
}

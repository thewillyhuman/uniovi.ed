package com.guille.ed.avlTrees.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.guille.ed.avlTrees.AVLTree;

public class L7_BST_EvalTest {

	
	// CAUTION
	// Use this call at the end of the remove and add methods in the AVL class
	// theRoot.updateHeight();
	// return (theRoot);
	//
	// Normal use:
	// return (updateBF (theRoot));
	//
	// Also use this statement in the AVLNode
	// getElement().toString() + ("+getHeight()+")";
	// ... instead of...
	// getElement().toString() + ("+getBF()+")";


	
	
	@Test
	public void test_A() {
	
		AVLTree <Character> charTree = new AVLTree<Character>();
		charTree.add('a');
		charTree.add('b');
		charTree.add('c');
		
		assertEquals ("a(2)-b(1)-c(0)--", charTree.toString());
		
		charTree.add('d');
		assertEquals ("a(3)-b(2)-c(1)-d(0)--", charTree.toString());
		
		
		
	}
	
	
	@Test
	public void test_B() {
	
		// Example
		AVLTree<Character> a = new AVLTree<Character>();
		a.add('b');
		a.add('a');
		a.add('d');
		a.add('c');
		a.add('g');
		a.add('i');
		a.add('h');
		assertEquals ("b(4)a(0)--d(3)c(0)--g(2)-i(1)h(0)---", a.toString());
	
		// Scenery III
		a.remove('d');
		assertEquals ("b(4)a(0)--c(3)-g(2)-i(1)h(0)---", a.toString());
		
		// Scenery II
		a.remove('g');
		assertEquals ("b(3)a(0)--c(2)-i(1)h(0)---", a.toString());
				
		// Scenery I
		a.remove('a');
		assertEquals ("b(3)-c(2)-i(1)h(0)---", a.toString());
	}
	
	@Test
	public void test_C_Joins() throws CloneNotSupportedException {
	
		// Example
		AVLTree<Integer> a = new AVLTree<Integer>();
		a.add(5);
		a.add(3);
		a.add(1);
		a.add(2);
		a.add(7);
		assertEquals ("5(3)3(2)1(1)-2(0)---7(0)--", a.toString());
		
		AVLTree<Integer> b = new AVLTree<Integer>();
		b.add(7);
		b.add(6);
		b.add(8);
		assertEquals ("7(1)6(0)--8(0)--", b.toString());
		
		assertEquals ("5(3)3(2)1(1)-2(0)---7(0)--", a.joins(a).toString());
		assertEquals ("7(1)6(0)--8(0)--", b.joins(b).toString());
		
		// At least one must work (ask the student to explain his/her algorithm)
		// Depends on the traverse strategy and which tree is used as the pivot
		assertEquals ("5(3)3(2)1(1)-2(0)---7(1)6(0)--8(0)--", a.joins(b).toString());
		assertEquals ("7(5)6(4)5(3)3(2)1(1)-2(0)-----8(0)--", b.joins(a).toString());
	}
	
	@Test
	public void test_D_Sample() {
	
		AVLTree<Character> a = new AVLTree<Character>();
		a.add('b');
		a.add('a');
		a.add('d');
		assertEquals ("b(1)a(0)--d(0)--", a.toString());
	
		AVLTree<Character> b = new AVLTree<Character>();
		b.add('c');
		b.add('g');
		b.add('i');
		b.add('d');
		assertEquals ("c(2)-g(1)d(0)--i(0)--", b.toString());
		assertEquals ("b(3)a(0)--d(2)c(0)--g(1)-i(0)--", a.joins(b).toString());
	}


}

package com.guille.ed.avlTrees.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.guille.ed.avlTrees.AVLTree;
import com.guille.util.annotations.MartinTest;

@SuppressWarnings("deprecation")
@MartinTest()
/**
 * 
 * @author Guillermo Facundo Colunga
 * @version carlos.1
 */
public class AVLTreeMartinTest {

	@Test
	public void addTest() {
		// Example.
		AVLTree<Character> a = new AVLTree<Character>();
		a.add('b');
		assertEquals("b(0)--", a.toString());
		a.add('a');
		assertEquals("b(1)a(0)---", a.toString());
		a.add('d');
		assertEquals("b(1)a(0)--d(0)--", a.toString());
		a.add('c');
		assertEquals("b(2)a(0)--d(1)c(0)---", a.toString());
		a.add('g');
		assertEquals("b(2)a(0)--d(1)c(0)--g(0)--", a.toString());
		a.add('i');
		assertEquals("b(3)a(0)--d(2)c(0)--g(1)-i(0)--", a.toString());
		a.add('h');
		assertEquals("b(4)a(0)--d(3)c(0)--g(2)-i(1)h(0)---", a.toString());

	}

	@Test
	public void searchTest() {
		// Example
		AVLTree<Character> a = new AVLTree<Character>();
		a.add('b');
		a.add('a');
		a.add('d');
		a.add('c');
		a.add('g');
		a.add('i');
		a.add('h');
		assertEquals(true, a.search('i'));
		assertEquals(false, a.search('f'));

	}

}

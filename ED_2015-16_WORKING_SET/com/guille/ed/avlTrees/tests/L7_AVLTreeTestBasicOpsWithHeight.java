package com.guille.ed.avlTrees.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.guille.ed.avlTrees.AVLTree;

public class L7_AVLTreeTestBasicOpsWithHeight {

	@Test
	public void testAddRemove() throws Exception {
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

		t.remove("b");
		assertEquals("a(4)-d(3)c(0)--g(2)-i(1)h(0)---", t.toString());
		t.remove("g");
		assertEquals("a(3)-d(2)c(0)--i(1)h(0)---", t.toString());
		t.remove("c");
		assertEquals("a(3)-d(2)-i(1)h(0)---", t.toString());
		t.remove("h");
		assertEquals("a(2)-d(1)-i(0)--", t.toString());

		try {
			t.add("a");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

package com.guille.ed.avlTrees.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.guille.ed.avlTrees.AVLTree;


public class LI4_EvalTest2 {

	@Test
	public void test_NumberOfElementsGreaterThan() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		
		// empty tree
		// assertEquals(0, tree.getNumberOfEementsGreaterThan(0));
		
		int N = 2000; // N tests
		
		for(int i = 1; i <= N; i++){
			tree.add(i);
		}
		
		for(int i= 0; i <= N; i++){
			assertEquals(N-i, tree.getNumberOfEementsGreaterThan(i));
		}
		
		assertEquals(0, tree.getNumberOfEementsGreaterThan(N+3));
		
	}

}

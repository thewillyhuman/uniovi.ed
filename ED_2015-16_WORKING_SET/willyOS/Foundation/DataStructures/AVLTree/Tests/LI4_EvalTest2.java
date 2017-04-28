package willyOS.Foundation.DataStructures.AVLTree.Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import willyOS.Foundation.DataStructures.AVLTree.AVLTree;

/**
 * 
 * @author Carlos Mencía
 * @version 0.1
 *
 */
public class LI4_EvalTest2 {

    @Test
    public void test_NumberOfElementsGreaterThan() {
	AVLTree<Integer> tree = new AVLTree<Integer>();

	// empty tree
	assertEquals(0, tree.greaterElements(0));

	int N = 2000; // N tests
	System.out.println("Adding nodes.");
	for (int i = 1; i <= N; i++) {
	    tree.add(i);
	}
	System.out.println("Checking nodes.");
	for (int i = 0; i <= N; i++) {
	    assertEquals(N - i, tree.greaterElements(i));
	}

	assertEquals(0, tree.greaterElements(N + 3));

    }

}

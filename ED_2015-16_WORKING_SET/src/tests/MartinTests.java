package tests;

import static org.junit.Assert.*;

import main.Graph;
import main.GraphNode;

import org.junit.Test;

public class MartinTests {

	@Test
	public void GraphNodeTest() {
		GraphNode<Integer> numbers = new GraphNode<Integer>(4);
		System.out.println(numbers.getElement());
		assertEquals(4, (int) numbers.getElement());
		assertEquals(false, numbers.isVisited());
		numbers.setVisited(true);
		assertEquals(true, numbers.isVisited());
		assertEquals("GN(N:4/V:true)", numbers.toString());

		GraphNode<String> myString = new GraphNode<String>("hello");
		assertEquals("hello", myString.getElement());
		assertEquals(false, myString.isVisited());
		assertEquals("GN(N:hello/V:false)", myString.toString());

		GraphNode<Character> myChar = new GraphNode<Character>('a');
		assertEquals('a', (char) myChar.getElement());
		assertEquals("GN(N:a/V:false)", myChar.toString());
		myChar.setElement('b');
		myChar.print();
		assertEquals("GN(N:b/V:false)", myChar.toString());
		myChar.setVisited(true);
		assertEquals("GN(N:b/V:true)", myChar.toString());
	}

	@Test
	public void GraphEdittingTest() {
		Graph<Character> g1 = new Graph<Character>(3);
		System.out.println("TEST 1 (EDITING) BEGINS ***");
		assertEquals(0, g1.getSize());
		try {
			g1.addNode('a');
		} catch (Exception e) {
			System.out.println("No repeated nodes are allowed" + e);
		}
		assertEquals(1, g1.getSize());
		assertEquals(0, g1.getNode('a'));
		assertArrayEquals(new boolean[][] { { false, false, false }, { false, false, false }, { false, false, false } },
				g1.getEdges());
		assertArrayEquals(new double[][] { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } }, g1.getWeight());
		// Test nodes for nodes not found
		assertEquals(Graph.INDEX_NOT_FOUND, g1.getNode('b'));
		// No repeated nodes is allowed
		try {
			g1.addNode('a');
		} catch (Exception e) {
			System.out.println("No repeated nodes are allowed" + e);
		}
		try {
			g1.addNode('b');
			g1.addNode('c');
		} catch (Exception e) {
			System.out.println("No repeated nodes are allowed" + e);
		}
		assertEquals(3, g1.getSize());
		assertEquals(0, g1.getNode('a'));
		assertEquals(1, g1.getNode('b'));
		assertEquals(2, g1.getNode('c'));
		assertArrayEquals(new boolean[][] { { false, false, false }, { false, false, false }, { false, false, false } },
				g1.getEdges());
		assertArrayEquals(new double[][] { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } }, g1.getWeight());
		// Testing edges
		try {
			g1.existsEdge('b', 'd');
		} catch (Exception e) {
			System.out.println("Starting|arrival node does not exists" + e);
		}
		try {
			assertEquals(false, g1.existsEdge('b', 'c'));
		} catch (Exception e) {
			System.out.println("Starting or arrival node does not exists" + e);
		}
		assertArrayEquals(new boolean[][] { { false, false, false }, { false, false, false }, { false, false, false } },
				g1.getEdges());
		assertArrayEquals(new double[][] { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } }, g1.getWeight());
		try {
			g1.addEdge('b', 'c', 5.0);
			assertEquals(true, g1.existsEdge('b', 'c'));
		} catch (Exception e) {
			System.out.println("Starting or arrival node does not exists" + e);
		}
		assertArrayEquals(new boolean[][] { { false, false, false }, { false, false, true }, { false, false, false } },
				g1.getEdges());
		assertArrayEquals(new double[][] { { 0.0, 0.0, 0.0 }, { 0.0, 0.0, 5.0 }, { 0.0, 0.0, 0.0 } }, g1.getWeight());
	}


}

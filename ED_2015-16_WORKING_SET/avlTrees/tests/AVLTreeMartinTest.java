package avlTrees.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.guille.annotations.MartinTest;
import com.guille.annotations.MartinTest.Priority;

import avlTrees.AVLTree;

@MartinTest(Priority.HIGH)
public class AVLTreeMartinTest {

	@Test
	public void addTest() {
		// Example.
		AVLTree<Character> a = new AVLTree<Character>();
		a.add('b');
		assertEquals("b--", a.toString());
		a.add('a');
		assertEquals("ba---", a.toString());
		a.add('d');
		assertEquals("ba--d--", a.toString());
		a.add('c');
		assertEquals("ba--dc---", a.toString());
		a.add('g');
		assertEquals("ba--dc--g--", a.toString());
		a.add('i');
		assertEquals("ba--dc--g-i--", a.toString());
		a.add('h');
		assertEquals("ba--dc--g-ih---", a.toString());

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

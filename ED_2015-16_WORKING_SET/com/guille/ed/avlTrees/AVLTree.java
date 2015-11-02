package com.guille.ed.avlTrees;

/**
 * 
 * @author Guillermo Facundo Colunga
 * @version 2015.10.29.1
 * @param <T> Type of data that the structure will contain.
 */
public class AVLTree<T extends Comparable<T>> {

	AVLNode<T> root;

	/**
	 * Main Constructor.
	 */
	public AVLTree() {
		setRoot(null);
	}

	/**
	 * Returns the root of the tree, if there is...
	 * 
	 * @return the AVLNode that represents the root of the tree.
	 */
	public AVLNode<T> getRoot() {
		return this.root;
	}

	/**
	 * Sets the root of the tree.
	 * 
	 * @param root AVLNode to be the root of the tree.
	 */
	public void setRoot(AVLNode<T> root) {
		this.root = root;
	}

	/**
	 * Adds an element to the tree. By calling the recursive and private method
	 * add(AVLNode<T> root, T element), that will return the top node of the
	 * tree.
	 * 
	 * @param element to be added to the tree.
	 * @throws Exception if the the element is null or if it's already in the
	 *             tree.
	 */
	public void add(T element) throws IllegalArgumentException {
		setRoot(add(getRoot(), element));
	}

	/**
	 * Recursive add method. If the root given is null it will create a new
	 * AVLNode assigning the value of the node we want to add there. If not will
	 * allocate the element in its place and then will return again the root.
	 * 
	 * @param root of the AVL tree.
	 * @param element to be added to the tree.
	 * @return the root of the tree.
	 * @throws Exception if the element already exists or if it's null.
	 */
	private AVLNode<T> add(AVLNode<T> root, T element) throws IllegalArgumentException {
		if (element == null) {
			throw new IllegalArgumentException("The element you want to add was null.");
		} else if (root == null) {
			return new AVLNode<T>(element);
		} else if (root.getElement().equals(element)) {
			throw new IllegalArgumentException("No repeated elements are allowed inside a tree.");
		} else if (element.compareTo(root.getElement()) < 0) {
			root.setLeft(add(root.getLeft(), element));
		} else {
			root.setRight(add(root.getRight(), element));
		}
		return root;
	}

	/**
	 * Iterative method to add nodes. Please, use the recursive version.
	 * 
	 * @param element to add to the tree.
	 */
	@Deprecated
	public void addIterative(T element) {
		if (element == null)
			throw new IllegalArgumentException("The element you want to add was null.");
		AVLNode<T> root = getRoot();
		boolean added = false;
		while (!added) {
			if (root == null) {
				setRoot(new AVLNode<T>(element));
				added = true;
			} else if (element.compareTo(root.getElement()) < 0) {
				if (root.getLeft() == null) {
					root.setLeft(new AVLNode<T>(element));
					added = true;
				}
				root = root.getLeft();
			} else if (element.equals(root.getElement())) {
				throw new IllegalArgumentException("No repeated elements are allowed inside a tree.");
			} else {
				if (root.getRight() == null) {
					root.setRight(new AVLNode<T>(element));
					added = true;
				}
				root = root.getRight();
			}
		}
	}

	/**
	 * Public toString method.
	 * 
	 * @return toString private and recursive method
	 */
	@Override
	public String toString() {
		return toString(root);
	}

	/**
	 * toString private recursive method. While the root is different from null
	 * the method will continue traversing the tree and adding the nodes to the
	 * StringBuilder. Instead of String concatenation it uses StringBuilder
	 * because as it is a recursive method we improve the performance.
	 * 
	 * @param root
	 * @return null if root = null. Otherwise: "root+left+right".
	 */
	private String toString(AVLNode<T> root) {
		StringBuilder str = new StringBuilder();
		if (root == null) {
			str.append("-");
		} else {
			str.append(root.toString());
			str.append(toString(root.getLeft())).append(toString(root.getRight()));
		}
		return str.toString();
	}

	/**
	 * Search method. Given a T element it returns true if the element is in the
	 * tree.
	 * 
	 * @param T element, the element you want to look for in the tree.
	 * @return true if the element is in the tree, false otherwise.
	 */
	public boolean search(T element) {
		return search(element, getRoot());
	}

	/**
	 * Search private and reflexive method. Given a T element and a root it
	 * checks if the T element is in the tree.
	 * 
	 * @param T element, the element you want to look for in the tree.
	 * @param root, where you are looking for the element.
	 * @return true if the element is in the tree, false otherwise.
	 */
	private boolean search(T element, AVLNode<T> root) {
		if (root == null || element == null) {
			return false;
		} else if (root.getElement().equals(element)) {
			return true;
		} else if (element.compareTo(root.getElement()) < 0) {
			return search(element, root.getLeft());
		} else if (element.compareTo(root.getElement()) > 0) {
			return search(element, root.getRight());
		}
		return false;
	}

	/**
	 * Iterative version of search method. Please, use the recursive method.
	 * 
	 * @param element to be searched.
	 * @return true if the element exists in the tree. False otherwise.
	 */
	@Deprecated
	public boolean searchIterative(T element) {
		if (element == null)
			throw new IllegalArgumentException("The element you want to add was null.");
		AVLNode<T> root = getRoot();
		while (root != null) {
			if (element.equals(root.getElement())) {
				return true;
			} else if (element.compareTo(root.getElement()) < 0) {
				root = root.getLeft();
			} else {
				root = root.getRight();
			}
		}
		return false;
	}

	/**
	 * Search and Return method. If the element is in the tree then it search
	 * for the element in the tree and returns it.
	 * 
	 * @param element
	 * @return
	 */
	public T searchReturn(T element) {
		if (search(element)) {
			return searchReturn(element, getRoot());
		} else {
			return null;
		}
	}

	/**
	 * Search and return private and reflexive method. Given a T element and a
	 * root it returns the element.
	 * 
	 * @param T element, the element you want to look for in the tree.
	 * @param root, where you are looking for the element.
	 * @return The element you are loking for.
	 */
	private T searchReturn(T element, AVLNode<T> root) {
		if (root.getElement().equals(element)) {
			return root.getElement();
		} else if (element.compareTo(root.getElement()) < 0) {
			return searchReturn(element, root.getLeft());
		} else {
			return searchReturn(element, root.getRight());
		}
	}

	/**
	 * Get the maximum value in the tree. Calls the recursive and private method
	 * T getMax(AVLNode<T> root).
	 * 
	 * @return the maximum value in the tree.
	 */
	public T getMax() {
		return getMax(getRoot());
	}

	/**
	 * Private and reflexive getMax Method, gets the maximum value in the tree
	 * by means of recursion. Notice that the max value of a tree is always
	 * allocated at the bottom right position.
	 * 
	 * @param root of the tree.
	 * @return the maximum value of the tree
	 */
	private T getMax(AVLNode<T> root) {
		if (root == null) {
			return null;
		} else if (root.getRight() != null) {
			return getMax(root.getRight());
		}
		return root.getElement();
	}

	/**
	 * Travels the Tree in order, that is: leftSubTtree + root + rightSubTree.
	 * Null leaves will be represented as "-"
	 * 
	 * @return the result of travelling all the tree in order from the top root.
	 */
	public String inOrderTraversal() {
		return inOrderTraversal(this.getRoot());
	}

	/**
	 * Recursive method to traverse the tree from a given root. It travels in
	 * order as left + root + right. Null leaves will be represented as "-"
	 * 
	 * @param root of the tree or subtree.
	 * @return an String containing all the traverse path.
	 */
	private String inOrderTraversal(AVLNode<T> root) {
		StringBuilder aux = new StringBuilder();
		if (root == null)
			return "-";

		aux.append(inOrderTraversal(root.getLeft()));
		aux.append(root.getElement());
		aux.append(inOrderTraversal(root.getRight()));

		return aux.toString();
	}

	/**
	 * Travels the Tree in post-order, that is: leftSubTtree + rightSubTree +
	 * root. Null leaves will be represented as "-"
	 * 
	 * @return the result of travelling all the tree in post-order from the top
	 *         root.
	 */
	public String postOrderTraversal() {
		return postOrderTraversal(this.getRoot());
	}

	/**
	 * Recursive method to traverse the tree from a given root. It travels in
	 * post-order as left + right + root. Null leaves will be represented as "-"
	 * 
	 * @param root of the tree or subtree.
	 * @return an String containing all the traverse path.
	 */
	private String postOrderTraversal(AVLNode<T> root) {
		StringBuilder aux = new StringBuilder();
		if (root == null)
			return "-";

		aux.append(postOrderTraversal(root.getLeft()));
		aux.append(postOrderTraversal(root.getRight()));
		aux.append(root.getElement());

		return aux.toString();
	}

}

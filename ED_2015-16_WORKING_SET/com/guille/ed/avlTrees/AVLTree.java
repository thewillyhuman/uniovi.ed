package com.guille.ed.avlTrees;

/**
 * In computer science, an AVL tree (Georgy Adelson-Velsky and Evgenii Landis'
 * tree, named after the inventors) is a self-balancing binary search tree. It
 * was the first such data structure to be invented.[2] In an AVL tree, the
 * heights of the two child subtrees of any node differ by at most one; if at
 * any time they differ by more than one, rebalancing is done to restore this
 * property. Lookup, insertion, and deletion all take O(log n) time in both the
 * average and worst cases, where n is the number of nodes in the tree prior to
 * the operation. Insertions and deletions may require the tree to be rebalanced
 * by one or more tree rotations.
 * 
 * @author Guillermo Facundo Colunga
 * @version carlos.2
 * @param <T> Type of data that the structure will contain.
 */
public class AVLTree<T extends Comparable<T>> {

	AVLNode<T> root;

	/**
	 * Main Constructor. It doesn't need any parameter. will create an AVL Tree
	 * with a null root.
	 */
	public AVLTree() {
		setRoot(null);
	}

	/**
	 * Returns the root of the tree, if there is. Otherwise null.
	 * 
	 * @return the AVLNode that represents the root of the tree if there is.
	 *         Otherwise null.
	 */
	public AVLNode<T> getRoot() {
		return this.root;
	}

	/**
	 * Sets the root of the tree. As null is a dangerous value if the root is
	 * set to null will print a warning message.
	 * 
	 * @param root AVLNode to be the root of the tree.
	 */
	public void setRoot(AVLNode<T> root) {
		if (root == null)
			System.err.println("Warning: Setting the root as null.");
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
	private AVLNode<T> add(AVLNode<T> root, T element)
			throws IllegalArgumentException {
		if (element == null) {
			throw new IllegalArgumentException(
					"The element you want to add was null.");
		} else if (root == null) {
			return new AVLNode<T>(element);
		} else if (root.getElement().equals(element)) {
			throw new IllegalArgumentException(
					"No repeated elements are allowed inside a tree.");
		} else if (element.compareTo(root.getElement()) < 0) {
			root.setLeft(add(root.getLeft(), element));
		} else {
			root.setRight(add(root.getRight(), element));
		}
		return root;
	}

	/**
	 * Deprecated. Iterative method to add nodes. If the root given is null it
	 * will create a new AVLNode assigning the value of the node we want to add
	 * there. If not will allocate the element in its place and then will return
	 * again the root.
	 * 
	 * Please, use the recursive version.
	 * 
	 * @param element to add to the tree.
	 */
	@Deprecated
	public void addIterative(T element) {
		if (element == null)
			throw new IllegalArgumentException(
					"The element you want to add was null.");
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
				throw new IllegalArgumentException(
						"No repeated elements are allowed inside a tree.");
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
	 * Public toString method. Returns a string representation of the object. In
	 * general, the toString method returns a string that "textually represents"
	 * this object. The result should be a concise but informative
	 * representation that is easy for a person to read. It is recommended that
	 * all subclasses override this method. In this case the default format is:
	 * root+left+right and null pointers as "-" (dash). (Pre-Order)
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
	 * @return null if root = null. Otherwise: "root+left+right". Pre-Order.
	 */
	private String toString(AVLNode<T> root) {
		StringBuilder str = new StringBuilder();
		if (root == null) {
			str.append("-");
		} else {
			str.append(root.toString());
			str.append(toString(root.getLeft())).append(
					toString(root.getRight()));
		}
		return str.toString();
	}

	/**
	 * Search method. Given a T element it returns true if the element is in the
	 * tree. False otherwise.
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
	 * Deprecated. Iterative version of search method. Please, use the recursive
	 * method. Given a T element and a root it checks if the T element is in the
	 * tree.
	 * 
	 * @param element to be searched.
	 * @return true if the element exists in the tree. False otherwise.
	 */
	@Deprecated
	public boolean searchIterative(T element) {
		if (element == null)
			throw new IllegalArgumentException(
					"The element you want to add was null.");
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
		if (search(element))
			return searchReturn(element, getRoot());
		else
			return null;
	}

	/**
	 * Search and return private and reflexive method. Given a T element and a
	 * root it returns the element.
	 * 
	 * @param T element, the element you want to look for in the tree.
	 * @param root, where you are looking for the element.
	 * @return The element you are looking for.
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
	public T getMax(AVLNode<T> root) {
		if (root == null) {
			return null;
		} else if (root.getRight() != null) {
			return getMax(root.getRight());
		}
		return root.getElement();
	}

	/**
	 * Travels the Tree in order, that is: leftSubTtree + root + rightSubTree.
	 * Null leaves will be represented as "-".
	 * 
	 * Procedure: Traverse the left subtree by recursively calling the in-order
	 * function. Display the data part of root element (or current element).
	 * Traverse the right subtree by recursively calling the in-order function
	 * 
	 * @return the result of traveling all the tree in order from the top root.
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
	 * Procedure: Traverse the left subtree by recursively calling the
	 * post-order function. Traverse the right subtree by recursively calling
	 * the post-order function. Display the data part of root element (or
	 * current element).
	 * 
	 * @return the result of traveling all the tree in post-order from the top
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

	/**
	 * Public and not reflexive remove method. Given an element as a parameter it removes it from the tree.
	 * @param element, the element to be deleted
	 * @throws Exception if you try to delete a null, empty or non existent node.
	 */
	public void remove(T element) throws Exception {
		if(search(element)) {
			root = remove(element, getRoot());
		} else {
			throw new IllegalArgumentException("The element you want to remove is not in the tree.");
		}
	}
	
	
	/**
	 * Private and reflexive remove method. Given an element as a paramenter and
	 * a root it removes the element from the tree.
	 * 
	 * @param element, the element to be deleted
	 * @param root where you start to look for the node
	 * @return the deleted node.
	 * @throws Exception if you try to delete a null, empty or non existent node
	 */
	private AVLNode<T> remove(T element, AVLNode<T> root) throws Exception {
		if (root == null) {
			throw new IllegalArgumentException( "The element you want to remove is null. Or the tree is null");
		} else if (element.compareTo(root.getElement()) < 0) {
			root.setLeft(remove(element, root.getLeft()));
		} else if (element.compareTo(root.getElement()) > 0) {
			root.setRight(remove(element, root.getRight()));
		} else {
			if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			} else {
				System.out.println("The element we want to delete has two children.");
				root.setElement(getMax(root.getLeft()));
				remove(element, root.getLeft());
			}
		}
		return root;

	}

}

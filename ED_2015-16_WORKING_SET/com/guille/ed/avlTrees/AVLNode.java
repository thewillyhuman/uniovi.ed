package com.guille.ed.avlTrees;

/**
 * Represents an AVL leave a an AVLTree.
 * 
 * @author Guillermo Facundo Colunga
 * @version carlos.1
 * @param <T> Type of data that the AVLNode will contain.
 */
public class AVLNode<T extends Comparable<T>> {

	private T element;
	private AVLNode<T> left;
	private AVLNode<T> right;

	/**
	 * AVLNode Constructor. Only requires an element for the current AVLNode.
	 * The left child and the right child will be set to null.
	 * 
	 * @param element to be set in the current AVLNode.
	 * @throws Exception if element is null.
	 */
	public AVLNode(T element) {
		setElement(element);
		setLeft(null);
		setRight(null);
	}

	/**
	 * AVLNode Constructor. Requires the element for the current node, the
	 * AVLNode of the left and the one for the right.
	 * 
	 * @param element for the current node
	 * @param left AVLNode
	 * @param right AVLNode
	 * @throws Exception Exception if element, left or right is null.
	 */
	public AVLNode(T element, AVLNode<T> left, AVLNode<T> right) {
		setElement(element);
		setLeft(left);
		setRight(right);
	}

	/**
	 * Returns the actual value of the node. Notice that if the current value is null
	 * will return null.
	 * 
	 * @return the value of the node. In other words the element that the node
	 *         contains.
	 */
	public T getElement() {
		return this.element;
	}

	/**
	 * Sets the value of the node. Because of the implementation this method will accept null values.
	 * 
	 * @param element to be set.
	 */
	public void setElement(T element) {
		this.element = element;
	}

	/**
	 * Returns the AVLNode that is placed at the left. So its value is less than
	 * the actual node. If there is no left child will return null.
	 * 
	 * @return the AVLNode that is placed at the left. Null if there isn't.
	 */
	public AVLNode<T> getLeft() {
		return this.left;
	}

	/**
	 * Sets the AVLNode that is placed at the left. Because of the implementation this method will accept null values.
	 * 
	 * @param left the node to be set.
	 */
	public void setLeft(AVLNode<T> left) {
		this.left = left;
	}

	/**
	 * Returns the AVLNode that is placed at the right. So its value is grater
	 * than the actual node. If there is no left child will return null.
	 * 
	 * @return the AVLNode that is placed at the right. Null if there isn't.
	 */
	public AVLNode<T> getRight() {
		return this.right;
	}

	/**
	 * Sets the AVLNode that is placed at the left. Because of the implementation this method will accept null values.
	 * 
	 * @param right the node to be set.
	 */
	public void setRight(AVLNode<T> right) {
		this.right = right;
	}

	/**
	 * toString default method. Returns as an String the value of the element.
	 * 
	 * @return the value of the node.
	 */
	@Override
	public String toString() {
		return this.getElement().toString();
	}

	/**
	 * Prints the value of the toString method.
	 */
	public void print() {
		System.out.println(this.toString());
	}
}

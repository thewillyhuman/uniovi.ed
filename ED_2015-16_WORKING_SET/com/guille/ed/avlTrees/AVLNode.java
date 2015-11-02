package com.guille.ed.avlTrees;

public class AVLNode<T extends Comparable<T>> {

	private T element;
	private AVLNode<T> left;
	private AVLNode<T> right;

	/**
	 * AVLNode Constructor. Only requires an element for the current AVLNode.
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
	 * Returns the actual value of the node.
	 * 
	 * @return the value of the node. In other words the element that the node
	 *         contains.
	 */
	public T getElement() {
		return this.element;
	}

	/**
	 * Sets the value of the node.
	 * 
	 * @param element to be set.
	 */
	public void setElement(T element) {
		this.element = element;
	}

	/**
	 * Returns the AVLNode that is placed at the left. So its value is less than
	 * the actual node.
	 * 
	 * @return the AVLNode that is placed at the left.
	 */
	public AVLNode<T> getLeft() {
		return this.left;
	}

	/**
	 * Sets the AVLNode that is placed at the left.
	 * 
	 * @param left the node to be setted.
	 */
	public void setLeft(AVLNode<T> left) {
		this.left = left;
	}

	/**
	 * Returns the AVLNode that is placed at the right. So its value is grater
	 * than the actual node.
	 * 
	 * @return the AVLNode that is placed at the right.
	 */
	public AVLNode<T> getRight() {
		return this.right;
	}

	/**
	 * Sets the AVLNode that is placed at the left.
	 * 
	 * @param right the node to be setted.
	 */
	public void setRight(AVLNode<T> right) {
		this.right = right;
	}

	/**
	 * toString default method. Returns as an String the value of the element.
	 * 
	 * @return the value of the node.
	 */
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

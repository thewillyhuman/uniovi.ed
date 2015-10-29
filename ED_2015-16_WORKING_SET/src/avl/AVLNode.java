package avl;

/**
 * 
 * @author Guillermo Facundo Colunga
 * @version 2015.10.29.1
 * @param <T> Type of data the node will store.
 */
public class AVLNode<T extends Comparable<T>> {

    private T element;
    private AVLNode<T> left;
    private AVLNode<T> right;

    /**
     * AVLNode Constructor. Only requieres an element for the current AVLNode.
     * @param element to be setted in the current AVLNode.
     * @throws Exception if element is null.
     */
    public AVLNode(T element) throws Exception {
	setElement(element);
    }

    /**
     * AVLNode Construtor. Requieres the element for the current node, the AVLNode of the left and the one for the right.
     * 
     * @param element for the current node
     * @param left AVLNode
     * @param right AVLNode
     * @throws Exception Exception if element, left or right is null.
     */
    public AVLNode(T element, AVLNode<T> left, AVLNode<T> right) throws Exception {
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
     * @throws Exception if you try to set an element as null.
     */
    public void setElement(T element) throws Exception {
	if (element == null)
	    throw new Exception("You cannot set an element as null");
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
     * @throws Exception
     *             If left is null.
     */
    public void setLeft(AVLNode<T> left) throws Exception {
	if (left == null)
	    throw new Exception("Left node cannot be set as null");
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
     * @throws Exception  If right is null.
     */
    public void setRight(AVLNode<T> right) throws Exception {
	if (left == null)
	    throw new Exception("Right node cannot be set as null");
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

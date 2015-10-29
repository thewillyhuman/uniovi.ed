package avl;

public class AVL<T extends Comparable<T>> {

    AVLNode<T> root;

    /**
     * Main Constructor.
     */
    public AVL() {
	setRoot(null);
    }

    /**
     * Returns the root of the tree, if there is...
     * @return the AVLNode that represents the root of the tree.
     */
    public AVLNode<T> getRoot() {
	return root;
    }

    /**
     * Sets the root of the tree.
     * @param root AVLNode destinated to be the root of the tree.
     */
    public void setRoot(AVLNode<T> root) {
	this.root = root;
    }

    /**
     * Adds an element to the tree.
     * @param element to be added to the tree.
     * @throws Exception if the the element is null or if it's already in the tree.
     */
    public void add(T element) throws Exception {
	setRoot(add(this.getRoot(), element));
    }

    /**
     * Recursive add method. If the root given is null it will create a new AVLNode asigning the value of the node
     * we want to add there. If not will allocate the element in its place and then will return again the root.
     * @param root of the AVL tree.
     * @param element to be added to the tree.
     * @return the root of the tree.
     * @throws Exception if the element already exists or if it's null.
     */
    private AVLNode<T> add(AVLNode<T> root, T element) throws Exception {
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
     * Public toString method.
     * 
     * @return toString private and recursive method
     */
    @Override
    public String toString() {
	return toString(root);
    }

    /**
     * toString private recursive method.
     * 
     * @param root
     * @return null if root = null. Otherwise: "root+left+right".
     */
    private String toString(AVLNode<T> root) {
	StringBuilder str = new StringBuilder();
	if (root == null)
	    str.append("-");
	else {
	    str.append(root.toString());
	    str.append(toString(root.getLeft())).append(toString(root.getRight()));
	}
	return str.toString();
    }

    /**
     * Search method. Given a T element it returns true if the element is in the
     * tree.
     * 
     * @param T
     *            element, the element you want to look for in the tree.
     * @return true if the element is in the tree, false otherwise.
     */
    public boolean search(T element) {
	return search(element, getRoot());
    }

    /**
     * Search private and reflexive method. Given a T element and a root it
     * checks if the T element is in the tree.
     * 
     * @param T
     *            element, the element you want to look for in the tree.
     * @param root,
     *            where you are looking for the element.
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
     * @param T
     *            element, the element you want to look for in the tree.
     * @param root,
     *            where you are looking for the element.
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
     * Get the maximun value in the tree
     * 
     * @return the maximun value in the tree.
     */
    public T getMax() {
	return getMax(getRoot());
    }

    /**
     * Private and reflexive getMax Method, gets the maximun value in the tree
     * 
     * @param root
     * @return the maximun value of the tree
     */
    private T getMax(AVLNode<T> root) {
	if (root.getRight() != null) {
	    return getMax(root.getRight());
	} else {
	    return root.getElement();
	}
    }

    /**
     * Gets and returns the maximum NODE in the tree.
     * 
     * @return The Maximum Node in the tree.
     */
    public AVLNode<T> getMaxNode() {
	return getMaxNode(getRoot());
    }

    /**
     * Private and reflexive getMaxNode Method, gets the maximun NODE in the
     * tree
     * 
     * @param root
     * @return The Maximun Node in the tree.
     */
    private AVLNode<T> getMaxNode(AVLNode<T> root) {
	if (root.getRight() != null) {
	    return getMaxNode(root.getRight());
	} else {
	    return root;
	}
    }

}

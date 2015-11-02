package src.graphs;

public class Container<T> {
	
	private T element;
	
	/**
	 * Constructor.
	 * @param e the value of the String.
	 */
	public Container(T e) {
		setElement(e);
	}
	
	/**
	 * Setter for the element.
	 * @param e (String), the new value for the element. Null not accepted
	 */
	public void setElement(T e) {
		if(e!=null)
			this.element=e;
	}
	
	/**
	 * Getter, returns as an String the value of the container.
	 * @return the value of the container as an String.
	 */
	public T getElement() {
		return this.element;
	}
	
	/**
	 * toString method.
	 * @return the value of the container as an String.
	 */
	public String toString() {
		return this.element.toString();
	}

}

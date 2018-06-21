
/**
 * The Node stores a reference to an Object
 * as well as a reference to the next Node
 * The references can be manipulated to form 
 * a linked list
 * 
 * @author Matthew Silva
 *
 */

public class Node<T> {

	/**
	 * The Object referenced by this Node
	 */
	private T item;
	
	/**
	 * The Node referenced by this Node
	 */
	private Node<T> next;
	
	/**
	 * Default constructor redundantly initializes
	 * instance variables to null
	 */
	public Node() {
		item = null;
		next = null;
	}
	
	/**
	 * Sets the Node's referenced Object
	 * to item
	 * @param item
	 */
	public void setItem(T item) {
		this.item = item;
	}
	
	/**
	 * @return The Node's referenced Object 
	 */
	public T getItem() {
		return item;
	}
	
	/**
	 * Sets the referenced next Node
	 * @param Desired Node to reference
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**
	 * @return The Node referenced by this Node
	 */
	public Node<T> getNext() {
		return next;
	}
	
}


/**
 * 
 * A Collection can store data, add data,
 * remove data at random and specific
 * locations, and check if it is empty.
 * 
 * @author Matthew Silva
 *
 * @param <T> Type of Objects to be stored in the Collection
 */
public class Collection<T> implements CollectionInterface<T>{

	
	// REMOVE CASTS TO T
	// REMOVE CASTS TO T
	/**
	 * The reference to the first Node of the Collection
	 */
	private Node<T> head;
	
	
	/**
	 * Default constructor states there is no first node yet
	 */
	public Collection() {
		head = null;
	}
	
	/**
	 * @return Is the Collection empty?
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * @return Returns the number of elements in the collection
	 * i.e. 0 if empty
	 */
	public int size() {
		Node<T> current = head;
		int size = 0;
		while(current != null) {
			size++;
			current = current.getNext();
		}
		
		return size;
	}
	
	/**
	 * Adds an Object to the Collection
	 */
	public void add(T item) {
		Node<T> holder = new Node<T>();
		holder.setItem(item);
		holder.setNext(head);
		head = holder;
	}
	
	/**
	 * Removes and returns the first Object in the Collection
	 * 
	 * @return First Object of the Collection
	 */
	public T remove() throws IllegalStateException{
	
		if(isEmpty()) throw new IllegalStateException("Collection empty");
		T result = head.getItem();
		head = head.getNext();
		return result;
	}
	
	/**
	 * Removes and returns the Object at the
	 * specified index from the Collection
	 * @param Index in the Collection
	 * @return The Object at the specified index
	 */
	public T remove(int index) {
		if (index == 0) {
			return remove();
		}
		T result = get(index);
		getNode(index - 1).setNext(getNode(index).getNext());
		return result;
	
	}
	
	/**
	 * Return the Node at the specified index.
	 * 
	 * @param Desired Node's index
	 * @return Node at the specified index
	 * @throws IndexOutOfBoundsException if the index is too large
	 * or too small
	 */
	private Node<T> getNode(int index) throws IndexOutOfBoundsException{
		if(index > size() - 1)
			throw new IndexOutOfBoundsException("Index too large");
		if(index < 0) 
			throw new IndexOutOfBoundsException("Index less than 0");
		
		Node<T> current = head;
		
		for (int g = 0; g < index; g++) {
			current = current.getNext();
		}
		return current;
	}
	
	/**
	 * Removes and returns a random Object from the Collection
	 * 
	 * @return Random Object from the Collection
	 * @throws IllegalStateException if Collection is empty
	 * 
	 */
	public T removeRandom() throws IllegalStateException {
		
		if (isEmpty()) throw new IllegalStateException("Collection empty");
		if (size() == 1)
			return remove();
		int randomIndex = (int) Math.round((Math.random()*(size() - 1)));
		return remove(randomIndex);
		
	}
	
	/**
	 * Returns the Object at the specified Collection index
	 * 
	 * @param Desired Object index in the Collection
	 * @return The Object at the specified index
	 */
	public T get(int index) throws IndexOutOfBoundsException{
		if(index > size()) throw new IndexOutOfBoundsException("Index too large");
		if(index < 0) throw new IndexOutOfBoundsException("Index less than 0");
		
		T result = (T) head.getItem();
		Node<T> current = head;
		
		for (int g = 0; g < index; g++)
		{
			current = current.getNext();
			result = current.getItem();
		}
		return result;
	}
	
	/**
	 * Clears the Collection, removing all stored Objects
	 */
	public void clear() {
		head = null;
	}
	
	
}


/**
 * A
 * 
 * @author Matthew Silva
 *
 * @param <T> Type of Objects stored in the Collection
 */
public interface CollectionInterface<T> {

	/**
	 * Adds an Object to the collection
	 * @param Object to be added
	 */
	public void add(T item);
	
	/**
	 * Removes the selected Object from the
	 * collection and returns the Object 
	 * just removed
	 * @return The Object just removed
	 * @throws Exception if collection is empty
	 * @TODO add a helper method that splices an Object in at the selected location 
	 */
	public T remove() throws IllegalStateException;
	
	/**
	 * Removes a random Object from the
	 * collection and returns the Object
	 * just removed
	 * @return The Object just removed
	 */
	public T removeRandom() throws IllegalStateException;
	
	/**
	 * @return Does the collection contain any Objects?
	 */
	public boolean isEmpty();
	
	/**
	 * @return The number of Objects in the Collection
	 */
	public int size();

	/**
	 * Return the Object at the specified index from
	 * the Collection
	 * @param Desired index in the Collection
	 * @return The Object at the specified index
	 */
	public T get(int g);

	/**
	 * Clear the collection of all stored Objects
	 */
	public void clear();
	
}

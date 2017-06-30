package edu.miracosta.cs113;

public abstract class Heap<E> //implements Comparable<E>
{	
	/**
	 * Insert an item into the heap.
	 * Postcondition: The ArrayList theData is in heap order.
	 * @param object, item that is being added to the heap.
	 * @return true if the item was inserted, false otherwise.
	 * @throws NullPointerException if the item to be inserted is null.
	 */
	public abstract boolean insert(E object);
	
	/**
	 * Compare two items using either a Comparator object's compare
	 * method or their natural ordering using method compareTo.
	 * Precondition: If comparator is null, parent and child implement Comparable<E>.
	 * @param parent, one item.
	 * @param child, the other item.
	 * @return depending on how the subclass is implemented.
	 */
	public abstract int compare(E parent, E child);
	
	/**
	 * Remove an item from the Heap.
	 * Precondition: The ArrayList theData is in heap order.
	 * Postcondition: Removed smallest item, theData is in Heap order.
	 * @return The smallest/largest item in the heap, or null if empty.
	 */
	public abstract E remove();
	
	/**
	 * Prints the entire Heap for the user.
	 */
	public abstract void printHeap();
}

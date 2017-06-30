package edu.miracosta.cs113;

public interface SearchTree<E> 
{
	/**
	 * Inserts item where it belongs in the tree. 
	 * @param object to be inserted (can not take duplicates)
	 * @return true if item was inserted, false otherwise.
	 */
	public boolean add(E object);
	/**
	 * Checks if the object is in the tree.
	 * @param object being searched for.
	 * @return true if the item was found in the tree,
	 * 				false otherwise.
	 */
	public boolean contains(E object);
	/**
	 * Returns a reference to the data in the node that is equal
	 * to object, If no such node is found returns null.
	 * @param object being searched for.
	 */
	public E find(E object);
	/**
	 * Removes object (if found) from tree and returns it
	 * otherwise returns null.
	 * @param object being deleted (if found).
	 * @return object (if found).
	 */
	public E delete(E object);
	/**
	 * Removes object (if found) from the tree and returns
	 * a boolean value.
	 * @param object beinged removed (if found).
	 * @return true if the object was removed, false otherwise.
	 */
	public boolean remove(E object);
}

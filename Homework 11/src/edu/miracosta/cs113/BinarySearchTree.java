package edu.miracosta.cs113;

@SuppressWarnings("serial")
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>
{
	/**
	 * Stores a second return value from the recursive add method
	 * that indicates whether the item has been inserted.
	 */
	protected boolean addReturn;
	/**
	 * Stores a second return value from the recursive delete method
	 * that references the item that was stored in the tree.
	 */
	protected E deleteReturn;
	
	/**
	 * Starter add method, found on page 321.
	 * pre: The object to insert must implement the
	 * 		Comparable interface.
	 * @param object, the object being inserted.
	 * @return true if the object is inserted, false if
	 * 				the item already exists in the tree.
	 */
	@Override
	public boolean add(E object) 
	{
		root = add(root, object);
		return addReturn;
	}
	//Helper add() method:
	/**
	 * Recursive add method.
	 * post: The data field addReturn is set true if the item is added
	 * 			to the tree, false if the item is already in the tree.
	 * @param localRoot, The local root of the subtree.
	 * @param item, The object to be inserted.
	 * @return The new local root that now contains the inserted item.
	 */
	private Node<E> add(Node<E> localRoot, E item)
	{
		if(localRoot == null)
		{
			//item is not in the tree, insert it.
			addReturn = true;
			return new Node<E>(item);
		}
		else if(item.compareTo(localRoot.data) == 0)
		{
			//item is equal to localRoot.data
			addReturn = false;
			return localRoot;
		}
		else if(item.compareTo(localRoot.data) < 0)
		{
			//item is less than the localRoot.data
			localRoot.left = add(localRoot.left, item);
			return localRoot;
		}
		else
		{
			//item is greater than localRoot.data
			localRoot.right = add(localRoot.right, item);
			return localRoot;
		}
	}
	@Override
	public boolean contains(E object) {
		// TODO Auto-generated method stub
		// Implement after Homework 11.
		return false;
	}
	@Override
	public E find(E object) {
		// TODO Auto-generated method stub
		// Implement after Homework 11; found on page 319.
		return null;
	}
	@Override
	public E delete(E object) {
		// TODO Auto-generated method stub
		// Implement after Homework 11; found on page 325.
		return null;
	}
	@Override
	public boolean remove(E object) {
		// TODO Auto-generated method stub
		// Implement after Homework 11; found on page 325.
		return false;
	}
}

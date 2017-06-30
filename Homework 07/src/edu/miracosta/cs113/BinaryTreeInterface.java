package edu.miracosta.cs113;

public interface BinaryTreeInterface<E>
{
	/**
	 * returns the left subtree.
	 */
	public BinaryTree<E> getLeftSubtree();
	/**
	 * returns the right subtree.
	 */
	public BinaryTree<E> getRightSubtree();
	/**
	 * returns the data in the root.
	 */
	public E getData();
	/**
	 * Returns true if the tree is a leaf, false otherwise.
	 */
	public boolean isLeaf();
	/**
	 * Returns a string representation of the tree.
	 */
	public String toString();
}

package edu.miracosta.cs113;
import java.io.Serializable; 
import java.util.Scanner;

@SuppressWarnings("serial")
public class BinaryTree<E> implements BinaryTreeInterface<E>, Serializable
{
	protected static class Node<E>
	{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		
		/**
		 * Creates a new node containing the given object.
		 * @param data, object stored in the node.
		 */
		public Node(E data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
		public String toString() 
		{
			return this.data.toString(); 
		}
	}//end of Node inner class.
	protected Node<E> root;
	
	/**
	 * No parameter constructor, creates an empty binary tree.
	 */
	public BinaryTree()
	{
		root = null;
	}
	/**
	 * Creates a tree with a given node at the root.
	 * @param root
	 */
	protected BinaryTree(Node<E> root)
	{
		this.root = root;
	}
	/**
	 * Builds a tree from a data value and two trees.
	 * @param data
	 * @param leftTree
	 * @param rightTree
	 */
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
	{
		root = new Node<E>(data);
		
		if(leftTree != null) 
		{
			root.left = leftTree.root;
		} 
		else 
		{
			root.left = null;
		}
		if (rightTree != null) 
		{
			root.right = rightTree.root;
		} 
		else 
		{
			root.right = null;
		}
	}
	/**
	 * Returns the data stored in the root.
	 */
	public E getData()
	{
		return root.data;
	}
	/**
	 * Returns the left subtree.
	 */
	public BinaryTree<E> getLeftSubtree() 
	{
		if (root != null && root.left != null) 
		{
			return new BinaryTree<E>(root.left);
		} 
		else 
		{
			return null;
		}
	}
	/**
	 * Returns the right subtree.
	 */
	public BinaryTree<E> getRightSubtree() 
	{
		if (root != null && root.right != null) 
		{
			return new BinaryTree<E>(root.right);
		} 
		else 
		{
			return null;
		}
	}
	/**
	 * Returns true if the tree is a leaf, false otherwise.
	 */
	public boolean isLeaf() 
	{
		return (root.left == null && root.right == null);
	}
	/**
	 * Generates a string representing a pre-order traversal in which each
	 * local root is indented a distance proportional to its depth.
	 */
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}
	/**
	 * Performs a pre-order traversal of the subtree whose root is node.
	 * Appends the representation to the StringBuilder.
	 * Increments the value of depth (the current tree level).
	 */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb)
	{
		for (int i = 1; i < depth; i++) 
		{
			sb.append(" ");
		}
		if (node == null) 
		{
			sb.append("null\n");
		} 
		else 
		{
			sb.append(node.toString() + "\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}
	/**
	 * Constructs a binary tree by reading its data using a 
	 * Scanner object.
	 */
	public static BinaryTree<String> readBinaryTree(Scanner scan)
	{
		String data = scan.next();
		
		if (data.equals("null")) 
		{
			return null;
		} 
		else 
		{
			BinaryTree<String> leftTree = readBinaryTree(scan);
			BinaryTree<String> rightTree = readBinaryTree(scan);
			return new BinaryTree<String>(data, leftTree, rightTree);
		}
	}
	/**
	 * Returns the toString of the root node
	 * @return String
	 */
	public String printRoot() 
	{
		return root.toString(); 
	}
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
}	

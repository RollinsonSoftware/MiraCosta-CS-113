/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 ********************************************/

/*****************************************************************************
 * HOMEWORK NUMBER 11
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM: Programming Project 1, pg. 534
 * Complete the AVLTree class by coding the missing methods for insertion only
 *  (only add, not remove, etc.).  Use it to insert a collection of randomly 
 *  generated numbers.  Insert the same set of numbers in a binary search tree
 *   that is not balanced.  Verify that each tree is correct by performing an
 *    inorder traversal.  Also, display the format of each tree that was built
 *     and compare their heights.
 *****************************************************************************
 * ALGORITHM:
 * Create two separate trees, one BST and one AVL.
 * insert 10 random values into each tree.
 * insert the same set of numbers into both trees.
 * loop the last two steps until you have the desired number of nodes.
 * Print out each tree by calling each trees respective toString.
 * The default toString()'s actually perform a pre-order traversal, but
 * 		prints it out in a different format.
 * Show a in order traversal, in list format to show that all nodes are in
 * 		order.
 *****************************************************************************/
package edu.miracosta.cs113;

import java.util.Random;
//import java.util.Collections;

public class Driver 
{
	//Number of nodes you want in each tree.
	private static final int NODES = 10;
	
	public static void main(String[] args)
	{
		int current;
		
		Random rand =  new Random();
		AVLTree<Integer> avlTree = new AVLTree<>();
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		for(int i = 0; i < NODES; i++)
		{
			current = rand.nextInt(9) + 1;
			avlTree.add(current);
			tree.add(current);
		}
		
		System.out.println("The AVL Tree: ");
		System.out.println(avlTree + "\n");
		System.out.println("The Binary Search Tree: ");
		System.out.println(tree);
		
		System.out.println("In-Order-Traversal of both trees: \n");
		System.out.println("The AVL Tree: ");
		System.out.println(avlTree.printInOrder());
		System.out.println("\nThe Binary Search Tree: ");
		System.out.println(tree.printInOrder());
		
	}
}

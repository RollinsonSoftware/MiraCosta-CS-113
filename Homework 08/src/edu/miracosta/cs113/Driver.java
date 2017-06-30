/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 ********************************************/

/*****************************************************************************
 * HOMEWORK NUMBER 8
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM:
 * Create an abstract class Heap that has two concrete subclasses, MinHeap
 * and MaxHeap. Each subclass should have two constructors, one that takes
 * no parameters and the other that takes a Comparator object. In the
 * abstract class, the compare method should be abstract, and each subclass
 * should define its own compare method to ensure that the ordering of
 * elements corresponds to that required by the heap. For a MinHeap, the
 * key in each node should be greater than the key of its parent; the ordering
 * is reversed for a MaxHeap.
 *****************************************************************************
 * ALGORITHM:
 * Basic tester that makes sure the heap is correctly ordered, both the 
 * MinHeap and the MaxHeap test using Integer's compare method.
 * Insert all the values from lab 11 into the heap.
 * Print the heap for the user.
 * Remove the smallest number from the heap and show it to the user.
 * Print the heap again for the user to show that heap ordering is maintained.
 * Do the same testing for max heap, but removal should remove the largest
 * item instead of the smallest.
 *****************************************************************************/
package edu.miracosta.cs113;

public class Driver
{
	public static void main(String[] args)
	{
		MinHeap<Integer> test = new MinHeap<>();
		MaxHeap<Integer> test2 = new MaxHeap<>();
		
		//These are the numbers from lab 11, so it's easy to check!
		test.insert(10);
		test.insert(14);
		test.insert(3);
		test.insert(6);
		test.insert(12);
		test.insert(13);
		test.insert(7);
		test.insert(4);
		test.insert(1);
		test.insert(2);
		
		System.out.println("The MinHeap is: ");
		test.printHeap();
		
		System.out.println("\n\nThe smallest number in the heap is: " + test.remove());
		
		System.out.println("\nThe MinHeap is: ");
		test.printHeap();
		
		System.out.println("\n\n==================================");
		
		test2.insert(10);
		test2.insert(14);
		test2.insert(3);
		test2.insert(6);
		test2.insert(12);
		test2.insert(13);
		test2.insert(7);
		test2.insert(4);
		test2.insert(1);
		test2.insert(2);
		
		System.out.println("\nThe MaxHeap is: ");
		test2.printHeap();
		
		System.out.println("\n\nThe largest number in the heap is: " + test2.remove());
		
		System.out.println("\nThe MaxHeap is: ");
		test2.printHeap();
	}
}

package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.Comparator;

public class MinHeap<E> extends Heap<E> 
{
	//Data fields:
	/** The initial capacity for this ArrayList */
	public static final int cap = 15;
	/** The ArrayList to hold the data . */
	ArrayList<E> theData;
	/** Reference to a Comparator object. */
	@SuppressWarnings("rawtypes")
	Comparator comparator = null;
	
	public MinHeap()
	{
		theData = new ArrayList<>(cap);
	}
	
	public MinHeap(@SuppressWarnings("rawtypes") Comparator comp)
	{
		theData = new ArrayList<E>(cap);
		comparator = comp;
	}
	
	/**
	 * Insert an item into the heap.
	 * Postcondition: The ArrayList theData is in heap order.
	 * @param object, item that is being added to the heap.
	 * @return true if the item was inserted, false otherwise.
	 * @throws NullPointerException if the item to be inserted is null.
	 */
	@Override
	public boolean insert(E object)
	{
		//Add the item to the heap.
		theData.add(object);
		
		//Child is newly inserted item.
		int child = theData.size() - 1;
		//Find the child's parent.
		int parent = (child - 1) / 2;
		
		//Sort the Heap
		while(parent >= 0 && compare(theData.get(parent), theData.get(child)) > 0)
		{
			swap(theData.get(parent), theData.get(child));
			child = parent;
			parent = (child - 1) / 2;
		}
		return true;
	}
	
	/**
	 * Compare two items using either a Comparator object's compare
	 * method or their natural ordering using method compareTo.
	 * Precondition: If comparator is null, parent and child implement Comparable<E>.
	 * @param parent, one item.
	 * @param child, the other item.
	 * @return Negative int if parent is less than child.
	 * 			Zero if parent is equal to child.
	 * 			Positive int if parent is greater than child.
	 * @throws ClassCastException if items are not comparable.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int compare(E parent, E child) 
	{
		if(comparator != null)
		{
			return comparator.compare(parent, child);
		}
		else
		{
			return ((Comparable<E>) parent).compareTo(child);
		}
	}
	
	/**
	 * Remove an item from the Heap.
	 * Precondition: The ArrayList theData is in heap order.
	 * Postcondition: Removed smallest item, theData is in Heap order.
	 * @return The smallest item in the heap, or null if empty.
	 */
	@Override
	public E remove() 
	{
		if(theData.isEmpty())
		{
			return null;
		}
		
		//Save the top of the Heap.
		E result = theData.get(0);
		
		//If only one item then remove it.
		if(theData.size() == 1)
		{
			theData.remove(0);
			return result;
		}
		
		/**
		 * Remove the last item from the ArrayList and place it into
		 * the first position. 
		*/
		theData.set(0, theData.remove(theData.size() - 1));
		
		//The parent starts at the top.
		int parent = 0;
		while(true)
		{
			int leftChild = 2 * parent + 1;
			if(leftChild >= theData.size())
			{
				break; //Out of Heap.
			}
			
			int rightChild = leftChild + 1;
			int minChild = leftChild; //Assume leftChild is smaller.
			
			//See whether rightChild is smaller.
			if(rightChild < theData.size()
				&& compare(theData.get(leftChild), theData.get(rightChild)) > 0)
			{
				minChild = rightChild;
			}
			
			//assert: minChild is the index of the smaller child.
			//Move smaller child up the heap if necessary.
			if(compare(theData.get(parent), theData.get(minChild)) > 0)
			{
				swap(parent, minChild);
				parent = minChild;
			}
			else
			{
				break; //Heap property is restored.
			}
		}
		return result;
	}
	
	//Helper Methods:
	/**
	 * Swaps the index of the parent and the child.
	 * @param parent object
	 * @param child object
	 */
	private void swap(E parent, E child)
	{
		int parentIndex = theData.indexOf(parent);
		int childIndex = theData.indexOf(child);
		
		theData.set(parentIndex, child);
		theData.set(childIndex, parent);
	}
	/**
	 * Swaps the objects at the indices parent and the child.
	 * @param parent index
	 * @param child index
	 */
	private void swap(int parentIndex, int childIndex)
	{
		E parent = theData.get(parentIndex);
		E child = theData.get(childIndex);
		
		theData.set(parentIndex, child);
		theData.set(childIndex, parent);
	}
	/**
	 * Prints the entire Heap for the user.
	 */
	public void printHeap()
	{
		for(E object : theData)
		{
			System.out.println(object);
		}
	}
}

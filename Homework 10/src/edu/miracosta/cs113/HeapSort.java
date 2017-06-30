package edu.miracosta.cs113;

/** Implementation of the heapsort algorithm. (page 449) */
public class HeapSort 
{
	/**
	 * Sort the array using heapsort algorithm.
	 * pre: Table contains Comparable items.
	 * post: Table is sorted.
	 * @param table, the array to be sorted.
	 */
	public static <T extends Comparable<T>> void sort(T[] table)
	{
		buildHeap(table);
		shrinkHeap(table);
	}
	/**
	 * Transforms the table into a heap.
	 * pre: The array contains at least one item.
	 * post: All items in the array are in heap order. 
	 * @param table, the array to be transformed into a heap.
	 */
	private static <T extends Comparable<T>> void buildHeap(T[] table)
	{
		int n = 1;
		
		while(n < table.length)
		{
			n++;
			int child = n - 1;
			int parent = (child - 1) / 2;
			
			while(parent >= 0 && table[parent].compareTo(table[child]) < 0)
			{
				swap(table, parent, child);
				child = parent;
				parent = (child - 1) / 2;
			}
		}
	}
	/**
	 * Transforms a heap into a sorted array.
	 * pre: All items in the array are in heap order.
	 * post: The array is sorted.
	 * @param table, the array to be sorted.
	 */
	private static <T extends Comparable<T>> void shrinkHeap(T[] table)
	{
		int n = table.length;
		
		while(n > 0)
		{
			n--;
			swap(table, 0, n);
			int parent = 0;
			
			while(true)
			{
				int leftChild = 2 * parent + 1;
				
				if(leftChild >= n)
				{
					break; //No more children.
				}
				
				int rightChild = leftChild + 1;
				int maxChild = leftChild;
				
				if(rightChild < n && table[leftChild].compareTo(table[rightChild]) < 0)
				{
					maxChild = rightChild;
				}
				if(table[parent].compareTo(table[maxChild]) < 0)
				{
					swap(table, parent, maxChild);
					parent = maxChild;
				}
				else //Heap property is restored.
				{
					break; //Exit the loop.
				}
			}
		}
	}
	/**
	 * Swap the items in table[i] and table[j]
	 * @param table, the array that contains the items.
	 * @param i, the index of one item.
	 * @param j, the index of the other item.
	 */
	private static <T extends Comparable<T>> void swap(T[] table, int i, int j)
	{
		T temp = table[i];
		table[i] = table[j];
		table[j] = temp;
	}
}

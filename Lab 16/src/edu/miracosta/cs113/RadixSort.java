package edu.miracosta.cs113;
import java.util.ArrayList;
import java.lang.Number;

public class RadixSort 
{
	/** Sort the table using the RadixSort algorithm
	 * pre : table contains Comparable objects
	 * post : table is sorted
	 * @param table The array to be sorted
	 */
	public static <T extends Number & Comparable<T>> void sort(T[] table)
	{
		ArrayList<ArrayList<T>> list = new ArrayList<ArrayList<T>>();
		list.add(new ArrayList<T>());
		list.add(new ArrayList<T>());
		list.add(new ArrayList<T>());
		list.add(new ArrayList<T>());
		list.add(new ArrayList<T>());
		list.add(new ArrayList<T>());
		list.add(new ArrayList<T>());
		list.add(new ArrayList<T>());
		list.add(new ArrayList<T>());
		list.add(new ArrayList<T>());
		radixSort(table, 10, list, 4);
	}
	
	/** A part of the table using the RadixSort algorithm
	 * 
	 * @param table the array to be sorted
	 * @param radix usually 10
	 * @param list ArrayList<ArrayList<T> 
	 */
	private static <T extends Number & Comparable<T>> void radixSort(T[] table, int radix ,ArrayList<ArrayList<T>> list, int maxDigits )
	{

		if(radix == 0)
		{
			return;
		}
		else
		{
			int num;
			for(T item : table)
			{
				num = item.intValue() / (radix /10);
				if(num % 10 == 0)
				{
					list.get(0).add(item);
				}
				else if(num % 10 == 1)
				{
					list.get(1).add(item);
				}
				else if(num % 10 == 2)
				{
					list.get(2).add(item);
				}
				else if(num % 10 == 3)
				{
					list.get(3).add(item);
				}
				else if(num % 10 == 4)
				{
					list.get(4).add(item);
				}
				else if(num % 10 == 5)
				{
					list.get(5).add(item);
				}
				else if(num % 10 == 6)
				{
					list.get(6).add(item);
				}
				else if(num % 10 == 7)
				{
					list.get(7).add(item);
				}
				else if(num % 10 == 8)
				{
					list.get(8).add(item);
				}
				else if(num % 10 == 9)
				{
					list.get(9).add(item);
				}
			}
			int i = 0;
			for(ArrayList<T> lists : list)
			{
				for(T nums : lists)
				{
					table[i] = nums;
					i++;
				}
				lists.clear();
			}
			
			if(radix == Math.pow(10, maxDigits)) 
			{
				radixSort(table, 0 , list, 4);
			}
			else
			{
				radixSort(table, radix * 10 , list, 4);
			}
				
				

		}
	}
}

//Driver for Programming Exercises 1 & 2 Sec9 on 2.1 pg. 69	
package edu.miracosta.cs113;

import java.util.ArrayList;

public class Driver 
{
	public static void main(String[] args)
	{
		//tests the replace method
		ArrayList<String> list1 = new ArrayList<String>(5);
		//tests the delete method
		ArrayList<String> list2 = new ArrayList<String>(5);
		
		//filling list1
		list1.add("Fred");
		list1.add("Bob");
		list1.add("Jim");
		list1.add("Dave");
		list1.add("Sam");
		
		System.out.println("\nList 1 before delete() call.");
		printList(list1);
		delete(list1, "Jim");
		
		System.out.println("\nList 1 after delete() call.");
		printList(list1);
		
		//filling list2
		list2.add("Fred");
		list2.add("Fred");
		list2.add("Fred");
		list2.add("Bob");
		list2.add("Bob");
		
		System.out.println("\nList 2 before the replace() call.");
		printList(list2);
		replace(list2, "Fred", "Jack");
		
		System.out.println("\nList 2 after the replace() call.");
		printList(list2);
	}
	//Replaces each occurrence of oldItem in aList with newItem.
	public static void replace(ArrayList<String> aList, String oldItem, String newItem)
	{
		for(int i = 0; i < aList.size(); i++)
		{
			if(aList.get(i).equalsIgnoreCase(oldItem))
			{
				aList.set(i, newItem);
			}
		}
	}
	//Deletes the first occurrence of target in aList.
	public static void delete(ArrayList<String> aList, String target)
	{
		for(String index : aList)
		{
			if(index.equalsIgnoreCase(target))
			{
				aList.remove(index);
				break;
			}
		}
	}
	//prints an ArrayList
	public static void printList(ArrayList<String> aList)
	{
		for(String index : aList)
		{
			System.out.println(index);
		}
	}
}

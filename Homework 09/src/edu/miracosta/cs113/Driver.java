/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 ********************************************/

/*****************************************************************************
 * HOMEWORK NUMBER 8
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM:
 * Programming Project 7, pg. 417:
 * Complete class HashtableChain so that it fully implements the Map
 * interface and test it.
 * Complete the class SetIterator as describe in Project 6, pg. 417.
 *****************************************************************************
 * ALGORITHM:
 * Basic tester that makes sure the HashtableChain class implements all methods
 * correctly. 
 * I added the option to read input from the user with the for loop, it works
 * however I commented it out because it is tedious to enter in even 3 students.
 * Instead I made a method to add 10 Students to the Hashtable. 
 *****************************************************************************/

package edu.miracosta.cs113;

public class Driver 
{
	public static void main(String[] args)
	{
		HashtableChain<Character, Student> hash = new HashtableChain<>();
		addAll(hash);
		/**
		for(int i = 0; i < 3; i++)
		{
			//MUST CHANGE THE HASHTABLE KEY 
			//TO INTEGER FOR THIS TO WORK!
			 * 
			Student current = new Student();
			current.setAll();
			hash.put(i, current);
		}
		*/
		print(hash);
		
		System.out.println("\nRemoving the student: " + hash.remove("H"));
	}
	private static void addAll(HashtableChain<Character, Student> hash)
	{
		hash.put('H', new Student("Jack", "Rollinson", 1));
		hash.put('E', new Student("Jeff", "Durkey", 2));
		hash.put('L', new Student("Sansa", "Stark", 5));
		hash.put('P', new Student("Nick", "Houlden", 7));
		hash.put('O', new Student("Andy", "Smith", 80));
		hash.put('N', new Student("Ricky", "Bobby", 23));
		hash.put('U', new Student("Luke", "Skywalker", 3));
		hash.put('R', new Student("Niel", "Caffery", 17));
		hash.put('Y', new Student("Super", "Man", 22));
		hash.put('!', new Student("Cool.", "Jack is", 99));
	}
	private static void print(HashtableChain<Character, Student> hash)
	{
		System.out.println("\nThe current size is: " + hash.size());
		for(int i = 0; i < hash.size(); i++)
			System.out.println("Key: " + i + " Value: " + hash.get(i));
	}
}

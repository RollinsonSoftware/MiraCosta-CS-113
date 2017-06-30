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
 * More in depth tester, the MinHeap min's using the compare method from
 * the class Student, the MaxHeap min's using a comparator's compare method.
 * Ask user for a command
 * if the user enters 1 then fill both heaps with dummy data.
 * output the heaps to the user and show the before and after results of
 * calling the remove method on both data structures.
 * if the user enters 2, ask them how many students they would like to create.
 * loop however many times asked and add each student to both the MinHeap and
 * the MaxHeap.
 * output the heaps to the user and show the before and after results of
 * calling the remove method on both data structures.
 * if the user enters 3 exit the program.
 *****************************************************************************/
package edu.miracosta.cs113;

import java.util.Scanner;

public class StudentDriver
{
	public static void main(String[] args)
	{
		Scanner key = new Scanner(System.in);
		//MinHeap uses the student's compareTo method.
		MinHeap<Student> min = new MinHeap<>();
		//MaxHeap uses the comparator's compare method.
		MaxHeap<Student> max = new MaxHeap<>(new CompareStudents());
		
		int command = 0;
		int loopNum;
		
		menu();
		System.out.print("\nPlease enter a command: ");
		command = key.nextInt();
			
		if(command == 1)
		{
			min.insert(new Student("Jack", "Rollinson", 1));
			min.insert(new Student("Jeff", "Durkey", 2));
			min.insert(new Student("Sansa", "Stark", 5));
			min.insert(new Student("Nick", "Houlden", 7));
			min.insert(new Student("Andy", "Smith", 80));
			min.insert(new Student("Ricky", "Bobby", 23));
			min.insert(new Student("Luke", "Skywalker", 3));
			min.insert(new Student("Niel", "Caffery", 17));
			min.insert(new Student("Super", "Man", 22));
			min.insert(new Student("Cool.", "Jack is", 99));
					
			System.out.println("The MinHeap is: \n");
			min.printHeap();
					
			System.out.println("\n\nThe smallest number in the heap is: " + min.remove());
					
			System.out.println("\nThe MinHeap is: \n");
			min.printHeap();
			
			System.out.println("\n\n==================================");
					
			max.insert(new Student("Jack", "Rollinson", 1));
			max.insert(new Student("Jeff", "Durkey", 2));
			max.insert(new Student("Sansa", "Stark", 5));
			max.insert(new Student("Nick", "Houlden", 7));
			max.insert(new Student("Andy", "Smith", 80));
			max.insert(new Student("Ricky", "Bobby", 23));
			max.insert(new Student("Luke", "Skywalker", 3));
			max.insert(new Student("Niel", "Caffery", 17));
			max.insert(new Student("Super", "Man", 22));
			max.insert(new Student("Cool.", "Jack is", 99));
					
			System.out.println("\nThe MaxHeap is: ");
			System.out.println("(Now making comparisons with the comparator)\n");
			max.printHeap();
					
			System.out.println("\n\nThe largest number in the heap is: " + max.remove());
					
			System.out.println("\nThe MaxHeap is: \n");
			max.printHeap();
		}
		else if(command == 2)
		{
			System.out.print("How many students would you like to create? :");
			loopNum = key.nextInt();
					
			for(int i = 0; i < loopNum; i++)
			{
				Student current = new Student();
				current.setAll();
				min.insert(current);
				max.insert(current);
			}
			System.out.println("The MinHeap is: \n");
			min.printHeap();
					
			System.out.println("\n\nThe smallest number in the heap is: " + min.remove());
					
			System.out.println("\nThe MinHeap is: \n");
			min.printHeap();
					
			System.out.println("\n\n==================================");
					
			System.out.println("\nThe MaxHeap is: ");
			System.out.println("(Now making comparisons with the comparator)\n");
			max.printHeap();
					
			System.out.println("\n\nThe largest number in the heap is: " + max.remove());
					
			System.out.println("\nThe MaxHeap is: \n");
			max.printHeap();
		}
		else if(command == 3)
		{
			key.close();
			System.exit(0);
		}
	}
	/**
	 * outputs menu to the user.
	 */
	public static void menu()
	{
		System.out.println("====================================");
		System.out.println("1 = Show output with premade values.");
		System.out.println("2 = Make your own vlaues!");
		System.out.println("3 = Exit.");
		System.out.println("====================================");
	}
}

/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 * SECTION:		3
 * TOPIC #:		3
 ********************************************/

/*****************************************************************************
 * HOMEWORK NUMBER 3
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM:
 * Write a program to manage a list of students waiting to register for a course as
 * described in section 2.5 include operations for adding to the front and the end
 * of the list, as well as removing a student by name, and removing the first student
 * from the list.
 *****************************************************************************
 * ALGORITHM:
 * Create a new empty linked list.
 * Prompt the user to add 5 students to the front of the list for testing
 * Print the list out to show the user the contents of the list
 * Prompt the user to give you one more name to test adding to the end of the list
 * make a new student and add them to the end of the list
 * Print the list out to show the user the contents of the list, and what has changed
 * Remove the first student from the list
 * Print the list out to show the user the contents of the list
 * Prompt user for information on a student to remove them from the list
 * Create a new student object and search the list for a match
 * 	remove student object if match is found.
 * Print the list out to show the user the contents of the list, to show the student was removed.
 *****************************************************************************/
package edu.miracosta.cs113;

public class Homework3Driver 
{
	public static void main(String[] args)
	{
		DoublyLinkedList<Student> list = new DoublyLinkedList<Student>();
		
		System.out.println("Please choose names for 5 students.");
		System.out.println("We will be adding each new student to the front of the list");
		
		//testing adding students to the front
		for(int i = 0; i < 5; i++)
		{
			Student current = new Student();
			current.setAll();
			
			list.addFirst(current);
		}
		
		showList(list);
		
		//adding a student to the end of the list
		System.out.println("\nNow lets add a new student to the end!");
		System.out.println("What should the students name be?");
		Student end = new Student();
		end.setAll();
		list.addLast(end);
		
		showList(list);
		
		//removing the first student on the list
		System.out.println("\nNow lets remove a student from the beginning of the list!");
		list.removeFirst();
		
		showList(list);
		
		Student test = new Student("Test", "Student");
		list.add(3, test);
		showList(list);
		list.remove(test);
		showList(list);
	}
	public static void showList(DoublyLinkedList<Student> list)
	{
		System.out.println("\nThe list currently looks like: ");
		System.out.println(list);
	}
}

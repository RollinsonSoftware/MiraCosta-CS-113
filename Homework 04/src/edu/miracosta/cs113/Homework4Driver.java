//Made a better tester for the doubly linked list methods, This has faster testing and easier
//	readability over the Homework3 Driver (the homework asked to test with the homework 3 driver).

/*****************************************************************************
 * HOMEWORK NUMBER 4
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM:
 * Implement the list interface in java, this should be the doubly linked list
 * Also include the iterator. This is a tester for the the list.
 *****************************************************************************
 * ALGORITHM:
 * Create a method that will test all the add methods, for easy testing.
 * Create a method that utilizes the toString() doubly linked list class to print
 * the entire list out.
 * Create a new List and add the items.
 * Test all methods from doubly linked list class on the new list.
 *****************************************************************************/
package edu.miracosta.cs113;

public class Homework4Driver 
{
	public static void main(String[] args)
	{
		DoublyLinkedList<Student> list = new DoublyLinkedList<Student>();
		showList(list); // should be blank
		addItems(list);
		addItems(list);
		showList(list); // should have have 4 items, testing the add() and addFirst()
		
		list.clear(); //clearing the list
		showList(list);
		addItems(list); //re-adding
		showList(list); //should have 4
		
		System.out.println("The FIRST person on the list is: " + list.getFirst());
		System.out.println("Removing the first person on the list, which was: " + list.removeFirst());
		System.out.println("The LAST person on the list is: " + list.getLast() + "\n");
		
		showList(list);
		
		System.out.println("The student in the 2nd spot is: " + list.get(2) + "\n");
		
		//testing remove()
		Student test = new Student("Test", "Student");
		list.add(3, test);
		showList(list);
		list.remove(test);
		showList(list);
		
		
	}
	public static void addItems(DoublyLinkedList<Student> list)
	{
		Student student1 = new Student("Jack", "Rollinson");
		Student student2 = new Student("Bruce", "Wayne");
		Student student3 = new Student("Tim", "Blake");
		Student student4 = new Student("Jim", "Gundarson");
		
		list.addFirst(student1);
		list.addLast(student2);
		list.add(2, student3);
		list.addFirst(student4);
	}
	public static void showList(DoublyLinkedList<Student> list)
	{
		System.out.println("The list currently looks like: ");
		System.out.println(list);
		System.out.println("The current size of the list is: " + list.size() + "\n");
	}
}

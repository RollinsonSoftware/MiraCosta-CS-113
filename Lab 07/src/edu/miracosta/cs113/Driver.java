/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 ********************************************/

/*****************************************************************************
 * LAB NUMBER 7
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM:
 * Programming Project 3 on page 191.
 *****************************************************************************
 * ALGORITHM:
 * Create a new ArrayStack
 * Show the user that it is empty (tests empty method)
 * Fill the stack with values (tests the push method)
 * Show the value at the top of the stack to the user (tests the peek method)
 * Pop a few values from the stack and show the user (tests the pop method)
 * Again show the top of the stack, this should be the next value after the
 * 		previously popped value.
 *****************************************************************************/
package edu.miracosta.cs113;

public class Driver 
{
	public static void main(String[] args)
	{
		ArrayStack<Integer> test = new ArrayStack<Integer>();
		
		System.out.println("Is the stack empty? (true/false): " + test.empty());
		
		System.out.println("\nNow pushing the numbers 1-100 onto the stack!");
		for(int i = 0; i <= 100; i++)
		{
			test.push(i);
		}
		
		System.out.println("\nThe top of the stack is: " + test.peek());
		
		System.out.println("\nNow popping the first 5 values at the top of the stack!\n");
		for(int i = 0; i < 5; i++)
		{
			System.out.println(test.pop());
		}
		
		System.out.println("\nThe top of the stack is now: " + test.peek());
	}
}

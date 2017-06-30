/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 ********************************************/

/*****************************************************************************
 * LAB NUMBER 8
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM:
 * Programming problems 1, 2, and 3 on page 200.
 *****************************************************************************
 * ALGORITHM:
 * Create two stacks of Integer objects.
 * Store the numbers -1, 15, 23, 44, 4, 99 in the first stack.
 * Show that the top of the first stack is 99.
 * Loop to get each number from the first stack and store it in the second
 *  	stack as well as the queue.
 * Loop to remove a value from the second stack and from the queue, display
 * 		each pair of values on a separate output line.
 * Continue until the data structures are empty show the output.
 *****************************************************************************/
package edu.miracosta.cs113;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Driver 
{
	public static void main(String[] args)
	{
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		Queue<Integer> queue1 = new LinkedList<Integer>();
		
		stack1.push(-1);
		stack1.push(15);
		stack1.push(23);
		stack1.push(44);
		stack1.push(4);
		stack1.push(99);
		
		System.out.println("Top of stack: " + stack1.peek());
		
		while(stack1.size() != 0)
		{
			Integer enterQueue = stack1.peek();
			System.out.println("\nAdding to the queue: " + enterQueue);
			System.out.println("\nAdding to the second stack and removing from first: " + stack1.peek());
			stack2.push(stack1.pop());
			queue1.offer(enterQueue);
		}
		while(stack2.size() != 0 && queue1.size() != 0)
		{
			System.out.println("\nThe next number in the 2nd Stack is: " + stack2.peek());
			stack2.pop();
			System.out.println("\nThe next number in the Queue is: " + queue1.peek());
			queue1.poll();
		}
		System.out.println("Stack 1 empty? (true/false): " + stack1.empty());
		System.out.println("Stack 2 empty? (true/false): " + stack2.empty());
		System.out.println("Queue 1 empty? (value/null): " + queue1.peek());
	}
}

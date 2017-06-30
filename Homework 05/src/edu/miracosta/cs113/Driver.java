/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 ********************************************/

/*****************************************************************************
 * HOMEWORK NUMBER 5
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM:
 * Programming project number 9 on page 193.
 *****************************************************************************
 * ALGORITHM:
 * This will work with any word capital or lower case.
 * If testing with a palindrome sentence, remove all spaces and punctuation.
 * Create two stacks.
 * Ask a user for a word to check if it is a palindrome.
 * Check if the word as an even or odd amount of characters.
 * Loop to add each character from the string onto a stack.
 * Loop to add half of the contents of that stack to a second stack.
 * Empty both the stacks into two separate strings and compare them.
 * If the word had an odd amount of characters to begin with, remove the first
 * 		character from the second string (this is actually the middle character)
 * Output to the user if the word was a palindrome or not.
 *****************************************************************************/
package edu.miracosta.cs113;

import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args)
	{
		String word;
		
		Scanner keyboard = new Scanner(System.in);
		ListStack<Character> stack1 = new ListStack<Character>();
		ListStack<Character> stack2 = new ListStack<Character>();
		
		System.out.print("Please enter a word: ");
		word = keyboard.nextLine();
		keyboard.close(); 
		
		if(word.length() % 2 == 0)
		{
			String firstHalf = "";
			String secondHalf = "";
			
			for(int i = 0; i < word.length(); i++)
			{
				stack1.push(word.charAt(i));
			}
			for(int i = 0; i < word.length() / 2; i++)
			{
				stack2.push(stack1.pop());
			}
			while(stack1.empty())
			{
				char letter = stack1.pop();
				firstHalf += letter;
			}
			while(stack2.empty())
			{
				char letter = stack2.pop();
				secondHalf += letter;
			}
			//System.out.println("first half: " + firstHalf);
			//System.out.println("second half: " + secondHalf);
			if(firstHalf.equalsIgnoreCase(secondHalf))
			{
				System.out.println(word + " IS a palindrome!");
			}
			else
			{
				System.out.println(word + " IS NOT a palindrome!");
			}
		}
		else
		{
			String firstHalf = "";
			String secondHalf = "";
			
			for(int i = 0; i < word.length(); i++)
			{
				stack1.push(word.charAt(i));
			}
			for(int i = 0; i < word.length() / 2; i++)
			{
				stack2.push(stack1.pop());
			}
			while(stack1.empty())
			{
				char letter = stack1.pop();
				firstHalf += letter;
			}
			while(stack2.empty())
			{
				char letter = stack2.pop();
				secondHalf += letter;
			}
			firstHalf = firstHalf.substring(1);
			//System.out.println("first half: " + firstHalf);
			//System.out.println("second half: " + secondHalf);
			if(firstHalf.equalsIgnoreCase(secondHalf))
			{
				System.out.println(word + " IS a palindrome!");
			}
			else
			{
				System.out.println(word + " IS NOT a palindrome!");
			}
		}
	}
}

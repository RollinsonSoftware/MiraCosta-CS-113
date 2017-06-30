/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 * SECTION:		1
 * TOPIC #:		1
 ********************************************/

/*****************************************************************************
 * LAB NUMBER 1
 *****************************************************************************
 * PROGRAM DESCRIPTION/LAB PROBLEM:
 * Write a program that prints the number from 1 to 100, but for multiples of
 * 3 print "Fizz" instead of the number and for multiples of 5 print "Buzz".
 * For numbers that are multiples of both 3 and 5 print "Fizzbuzz".
 *****************************************************************************
 * ALGORITHM:
 * Make a for loop that runs exactly 100 times and prints each number 1-100.
 * 		if num / 3 = 0 and num / 5 = 0
 * 			print "Fizzbuzz"
 * 		if num / 3 = 0
 * 			print "Fizz"
 * 		if num / 5 = 0
 * 			print "Buzz"
 * 		else
 * 			print num
 *****************************************************************************/
package edu.miracosta.cs113;

public class Driver 
{
	public static void main(String[] args) 
	{
		for(int i = 1; i <= 100; i++)
		{
			if((i % 3 == 0) && (i % 5 == 0))
			{
				System.out.println("Fizzbuzz");
			}
			else if(i % 3 == 0)
			{
				System.out.println("Fizz");
			}
			else if(i % 5 == 0)
			{
				System.out.println("Buzz");
			}
			else
			{
				System.out.println(i);
			}
		}
	}
}

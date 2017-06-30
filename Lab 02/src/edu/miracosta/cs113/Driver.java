/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 * SECTION:		1
 * TOPIC #:		1
 ********************************************/

/*****************************************************************************
 * LAB NUMBER 2
 *****************************************************************************
 * PROGRAM DESCRIPTION/LAB PROBLEM:
 * Write a method that finds out if a number is a power of two (without using
 * bitwise operators). Create a tester program to test a couple of values to prove
 * your method works.
 *****************************************************************************
 * ALGORITHM:
 * Ask user for a valid int to test if its a power of 2.
 * Check if the number is a power of two using a method call.
 * *inside method now*
 * if number given is 0
 * 		return false
 * if number given is 1
 * 		return true
 * before checking any other number, make sure the number in question is positive
 * 	by finding its absolute value.
 * while a number is > 2
 * 		if number / 2 is not = 0
 * 			break
 * 		set number = number / 2
 * 		return false if number is still > than 2
 *		return true if number is no longer > than 2
 *****************************************************************************/
package edu.miracosta.cs113;
import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args)
	{
		int num;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a number to test: ");
		num = keyboard.nextInt();
		keyboard.close();
		
		if(checkPower(num))
		{
			System.out.println(num + " IS a power of 2!");
		}
		else
		{
			System.out.println(num + " IS NOT a power of 2!");
		}
	}
	public static boolean checkPower(int num)
	{
		if(num == 0)
		{
			return false;
		}
		if(num == 1)
		{
			return true;
		}
		
		num = Math.abs(num);
		
		while(num > 2)
		{
			if(num % 2 != 0)
			{
				break;
			}
			num /= 2;
		}
		return !(num > 2);
	}
}

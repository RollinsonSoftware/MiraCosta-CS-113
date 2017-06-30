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
 * write a program that can combine polynomials
 *****************************************************************************
 * ALGORITHM:
 * read in all the polynomials for first equation
 * print equation for the user
 * read in all the polynomials for the second equation
 * print the equation for the user
 * Copy contents of both arraylists to one arraylist
 * sort the arraylist in order of largest exponent
 * print the equation for the user
 * combine like terms
 * print the equation for the user
 *****************************************************************************/
package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class TermDriver 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Term> polynomial1 = new ArrayList<>(5);
		ArrayList<Term> polynomial2 = new ArrayList<>(5);
		ArrayList<Term> answer = new ArrayList<>(10);
		
		int coefficient;
		int exponent;
		
		System.out.println("Enter terms in order, (exponent = 1 for x and exponent = 0 for just a coefficient)");
		System.out.println("Please enter the terms for the first polynomial.");
		do
		{	
			System.out.print("\nEnter a coefficient: ");
			coefficient = keyboard.nextInt();
			
			System.out.print("\nEnter an exponent: ");
			exponent = keyboard.nextInt();
			
			polynomial1.add(new Term(coefficient, exponent));
		}while(coefficient > 0 && exponent > 0);
		
		System.out.println("\nThe first polynomial is:");
		printPoly(polynomial1);
		
		System.out.println("\nPlease enter the terms for the second polynomial.");
		do
		{
			System.out.print("\nEnter a coefficient: ");
			coefficient = keyboard.nextInt();
			
			System.out.print("\nEnter an exponent: ");
			exponent = keyboard.nextInt();
			
			polynomial2.add(new Term(coefficient, exponent));
		}while(coefficient > 0 && exponent > 0);
		
		System.out.println("\nThe second polynomial is:");
		printPoly(polynomial2);
		
		for(Term num : polynomial1)
		{
			answer.add(num);
		}
		for(Term num : polynomial2)
		{
			answer.add(num);
		}
		
		Collections.sort(answer);
		Collections.reverse(answer);
		
		System.out.println("\n\nThe 2 polynomials added together is, before combining like terms is:");
		printPoly(answer);
		
		for(int i = 0; i < answer.size(); i++)
		{
			if(answer.get(i).compareTo(answer.get(i + 1)) == 0)
			{
				int num = answer.get(i).getCoefficient() + answer.get(i + 1).getCoefficient();
				answer.set(i, new Term(num, answer.get(i).getExponent()));
				answer.remove(i + 1);
			}
		}
		
		System.out.println("\n\nThe 2 polynomials added together is:");
		printPoly(answer);
		
		keyboard.close();
	}
	public static void printPoly(ArrayList<Term> list)
	{
		boolean showAdd = false;
		for(Term num : list)
		{
			if(showAdd == true)
			{
				System.out.print(" + ");
			}
			System.out.print(num);
			showAdd = true;
			}
	}
}

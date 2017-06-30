/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 ********************************************/

/*****************************************************************************
 * HOMEWORK NUMBER 6 PART 1
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM:
 * Programming Projects 5, Page 240:
 * Write a program to simulate processing 100 print jobs of varying lengths,
 * using one, two, or three printers. Assume that a print request is made
 * every minute and that the number of pages to print varies from 1 to 50.
 *****************************************************************************
 * ALGORITHM:
 * Ask the user how many printers to test with.
 * Loop 100 times to create 100 new print jobs.
 * Using the Math.Random class set a random number of pages for each print job.
 * Calculate the start time based off the end time of the previous print job.
 * Calculate the end time based off the number of pages for each print job.
 * Once all instance variables are set for the print job object, add it to a queue.
 * Depending on the number of pages, send it to small, medium or large queue.
 * Print results for the user, using the PrintJob.toString().
 *****************************************************************************/
package edu.miracosta.cs113.project1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args)
	{
		int time = 0; //Helps the large printer keep track of time.
		int printers = 0;
		
		Random pages =  new Random();
		Scanner keyboard = new Scanner(System.in);

		ListQueue<PrintJob> small = new ListQueue<>();
		ListQueue<PrintJob> medium = new ListQueue<>();
		ListQueue<PrintJob> large = new ListQueue<>();
		
		try
		{
			System.out.print("How many printers would you like to test with? (1-3): ");
			printers = keyboard.nextInt();
			keyboard.close();
			
			if(printers == 1)
			{
				for(int i = 0; i < 100; i++)
				{
					PrintJob current = new PrintJob(pages.nextInt(10) + 1, i);
					
					if(current.getPages() <= 10)
					{
						current.setEndTime(i + 1);
						small.offer(current);
					}
				}
			}
			else if(printers == 2)
			{
				for(int i = 0; i < 100; i++)
				{
					PrintJob current = new PrintJob(pages.nextInt(20) + 1, i);
					
					if(current.getPages() <= 10)
					{
						current.setEndTime(i + 1);
						small.offer(current);
					}
					else if(current.getPages() <= 20)
					{
						current.setEndTime(i + 2);
						medium.offer(current);
					}
				}
			}
			else if(printers == 3)
			{
				for(int i = 0; i < 100; i++)
				{
					PrintJob current = new PrintJob(pages.nextInt(50) + 1, i);
					
					if(current.getPages() <= 10)
					{
						current.setEndTime(i + 1);
						small.offer(current);
					}
					else if(current.getPages() <= 20)
					{
						current.setEndTime(i + 2);
						medium.offer(current);
					}
					else if(current.getPages() <= 30)
					{
						current.setStartTime(time + 1);
						time = current.setEndTime(time + 4);
						large.offer(current);
					}
					else if(current.getPages() <= 40)
					{
						current.setStartTime(time + 1);
						time = current.setEndTime(time + 5);
						large.offer(current);
					}
					else if(current.getPages() <= 50)
					{
						current.setStartTime(time + 1);
						time = current.setEndTime(time + 6);
						large.offer(current);
					}
				}
			}
			else
			{
				throw new InputMismatchException();
			}
		}
		catch (InputMismatchException e) 
        {
            System.out.println("ERROR: You can only test with 1, 2, or 3 printers!");
            System.exit(0);
        }
		
		while(small.peek() != null)
		{
			System.out.println("\nPrinted from small:");
			System.out.println(small.poll());
		}
		while(medium.peek() != null)
		{
			System.out.println("\nPrinted from medium:");
			System.out.println(medium.poll());
		}
		while(large.peek() != null)
		{
			System.out.println("\nPrinted from large:");
			System.out.println(large.poll());
		}
	}
}

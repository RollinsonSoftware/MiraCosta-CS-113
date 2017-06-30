/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 ********************************************/

/*****************************************************************************
 * HOMEWORK NUMBER 10
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM:
 * A variation of the merge sort algorithm can be used to sort large sequential
 * data files. The basic strategy is to take the initial data file, read in several
 * (say, 10) data records, sort these records using an efficient array-sorting
 * algorithm, and then write these sorted groups of records (runs) alternately
 * to one of two output files. After all records from the initial data file have
 * been distributed to the two output files, the runs on these output files are
 * merged one pair of runs at a time and written to the original data file. After
 * all runs from the output file have been merged, the records on the original
 * data file are redistributed to the output files, and the merging process is
 * repeated. Runs no longer need to be sorted after the first distribution to
 * the temporary output files.
 *****************************************************************************
 * ALGORITHM:
 * start by pulling groups of 10 data files from the initial data file.
 * sort each array made using heap sort algorithm from the book.
 * alternate between the left and right text files, copying all the values from
 * 		the array.
 * while checking to see if the left and right text files are empty.
 * pull one group of 10 from the left and the right and merge them into a new
 * 		array using the merge sort algorithm from the book.
 * write the groups of 20 to the initial text file.
 * continue this process but with each iteration, the amount of values being 
 * 		written to the initial text file is * 2.
 * Stop when the number of int's being pull from the text files exceeds the
 * 		total number of values in the text file.
 *****************************************************************************/
package edu.miracosta.cs113;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.Comparable;

public class Driver<T extends Comparable<T>>
{
	private static final String INITIAL_FILE = "data.txt";
	private static final String LEFT_FILE = "alt1.txt";
	private static final String RIGHT_FILE = "alt2.txt";
	
	public static void main(String[] args) 
	{
		int count = 0;
		int numData = 0;
		String temp = " ";
		
		Integer[] table = new Integer[10] ;
		Integer[] rightTable = null;
		Integer[] leftTable = null;
		
		PrintWriter outputStreamI = null; // I for INITIAL
		PrintWriter outputStreamL = null; // L for LEFT
		PrintWriter outputStreamR = null; // R for RIGHT
		 
		Scanner inputStreamI = null; // I for INITIAL
		Scanner inputStreamL = null; // L for LEFT
		Scanner inputStreamR = null; // R for RIGHT
		
		try
		{
			inputStreamI = new Scanner(new FileInputStream(INITIAL_FILE));
			outputStreamL = new PrintWriter(new FileOutputStream(LEFT_FILE));
			outputStreamR = new PrintWriter(new FileOutputStream(RIGHT_FILE));
		}
		catch(IOException e)
		{
			System.out.println("Trouble establishing I/O streams!");
			e.printStackTrace();
		}
		
		while(inputStreamI.hasNextLine())
		{
			table = new Integer[10];
			
			//Pulling groups of ten from the original text file.
			for(int i = 0; i < table.length ; i++)
			{
				temp = inputStreamI.nextLine();
				table[i] = Integer.parseInt(temp);
				numData++;
			}
			
			//Sorting once and done!
			HeapSort.sort(table);
			
			//alternate writing the groups of 10 to the right and left text files.
			for(Integer index : table)
			{
				if(count % 2 == 0)
				{
					outputStreamL.println(index);
				}
				else
				{
					outputStreamR.println(index);
				}
			}
			count++;
		}
		
		inputStreamI.close();
		outputStreamL.close();
		outputStreamR.close();
		
		try
		{
			outputStreamI = new PrintWriter(new FileOutputStream(INITIAL_FILE));
			inputStreamL = new Scanner(new FileInputStream(LEFT_FILE));
			inputStreamR = new Scanner(new FileInputStream(RIGHT_FILE));	
		}
		catch(IOException e)
		{
			System.out.println("Trouble establishing I/O streams!");
			e.printStackTrace();
		}
		
		while(inputStreamL.hasNextLine() || inputStreamR.hasNextLine())
		{
			rightTable = new Integer[10];
			leftTable = new Integer[10]; 
			table = new Integer[rightTable.length + leftTable.length]; 
			
			//Pulling 10 integers from the left.
			for(int i = 0; i < leftTable.length; i++)
			{
				temp = inputStreamL.nextLine();
				leftTable[i] = Integer.parseInt(temp);
			}
			//Pulling 10 integers from the right.
			for(int j = 0; j < rightTable.length; j++)
			{
				temp = inputStreamR.nextLine();
				rightTable[j] = Integer.parseInt(temp);
			}
			
			//Merging left and right, then writing to original file.
			merge(table, rightTable, leftTable);
			
			//writing sets of 20 to the original file.
			for(Integer index : table)
			{
				outputStreamI.println(index);
			}
		}
		
		outputStreamI.close();
		inputStreamL.close();
		inputStreamR.close();
		
		int length = 20;
		
		while(length <= numData)
		{
			count = 0;
			
			try
			{
				inputStreamI = new Scanner(new FileInputStream(INITIAL_FILE));
				outputStreamL = new PrintWriter(new FileOutputStream(LEFT_FILE));
				outputStreamR = new PrintWriter(new FileOutputStream(RIGHT_FILE));
			}
			catch(IOException e)
			{
				System.out.println("Trouble establishing I/O streams!");
				e.printStackTrace();
			}
			
			while(inputStreamI.hasNextLine())
			{
				table = new Integer[length];
				
				//read in 'length' values from the original file.
				for(int i = 0; i < table.length ; i++)
				{
					if(inputStreamI.hasNextLine())
					{
						temp = inputStreamI.nextLine();
					}
					
					table[i] = Integer.parseInt(temp);
				}
				
				//alternate writing the values to the left and right sequence.
				for(Integer index : table)
				{
					if(count % 2 == 0)
					{
						outputStreamL.println(index);
					}
					else
					{
						outputStreamR.println(index);
					}		
				}
				count++;
			}
			
			inputStreamI.close();
			outputStreamL.close();
			outputStreamR.close();
			
			try
			{
				outputStreamI = new PrintWriter(new FileOutputStream(INITIAL_FILE));
				inputStreamL = new Scanner(new FileInputStream(LEFT_FILE));
				inputStreamR = new Scanner(new FileInputStream(RIGHT_FILE));
			}
			catch(IOException e)
			{
				System.out.println("Class or IO Error!");
				e.printStackTrace();
			}
			
			//Handles the case if left and the right do not have equal sizes.
			while(inputStreamL.hasNextLine() || inputStreamR.hasNextLine())
			{
				rightTable = new Integer[length];
				leftTable = new Integer[length];
				table = new Integer[rightTable.length + leftTable.length];
				
				for(int i = 0; i < leftTable.length ; i++)
				{
					if(inputStreamL.hasNextLine())
					{
						temp = inputStreamL.nextLine();
						leftTable[i] = Integer.parseInt(temp);
					}
				}
				
				for(int k = 0; k < rightTable.length ; k++)
				{
					if(inputStreamR.hasNextLine())
					{
						temp = inputStreamR.nextLine();
						rightTable[k] = Integer.parseInt(temp);
					}
				}
				
				merge(table ,rightTable, leftTable);
		
				for(Integer index : table)
				{
					if(index != null)
					{
						outputStreamI.println(index);
					}
				}
			}
			length = length * 2;
			
			outputStreamI.close();
			inputStreamL.close();
			inputStreamR.close();
		}
		
		System.out.println("Finished sorting the text files, please check them in the folder!\n");
		System.out.println("Exiting program...");
	}
	
	// Code for method is found on page 442 of the text book. (with some minor changes)
	private static <T extends Comparable<T>> void merge(T[] outputSequence, T[] leftSequence, T[] rightSequence)
	{
		int i = 0; //Index into the left input sequence.
		int j = 0; //Index into the right input sequence.
		int k = 0; //Index into the output sequence.
		
		// While there is data in both input sequences.
		while(i < leftSequence.length && j < rightSequence.length)
		{
			if(leftSequence[i] == null)
			{
				i = leftSequence.length;
				
				if(rightSequence[j] == null)
				{
					j = rightSequence.length;
				}
			}
			else if(rightSequence[j] == null)
			{
				if(leftSequence[j] == null)
				{
					j = leftSequence.length;
				}
				
				j = rightSequence.length;
			}
			
			// Find the smaller and insert it into the output sequence.
			else if(leftSequence[i].compareTo(rightSequence[j]) < 0)
			{
				outputSequence[k++] = leftSequence[i++];
			}
			else
			{
				outputSequence[k++] = rightSequence[j++];
			}
		}
		
		// assert: one of the sequences has more items to copy.
		// Copy remaining input from left sequence into the output sequence.
		while(i < leftSequence.length)
		{
			if(leftSequence[i] == null)
			{
				i = leftSequence.length;
			}
			else
			{
				outputSequence[k++] = leftSequence[i++];
			}
		}
		
		// Copy remaining input from right sequence into output.
		while(j < rightSequence.length)
		{
			if(rightSequence[j] == null)
			{
				j = rightSequence.length;
			}
			else
			{
				outputSequence[k++] = rightSequence[j++];
			}
		}
	}
}
/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 ********************************************/

/*****************************************************************************
 * HOMEWORK NUMBER 10
 *****************************************************************************
 * ALGORITHM:
 * Basic driver to create and fill a new text file with random number between
 * 1 and 691. This class must be ran before the Driver is compiled and executed.
 * Creates a new output stream.
 * Loops a set number of times and upon each iterations, writes a new integer
 * value + a new line to text file.
 * when finished filling the text file, the user is notified and the program
 * ends.
 *****************************************************************************/
package edu.miracosta.cs113;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class WriteDataFile 
{
	//Changes the number of lines in the text file.
	private static final int DATA_SIZE = 700;
	
	public static void main(String[] args)
	{
		PrintWriter outputStream = null;
		Random rand = new Random();
		
		try
		{
			outputStream = new PrintWriter(new FileOutputStream("data.txt"));
		}
		catch(IOException e)
		{
			System.out.println("Output/Input Stream could not be established.");
			e.printStackTrace();
		}
		
		//Creating the unsorted text file.
		for(int i = 0; i < DATA_SIZE; i++)
		{
			outputStream.println((rand.nextInt(697) + 1));
		}
		
		outputStream.close();
		System.out.println("Data file has been created!\n");
		System.out.println("Exiting program...\n");
	}
}

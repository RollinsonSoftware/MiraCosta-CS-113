package edu.miracosta.cs113;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TreeTester 
{
	public static void main(String[] args) 
	{
		Scanner inputStream = null;
		Scanner code = null;
		String temp;
		int command;
		
		Scanner keyboard = new Scanner(System.in);
		
		try
	    {
			inputStream = new Scanner(new FileInputStream("codes.txt"));
	    } 
	    catch(FileNotFoundException e)
	    {
	    	System.out.println("Text file was not found, exiting program.");
	    	System.exit(0);
	    }
		
		BinaryTree<String> tree = BinaryTree.readBinaryTree(inputStream);
		inputStream.close();
		
		
		menu();
		System.out.print("Please enter a command: ");
		command = keyboard.nextInt();
		keyboard.nextLine();
		
		while(command < 4)
		{
			if(command == 1)
			{
				System.out.printf("%s %s %4s %s" , "| ", decodeNode(tree, "*-") + " : ", " *-  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "-***")  + " : ", " -***  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "-*-*")  + " : ", " -*-*  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "-**")  + " : ", " -**  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "*")  + " : ", " *  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "**-*")  + " : ", " **-*  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "--*")  + " : ", " --*  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "****")  + " : ", " ****  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "**")  + " : ", " **  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "*---")  + " : ", " *---  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "-*-")  + " : ", " -*-  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "*-**")  + " : ", " *-**  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "--")  + " : ", " --  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "-*")  + " : ", " -*  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "---")  + " : ", " ---  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "*--*")  + " : ", " *--*  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "--*-")  + " : ", " --*-  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "*-*")  + " : ", " *-*  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "***")  + " : ", " ***  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "-")  + " : ", " -  ", " |");
				System.out.printf("%s %s1 %4s %s" , "\n| ", decodeNode(tree, "**-")  + " : ", " **-  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "***-")  + " : ", " ***-  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "*--")  + " : ", " *--  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "-**-")  + " : ", " -**-  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "-*--")  + " : ", " -*--  ", " |");
				System.out.printf("%s %s %4s %s" , "\n| ", decodeNode(tree, "--**")  + " : ", " --**  ", " |");
			}
			else if(command == 2)
			{
				System.out.print("What is the name of the file? : ");
				temp = keyboard.nextLine();
				
				try
			    {
					inputStream = new Scanner(new FileInputStream(temp));
			    } 
			    catch(FileNotFoundException e)
			    {
			     	System.out.println("Text file was not found, exiting program.");
			    	System.exit(0);
			    }
				
				System.out.println("Translation: ");
				
				while(inputStream.hasNextLine())
				{
					code = new Scanner(inputStream.nextLine());
					System.out.println(decodeLine(tree, code));
					code.close();
				}
			}
			else if(command == 3)
			{
				System.out.println("Please enter morse code for translation(only use *, - and spaces): ");
				temp = keyboard.nextLine();
				
				code = new Scanner(temp);
				System.out.println("The translation is : " + decodeLine(tree, code));
				code.close();
			}
			
			menu();
			System.out.print("Please enter your command : ");
			temp = keyboard.nextLine();
			command = Integer.parseInt(temp);
		}
		keyboard.close();
	}//end of main
	

	/**
	 * 
	 */
	public static String decodeNode(BinaryTree<String> codes, String code)
	{
		if(code.length() == 0)
		{
			return "" + codes.printRoot();
		}
		else if(code.charAt(0) == '*')
		{
			return "" + decodeNode(codes.getLeftSubtree(), code.substring(1));
		}
		else if(code.charAt(0) == '-')
		{
			return "" + decodeNode(codes.getRightSubtree(), code.substring(1));
		}
		else
		{
			return decodeNode(codes, code.substring(1));
		}
	}
	/**
	 * 
	 */
	public static String decodeLine(BinaryTree<String> codes , Scanner code)
	{
		String line;
		code.useDelimiter(" ");
		if(!code.hasNext())
		{
			return "";
		}
		else 
		{
			line = code.next();
			return decodeNode(codes, line) + decodeLine(codes, code);		
		}
	}
	/**
	 * Display the options for the user.
	 * 
	 */
	public static void menu()
	{
		System.out.println("\n\n1. Translation table");
		System.out.println("2. Decode text file ");
		System.out.println("3. Decode line");
		System.out.println("4. Exit");
	}
}

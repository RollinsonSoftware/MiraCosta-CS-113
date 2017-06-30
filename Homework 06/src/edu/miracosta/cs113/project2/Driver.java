/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 ********************************************/

/*****************************************************************************
 * HOMEWORK NUMBER 6 PART 2
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM:
 * Programming Project 7 Page 291.
 * Write a recursive method that will dispense change for a given amount of
 * money. The method will display all combinations of quarters, dimes, 
 * nickels, and pennies that equal the desired amount. No duplicates!
 *****************************************************************************
 * ALGORITHM:
 * Ask the user for the amount of change (in cents).
 * Check for valid input (no negative numbers or letters/symbols).
 * To find each new combination, start with all pennies.
 * If the number of pennies >= number of nickels; nickels + 1 and pennies - 5
 * If the number of pennies >= number of dimes; dimes + 1 and pennies - 10
 * If the number of pennies >= number of quarters; quarters + 1 and pennies - 25.
 * Repeat until the total amount is greater the amount originally provided by
 * 		the user.
 * Store the new combination as an object that can hold data for each coin.
 * After a new combination is found, check to see if there is a duplicate object.
 * 		If not add the combination object to a list and increment the number of combos.
 * After all combinations have been found, loop to print all the different combos
 * 		to the user.
 * Output how many different combinations there were.
 *****************************************************************************/
package edu.miracosta.cs113.project2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver 
{
    private static ArrayList<int[]> allCombos = new ArrayList<>();
    private static int numCombos = 0;

    public static void main(String[] args)
    {
        int amount;
        
        Scanner keyboard = new Scanner(System.in);
        
        while(true) 
        {
            System.out.print("Please enter an amount in cents: ");
    
            try 
            {
                amount = keyboard.nextInt();
                
                if (amount < 0) 
                {
                    throw new InputMismatchException();
                }
                getChange(amount, 0, 0, 0, amount);
                break; 
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("ERROR: You must enter a possitive integer!");
            } 
            catch (StackOverflowError e)
            {
                System.out.println("\nERROR: Stack Overflow!");
                System.exit(0);
            }
        }
        keyboard.close();
        
        System.out.println("\nPrinting all the possible combinations for " + amount + " cents: ");
        System.out.println("\n==========================================================");
        
        printCombos(allCombos, numCombos);
    }//end of main
    
    /**
     * Loops through the list of combos and displays each unique combo,
     * 		and the total number of combos.
     * @param list: ArrayList containing all the UNIQUE combinations.
     * @param totalCombos: The total number of items in the list.
     */
    public static void printCombos(ArrayList<int[]> list, int totalCombos)
    {
    	for(int[] index : list) 
        {
            System.out.println(index[0] + " Quarters\t" + index[1] + " Dimes\t\t" + index[2] + " Nickels\t" + index[3] + " Pennies");
        }
        
        System.out.println("==========================================================");
        System.out.println("\nTotal number of combinations: " + totalCombos);
    }
    /**
     * Stores a new combo in the ArrayList of all possible combos, also
     * 		double checks to make sure there is not a duplicate!
     * @param quarters/dimes/nickels/pennies: The number of each type of coin.
     */
    public static void saveCombo(int quarters, int dimes, int nickels, int pennies) 
    {
        int[] newCombo = {quarters, dimes, nickels, pennies};

        for(int[] combo : allCombos) 
        {
            if (Arrays.equals(newCombo, combo)) 
            {
                return; //combination was a duplicate, discarding.
            }
        }
        allCombos.add(newCombo);
        numCombos++; //keeping track of how many combinations in total.
    }
    /**
     * Finds new combinations, and adds them to the ArrayList of combinations.
     * @param total: the total amount in CENTS
     * @param quarters/dimes/nickels/pennies: The number of each type of coin.
     */
    public static void getChange(int total, int quarters, int dimes, int nickels, int pennies) 
    {
        // Base Case
        if(quarters * 25 + dimes * 10 + nickels * 5 + pennies > total) 
        {
            return;
        }

        saveCombo(quarters, dimes, nickels, pennies);

        // Recursive Cases
        if(pennies >= 5) 
        {
            getChange(total, quarters, dimes, nickels + 1, pennies - 5);
        }
        if(pennies >= 10) 
        {
            getChange(total, quarters, dimes + 1, nickels, pennies - 10);
        }
        if(pennies >= 25) 
        {
            getChange(total, quarters + 1, dimes, nickels, pennies - 25);
        }
    }
}
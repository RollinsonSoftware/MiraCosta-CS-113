/********************************************
 * AUTHOR: 		Jack Rollinson
 * COURSE:		CS 113 Data Structures
 * SECTION:		1
 * TOPIC #:		1
 ********************************************/

/*****************************************************************************
 * HOMEWORK NUMBER 1
 *****************************************************************************
 * PROGRAM DESCRIPTION/HOMEWORK PROBLEM:
 * Write a program as if you were detective Jill, which finds the solution with
 * fewer than 20 checks for any of the three answer sets.
 *****************************************************************************
 * ALGORITHM:
 * Start by initializing all three variables to 1.
 * Initialize the solution variable to an int > 3 to keep the compiler happy.
 * In each iteration of the do-while loop check if the theory is correct.
 * If the checkAnswer() returns 0 then the theory is correct.
 * 		-end do-while loop.
 * If the checkAnswer() returns 1 then the weapon is incorrect.
 * 		-Add 1 to the weapon value and check again.
 * If the checkAnswer() returns 2 then the location is incorrect.
 * 		-Add 1 to the location value and check again.
 * If the checkAnswer() returns 3 then the murder/person is incorrect.
 * 		-Add 1 to the murder value and check again.
 *****************************************************************************/
package edu.miracosta.cs113;

import java.util.Scanner;
import assistantJack.AssistantJack;
import assistantJack.Theory;

public class IncrementalClue 
{
	//The only code changed from RandomClue was what was inside the do-while loop.
	public static void main(String[] args) 
	{
		int answerSet, solution, murder, weapon, location;
		Scanner keyboard = new Scanner(System.in);
		Theory answer = null;
		AssistantJack jack;
		

		System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
		answerSet = keyboard.nextInt();
		keyboard.close();

		jack = new AssistantJack(answerSet);
		
		//All values start at 1, the first possible combination.
		murder = 1;
		location = 1;
		weapon = 1;
		solution = 5; //keeps compiler happy
		
		do 
		{
			//Depending on what checkAnswer() returns, will add 1 to that category.
			if(solution == 3)
			{
				murder++;
			}
			if(solution == 2)
			{
				location++;
			}
			if(solution == 1)
			{
				weapon++;
			}
			
			solution = jack.checkAnswer(weapon, location, murder);
		} while (solution != 0);
		
		answer = new Theory(weapon, location, murder);
		System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution = " + answer);

		if (jack.getTimesAsked() > 20) 
		{
			System.out.println("FAILED!! You're a horrible Detective...");
		} 
		else 
		{
			System.out.println("WOW! You might as well be called Batman!");
		}
	}
}
/**
 * This was an extra solution to the homework I made, please grade the IncrementalClue class.
 */
package edu.miracosta.cs113;

import java.util.Scanner;
import assistantJack.AssistantJack;
import assistantJack.Theory;

public class DecrementalClue 
{

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
		
		murder = 6;
		location = 10;
		weapon = 6;
		solution = 5; //keeps compiler happy
		
		do 
		{
			if(solution == 3)
			{
				murder--;
			}
			if(solution == 2)
			{
				location--;
			}
			if(solution == 1)
			{
				weapon--;
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
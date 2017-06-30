package edu.miracosta.cs113;

public class Y2Tester 
{
	//Tester for (5 * n * n + 2)
	public static void main(String[] args)
	{
		for(int i = 2; i < 100; i++)
		{
			for(int j = 0; j <= 100; j+=5)
			{
				if(i % 10 == 0)
				{
					System.out.println("j is currently " + j);
				}
			}
		}
	}
}

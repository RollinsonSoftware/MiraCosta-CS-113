package edu.miracosta.cs113;

import java.util.Scanner;

public class Student
{
	private String firstName;
	private String lastName;

	Scanner keyboard = new Scanner(System.in);
	
	//CONSTRUCTORS
	public Student()
	{
		this.firstName = "Default";
		this.lastName = "User";
	}
	//SETTERS
	public void setAll() //This is the only public setter, it does all the work!
	{
		setFirstName();
		setLastName();
	}
	private void setFirstName()
	{
		System.out.print("\nWhat is the new Student's first name?: ");
		this.firstName = keyboard.nextLine();
	}
	private void setLastName()
	{
		System.out.print("\nWhat is " + this.getFirstName() + "'s last name?: ");
		this.lastName = keyboard.nextLine();
	}
	//GETTERS (all public)
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	//OTHER
	public boolean equals(Student other)
	{
		if(this.getFirstName().equalsIgnoreCase(other.getFirstName())
			&& this.getLastName().equalsIgnoreCase(other.getLastName()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String toString()
	{
		return this.getLastName() + ", " + this.getFirstName();
	}
}
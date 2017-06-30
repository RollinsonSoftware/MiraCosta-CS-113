//UPDATE 2/26/2017: overloaded setters and added a new full constructor for easier testing.

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
	public Student(String firstName, String lastName)
	{
		setFirstName(firstName);
		setLastName(lastName);
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
	private void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	private void setLastName()
	{
		System.out.print("\nWhat is " + this.getFirstName() + "'s last name?: ");
		this.lastName = keyboard.nextLine();
	}
	private void setLastName(String lastName)
	{
		this.lastName = lastName;
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
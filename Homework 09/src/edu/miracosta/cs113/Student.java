//UPDATE 2/26/2017: overloaded setters and added a new full constructor for easier testing.
//UPDATE 4/16/2017: implemented Comparable<E>
//UPDATE 4/20/2017: add documentation to all methods, and added a copy constructor.

package edu.miracosta.cs113;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class Student implements Comparable
{
	//INSTANCE VARIABLES:
	private int idNum;
	private String firstName;
	private String lastName;

	Scanner keyboard = new Scanner(System.in);
	
	//CONSTRUCTORS:
	//Default
	public Student()
	{
		setFirstName("Default");
		setLastName("User");
		setIdNum(0);
	}
	//Full
	public Student(String firstName, String lastName, int idNum)
	{
		setFirstName(firstName);
		setLastName(lastName);
		setIdNum(idNum);
	}
	//Copy
	public Student(Student other)
	{
		setFirstName(other.getFirstName());
		setLastName(other.getLastName());
		setIdNum(other.getIdNum());
	}
	//SETTERS:
	/**
	 * Calls all default setters, Reads in values for all 
	 * instance variables using scanner.
	 */
	public void setAll()
	{
		setFirstName();
		setLastName();
		setIdNum();
	}
	/**
	 * Reads string input from user for students first name.
	 */
	private void setFirstName()
	{
		System.out.print("\nWhat is the new Student's first name?: ");
		this.firstName = keyboard.nextLine();
	}
	/**
	 * Takes string as parameter and set's students first name.
	 * @Overload
	 * @param firstName, string of students first name.
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	/**
	 * Reads string input from user for students last name.
	 */
	private void setLastName()
	{
		System.out.print("\nWhat is " + this.getFirstName() + "'s last name?: ");
		this.lastName = keyboard.nextLine();
	}
	/**
	 * Takes string as parameter and set's students last name.
	 * @Overload
	 * @param lastName, string of students last name.
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	/**
	 * Reads an int in from the user using Scanner for the
	 * students ID number.
	 */
	private void setIdNum()
	{
		String temp;
		
		System.out.print("\nPlease enter an I.D. Number: ");
		temp = keyboard.nextLine();
		this.idNum = Integer.parseInt(temp);
	}
	/**
	 * Takes an int as parameter and set's students ID
	 * number.
	 * @Overload
	 * @param number, int for students ID number.
	 */
	public void setIdNum(int number)
	{
		this.idNum = number;
	}
	//GETTERS (all public):
	/**
	 * Returns the students first name as a string.
	 * @return students first name.
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	/**
	 * Returns the students last name as a string.
	 * @return students last name.
	 */
	public String getLastName()
	{
		return this.lastName;
	}
	/**
	 * Returns the students ID number as an int.
	 * @return students ID number.
	 */
	public int getIdNum()
	{
		return this.idNum;
	}
	//OTHER:
	/**
	 * Compares all instance variables to see if 2 objects are equal deep copies.
	 * @param other, object being compared.
	 * @return true if objects are equal deep copies and false otherwise.
	 */
	public boolean equals(Student other)
	{
		if(this.getFirstName().equalsIgnoreCase(other.getFirstName())
			&& this.getLastName().equalsIgnoreCase(other.getLastName())
			&& this.getIdNum() == other.getIdNum())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Gives a String representation of all instance variables for class Student.
	 * @return String of students full name and id number.
	 */
	public String toString()
	{
		return this.getLastName() + ", " + this.getFirstName() + ", I.D. #: " + this.getIdNum();
	}
	/**
	 * Compare two Student objects.
	 * @param otherStudent the student that is being compared to the calling object.
	 * @return -1 if callingObject < otherStudent; 0 if callingObject == otherStudent;
	 * 			and +1 if callingObject > otherStudent.
	 */
	public int compareTo(Object other)
	{	
		Student otherStudent = (Student)other;
		if(this.getIdNum() < otherStudent.getIdNum())
		{
			return -1;
		}
		else if(this.equals(otherStudent))
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}
package edu.miracosta.cs113;
import java.util.Scanner;

/** Represents a square
 * 	Extends Shape.
 */
public class Square extends Shape
{
	//Data fields
	/** The width of the square. */
	private double width = 0;
	/** The height of the square. */
	private double height = 0;
	
	//Constructors
	public Square() 
	{
		super("Square");
	}
	
	/** Constructs a square of the specified size.
	 * @param width the width
	 * 		  height is always equal to width
	 */
	public Square(double width)
	{
		super("Square");
		this.width = width;
		this.height = width;
	}
	
	//Methods
	
	/** Get the width.
	 * @return The width
	 */
	public double getWidth()
	{
		return width;
	}
	
	/** Get the height.
	 * @return The height
	 */
	public double getHeight()
	{
		return height;
	}
	
	/** Compute the area.
	 * @return The area of the square
	 */
	public double computeArea()
	{
		return height * width;
	}
	
	/** Compute the perimeter
	 * @return The perimeter of the square
	 */
	public double computePerimeter()
	{
		return 2 * (height + width);
	}
	
	/** Read the attributes of the square. */
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the width of the square");
		width = in.nextDouble();
		System.out.println("The height has also been set to: " + width);
		height = width;
		in.close();
	}
	
	/** Create a string representation of the square.
	 * @return A String representation of the square.
	 */
	public String toString()
	{
		return super.toString() + ": width is " + width + ", height is " + height;
	}
}
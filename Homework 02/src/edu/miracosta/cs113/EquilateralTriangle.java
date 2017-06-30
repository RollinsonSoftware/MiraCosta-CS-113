package edu.miracosta.cs113;
import java.util.Scanner;

/** Represents an equilateral triangle
 * 	Extends Shape.
 */
public class EquilateralTriangle extends Shape
{
	//Data fields
	/** The base of the equilateral triangle. */
	private double base = 0;
	/** The height of the equilateral triangle. */
	private double height = 0;
	
	//Constructors
	public EquilateralTriangle() 
	{
		super("EquilateralTriangle");
	}
	
	/** Constructs a equilateral triangle of the specified size.
	 * @param base, the base
	 * 		  height, the height
	 */
	public EquilateralTriangle(double base, double height)
	{
		super("EquilateralTriangle");
		this.base = base;
		this.height = height;
	}
	
	//Methods
	
	/** Get the base.
	 * @return The base
	 */
	public double getBase()
	{
		return base;
	}
	
	/** Get the height.
	 * @return The height
	 */
	public double getHeight()
	{
		return height;
	}
	
	/** Compute the area.
	 * @return The area of the equilateral triangle
	 */
	public double computeArea()
	{
		return (height * base) / 2;
	}
	
	/** Compute the perimeter
	 * @return The perimeter of the equilateral triangle
	 */
	public double computePerimeter()
	{
		return 3 * base;
	}
	
	/** Read the attributes of the equilateral triangle. */
	public void readShapeData()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the base of the equilateral triangle");
		base = in.nextDouble();
		System.out.println("Enter the height of the equilateral triangle");
		height = in.nextDouble();
		in.close();
	}
	
	/** Create a string representation of the equilateral triangle.
	 * @return A String representation of the equilateral triangle.
	 */
	public String toString()
	{
		return super.toString() + ": base is " + base + ", height is " + height;
	}
}
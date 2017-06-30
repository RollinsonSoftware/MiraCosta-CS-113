package edu.miracosta.cs113;

/**
 * Abstract class for a geometric shape.
 */
public abstract class Shape
{
	//The name of the shape
	private String shapeName = "";
	
	/** Initializes the shapeName.
	 * 
	 * @param shapeName the kind of shape
	 */
	public Shape(String shapeName)
	{
		this.shapeName = shapeName;
	}
	/**Get the kind of shape.
	 * 
	 * @return the shapeName
	 */
	public String getShapeName()
	{
		return shapeName;
	}
	public String toString()
	{
		return "Shape is a " + shapeName;
	}
	//abstract methods:
	public abstract double computeArea();
	public abstract double computePerimeter();
	public abstract void readShapeData();
}
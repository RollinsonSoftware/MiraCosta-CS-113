package edu.miracosta.cs113;

public class Term implements Comparable<Term>
{
	private int coefficient;
	private int exponent;
	
	public Term(int coefficient, int exponent)
	{
		setCoefficient(coefficient);
		setExponent(exponent);
	}
	//SETTERS
	public void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient;
	}
	public void setExponent(int exponent)
	{
		this.exponent = exponent;
	}
	//GETTERS
	public int getCoefficient()
	{
		return this.coefficient;
	}
	public int getExponent()
	{
		return this.exponent;
	}
	//OTHER
	public int compareTo(Term other)
	{
		int num = 0;
		
		if(this.getExponent() < other.getExponent())
		{
			num = -1;
		}
		else if(this.getExponent() == other.getExponent())
		{
			num = 0;
		}
		else if(this.getExponent() > other.getExponent())
		{
			num = 1;
		}
		return num;
	}
	public String toString()
	{
		String term = "";
		
		if(this.getExponent() == 0)
		{
			term = "" + this.getCoefficient();
		}
		else if(this.getExponent() == 1)
		{
			term = this.getCoefficient() + "x";
		}
		else if(this.getExponent() >= 2)
		{
			term = this.getCoefficient() + "x^" + this.getExponent();
		}
		return term;
	}
	public boolean equals(Term other)
	{
		if(other.getCoefficient() == this.getCoefficient()
			&& other.getExponent() == this.getExponent())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

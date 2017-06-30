package edu.miracosta.cs113;

@SuppressWarnings("serial")
public class StockException extends Exception
{
	/**
	 * Default exception for the stock class.
	 * prints a stack trace.
	 */
	public StockException()
	{
		super();
		super.printStackTrace();
	}
	/**
	 * Exception for the stock class with a custom message for the user.
	 * Prints a stack trace.
	 * @param message being output when the exception is thrown.
	 */
	public StockException(String message)
	{
		super(message);
		super.printStackTrace();
	}
}

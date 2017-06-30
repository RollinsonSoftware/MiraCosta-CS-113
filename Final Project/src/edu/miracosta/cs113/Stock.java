package edu.miracosta.cs113;

import java.util.Random;

@SuppressWarnings("rawtypes")
public class Stock implements Comparable
{
	//Objects:
	Random rand = new Random();
	
	//INSTANCE VARIABLES:
	private String ticker; //Ticker symbol.
	private double high; //52 week high.
	private double low; //52 week low.
	private double open; //Days opening price.
	private double close; //Days closing price.
	private double move200; //200 day moving average.
	private double move50; //50 day moving average.
	private int avgVolume; //Days average trade volume.
	
	//Constructors:
	/**
	 * Default constructor, sets all data to good random values.
	 * @throws StockException, wont actually be thrown, but keeps compiler happy.
	 */
	public Stock()
	{
		randomFill();
	}
	/**
	 * Full constructor, sets all the data to the given values.
	 * @param ticker, stocks symbol.
	 * @param high, 52 week high.
	 * @param low, 52 week low.
	 * @param open, opening price.
	 * @param close, closing price.
	 * @param move200, 200 day moving average.
	 * @param move50, 50 day moving average.
	 * @param volume, daily trade volume.
	 * @throws StockException, all data must be valid.
	 */
	public Stock(String ticker, double high, double low, double open,
					double close, double move200, double move50,
					int volume)
	{
		try
		{
			setTicker(ticker);
			setHigh(high);
			setLow(low);
			setOpen(open);
			setClose(close);
			setMoveAvg200(move200);
			setMoveAvg50(move50);
			setAvgVolume(volume);
		}
		catch(StockException e)
		{
			System.exit(0);
		}
	}
	
	//SETTERS:
	/**
	 * Records the ticker symbol for the stock as a string.
	 * @param symbol, the stocks ticker symbol.
	 * @throws StockException, symbol can not be more than 5 chars. 
	 */
	public void setTicker(String symbol) throws StockException
	{
		if(symbol.length() < 6)
		{
			this.ticker = symbol;
		}
		else
		{
			throw new StockException("Ticker Symbol must be less than 6 characters!");
		}
	}
	/**
	 * Records the 52 week high for the stock.
	 * @param value, the stocks 52 week high.
	 * @throws StockException, value must be >= zero. 
	 */
	public void setHigh(double value) throws StockException
	{
		if(value >= 0)
		{
			this.high = value;
		}
		else
		{
			throw new StockException("Value must be greater than or equal to zero!");
		}
	}
	/**
	 * Records the 52 week low for the stock.
	 * @param value, the stocks 52 week low.
	 * @throws StockException, value must be >= zero. 
	 */
	public void setLow(double value) throws StockException
	{
		if(value >= 0)
		{
			this.low = value;
		}
		else
		{
			throw new StockException("Value must be greater than or equal to zero!");
		}
	}
	/**
	 * Records the days opening price for the stock.
	 * @param value, todays opening price.
	 * @throws StockException, value must be >= zero. 
	 */
	public void setOpen(double value) throws StockException
	{
		if(value >= 0)
		{
			this.open = value;
		}
		else
		{
			throw new StockException("Value must be greater than or equal to zero!");
		}
	}
	/**
	 * Records the days closing price for the stock.
	 * @param value, todays closing price.
	 * @throws StockException, value must be >= zero. 
	 */
	public void setClose(double value) throws StockException
	{
		if(value >= 0)
		{
			this.close = value;
		}
		else
		{
			throw new StockException("Value must be greater than or equal to zero!");
		}
	}
	/**
	 * Records the stocks 200 day moving average.
	 * @param value, the stocks current 200 day moving average.
	 * @throws StockException, must be greater than zero.
	 */
	public void setMoveAvg200(double value) throws StockException
	{
		if(value > 0)
		{
			this.move200 = value;
		}
		else
		{
			throw new StockException("Value must be greater than zero!");
		}
	}
	/**
	 * Records the stocks 50 day moving average.
	 * @param value, the stocks current 50 day moving average.
	 * @throws StockException, must be greater than zero. 
	 */
	public void setMoveAvg50(double value) throws StockException
	{
		if(value > 0)
		{
			this.move50 = value;
		}
		else
		{
			throw new StockException("Value must be greater than zero!");
		}
	}
	/**
	 * Records the days trading volume.
	 * @param num, the days trading volume.
	 * @throws StockException, value must be >= zero.
	 */
	public void setAvgVolume(int num) throws StockException
	{
		if(num >= 0)
		{
			this.avgVolume = num;
		}
		else
		{
			throw new StockException("Number must be greater or equal to zero!");
		}
	}
	
	//GETTERS:
	/**
	 * Returns the stocks ticker symbol.
	 * @return ticker instance variable.
	 */
	public String getTicker()
	{
		return this.ticker;
	}
	/**
	 * Returns the stocks 52 week high.
	 * @return high instance variable.
	 */
	public double getHigh()
	{
		return this.high;
	}
	/**
	 * Returns the stocks 52 week low.
	 * @return low instance variable.
	 */
	public double getLow()
	{
		return this.low;
	}
	/**
	 * Returns todays opening price for the stock.
	 * @return open instance variable.
	 */
	public double getOpen()
	{
		return this.open;
	}
	/**
	 * Returns todays closing price for the stock.
	 * @return close instance variable.
	 */
	public double getClose()
	{
		return this.close;
	}
	/**
	 * Returns the stocks current 200 day moving average.
	 * @return move200 instance variable.
	 */
	public double getMoveAvg200()
	{
		return this.move200;
	}
	/**
	 * Returns the stocks current 50 day moving average.
	 * @return move50 instance variable.
	 */
	public double getMoveAvg50()
	{
		return this.move50;
	}
	/**
	 * Returns todays current trading volume.
	 * @return avgVolume instance variable.
	 */
	public int getAvgVolume()
	{
		return this.avgVolume;
	}
	
	//OTHER METHODS:+
	/**
	 * Prints a String representation of all the instance variables.
	 * @return all instance variables.
	 */
	public String toString()
	{
		return "Ticker Symbol: " + this.getTicker() + "\n52 Week High: " + this.getHigh() +
				"\n52 Week Low: " + this.getLow() + "\nToday's Open: " + this.getOpen() +
				"\nToday's Close: " + this.getClose() + "\n200 Day Moving Average: " + this.getMoveAvg200() +
				"\n50 Day Moving Average: " + this.getMoveAvg50() + "\nAverage Volume: " + this.getAvgVolume();
	}
	/**
	 * Equals method that checks for deep copies of stock objects.
	 * @return true if the object is a deep copy, false otherwise.
	 */
	public boolean equals(Stock other)
	{
		if(this.ticker.equalsIgnoreCase(other.getTicker()) &&
				this.high == other.getHigh() &&
				this.low == other.getLow() &&
				this.open == other.getOpen() &&
				this.close == other.getClose() &&
				this.move200 == other.getMoveAvg200() &&
				this.move50 == other.getMoveAvg50() &&
				this.avgVolume == other.getAvgVolume())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Creates random values for each instance variable except the
	 * ticker symbol, good for testing.
	 * @throws StockException 
	 */
	public void randomFill()
	{
		try
		{
			setTicker("RAND");
			setLow((rand.nextInt(697) + 1));
			setHigh((rand.nextInt(50) + 1) + this.getLow());
			setOpen((rand.nextInt(697) + 1));
			setClose((rand.nextInt(697) + 1));
			setMoveAvg200((rand.nextInt(697) + 1));
			setMoveAvg50((rand.nextInt(697) + 1));
			setAvgVolume((rand.nextInt(6934567) + 1));
		}
		catch(StockException e)
		{
			System.exit(0);
		}
	}
	/**
	 * Default compareTo() that calls Strings compareTo method.
	 * All other number comparisons should be done with a comparator.
	 * @param otherStock, the objected being compared to.
	 * @return -1 if the other stock is larger.
	 * 			0 if the other stock is equal.
	 * 			1 if the other stock is smaller.
	 */
	@Override
	public int compareTo(Object otherStock) 
	{
		return this.getTicker().compareTo(((Stock)otherStock).getTicker());
	}
}

package edu.miracosta.cs113.project1;

public class PrintJob 
{
	private int pages;
	private int startTime;
	private int endTime;
	//private boolean printed;
	
	//CONSTRUCTORS
	public PrintJob(int pages, int startTime)
	{
		setPages(pages);
		setStartTime(startTime);
	}
	public PrintJob(int numPages, int startTime, int endTime)
	{
		setPages(numPages);
		setStartTime(startTime);
		setEndTime(endTime);
	}
	//SETTERS
	public void setPages(int pages)
	{
		this.pages = pages;
	}
	public void setStartTime(int startTime)
	{
		this.startTime = startTime;
	}
	public int setEndTime(int endTime)
	{
		return this.endTime = endTime;
	}
	//GETTERS
	public int getPages()
	{
		return this.pages;
	}
	public int getStartTime()
	{
		return this.startTime;
	}
	public int getEndTime()
	{
		return this.endTime;
	}
	//OTHERS
	public String toString()
	{
		return "\nNumber of pages: " + this.getPages() + "\nTime added to queue: " + 
				this.getStartTime() + " minutes.\nTime finished printing: " + this.getEndTime() + " minutes.";
	}
	public boolean equals(PrintJob other)
	{
		return (other.getPages() == this.getPages() && other.getStartTime() == this.getStartTime() &&
					other.getEndTime() == this.getEndTime());
	}
}

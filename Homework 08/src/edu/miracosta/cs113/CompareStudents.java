package edu.miracosta.cs113;

import java.util.Comparator;

/**
 * Class to compare Students based on their last name.
 * @param <E> keeps compiler happy.
 */
public class CompareStudents implements Comparator<Student>
{
	/**
	 * Compare two Students<E>
	 * @param left The left-hand side of the comparison.
	 * @param right The right-hand side of the comparison.
	 * @return -1 if left < right; 0 if left == right;
	 * 			and +1 if left > right.
	 */
	@Override
	public int compare(Student left, Student right) 
	{
		if(left.equals(right))
		{
			return 0;
		}
		else if(left.getLastName().equalsIgnoreCase(right.getLastName()))
		{
			return left.getFirstName().compareToIgnoreCase(right.getFirstName());
		}
		else
		{
			return left.getLastName().compareToIgnoreCase(right.getLastName());
		}
	}
}

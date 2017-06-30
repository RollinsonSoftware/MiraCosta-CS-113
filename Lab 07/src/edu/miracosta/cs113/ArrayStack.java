package edu.miracosta.cs113;

import java.util.ArrayList;

public class ArrayStack<E>
{
	ArrayList<E> stack;
	
	public ArrayStack()
	{
		stack = new ArrayList<E>();
	}
	/**
	 * Checks if the stack is empty or not.
	 * @return true if the stack is empty.
	 * @return false if the stack is not empty.
	 */
	public boolean empty()
	{
		return stack.isEmpty();
	}
	/**
	 * Returns the object at the top of the stack without removing it.
	 * @return Object at the top of the stack.
	 */
	public E peek()
	{
		return stack.get(0);
	}
	/**
	 * Returns the object at the top of the stack and removes it.
	 * @return object at the top of the stack.
	 */
	public E pop()
	{
		E first = stack.get(0);
		stack.remove(0);
		return first;
	}
	/**
	 * Pushes an item onto the top of the stack.
	 * @param object
	 * @return The object that was last added to the stack.
	 */
	public E push(E object)
	{
		stack.add(0, object);
		return object;
	}
}

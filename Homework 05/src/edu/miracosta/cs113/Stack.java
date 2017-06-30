package edu.miracosta.cs113;

public interface Stack<E>
{
	/**
	 * Checks if the stack is empty or not.
	 * @return true if the stack is empty.
	 * @return false if the stack is not empty.
	 */
	public boolean empty();
	/**
	 * Returns the object at the top of the stack without removing it.
	 * @return Object at the top of the stack.
	 */
	public E peek();
	/**
	 * Returns the object at the top of the stack and removes it.
	 * @return object at the top of the stack.
	 */
	public E pop();
	/**
	 * Pushes an item onto the top of the stack.
	 * @param object
	 * @return The object that was last added to the stack.
	 */
	public E push(E object);
}

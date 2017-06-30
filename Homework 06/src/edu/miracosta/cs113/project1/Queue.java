package edu.miracosta.cs113.project1;

public interface Queue<E>
{
	/**
	 * Inserts item at the rear of the queue. 
	 * @return true if successful.
	 * @return false if the item could not be inserted.
	 */
	public boolean offer(E item);
	/**
	 * Removes the entry at the front of the queue and returns it if the queue is not empty.
	 * 		If the queue is empty, throws a NoSuchElementException.
	 * @return Object added to the queue.
	 */
	public E remove();
	/**
	 * Removes the entry at the front of the queue and returns it.
	 * @return object at the front of the queue, null if empty.
	 */
	public E poll();
	/**
	 * Returns the entry at the front of the queue without removing it.
	 * @return The object at the front of the queue, null if empty.
	 */
	public E peek();
	/**
	 * Returns the entry at the front of the queue without removing it.
	 * 		if the queue is empty, throws a NoSuchElementException.
	 * @return The object at the front of the queue.
	 */
	public E element();
}

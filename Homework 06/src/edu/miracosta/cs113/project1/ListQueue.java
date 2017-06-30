package edu.miracosta.cs113.project1;

import java.util.NoSuchElementException;

public class ListQueue<E> implements Queue<E> 
{
	private static class Node<E>
	{
		private E data;
		private Node<E> next;
		
		/** Creates a new node with a null next field
		  	@param data The data stored
		*/ 
		private Node(E newData)
		{
			this.data = newData;
			this.next = null;
		}
		/** Creates a new node that references another node
		 	@param data The data stored
		 	@param nodeRef The node referenced by new node
		*/
		private Node(E newData, Node<E> nodeRef) 
		{
			this.data = newData;
			this.next = nodeRef;
		}
	} //end of Node inner class
	
	private Node<E> head;
	private int size;
	
	/**
	 * Creates a new queue with a size of 0
	 */
	public ListQueue()
	{
		head = null;
		size = 0;
	}
	//====Queue Methods====
	/**
	 * Inserts item at the rear of the queue. 
	 * @return true if successful.
	 * @return false if the item could not be inserted.
	 */
	public boolean offer(E item)
	{
		addLast(item);
		return true;
	}
	/**
	 * Removes the entry at the front of the queue and returns it if the queue is not empty.
	 * 		If the queue is empty, throws a NoSuchElementException.
	 * @return Object added to the queue.
	 */
	public E remove()
	{
		if(head == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			return removeFirst();
		}
	}
	/**
	 * Removes the entry at the front of the queue and returns it.
	 * @return object at the front of the queue, null if empty.
	 */
	public E poll()
	{
		if(head == null)
		{
			return null;
		}
		else
		{
			return removeFirst();
		}
	}
	/**
	 * Returns the entry at the front of the queue without removing it.
	 * 		if the queue is empty, throws a NoSuchElementException.
	 * @return The object at the front of the queue.
	 */
	public E element()
	{
		if(head == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			return head.data;
		}
	}
	
	//====Stack Methods====
	/**
	 * Checks if the stack is empty or not.
	 * @return true if the stack is empty.
	 * @return false if the stack is not empty.
	 */
	public boolean empty()
	{
		return head != null && size != 0;
	}
	/**
	 * Returns the object at the top of the stack without removing it.
	 * @return Object at the top of the stack.
	 */
	public E peek()
	{
		if(head == null)
		{
			return null;
		}
		else
		{
			return head.data;
		}
	}
	/**
	 * Returns the object at the top of the stack and removes it.
	 * @return object at the top of the stack.
	 */
	public E pop()
	{
		return removeFirst();
	}
	/**
	 * Pushes an item onto the top of the stack.
	 * @param object
	 * @return The object that was last added to the stack.
	 */
	public E push(E object)
	{
		addFirst(object);
		return object;
	}
	
	//====Linked List Methods====
	/** Adds a new node to the front of the list
 		@param item The data stored
	*/
	public void addFirst(E item) 
	{
		head = new Node<E>(item, head);
		size++;
	}
	/** Adds a new node to the end of the list
		@param item The data stored
	*/
	public void addLast(E item)
	{
		add(size, item);
	}
	/** Removes the first node in the list
		@return returns data of node that was removed.
	*/
	public E removeFirst() 
	{
		if (head == null && size == 0)
		{
			return null;
		} 
		else 
		{
			Node<E> temp = head;
			head = head.next;
			size--;
			return temp.data;
		}
	}
	//====HELPER METHODS====
	
	public String toString()
	{
		Node<E> nodeRef = head;
		StringBuilder result = new StringBuilder();
		while(nodeRef != null)
		{
			result.append(nodeRef.data);
			if(nodeRef.next != null)
			{
				result.append(" ==> ");
			}
			nodeRef = nodeRef.next; //Advance down the list
		}
		return result.toString();
	}
	public int getSize()
	{
		return this.size;
	}
	/** Adds a new node at the given index
	 	@param index The location of insertion
		@param item The data stored
	*/
	private void add(int index, E item) 
	{
		if (index < 0 || index > size) 
		{
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0)
		{
			addFirst(item);
		} 
		else 
		{
			Node<E> node = getNode(index-1);
			addAfter(node, item);
		}
	}
	/** Adds a new node after the given node
		@param node The node the comes before the new node
		@param item The data of the new node
	*/
	private void addAfter(Node<E> node, E item) 
	{
		Node<E> temp = new Node<E>(item, node.next);
		node.next = temp;
		size++;
	}
	/** Removes a node after the given node
		@param node The node preceding the node being removed
	*/
	/*
	private E removeAfter(Node<E> node)
	{
		Node<E> temp = node.next;
		if(temp != null)
		{
			node.next = temp.next;
			size--;
			return temp.data;
		}
		else
		{
			return null;
		}
	}
	*/
	/** Gets the node at a given index
		@param index Location of target node
	*/
	private Node<E> getNode(int index)
	{
		Node<E> node = head;
		int i = 0;
		while(i < index && node != null)
		{
			node = node.next;
			i++;
		}
		return node;
	} 
}
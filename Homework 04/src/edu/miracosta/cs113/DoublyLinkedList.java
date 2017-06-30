package edu.miracosta.cs113;

import java.util.NoSuchElementException;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;

//I commented out the implements because it wouldn't let override the methods with
//generic types in the parameters, I have all the required methods to implement the
//interface, but I believe that my code is more flexible this way.

//I plan on updating the documentation at some point to include the @param and @return comments.
//	as well as implementing all the commented out method stubs at the bottom.

public class DoublyLinkedList<E> //implements List
{
	private static class TwoWayNode<E>
	{
		private E data;
		private TwoWayNode<E> next;
		private TwoWayNode<E> previous;
		
		public TwoWayNode()
		{
			this.data = null;
			this.next = null;
			this.previous = null;
		}
		public TwoWayNode(E newData, TwoWayNode<E> previousNode, TwoWayNode<E> nextNode)
		{
			this.data = newData;
			this.next = nextNode;
			this.previous = previousNode;
		}
	} //end of TwoWayNode inner class
	
	private class DoublyLinkedIterator
	{
		private TwoWayNode<E> position = null;
		
		//Default Constructor, creates an iterator at the begining of the list.
		public DoublyLinkedIterator()
		{
			position = head;
		}
		//Full Constructor, creates an iterator at the given index.
		public DoublyLinkedIterator(int index)
		{
			position = head;
			
			for(int i = 0; i < index - 1; i++)
			{
				position = position.next;
			}
		}
		//Moves the iterator the beginning of the list.
		public void restart()
		{
			position = head;
		}
		//Checks if the list has another node in front of the iterators current position.
		public boolean hasNext()
		{
			return (position.next != null);
		}
		//Check if the list has another node behind the iterators current position.
		public boolean hasPrevious()
		{
			return (position.next == null && size != 0) || position.previous != null;
		}
		//Moves the iterator to the next position in the list.
		public E next()
		{
			if(!hasNext())
			{
				throw new IllegalStateException();
			}
			E toReturn = position.data;
			position = position.next;
			
			return toReturn;
		}
		//Moves the iterator to the previous position in the list.
		public E previous()
		{
			if(!hasPrevious())
			{
				throw new NoSuchElementException();
			}
			if(position.next == null) //Iterator has pasted the last element
			{
				position.previous = tail;
			}
			else
			{
				position.next = position.next.previous;
			}
			return position.next.data;
		}
		//Inserts a new node at the iterators current position.
		public void add(E newData)
		{
			if(head == null || position.previous == null)
			{
				DoublyLinkedList.this.addFirst(newData);
				size++;
			}
			else
			{
				TwoWayNode<E> temp = new TwoWayNode<E>(newData, position.previous, position);
				position.previous.next = temp;
				position.previous = temp;
				size++;
			}
		}
		//Replaces the last item returned from a call to next or previous with newData.
		//If it is not preceded by a previous or next call it throws an exception.
		public void set(E newData)
		{
			if(position == null)
			{
				throw new IllegalStateException();
			}
			else
			{
				TwoWayNode<E> newNode = new TwoWayNode<E>(newData, position.previous, position.next);
				position = newNode;
			}
		}
		//Deletes the node that the iterator last stepped over.
		public void deleteLast() //This is the remove method, I changed the name to avoid confusion with the list's remove()
		{
			if(position == null)
			{
				throw new IllegalStateException();
			}
			else if(position.previous == null)
			{
				head = head.next;
				position = head;
				size--;
			}
			else if(position.next == null)
			{
				position.previous.next = null;
				position = null;
				size--;
			}
			else
			{
				position.previous.next = position.next;
				position.next.previous = position.previous;
				position = position.next;
				size--;
			}
		}
	} //end of DoublyLinkedIterator inner class
	
	private TwoWayNode<E> head;
	private TwoWayNode<E> tail;
	private int size;
	
	//Returns a new iterator, at the front of the list, before the first item.
	public DoublyLinkedIterator iterator()
	{
		return new DoublyLinkedIterator();
	}
	//Returns a new iterator, just before the given index.
	public DoublyLinkedIterator iterator(int index)
	{
		return new DoublyLinkedIterator(index);
	}
	//Creates a new empty Doubly Linked List
	public DoublyLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	//Adds a new node to the beginning of the list.
	public void addFirst(E newData)
	{
		TwoWayNode<E> newNode = new TwoWayNode<E>(newData, null, head);
		
		if(head != null)
		{
			head.previous = newNode;
		}
		head = newNode;
		size++;
	}
	//Adds a new node to the end of the List.
	public boolean addLast(E newData) 
	{
		if(head == null)
		{
			addFirst(newData);
		}
		else
		{
			TwoWayNode<E> temp = head;
			
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = new TwoWayNode<E>(newData, temp, null);
			tail = temp;
			size++;
		}
		return true;
	}
	//Inserts a new node into the list at the position index.
	public void add(int index, E newData) 
	{
		DoublyLinkedIterator it = iterator();
		
		if(head == null || index == 0)
		{
			addFirst(newData);
		}
		else
		{
			for(int i = 0; i < index -1; i++)
			{
				it.next();
			}
			it.add(newData); //this method call also increments the size!
		}
	}
	//Gets the first element in the list. Throws an exception if the list is empty.
	public E getFirst()
	{
		if(head == null)
		{
			throw new NoSuchElementException();
		}
		return head.data;
	}
	//Gets the last element in the list. Throws an exception if the list is empty.
	public E getLast()
	{
		if(head == null)
		{
			throw new NoSuchElementException();
		}
		return tail.next.next.data;
	}
	//Returns the item at position index.
	public E get(int index)
	{
		DoublyLinkedIterator it = iterator();
		for(int i = 0; i < index - 1; i++)
		{
			it.next();
		}
		return it.next();
	}
	/** Removes the first occurrence of the generic object from the list.
	 *  @param the object you would like to remove.
	 *	@return returns true if item was removed; else false
	*/
	public boolean remove(E search)
	{
		TwoWayNode<E> position = head;
		
		boolean match = false;
		while(position !=  null && !match)
		{
			E current = position.data;
	
			if(current.equals(search))
			{
				match = true;
			}
			else
			{
				position.previous = position;
			}
			position = position.next;
		}
		removeAfter(position.previous.previous);
		return match;
	}
	/** Removes the first node in the list
		@return returns data of node that was removed.
	*/
	public E removeFirst() 
	{
		if (head == null)
		{
			return null;
		} 
		else 
		{
			TwoWayNode<E> temp = head;
			head = head.next;
			size--;
			return temp.data;
		}
	}
	//Returns the number of objects contained in the list.
	public int size()
	{
		return this.size;
	}
	//====HELPER METHODS====
	
	//Prints a String representation of the linked list.
	public String toString()
	{
		TwoWayNode<E> nodeRef = head;
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
	//Clears all the contents of the list.
	public void clear() 
	{
		head = null;
		tail = null;
		size = 0;
	}
	/** Removes a node after the given node
		@param node The node preceding the node being removed
	*/
	private E removeAfter(TwoWayNode<E> node)
	{
		TwoWayNode<E> temp = node.next;
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
	/**
	 * Other methods from the Java API that I will work on implementing at a later date.
	 * 
	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
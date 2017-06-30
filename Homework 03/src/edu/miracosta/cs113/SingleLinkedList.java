package edu.miracosta.cs113;

public class SingleLinkedList<E>
{
	private static class Node<E>
	{
		private E data;
		private Node<E> next;
		
		/** Creates a new node with a null next field
		  	@param data The data stored
		*/ 
		private Node(E newStudent)
		{
			this.data = newStudent;
			this.next = null;
		}
		/** Creates a new node that references another node
		 	@param data The data stored
		 	@param nodeRef The node referenced by new node
		*/
		private Node(E newStudent, Node<E> nodeRef) 
		{
			this.data = newStudent;
			this.next = nodeRef;
		}
	} //end of Node inner class
	
	private Node<E> head;
	private int size;

	public SingleLinkedList()
	{
		head = null;
		size = 0;
	}
	
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
		if (head == null)
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
	/** Removes the node containing a students name
		@return returns data of node that was removed.
	*/
	public void removeStudent(Student search)
	{
		Node<E> position = head;
		Node<E> pastPosition = head;
		boolean match = false;
		while(position !=  null && !match)
		{
			Student current = (Student)position.data;
	
			if(current.equals(search))
			{
				match = true;
			}
			else
			{
				pastPosition = position;
			}
			position = position.next;
		}
		removeAfter(pastPosition);
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
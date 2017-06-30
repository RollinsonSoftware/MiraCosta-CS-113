package edu.miracosta.cs113;


import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException; 

public class HashtableChain<K, V> extends AbstractMap<K, V> implements KWHashMap<K, V>
{
	//The size of the table.
	private static final int CAPACITY = 101;
	//The maximum load factor.
	private static final double LOAD_THRESHOLD = 0.75;
	
	private int numKeys;
	private LinkedList<Entry<K, V>>[] table; 
	
	//Constructor
	/**
	 * Construct a new HashTableChain, the table size is
	 * initiated to CAPACITY.
	 */
	@SuppressWarnings("unchecked")
	public HashtableChain()
	{
		//this way what ever the user gives will be a good value.
		table = new LinkedList[CAPACITY]; 
	}
	/**
	 * Constructs a new Hashtable of (size * 2) + 1 to
	 * make sure that the starting capacity is odd value.
	 * @param size, (size * 2) + 1 to insure good value.
	 */
	@SuppressWarnings("unchecked")
	public HashtableChain(int size)
	{
		//This will insure the starting size is a good value.
		table = new LinkedList[(size * 2) + 1];
	}
	@Override
	/*<exercise chapter="7" type="programming-project" number="7">*/
	/** Returns EntrySet object with iterator and size */
	public java.util.Set<Map.Entry<K, V>> entrySet() 
	{
		return new EntrySet();
	}

	/*<exercise chapter="7" section="4" type="programming" number="4">*/
	/**
	 * Loops through the table to show all the values of the map.
	 * @return A String representation of the Hashtable.
	 */
	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < table.length; i++)
		{
			sb.append("[" + i + "] ");
			
			for(Entry<K, V> entry : table[i])
			{
				sb.append("==> " + entry + " ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	/*<exercise chapter="7" section="4" type="programming" number="5">*/
	/**
	 * Returns the size of the table.
	 * @return the size.
	 */
	@Override
	public int size()
	{
		return table.length;
	}
	/*<exercise chapter="7" section="4" type="programming" number="2">*/
	//The written pseudo code for this is written on page 394
	/**
	 * Removes the mapping for this key from this table if it is
	 * present (optional operation).
	 * @param key, object being returned.
	 * @return The previous value associated with the specified key,
	 * 			null if there was no mapping.
	 */
	@Override
	public V remove(Object key)
	{
		int index = key.hashCode() % table.length;
		
		if(index < 0)
		{
			index += table.length;
		}
		if(table[index] == null)
		{
			return null;
		}
		
		for(Entry<K, V> pair : table[index])
		{
			if(pair.getKey().equals(key))
			{
				V value = pair.getValue();
				table[index].remove(pair);
				this.numKeys--;
				
				if(table[index].isEmpty())
				{
					table[index] = null;
				}
				
				return value;
			}
		}
		return null;
	}
	/**
	 * Returns the value associated with the specified key. Returns
	 * null if the key is not present.
	 * @param key, the object being searched for.
	 * @return value associated with key, null otherwise.
	 */
	public V get(Object key)
	{
		int index = key.hashCode() % table.length;
		if(index < 0)
		{
			index += table.length;
		}
		if(table[index] == null)
		{
			return null; //key not found.
		}
		
		//Traverse the LinkedList for the key.
		for(Entry<K, V> entry : table[index])
		{
			if(entry.key.equals(key))
			{
				return entry.value;
			}
		}
		
		return null;
	}
	/**
	 * Associates the specified value with the specified key.
	 * Returns the previous value associated with the speci-
	 * fied key, or null if there was no mapping for the key.
	 * @param key, maps to the value.
	 * @param value, data that is being stored.
	 * @return The value that was previously at the position.
	 * 			null if there was nothing at the position.
	 */
	public V put(K key, V value)
	{
		int index = key.hashCode() % table.length;
		 
		if(index < 0)
		{
			index += table.length;
		}
		if(table[index] == null)
		{
			table[index] = new LinkedList<Entry<K, V>>();
		}
		
		//Traverse the LinkedList to find the key.
		for(Entry<K, V> entry : table[index])
		{
			if(entry.key.equals(key))
			{
				V oldValue = entry.value;
				entry.setValue(value);
				return oldValue;
			}
		}
		
		//Key is not in the table, time to make a new one!
		table[index].addFirst(new Entry<K, V>(key, value));
		this.numKeys++;
		
		if(this.numKeys > (LOAD_THRESHOLD * table.length))
		{
			rehash();
		}
		
		return null;
	}
	/**
	 * Checks if this table contains key-value mappings.
	 * @return true if no key-value mappings, false otherwise.
	 */
	public boolean isEmpty()
	{
		return numKeys == 0;
	}
	/**
	* Expands table size when loadFactor exceeds LOAD_THRESHOLD
	* @post the size of table is doubled and is an
	* odd integer. Each entry from the original
	* table is reinserted into the expanded table.
	*/
	@SuppressWarnings("unchecked")
	protected void rehash()
	{
		LinkedList<Entry<K, V>>[] oldTable = this.table;
		table = new LinkedList[oldTable.length * 2 + 1];
		
		this.numKeys = 0;
		
		for(LinkedList<Entry<K, V>> list : oldTable)
		{
			if(list != null)
			{
				for(Entry<K, V> entry : list)
				{
					put(entry.getKey(), entry.getValue());
					this.numKeys++;
				}
			}
		}
	}
	
	
	
	//===============
	
	//===============ALL INNER CLASSES BELOW===============
	
	//===============
	
	
	
	
	/** Inner class to hold key value pairs for a hash table. */
	private static class Entry<K, V> implements Map.Entry<K, V>
	{
		private K key;
		private V value;
		
		/**
		 * Creates a new key-value pair.
		 * @param key, the key object.
		 * @param vlaue, the value object.
		 */
		public Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		/**
		 * Retrieves the key.
		 * @return the key object.
		 */
		public K getKey()
		{
			return this.key;
		}
		/**
		 * Retrieves the value.
		 * @return the value object.
		 */
		public V getValue()
		{
			return this.value;
		}
		/**
		 * Sets a new value.
		 * @param newValue
		 * @return oldValue
		 */
		@Override
		public V setValue(V newValue)
		{
			V oldValue = this.value;
			this.value = newValue;
			return oldValue;
		}
		/*<exercise chapter="7" section="4" type="programming" number="3">*/
		/**
		* Return a String representation of the Entry
		* @return a String representation of the Entry
		* in the form key = value
		*/
		public String toString()
		{
			return this.key + " = " + this.value;
		}
	}
	
	/** Inner class to implement the set view. */
	private class EntrySet extends java.util.AbstractSet<Map.Entry<K, V>> 
	{
		/** Return the size of the set. */
		@Override
		public int size() 
		{
			return numKeys;
		}
		/** Return an iterator over the set. */
		@Override
		public Iterator<Map.Entry<K, V>> iterator() 
		{
			return new SetIterator();
		}
	}
	
	/** Inner class to implement the set iterator. */
	private class SetIterator implements Iterator<Map.Entry<K, V>> 
	{
		//Current index of the map[].
		int index = 0;
		
		//The last item returned by the iterator.
		Entry<K, V> lastItem = null;
		
		//Iterator to traverse each linked list in the map[]
		Iterator<Entry<K, V>> localIterator = null;
		
		/**
		 * Check's if the next item is null or not.
		 */
		@Override
		public boolean hasNext() 
		{
			if (localIterator != null) 
			{
				if (localIterator.hasNext()) 
				{
					return true;
				} 
				else 
				{
					localIterator = null;
					index++;
				}
			}
			while (index < table.length && table[index] == null) 
			{
				index++;
			}
			if (index == table.length) 
			{
				return false;
			}
			
			localIterator = table[index].iterator();
			return localIterator.hasNext();
		}
		
		/**
		 * Returns the next item the iterator passes over.
		 * **See java API for iterator's next()!
		 */
		@Override
		public Map.Entry<K, V> next() 
		{
			if(localIterator.hasNext())
			{
				lastItem = localIterator.next();
				return lastItem;
			}
			else
			{
				throw new NoSuchElementException();
			}
		}
		/**
		 * Removes the last item returned by a next() call.
		 * **See java API for iterator's remove()!
		 * @throws IllegalStateException: If a remove() 
		 * 			call is not preceded by a next() call
		 */
		@Override
		public void remove() throws IllegalStateException
		{
			if(lastItem == null)
			{
				throw new IllegalStateException();
			}
			else
			{
				localIterator.remove();
				lastItem = null;
			}
		}
	}
	
	
	
	//===============
	
	//===============EXTRA METHODS===============
	
	//===============
	
	
	
	/**
	 * Returns true if the value as an associated key.
	 * @param 
	 */
	@Override
	public boolean containsValue(Object value)
	{
		for(LinkedList<Entry<K, V>> chain : table)
		{
			for(Entry<K, V> entry : chain)
			{
				if(entry.getValue().equals(value))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	/**
	 * Removes all Key-Value pairs by setting everything to null.
	 */
	@Override
	public void clear()
	{
		for(@SuppressWarnings("unused") LinkedList<Entry<K, V>> index : table)
		{
			index = null;
		}
	}
	/**
	 * Returns the total number of key-value pairs in the table.
	 * @return numKeys
	 */
	public int getNumKeys()
	{
		return this.numKeys;
	}
}

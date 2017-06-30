package edu.miracosta.cs113;

public interface KWHashMap<K, V> 
{
	/**
	* An interface for HashMap
	* @author Koffman and Wolfgang
	*/
	/**
	 * Returns the value associated with the specified key. Returns
	 * null if the key is not present.
	 * @param key
	 * @return value associated with key, null otherwise.
	 */
	public V get(Object key);
	/**
	 * Associates the specified value with the specified key.
	 * Returns the previous value associated with the speci-
	 * fied key, or null if there was no mapping for the key.
	 * @param key, maps to the value.
	 * @param value, data that is being stored.
	 * @return The value that was previously at the position.
	 */
	public V put(K key, V value);
	/**
	 * Removes the mapping for this key from this table if it is
	 * present (optional operation).
	 * @param key, object being returned.
	 * @return The previous value associated with the specified key,
	 * 			null if there was no mapping.
	 */
	public V remove(Object key);
	/**
	 * Returns the size of the table.
	 * @return the size.
	 */
	public int size();
	/**
	 * Checks if this table contains key-value mappings.
	 * @return true if no key-value mappings, false otherwise.
	 */
	public boolean isEmpty();
}

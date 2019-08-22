import java.util.ArrayList;

/**
 * This class implements a very simple Hash Map. It doesn't support resize of
 * the Hash Map in case that is full over the 50%. Also, is implemented only
 * for keys as Strings and values as Integers
 * 
 * @author Marios
 *
 */
public class HashMap {

	private int SIZE = 10;
	private ArrayList<HMNode>[] map;

	public HashMap() {
		createHashMap();
	}

	/**
	 * Add an element in the Hash Map.
	 * 
	 * @param key
	 * @param value
	 */
	public void add(String key, int value) {
		int hashCode = hashFunction(key);
		map[hashCode].add(new HMNode(key, value));
	}

	/**
	 * Returns the value of a key if it exists otherwise it return -1. Not the best
	 * idea but good for now. The purpose of this script is for learning the data
	 * structure Hash Map.
	 * 
	 * @param key
	 * @return
	 */
	public int key(String key) {
		int hashCode = hashFunction(key);
		for (HMNode n : map[hashCode]) {
			if (n.getKey().equals(key)) {
				return n.getValue();
			}
		}
		// Node not found
		return -1;
	}

	/**
	 * To String method for printing the Hash Map
	 */
	public String toString() {
		String output = "";
		for (int i = 0; i < SIZE; i++) {
			output += "map[" + i + "] ";
			for (HMNode n : map[i]) {
				output += "('" + n.getKey() + "' , " + n.getValue() + ") ";
			}
			output += "\n";
		}
		return output;
	}

	/**
	 * Function for the creation of the Hash Map. it creates the map array and
	 * initializes the ArrayLists for each cell of the array.
	 */
	private void createHashMap() {
		// Creating the array
		map = new ArrayList[SIZE];

		// Initializing ArrayLists
		for (int i = 0; i < SIZE; i++) {
			map[i] = new ArrayList<HMNode>();
		}
	}

	/**
	 * Hash Function for each key. Time complexity is O(X) where x is the length of
	 * the string
	 *
	 */
	private int hashFunction(String key) {
		int hashCode = 0;
		for (int i = 0; i < key.length(); i++) {
			hashCode += (int) key.charAt(i);
		}
		return hashCode % SIZE;
	}

}

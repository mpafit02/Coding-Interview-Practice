import java.util.ArrayList;

/**
 * This script finds the similar elements between two arrays in O(n) Time
 * Complexity and O(1) Space Complexity
 * 
 * @author Marios
 *
 */
public class SimilarElementsBetweenTwoArrays {

	public static void main(String[] args) {
		int[] array1 = { 13, 27, 35, 40, 49, 55, 59 };
		int[] array2 = { 17, 35, 39, 40, 55, 58, 60 };
		System.out.println(findSimilars(array1, array2));
	}

	/**
	 * The method that takes as arguments two arrays and finds the similar elements.
	 * It returns an array list containing all the simila elements of the two
	 * arrays.
	 */
	public static ArrayList<Integer> findSimilars(int[] array1, int[] array2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		return findSimilarsRec(array1, array2, 0, 0, result);
	}

	/**
	 * The recursive methd that finds the similar elements of two arrays in O(n)
	 * Time Complexity. It also skip duplicates if it has already added the specific
	 * element.
	 * 
	 * @param array1
	 * @param array2
	 * @param pointer1 The pointer for the array1
	 * @param pointer2 The pointer for the array2
	 * @param result The ArrayList containing the similar elements
	 * @return
	 */
	public static ArrayList<Integer> findSimilarsRec(int[] array1, int[] array2, int pointer1, int pointer2,
			ArrayList<Integer> result) {
		// Check if we reached the end in one of the two arrays
		if (pointer1 >= array1.length || pointer2 >= array2.length) {
			return result;
		}

		int elem1 = array1[pointer1];
		int elem2 = array2[pointer2];

		if (elem1 == elem2) {
			result.add(elem1);
			return findSimilarsRec(array1, array2, pointer1 + 1, pointer2 + 1, result);
		} else if (elem1 < elem2) {
			return findSimilarsRec(array1, array2, pointer1 + 1, pointer2, result);
		} else { // if (elem1 > elem2)
			return findSimilarsRec(array1, array2, pointer1, pointer2 + 1, result);
		}
	}
}

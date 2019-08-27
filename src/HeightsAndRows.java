import java.util.ArrayList;

/**
 * This code gets as input an Array with positive integers that represent the
 * heights of people. We have rows that we want to sort those people. I a person
 * is taller than everyone else in all the rows it creates a new row, otherwise
 * it takes a position to the first row that he will find that he is sorter.
 * Time Complexity: O(n) where n is the amount of people we have.
 * 
 * @author Marios
 *
 */
public class HeightsAndRows {

	public static void main(String args[]) {
		int[] A = { 5, 4, 6, 2, 8, 1, 6 }; // Heights

		System.out.println("Total Rows: " + findHeightsAndRows(A));
		System.out.println("Total Rows: " + findHeights(A));

	}

	/**
	 * Finds and returns just the heights of the tallest in each row and the numbr of rows
	 * @param A
	 * @return
	 */
	public static int findHeights(int[] A) {
		System.out.println("\nAnother way if we don't care who is in the rows and we just want the number of rows.");
		int max = 0;
		int rows = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				System.out.println("Row first: " + A[i]);
				max = A[i];
				rows++;
			}
		}
		return rows;
	}

	/**
	 * Finds the detailed rows
	 * @param A
	 * @return
	 */
	public static int findHeightsAndRows(int[] A) {
		ArrayList<Integer> min = new ArrayList<>();
		ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {

			int rowNumber = 0;
			boolean isAdded = false;

			for (ArrayList<Integer> row : rows) {
				System.out.println("Checks " + min.get(rowNumber) + " with " + A[i]);
				if (min.get(rowNumber) == A[i]) {
					isAdded = true;
					break;
				} else if (min.get(rowNumber) > A[i]) {
					row.add(A[i]);
					min.set(rowNumber, A[i]);
					isAdded = true;
					break;
				}
				rowNumber++;
			}

			if (!isAdded) {
				ArrayList<Integer> row = new ArrayList<>();
				row.add(A[i]);
				min.add(A[i]);
				rows.add(row);
			}
			System.out.println("Min: " + min);
			System.out.println("Rows: " + rows);
			System.out.println();
		}
		return rows.size();
	}
}

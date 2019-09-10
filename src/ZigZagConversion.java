/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string s, int numRows); 
 * 
 * Example 1:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3 
 * 
 * Output: "PAHNAPLSIIGYIR" 
 * 
 * 
 * Example 2:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4 
 * 
 * Output: "PINALSIGYAHRPI"
 * 
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * @author Marios
 *
 */
public class ZigZagConversion {

	/**
	 * Brute force version, uses additional space to store each row O(N) Time
	 * Complexity and O(N) Space Complexity
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
		if (numRows == 1 || s.length() == 1) {
			return s;
		}
		char[][] zigzag = new char[numRows][s.length()];
		int index = 0;
		for (int j = 0; j < s.length(); j++) {
			for (int i = 0; i < numRows; i++) {
				zigzag[i][j] = ' ';
			}
		}
		for (int j = 0; j < s.length(); j++) {
			for (int i = 0; i < numRows; i++) {
				if (index >= s.length()) {
					break;
				}
//				System.out.print(s.charAt(index) + " ");
				zigzag[i][j] = s.charAt(index);
				index++;
			}
			j++;
//			System.out.print(" - ");
			for (int i = numRows - 2; i > 0; i--) {
				if (index >= s.length()) {
					break;
				}
//				System.out.print(s.charAt(index) + " ");
				zigzag[i][j] = s.charAt(index);
				index++;
			}
//			System.out.println();
		}
		String zigzag_str = "";
//		System.out.println();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < s.length(); j++) {
//				System.out.print(zigzag[i][j] + " ");
				if (zigzag[i][j] != ' ') {
					zigzag_str += zigzag[i][j];
				}
			}
//			System.out.println();
		}
		return zigzag_str;
	}

	/**
	 * Better performance version with O(N) Time Complexity and O(1) Space
	 * Complexity where N is the length of the string
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convertFaster(String s, int numRows) {
		if (numRows == 1 || s.length() == 1) {
			return s;
		}
		int cycle = 2 * numRows - 2;
		String zigzag = "";
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < s.length(); j += cycle) {
				zigzag += s.charAt(j + i);
				if (i != 0 && i != numRows - 1 && j + cycle - i < s.length()) {
					zigzag += s.charAt(j + cycle - i);
				}
			}
		}
		return zigzag;
	}

	/**
	 * Fully optimized version by using string builder O(N) Time Complexity and O(1)
	 * Space Complexity
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convertFasterOptimized(String s, int numRows) {
		if (s.length() == 1 || numRows == 1 || s.length() < numRows) {
			return s;
		}
		StringBuilder ret = new StringBuilder();
		int cycle = 2 * numRows - 2;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < s.length(); j += cycle) {
				ret.append(s.charAt(j + i)); // Represents all the vertical collumns
				if (i != 0 && i != numRows - 1 && j + cycle - i < s.length()) {
					ret.append(s.charAt(j + cycle - i));
				}
			}
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		String strs[] = { "AB", "ABCDE", "PAYPALISHIRING", "PAYPALISHIRING", "PAYPALISHIRING1", "PAYPALISHIRING12",
				"PAYPALISHIRING123" };
		for (int rows = 1; rows <= 4; rows++) {
			for (String str : strs) {
				System.out.println("*****Input: s = \"" + str + "\", rows = " + rows);
				System.out.println("\n--Convert Brute Force\n");
				System.out.println("Output: \"" + convert(str, rows) + "\"");
				System.out.println("\n--Convert Faster\n");
				System.out.println("Output: \"" + convertFaster(str, rows) + "\"");
				System.out.println("\n--Convert Faster Optimized\n");
				System.out.println("Output: \"" + convertFasterOptimized(str, rows) + "\"");
				System.out.println();
				System.out.println();
			}
		}
	}
}

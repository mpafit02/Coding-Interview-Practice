/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * Symbol Value
 * 
 * I 1
 * 
 * V 5
 * 
 * X 10
 * 
 * L 50
 * 
 * C 100
 * 
 * D 500
 * 
 * M 1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * 
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * 
 * Example 1:
 * 
 * Input: 3
 * 
 * Output: "III"
 * 
 * 
 * Example 2:
 * 
 * Input: 4
 * 
 * Output: "IV"
 * 
 * 
 * Example 3:
 * 
 * Input: 9
 * 
 * Output: "IX"
 * 
 * 
 * Example 4:
 * 
 * Input: 58
 * 
 * Output: "LVIII"
 * 
 * Explanation: L = 50, V = 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * Input: 1994
 * 
 * Output: "MCMXCIV"
 * 
 * xplanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * @author Marios
 *
 */
public class IntegerToRoman {
	public static String intToRomanFaster(int num) {
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] chars = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder roman = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				roman.append(chars[i]);
				num -= values[i];
			}
		}
		return roman.toString();
	}

	public static String intToRoman(int num) {
		String roman = "";
		int digit = (int) (num / 1000);
		for (int i = 1; i <= digit; i++) {
			roman += "M";
		}

		num = num % 1000;
		digit = (int) (num / 100);
		if (digit == 4) {
			roman += "CD";
		} else if (digit == 9) {
			roman += "CM";
		} else if (digit >= 5) {
			roman += "D";
			for (int i = 6; i <= digit; i++) {
				roman += "C";
			}
		} else if (digit >= 1) {
			for (int i = 1; i <= digit; i++) {
				roman += "C";
			}
		}

		num = num % 100;
		digit = (int) (num / 10);
		if (digit == 4) {
			roman += "XL";
		} else if (digit == 9) {
			roman += "XC";
		} else if (digit >= 5) {
			roman += "L";
			for (int i = 6; i <= digit; i++) {
				roman += "X";
			}
		} else if (digit >= 1) {
			for (int i = 1; i <= digit; i++) {
				roman += "X";
			}
		}

		digit = num % 10;
		if (digit == 4) {
			roman += "IV";
		} else if (digit == 9) {
			roman += "IX";
		} else if (digit >= 5) {
			roman += "V";
			for (int i = 6; i <= digit; i++) {
				roman += "I";
			}
		} else if (digit >= 1) {
			for (int i = 1; i <= digit; i++) {
				roman += "I";
			}
		}

		return roman;
	}

	public static void main(String[] args) {
		int[] input = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 58, 1994 };
		for (int i = 0; i < input.length; i++) {
			System.out.println("Input: " + input[i]);
			System.out.println("Output: " + intToRoman(input[i]));
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < input.length; i++) {
			System.out.println("Input: " + input[i]);
			System.out.println("Output: " + intToRomanFaster(input[i]));
			System.out.println();
		}
	}

}

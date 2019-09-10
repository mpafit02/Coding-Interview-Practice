/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, two is written
 * as II in Roman numeral, just two one's added together. Twelve is written as,
 * XII, which is simply X + II. The number twenty seven is written as XXVII,
 * which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900. Given a Roman numeral, convert it to an
 * integer. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 
 * Example 1:
 * 
 * Input: "III"
 * 
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * Input: "IV"
 * 
 * Output: 4
 * 
 * 
 * Example 3:
 * 
 * Input: "IX"
 * 
 * Output: 9
 * 
 * 
 * Example 4:
 * 
 * Input: "LVIII"
 * 
 * Output: 58
 * 
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * Input: "MCMXCIV"
 * 
 * Output: 1994
 * 
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * @author Marios
 *
 */
public class RomanToInteger {
	public static int romanToInt(String s) {
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (i != s.length() - 1) {
				char c_next = s.charAt(i + 1);
				if (c == 'I' && c_next == 'V') {
					num += 4;
					// Skip one character
					i++;
				} else if (c == 'I' && c_next == 'X') {
					num += 9;
					// Skip one character
					i++;
				} else if (c == 'X' && c_next == 'L') {
					num += 40;
					// Skip one character
					i++;
				} else if (c == 'X' && c_next == 'C') {
					num += 90;
					// Skip one character
					i++;
				} else if (c == 'C' && c_next == 'D') {
					num += 400;
					// Skip one character
					i++;
				} else if (c == 'C' && c_next == 'M') {
					num += 900;
					// Skip one character
					i++;
				} else if (c == 'I') {
					num += 1;
				} else if (c == 'V') {
					num += 5;
				} else if (c == 'X') {
					num += 10;
				} else if (c == 'L') {
					num += 50;
				} else if (c == 'C') {
					num += 100;
				} else if (c == 'D') {
					num += 500;
				} else if (c == 'M') {
					num += 1000;
				}
			} else {
				if (c == 'I') {
					num += 1;
				} else if (c == 'V') {
					num += 5;
				} else if (c == 'X') {
					num += 10;
				} else if (c == 'L') {
					num += 50;
				} else if (c == 'C') {
					num += 100;
				} else if (c == 'D') {
					num += 500;
				} else if (c == 'M') {
					num += 1000;
				}
			}
		}
		return num;
	}

	public static void main(String[] args) {
		String strs[] = { "III", "IV", "IX", "LVIII", "MCMXCIV" };
		for (String str : strs) {
			System.out.println("Input: \"" + str + "\"");
			System.out.println("Output: " + romanToInt(str));
			System.out.println();
		}
	}

}

/**
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * Only the space character ' ' is considered as whitespace character. Assume we
 * are dealing with an environment which could only store integers within the
 * 32-bit signed integer range: [-231, 231 - 1]. If the numerical value is out
 * of the range of representable values, INT_MAX (231 - 1) or INT_MIN (-231) is
 * returned.
 * 
 * Example 1:
 * 
 * Input: "42"
 * 
 * Output: 42
 * 
 * 
 * Example 2:
 * 
 * Input: " -42"
 * 
 * Output: -42
 * 
 * Explanation: The first non-whitespace character is '-', which is the minus
 * sign. Then take as many numerical digits as possible, which gets 42.
 * 
 * 
 * Example 3:
 * 
 * Input: "4193 with words"
 * 
 * Output: 4193 Explanation:
 * 
 * Conversion stops at digit '3' as the next character is not a numerical digit.
 * 
 * 
 * Example 4:
 * 
 * Input: "words and 987"
 * 
 * Output: 0
 * 
 * Explanation: The first non-whitespace character is 'w', which is not a
 * numerical digit or a +/- sign. Therefore no valid conversion could be
 * performed.
 * 
 * 
 * Example 5:
 * 
 * Input: "-91283472332"
 * 
 * Output: -2147483648
 * 
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed
 * integer. Thefore INT_MIN (-231) is returned.
 * 
 * @author Marios
 *
 */
public class StringToInteger {

	public static int myAtoi(String str) {
		long num = 0;
		long symbol = 1;
		boolean foundNumber = false;
		boolean foundSymbol = false;
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (!foundSymbol && !foundNumber && c == ' ') {
				continue;
			} else if (foundNumber && !(c >= '0' && c <= '9')) {
				break;
			}
			if ((c < '0' || c > '9') && c != '+' && c != '-' && c != ' ') {

				return 0;
			} else if (c == '+' || c == '-') {
				if (foundSymbol || foundNumber) {
					return 0;
				}
				if (c == '-') {
					symbol = -1;
				}
				foundSymbol = true;
			} else if (c >= '0' && c <= '9') {
				num *= 10;
				num += c - 48;
				foundNumber = true;
				if (num != (int) num) {
					break;
				}
			} else {
				return 0;
			}
		}
		num = num * symbol;
		if (num >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (num <= Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else {
			return (int) num;
		}
	}

	public static void StringToIntegerAtoi(String str) {
		System.out.println("Input: \"" + str + "\"");
		System.out.println("Output: " + myAtoi(str));
		System.out.println();
	}

	public static void main(String[] args) {
		String strs[] = { "42", "+1", "-   234", "+-1", "--42", "-42", "  -42", "4193 with words", "4193 with words 5",
				"words and 987", "1words and 987", "-91283472332" };
		for (String str : strs) {
			StringToIntegerAtoi(str);
		}
	}

}

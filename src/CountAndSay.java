/**
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 1. 1
 * 
 * 2. 11
 * 
 * 3. 21
 * 
 * 4. 1211
 * 
 * 5. 111221
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 <= n <= 30, generate the nth term of the
 * count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * @author Marios
 *
 */
public class CountAndSay {
	public static String countAndSay(int n) {
		StringBuilder result = new StringBuilder();
		StringBuilder res = new StringBuilder();
		result.append("1");
		int count = 0;
		for (int i = 1; i < n; i++) {
			res = result;
			result = new StringBuilder();
			for (int j = 0; j < res.length() - 1; j++) {
				count++;
				if (res.charAt(j) != res.charAt(j + 1)) {
					result.append(Integer.toString(count));
					result.append(res.charAt(j));
					count = 0;
				}
			}
			count++;
			result.append(Integer.toString(count));
			result.append(res.charAt(res.length() - 1));
			count = 0;
			System.out.println(i + " : " + result.toString());
		}
		return result.toString();
	}

	public static void main(String[] args) {
		int n = 30;
		System.out.println("Input: " + n + "\nOutput: " + countAndSay(n) + " \n");
	}

}

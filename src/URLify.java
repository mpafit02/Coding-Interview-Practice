/**
 * This script replace the spaces of a string with the characters "%20". Time
 * Complexity is O(N) where N is the length of the initial string.
 * 
 * @author Marios
 *
 */
public class URLify {

	public static void main(String[] args) {
		char[] input = new char[17];
		String str = "Mr John Smith";
		for (int i = 0; i < str.length(); i++) {
			input[i] = str.charAt(i);
		}

		System.out.print("Input: \"");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
		}
		System.out.println("\"");

		char[] temp = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			temp[i] = input[i];
		}

		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			if (temp[i] == ' ') {
				input[j] = '%';
				input[j + 1] = '2';
				input[j + 2] = '0';
				j += 3;
			} else {
				input[j] = temp[i];
				j++;
			}
		}

		System.out.print("Output: \"");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
		}
		System.out.println("\"");
	}

}

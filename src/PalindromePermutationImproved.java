import java.util.HashSet;

/**
 * An optimized solution for finding Palindrome Permutations of a given string.
 * It finds the half strings and then the Permutations of that half of the
 * strings. Then add in reverse order the first half to create the Palindromes.
 * 
 * @author Marios
 *
 */
public class PalindromePermutationImproved {

	public static HashSet<String> permutations(String str, int index, HashSet<String> perms) {
		if (index >= str.length()) {
			return perms;
		}

		// Temporary HashSet for storing the new strings
		HashSet<String> temp = new HashSet<String>();

		// The character that we are going to add to the old permutations in order to
		// create new strings
		char c = str.charAt(index);

		// For each string in the existing set
		for (String perm : perms) {

			// Create all the possible string by adding the new character in all the
			// positions of the existing permutations
			for (int i = 0; i <= perm.length(); i++) {

				// The prefix
				String prefix = perm.substring(0, i);

				// The suffix
				String suffix = perm.substring(i);

				// Create the new string by adding the prefix the character and the suffix all
				// together
				String new_perm = prefix + c + suffix;

				// Add the new string to the HashSet
				temp.add(new_perm);
			}
		}
		// Call recursive again with the new permutations and the index for the new
		// character that we are going to add
		return permutations(str, index + 1, temp);
	}

	public static String reverse(String str) {
		String temp = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			temp += str.charAt(i);
		}
		return temp;
	}

	public static void palindromePermutations(String input) {
		String new_input = input.replace(" ", "").toLowerCase();
		System.out.println("Input: " + new_input);

		// Find Unique String
		int[] alphabet = new int[128];
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = 0;
		}
		for (int i = 0; i < new_input.length(); i++) {
			alphabet[new_input.charAt(i)]++;
		}

		String oddChar = "";
		String uniqueStr = "";

		boolean hasOddChar = false;
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] % 2 != 0) {
				if (hasOddChar == true) {
					System.out.println("This string doesn't have palindrome permutations!");
					return;
				} else {
					hasOddChar = true;
					oddChar += (char) i;
				}
			}

			for (int j = 0; j < (int) alphabet[i] / 2; j++) {
				uniqueStr += (char) i;
			}
		}
		// System.out.println(oddChar);
		// System.out.println(uniqueStr);

		// Calculate permutations and print the palindromes
		HashSet<String> perms = new HashSet<>();
		perms.add("");
		System.out.print("Output: ");
		int i = 0;
		for (String perm : permutations(uniqueStr, 0, perms)) {
			System.out.print(perm + oddChar + reverse(perm) + " ");
			i++;
			if (i % 10 == 0) {
				System.out.println();
				i = 0;
			}
		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {
		String[] input = { "Tact Coa", "Tact Ca", "Taot Ooa", "Ab Cbc", "Bd De" };
		for (String str : input) {
			palindromePermutations(str);
		}
	}

}

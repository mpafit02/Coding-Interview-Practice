/**
 * Checks if a string is strictly smaller than an other. That is true when the
 * frequency of occurrence of the smallest character in the string is less than
 * the frequency of occurrence of the smallest character in the comparison
 * string.
 * 
 * @author Marios
 *
 */
public class StrictlySmallerString {

	public static int getMinimum(String s) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 97]++;
		}
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] != 0) {
				return alphabet[i];
			}
		}
		return 0;
	}

	public static int[] strictlySmaller(String A, String B) {
		String[] a = A.split(",");
		String[] b = B.split(",");
		int result[] = new int[b.length];

		int min_a[] = new int[a.length];
		int min_b[] = new int[b.length];
		for (int i = 0; i < a.length; i++) {
			min_a[i] = getMinimum(a[i]);
		}
		for (int i = 0; i < b.length; i++) {
			min_b[i] = getMinimum(b[i]);
		}
		for (int i = 0; i < b.length; i++) {
			result[i] = 0;
			for (int j = 0; j < a.length; j++) {
				if (min_a[j] < min_b[i]) {
					result[i]++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String A = "abcd,aabc,bd,cc";
		String B = "aaa,aa,a,bb,bcdcc";
		int[] output = strictlySmaller(A, B);
		System.out.print("[");
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]);
			if (i != output.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

}

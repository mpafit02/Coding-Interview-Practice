/**
 * This class checks whether two strings have only one character or less
 * different. Time Complexity is O(n)
 * 
 * @author Marios
 *
 */
public class OneWayStringComparison {

	public static boolean isOneWay(String s1, String s2) {
		if (Math.abs(s1.length() - s2.length()) > 1) {
			return false;
		}
		int index1 = 0;
		int index2 = 0;

		int differences = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (index1 >= s1.length() || index2 >= s2.length()) {
				break;
			}
			if (s1.charAt(index1) == s2.charAt(index2)) {
				index1++;
				index2++;
			} else {
				differences++;
				if (index1 + 1 < s1.length() && index2 + 1 < s2.length()
						&& s1.charAt(index1 + 1) == s2.charAt(index2 + 1)) {
					index1++;
					index2++;
				} else if (index1 + 1 < s1.length() && s1.charAt(index1 + 1) == s2.charAt(index2)) {
					index1++;
				} else if (index2 + 1 < s2.length() && s1.charAt(index1) == s2.charAt(index2 + 1)) {
					index2++;
				} else {
					differences++;
					break;
				}
			}
		}
		if (differences > 1) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		String[] firstStr = { "pale", "pales", "pale", "pale", "pl" };
		String[] secondStr = { "ple", "pale", "bale", "bake", "pale" };

		for (int i = 0; i < firstStr.length; i++) {
			System.out.println(
					"Is One Way: " + firstStr[i] + ", " + secondStr[i] + " -> " + isOneWay(firstStr[i], secondStr[i]));
		}
	}

}

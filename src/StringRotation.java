/**
 * Find whether the string s2 is rotation of the string s1 by calling only once
 * the function isSubstring.
 * 
 * @author Marios
 *
 */
public class StringRotation {

	/**
	 * Find if a string is a substring of another. Time Complexity O(N) where N is
	 * the length of s1
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isSubstring(String s1, String s2) {
		// Empty string
		if (s2.length() == 0) {
			return true;
		}
		if (s2.length() > s1.length()) {
			return false;
		}
		int j = 0;
		int old_i = 0;
		boolean setOldI = false;
		for (int i = 0; i < s1.length(); i++) {
//			System.out.println(s1.charAt(i) + " " + s2.charAt(j) + " " + i + " " + j);
			if (s1.charAt(i) == s2.charAt(j)) {
				if (!setOldI) {
					old_i = i;
					setOldI = true;
				}
				j++;
				if (j >= s2.length()) {
					return true;
				}
			} else {
				j = 0;
				if (setOldI) {
					i = old_i;
					setOldI = false;
				}
			}
		}
		return false;
	}

	/**
	 * Check if string s2 is a rotation of the string s1 by calling isSubstring
	 * method only once. This method is so smart. if s2 is a rotation of s1 then the
	 * two parts that are rotated we can call them xy in s1 and yx in s2. If we
	 * create the string s2 + s2 is equal to yxyx will always the s1 = xy will be
	 * substring of.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		String s2s2 = s2 + s2;
//		System.out.println("S2 + S2 = " + s2s2);
		return isSubstring(s2s2, s1);
	}

	public static String[] allRotations(String s1) {
		String[] rotations = new String[s1.length()];
		for (int i = 0; i < s1.length(); i++) {
			rotations[i] = s1.substring(i, s1.length()) + s1.substring(0, i);
		}
		return rotations;
	}

	public static void findRotations(String s1, String s2) {
		System.out.println("\nFind Rotations for the strings '" + s1 + "' and '" + s2);
		String[] rotations = allRotations(s2);
		for (int i = 0; i < rotations.length; i++) {
			System.out.println();
			System.out.println("Is '" + rotations[i] + "' rotation of '" + s1 + "' -> " + isRotation(s1, rotations[i]));
		}
	}

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "waterbotlle";
		String s3 = "aaaaa";
		String s4 = "aaabaaa";
		findRotations(s1, s1);
		findRotations(s1, s2);
		findRotations(s3, s3);
		findRotations(s4, s4);
	}

}

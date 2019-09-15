/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * Example:
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * 
 * Output: 49
 */
public class ContainerWithMostWater {
	/**
	 * Brute Force approach with O(N^2) Time Complexity
	 * 
	 * @param height
	 * @return
	 */
	public static int maxAreaBruteForce(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i; j < height.length; j++) {
				int minHeight = height[j];
				if (height[i] < height[j]) {
					minHeight = height[i];
				}
				if ((j - i) * minHeight > max) {
					max = (j - i) * minHeight;
//					System.out.println(j + " " + i + " " + max + " " + minHeight);
				}
			}
		}
		return max;
	}

	/**
	 * Two pointers solution with O(N) Time Complexity and O(1) Space Complexity
	 * 
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int max = 0;
		int temp = 0;
		int l = 0;
		int r = height.length - 1;
		while (l < r) {
			temp = Math.min(height[l], height[r]) * (r - l);
			if (temp > max) {
				max = temp;
			}
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] input = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.print("Input: [");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			if (i != input.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		System.out.println("Output: " + maxAreaBruteForce(input));

		System.out.println();
		System.out.print("Input: [");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			if (i != input.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		System.out.println("Output: " + maxArea(input));
	}

}

import java.util.HashMap;

/**
 * This class finds whether there is a pair in a set of integer numbers that
 * adds to a target with Time Complexity O(N)
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * 
 * return [0, 1].
 * 
 * @author Marios
 *
 */
public class TwoSums {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> complements = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (complements.containsKey(nums[i])) {
				int[] result = { complements.get(nums[i]), i };
				return result;
			}
			complements.put(target - nums[i], i);
		}
		int[] result = {};
		return result;
	}

	public static void main(String[] args) {
		int[] input = { 2, 7, 11, 15 };
		System.out.print("The input is: [");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		int[] result = twoSum(input, 9);
		System.out.print("]\nThe result is: [");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println("]\n");

		int[] input2 = {};
		System.out.print("The input is: [");
		for (int i = 0; i < input2.length; i++) {
			System.out.print(input2[i] + " ");
		}
		int[] result2 = twoSum(input2, 9);
		System.out.print("]\nThe result is: [");
		for (int i = 0; i < result2.length; i++) {
			System.out.print(result2[i] + " ");
		}
		System.out.println("]\n");

		int[] input3 = { 2, 7, 11, 15 };
		System.out.print("The input is: [");
		for (int i = 0; i < input3.length; i++) {
			System.out.print(input3[i] + " ");
		}
		int[] result3 = twoSum(input3, 6);
		System.out.print("]\nThe result is: [");
		for (int i = 0; i < result3.length; i++) {
			System.out.print(result3[i] + " ");
		}
		System.out.println("]\n");
	}
}
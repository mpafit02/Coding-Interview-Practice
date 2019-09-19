import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author Marios
 *
 */
public class ThreeSum {

	public static List<List<Integer>> threeSumBruteForce(int[] nums) {
		if (nums.length < 3) {
			return new ArrayList<>();
		}
		List<List<Integer>> solutions = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						Collections.sort(temp);
						if (!solutions.contains(temp)) {
							solutions.add(temp);
						}
					}
				}
			}
		}
		return solutions;
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3) {
			return new ArrayList<>();
		}
		int left = 0;
		int right = nums.length - 1;
		sort(nums, left, right);
		System.out.println(Arrays.toString(nums));
		List<List<Integer>> solutions = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			while (left < right) {
				System.out.println("i " + i + " left " + left + " right " + right);
				if (i != left && i != right) {
					int sum = nums[left] + nums[right];
					if (sum + nums[i] == 0) {
						List<Integer> temp = new ArrayList<>();
						if (i > left) {
							temp.add(nums[left]);
							temp.add(nums[i]);
						} else {
							temp.add(nums[i]);
							temp.add(nums[left]);
						}
						temp.add(nums[right]);
						if (!solutions.contains(temp)) {
							solutions.add(temp);
						}
						left++;
					} else if (sum + nums[i] < 0) {
						left++;
					} else {
						right--;
					}
				} else {
					System.out.println("Breaked");
					break;
				}
			}
			left = 0;
			right = nums.length - 1;
		}
		return solutions;

	}

	public static void sort(int[] nums, int left, int right) {
		if (left < right) {
			int pos = partition(nums, left, right);
			sort(nums, left, pos - 1);
			sort(nums, pos + 1, right);
		}
	}

	public static int partition(int[] nums, int left, int right) {
		int pivot = nums[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (nums[j] < pivot) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		int temp = nums[i + 1];
		nums[i + 1] = nums[right];
		nums[right] = temp;

		return i + 1;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> solutions = threeSum(nums);
		System.out.println(solutions);
		System.out.println();
		int[] nums2 = { -2, 0, 1, 1, 2 };
		solutions = threeSum(nums2);
		System.out.println(solutions);
		System.out.println();
		int[] nums3 = { 3, 0, -2, -1, 1, 2 };
		solutions = threeSum(nums3);
		System.out.println(solutions);
		System.out.println();
		System.out.println();
		solutions = threeSumBruteForce(nums);
		System.out.println(solutions);
		System.out.println();
		solutions = threeSumBruteForce(nums2);
		System.out.println(solutions);
		System.out.println();
		solutions = threeSumBruteForce(nums3);
		System.out.println(solutions);
	}

}

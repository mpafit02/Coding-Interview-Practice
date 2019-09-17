import java.util.Arrays;

/**
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * 
 * Example 1:
 * 
 * Given nums = [3,2,2,3], val = 3,
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 * 
 * It doesn't matter what you leave beyond the returned length.
 * 
 * 
 * Example 2:
 * 
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * 
 * Your function should return length = 5, with the first five elements of nums
 * containing 0, 1, 3, 0, and 4.
 * 
 * Note that the order of those five elements can be arbitrary.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * 
 * Confused why the returned value is an integer but your answer is an array?
 * 
 * Note that the input array is passed in by reference, which means modification
 * to the input array will be known to the caller as well.
 * 
 * Internally you can think of this:
 * 
 * // nums is passed in by reference. (i.e., without making a copy) int len =
 * removeElement(nums, val);
 * 
 * // any modification to nums in your function would be known by the caller. //
 * using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) { print(nums[i]); }
 * 
 * @author Marios
 *
 */
public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
		int i = 0;
		int count = 0;
		int end = nums.length - 1;
		while (i <= end) {
			if (nums[i] == val) {
				int temp = nums[i];
				nums[i] = nums[end];
				nums[end] = temp;
				end--;
				count++;
			} else {
				i++;
			}
		}
		return nums.length - count;
	}

	public static void main(String[] args) {
		int[] input1 = { 3, 2, 2, 3 };
		int[] input2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int[] input3 = { 1 };
		int val1 = 3;
		int val2 = 2;
		int val3 = 1;
		System.out.println("Input: " + Arrays.toString(input1));
		System.out.println("Val: " + val1);
		System.out.println("Output: " + removeElement(input1, val1));
		System.out.println();
		System.out.println("Input: " + Arrays.toString(input2));
		System.out.println("Val: " + val2);
		System.out.println("Output: " + removeElement(input2, val2));
		System.out.println();
		System.out.println("Input: " + Arrays.toString(input3));
		System.out.println("Val: " + val3);
		System.out.println("Output: " + removeElement(input3, val3));
		System.out.println();
	}

}

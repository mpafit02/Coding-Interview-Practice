/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * Input: [1,3,5,6], 5
 * 
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * Input: [1,3,5,6], 2
 * 
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * Input: [1,3,5,6], 7
 * 
 * Output: 4
 * 
 * 
 * Example 4:
 * 
 * Input: [1,3,5,6], 0
 * 
 * Output: 0
 * 
 * @author Marios
 *
 */
public class SearchInsertPosition {
	public static int searchInsertRec(int[] nums, int target, int left, int right) {
		System.out.println(left + " " + right);
		if (left == right) {
			if (target <= nums[left]) {
				return left;
			} else {
				return left + 1;
			}
		}
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			return searchInsertRec(nums, target, left, mid);
		} else {
			return searchInsertRec(nums, target, mid + 1, right);
		}
	}

	public static int searchInsert(int[] nums, int target) {
		System.out.println("Check: " + target);
		return searchInsertRec(nums, target, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		int[] input = { 1, 3, 5, 6 };
		System.out.println(searchInsert(input, 2));
		System.out.println();
		System.out.println(searchInsert(input, 1));
		System.out.println();
		System.out.println(searchInsert(input, 3));
		System.out.println();
		System.out.println(searchInsert(input, 5));
		System.out.println();
		System.out.println(searchInsert(input, 6));
		System.out.println();
		System.out.println(searchInsert(input, 4));
		System.out.println();
		System.out.println(searchInsert(input, 0));
	}

}

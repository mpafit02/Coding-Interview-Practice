import java.util.Arrays;

/**
 * Three different ways of implementing the kth largest element search. One
 * method that first sorts the array in O(nlogn) and then returns the element in
 * the kth position. The other method implements a partial sort until it puts in
 * the right position the element k. Time Complexity is n + n/2 + n/4 + n/8 ...
 * which is equal to 2n to O(N) Time Complexity.
 * 
 * @author Marios
 *
 */
public class KthLargestElementInAnArray {
	// {2,5,3,8,1,4,7}
	// x = 7
	// i = 0
	// j = 0 -> 7
	// arr[0] = 2 < 7? True
	// arr[0] = 2, arr[0] = 2;
	// i = 1
	// {2,5,3,8,1,4,7}
	// arr[1] = 5 < 7? True
	// arr[1] = 5, arr[1] = 5
	// i = 2
	// {2,5,3,8,1,4,7}
	// arr[2] = 3 < 7? True
	// arr[2] = 3, arr[2] = 3
	// i = 3
	// {2,5,3,8,1,4,7}
	// arr[3] = 8 < 7? False
	// arr[4] = 1 < 7? True
	// arr[3] = 1, arr[4] = 8
	// i = 4
	// {2,5,3,1,8,4,7}
	// arr[5] = 4 < 7? True
	// arr[4] = 4, arr[5] = 8
	// i = 5
	// {2,5,3,1,4,8,7}
	// arr[6] = 7 < 7? False
	// arr[5] = 7, arr[6] = 8
	// {2,5,3,1,4,7,8}
	// return 5 // correct position

	public static int partition(int[] arr, int l, int r) {
		int x = arr[r];
		int i = l;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] >= x) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;

		return i;
	}

	public static int partitionSort(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than the pivot
			if (arr[j] > pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	public static void sort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partitionSort(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	public static int findKthLargestRec(int[] nums, int l, int r, int k) {
		// If k is smaller than number of elements
		// in array
		if (k > 0 && k <= r - l + 1) {
			int pos = partition(nums, l, r);
			print(nums);
			if (pos - l == k - 1) {
				return nums[pos];
			} else if (pos - l > k - 1) {
				return findKthLargestRec(nums, l, pos - 1, k);
			} else {
				return findKthLargestRec(nums, pos + 1, r, k - pos + l - 1);
			}
		}
		return Integer.MAX_VALUE;
	}

	public static int findKthLargest(int[] nums, int k) {
		int l = 0;
		int r = nums.length - 1;
		return findKthLargestRec(nums, l, r, k);
	}

	public static int findKthLargestSlower(int[] nums, int k) {
		sort(nums, 0, nums.length - 1);
		return nums[k - 1];
	}

	public static int findKthLargestFaster(int[] nums, int k) {
		k = nums.length - k - 1; // for the largest
		int start = 0;
		int index = 0;
		int end = nums.length - 2;
		int[] newArray = new int[nums.length - 1];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[index]) {
				newArray[start] = nums[i];
				start++;
			} else {
				newArray[end] = nums[i];
				end--;
			}
		}
		print(newArray);
		System.out.println("Start: " + start + " k: " + k);
		if (k > start) {
			return findKthLargestFaster(Arrays.copyOfRange(newArray, start + 1, newArray.length), k - start);
		} else if (k < start) {
			return findKthLargestFaster(Arrays.copyOfRange(newArray, 0, start), k);
		} else {
			return nums[start];
		}
	}

	public static void print(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		int[] input1 = { 3, 2, 1, 5, 6, 4 };
		int k1 = 2;
		System.out.println("Input: ");
		print(input1);
		System.out.println("K: " + k1);
		System.out.println("Output: " + findKthLargest(input1, k1));
		System.out.println();
		int[] input2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k2 = 4;
		System.out.println("Input: ");
		print(input2);
		System.out.println("K: " + k2);
		System.out.println("Output: " + findKthLargest(input2, k2));
		int[] input3 = { 3, 2, 1, 5, 6, 4 };
		int k3 = 2;
		System.out.println("Input: ");
		print(input3);
		System.out.println("K: " + k3);
		System.out.println("Output: " + findKthLargestSlower(input3, k3));
		System.out.println();
		int[] input4 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k4 = 4;
		System.out.println("Input: ");
		print(input4);
		System.out.println("K: " + k4);
		System.out.println("Output: " + findKthLargestSlower(input4, k4));
		System.out.println();
		int[] input5 = { 3, 2, 1, 5, 6, 4 };
		int k5 = 2;
		System.out.println("Input: ");
		print(input5);
		System.out.println("K: " + k5);
		System.out.println("Output: " + findKthLargestFaster(input5, k5));
		System.out.println();
		int[] input6 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k6 = 4;
		System.out.println("Input: ");
		print(input6);
		System.out.println("K: " + k6);
		System.out.println("Output: " + findKthLargestFaster(input6, k6));

	}

}

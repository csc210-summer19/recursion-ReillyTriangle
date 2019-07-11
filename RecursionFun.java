/**
 * @author Rick Mercer and Reinhilde Robinson
 * 
 *         Complete the seven methods methods in this file using recursion, no
 *         loops. Also complete these three methods inside LinkedList<E>:
 *         get(int) removeAll(E) duplicateAll(E)
 * 
 *         Also complete one method in ObstacleCourse that uses recursive
 *         backtracking. findExit(int, int)
 * 
 *         Note: I believe the given unit test tests all methods. We will be
 *         using this same for for correctness of code.
 * 
 *         We will not be using code coverage for points.
 */

public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (n == k) {
			return 1;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a
	// String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String str = Integer.toString(n);

		if (str.length() <= 3) {
			return str;
		}

		String digitsLeftOfComma = str.substring(0, str.length() - 3);
		String digitsRightOfComma = str.substring(str.length() - 3,
				str.length());

		int newN = Integer.parseInt(digitsLeftOfComma);

		return intWithCommas(newN) + "," + digitsRightOfComma;
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	// helper function to reverseArray
	private void reverseArray(int[] x, int index, int len) {
		if (index >= len / 2) {
			return;
		}
		int ref = x[index];
		x[index] = x[len - index - 1];
		x[len - index - 1] = ref;
		reverseArray(x, index + 1, len);
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return arrayRange(a, 0, a.length - 1, 0);
	}

	// helper function to arrayRange
	private int arrayRange(int[] a, int startIndex, int stopIndex, int span) {
		if (startIndex == stopIndex) {
			return span;
		}

		int max = Math.max(a[startIndex], a[stopIndex]);
		int min = Math.min(a[startIndex], a[stopIndex]);
		int newSpan = Math.max(span, max - min);

		int spanLeft = arrayRange(a, startIndex, stopIndex - 1, newSpan);
		int spanRight = arrayRange(a, startIndex + 1, stopIndex, newSpan);

		return Math.max(spanLeft, spanRight);
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return true;
		}
		return isSorted(nums, 0);
	}

	// helper function to isSorted
	private boolean isSorted(int[] nums, int index) {
		if (nums[index] > nums[index + 1]) {
			return false;
		}
		if (index == nums.length - 2) {
			return true;
		}
		return isSorted(nums, index + 1);
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		if (strs.length == 0) {
			return false;
		}
		return found(search, strs, 0);
	}

	// helper function to found
	private boolean found(String search, String[] strs, int index) {
		if (strs[index].equals(search)) {
			return true;
		}
		if (index == strs.length - 1) {
			return false;
		}
		return found(search, strs, index + 1);
	}
}

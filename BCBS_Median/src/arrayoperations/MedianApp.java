package arrayoperations;
import java.util.Arrays;

/**
 * BCBS Business Layer Option Two: Median of Two Sorted Arrays
 * @author Adair Tabb
 *
 */

public class MedianApp {
	
	/**
	 * This method is called by findMedian(). It takes in two int arrays as 
	 * parameters and concatenates them.
	 * It takes the length of each array, and uses the sum of those lengths to initialize
	 * a new int array large enough to contain both of them.
	 * The contents of each parameter array are iterated over 
	 * and added to the newly initialized array. This array is then sorted and returned.
	 * @param nums1 an int[] provided by findMedian().
	 * @param nums2 an int[] provided by findMedian().
	 * @return a sorted int[] comprised of the contents of nums1 and nums2.
	 */
	private static int[] mergeArrays(int[] nums1, int[] nums2) {
		int nums1Len = nums1.length;
		int nums2Len = nums2.length;
		int combinedLen = nums1Len+nums2Len;
		int[] mergedArray = new int[combinedLen];
		
		for (int i = 0; i < nums1Len; i += 1){
			mergedArray[i] = nums1[i];
		}
		
		for (int i = 0; i < nums2Len; i += 1) {
			mergedArray[nums1Len + i] = nums2[i];
		}
		
		Arrays.sort(mergedArray);
		
		return mergedArray;
	}
	
	public static Number findMedian(int[] nums1, int[] nums2) {
		Number median = 0;
		int[] mergedNums = mergeArrays(nums1, nums2);
		int arrLen = mergedNums.length;
		
		System.out.println("Combined Array: " +Arrays.toString(mergedNums));
		System.out.println("Length: " + arrLen);

		if (arrLen % 2 == 0) {
			median = (double)(mergedNums[arrLen/2] + mergedNums[(arrLen-1)/2])/2.0;
		} else {
			median = (int)mergedNums[arrLen/2];
		}
		
		return median;
	}

	public static void main(String[] args) {
		int[] primeNums = new int[] {2, 3, 5, 7, 11, 13};
		int[] fibonacciNums = new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34};
		int[] palindromicNums = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55};
		
		System.out.println("Median of primes and fibonacci = " + findMedian(primeNums, fibonacciNums) + "\n");
		System.out.println("Median of primes and palindromes = " + findMedian(primeNums, palindromicNums) + "\n");
		System.out.println("Median of fibonacci and palindromes = " + findMedian(fibonacciNums, palindromicNums) + "\n");
 
	}

}
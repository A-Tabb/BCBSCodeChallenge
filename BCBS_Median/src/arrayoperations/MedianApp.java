package arrayoperations;
import java.util.Arrays;

/**
 * BCBS Business Layer Option Two: Median of Two Sorted Arrays
 * @author Adair Tabb
 *
 */

public class MedianApp {
	
	/**
	 * Returns a single int[] array composed of the contents of two int[] arrays, 
	 * which are taken as parameters.
	 * 
	 * This method is called by findMedian().
	 * It takes the length of each int[] array from the parameters, and uses the 
	 * sum of those lengths to initialize a new int[] array large enough to contain both of them.
	 * The contents of each parameter array are iterated over and added to the 
	 * newly initialized array. This array is then sorted and returned.
	 * 
	 * @param nums1 an int[] provided by findMedian.
	 * @param nums2 an int[] provided by findMedian.
	 * @return a sorted int[] composed of the contents of nums1 and nums2.
	 * @see findMedian
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
	/**
	 * Returns the median of two sorted int[] arrays, 
	 * which are taken as parameters.
	 * 
	 * This method calls mergeArrays to receive a concatenation of 
	 * its two int[] array parameters. It takes the length of this concatenation.
	 * If the length is even, this method finds and returns the average of 
	 * the two middle indices. If the length is odd, this method
	 * finds and returns the middle index.
	 * 
	 * @param nums1 a sorted int[] array.
	 * @param nums2 a sorted int[] array.
	 * @return an int or double value that is the median of nums1 and nums2.
	 */
	public static Number findMedian(int[] nums1, int[] nums2) {
		Number median = 0;
		int[] mergedNums = mergeArrays(nums1, nums2);
		int arrLen = mergedNums.length;
		
		System.out.println("Combined Array: " +Arrays.toString(mergedNums));
		System.out.println("Length: " + arrLen);

		if (arrLen % 2 == 0) { //check to see if the length is even
			median = (double)(mergedNums[arrLen/2] + mergedNums[(arrLen-1)/2])/2.0; //take the average of the middle two indices
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
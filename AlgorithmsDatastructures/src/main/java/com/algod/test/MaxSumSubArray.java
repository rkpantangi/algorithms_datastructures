package com.algod.test;

/**
 * Given an array of Integers, find the sum of a contiguous sub array that has the largest sum.
 * This is a two pointer approach
 * @author Ram
 *
 */
public class MaxSumSubArray {

	public static void main(String[] args) {
		int [] arr = new int [] {-2, -3, 4, -1, -2, 1, 5, -3};
		maxSubArraySum1(arr);

		arr = new int [] {20, -5, 4, -1, -2, 1, 5, -3};
		maxSubArraySum1(arr);

		arr = new int [] {2, -3, 50, -1, -2, 1, 5, -3};
		maxSubArraySum1(arr);

		arr = new int [] {2, -3, 50, -1, -2, 1, 5, -3, -79, 100};
		maxSubArraySum1(arr);

		arr = new int [] {-2};
		maxSubArraySum1(arr);

		arr = new int [] {-2, -5};
		maxSubArraySum1(arr);
	}

	/*

		// 20 -5 4 -1 -2 1 5 -3
		// 2 -3 50 -1 -2 1 5 -3

		// -2 -3 4 -1 -2 1 5 -3
		if newsum < the current number, then move both st & end, otherwise just move end
		st=0, end=0, maxsum = prevsum = -2

		newsum = prevsum (-2) + (-3) = -5
		newsum < currentnumber (-5 < -3), yes, st=++end, prevsum=0

		newsum = prevsum (0) + 4 = 4
		newsum > maxsum, (4 > -2), maxsum=newsum, mst=st, mend=end
		newsum < currentnumber? (4 < 4), no, end++, prevsum = newsum

		newsum = prevsum (4) + (-1) = 3
		newsum > maxsum (3 > 4)? no
		newsum < currentnumber? (3 < -1), no, prevsum=newsum, end++

		newsum = prevsum (3) + (-2) = 1
		newsum > maxsum (1 > 4)? no
		newsum < currentnumber? (1 < -2), no, prevsum=newsum, end++

		newsum = prevsum (1) + 1 = 2
		newsum > maxsum (2 > 4)? no
		newsum < currentnumber? (2 < 1), no, prevsum=newsum, end++

		newsum = prevsum (2) + 5 = 7
		newsum > maxsum (7 > 4)? yes, maxsum=newsum, mst=st, mend=end
		newsum < currentnumber? (7 < 5), no, prevsum=newsum, end++

		newsum = prevsum (7) + -3 = 4
		newsum > maxsum (4 > 7)? no
		newsum < currentnumber? (4 < -3), no, prevsum=newsum, end++

	 */

	private static void maxSubArraySum1(int[] a) {
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
		int st=-1,maxst=-1,maxend=-1;
		for (int i=0;i<a.length;i++) {
			max_ending_here = max_ending_here + a[i];
			if (st == -1) {
				st = i;
			}
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				maxst = st;
				maxend = i;
			}
			if (max_ending_here < 0) {
				max_ending_here = 0;
				st=-1;
			}
		}
		System.out.println("Max sum - " + max_so_far + ", maxst - " + maxst + ", maxend - " + maxend);
	}
}

package com.algod;

import java.util.Arrays;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 *
 * Two pointer solution
 */
public class PairWithSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPair(new int[]{1, 2, 3, 4, 6}, 6)));
        System.out.println(Arrays.toString(findPair(new int[]{}, 6)));
        System.out.println(Arrays.toString(findPair(new int[]{2, 5, 9, 11}, 11)));
        System.out.println(Arrays.toString(findPair(new int[]{2, 5, 9, 11}, 10)));
    }

    private static int [] findPair(int [] arr, int sum) {
        int [] result = new int[2];

        if (arr.length < 2) {
            return result;
        }

        int st=0;
        int end=arr.length-1;

        while(st < end) {
            int lsum = arr[st] + arr[end];
            if (lsum > sum) {
                end--;
            } else if (lsum < sum) {
                st++;
            } else {
                break;
            }
        }
        if (st < end) {
            result[0] = st;
            result[1] = end;
        }
        return result;
    }
}

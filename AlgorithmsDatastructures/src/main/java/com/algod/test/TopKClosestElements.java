package com.algod.test;

import java.util.*;

/*
    Given a sorted array and a value X, find the k closest elements to X in the array.
 */
public class TopKClosestElements {

    public static void main(String[] args) {
        int [] nums = new int[] {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};
        System.out.println(Arrays.toString(topKClosestElements(nums, 35, 4)));

        nums = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(topKClosestElements(nums, -1, 4)));

        nums = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(topKClosestElements(nums, 100, 4)));
    }

    private static int[] topKClosestElements(int [] nums, int x, int k) {
        int cp = getCrossOverPoint(nums, x);
        int [] result = new int[k];
        if (cp == 0) {
            System.arraycopy(nums, 0, result, 0, k);
        } else if (cp == nums.length - 1) {
            System.arraycopy(nums, nums.length - k, result, 0, k);
        } else {
            int l=cp;
            int r=cp+1;
            int i=0;
            while(i < k) {
                if (Math.abs(x - nums[l]) < Math.abs(x - nums[r])) {
                    result[i++]=nums[l--];
                } else if (Math.abs(x - nums[l]) > Math.abs(x - nums[r])) {
                    result[i++]=nums[r++];
                } else {
                    result[i++]=nums[l--];
                    result[i++]=nums[r++];
                }
                if (l == -1) {
                    if (i < k-1) {
                        System.arraycopy(nums, r, result, i, (k - i - 1));
                    }
                    break;
                }
                if (r == nums.length) {
                    if (i < k-1) {
                        System.arraycopy(nums, l - ((k - i - 1)), result, i, (k - i - 1));
                    }
                    break;
                }
            }
        }
        return result;
    }

    private static int getCrossOverPoint(int [] nums, int x) {
        if (x <= nums[0]) return 0;
        if (x >= nums[nums.length - 1]) return nums.length-1;

        int lo = 0;
        int hi = nums.length;
        while(true) {
            int mid = (lo+hi)/2;
            if (x < nums[mid]) {
                hi = mid-1;
            } else if (x > nums[mid]) {
                lo = mid+1;
            } else {
                return mid;
            }
            if (lo == hi-1) {
                return lo;
            }
        }
    }
}

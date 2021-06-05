package com.algod.test;

import java.util.Arrays;

public class MoveZeroToTheEnd {

	public static void main(String[] args) {
		int [] nums = new int[] {0, 1, 0, 3, 12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		
		nums = new int[] {0, 0, 0, 0, 0};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		
		nums = new int[] {1, 0, 0, 0, 0};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] {0, 0, 0, 0, 1};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] {1, 0, 0, 5, 6};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));

	}

    private static void moveZeroes(int[] nums) {
        int lastzero=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] != 0) {
                if (lastzero >= 0 && lastzero < i) {
                    nums[lastzero] = nums[i];
                    lastzero++;
                }
            }
        }
        
        for (int i=lastzero;i<nums.length;i++) {
            nums[i]=0;
        }
    }
}

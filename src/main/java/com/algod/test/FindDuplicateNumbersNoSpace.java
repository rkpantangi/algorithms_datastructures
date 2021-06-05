package com.algod.test;

/**
 * Should not take additional space
 * This is a technique called Cyclical Sort .. or position swapping in the array.
 */
public class FindDuplicateNumbersNoSpace {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 4, 4, 3, 2}));
        System.out.println(findDuplicate(new int[]{2, 1, 3, 3, 5, 4}));
        System.out.println(findDuplicate(new int[]{2, 4, 1, 4, 4}));
        System.out.println(findDuplicate(new int[]{1, 2, 3}));
        System.out.println(findDuplicate(new int[]{1, 2, 3, 5, 6, 4}));
        System.out.println(findDuplicate(new int[]{1, 2, 3, 5, 6, 5}));
    }

    private static int findDuplicate(int [] arr) {
        int st=0;
        while(st < arr.length) {
            // check if number is already in the correct place: meaning - 2 in position 1 already
            if (arr[st] != st+1) {
                // is number in the target the same as the source?
                if (arr[arr[st]-1] != arr[st]) {
                    swap(arr, st, arr[st] - 1);
                } else {
                    return arr[st];
                }
            } else {
                st++;
            }
        }

        return -1;
    }

    private static void swap(int []arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}

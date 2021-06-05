package com.algod.test;

/**
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing
 * the duplicates in-place return the last index of the non-duplicate number
 * Two Pointer solution
 */
public class RemoveDuplicatesInPlace {

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 6, 9, 9};
        printUntil(arr, removeDuplicatesInPlace(arr));

        arr = new int[] {1, 2, 3, 4};
        printUntil(arr, removeDuplicatesInPlace(arr));

        arr = new int[] {2, 2, 2, 11};
        printUntil(arr, removeDuplicatesInPlace(arr));

        arr = new int[] {2, 2};
        printUntil(arr, removeDuplicatesInPlace(arr));

        arr = new int[] {2};
        printUntil(arr, removeDuplicatesInPlace(arr));
    }

    // 2, 3, 3, 3, 6, 9, 9
    private static int removeDuplicatesInPlace(int [] arr) {
        int nonDuplicate = 0;
        for (int i=1;i<arr.length;i++) {
            if (arr[nonDuplicate] != arr[i]) {
                nonDuplicate++;
                if (nonDuplicate != i) {
                    arr[nonDuplicate] = arr[i];
                }
            }
        }
        return nonDuplicate;
    }

    private static void printUntil(int [] arr, int end) {
        System.out.println();
        for (int i=0;i<=end;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

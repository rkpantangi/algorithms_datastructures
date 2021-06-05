package com.algod.test;

import java.util.*;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int [] nums = new int[] {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKElements(nums, 2)));

        nums = new int [] {1};
        System.out.println(Arrays.toString(topKElements(nums, 1)));
    }

    private static int[] topKElements(int [] nums, int k) {
        Map<Integer, Integer> countTracker = new HashMap<>();
        for (int num : nums) {
            countTracker.put(num, countTracker.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(countTracker::get));
        for (int key : countTracker.keySet()) {
            queue.add(key);
            if (queue.size() > k) queue.poll();
        }

        int [] result = new int[k];
        for (int i=0;i<k;i++) {
            result[i] = queue.poll();
        }
        return result;
    }

}

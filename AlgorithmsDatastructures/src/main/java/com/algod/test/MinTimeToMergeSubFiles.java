package com.algod.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * You are given an array of file sizes. Time to merge any two files is the sum of their sizes. You need a minimum of 2 files to merge.
 * Calculate the minimum time needed to merge all the files into one.
 */
public class MinTimeToMergeSubFiles {
	public static void main(String[] args) {
		List<Integer> files = Arrays.asList(8, 4, 6, 12);
		System.out.println(minimumTime(files.size(), files));
	}

	private static int minimumTime(int numOfSubFiles, List<Integer> files) {
		Collections.sort(files);

		int totalTime = 0;
		for (int i = 1; i < files.size(); i++) {
			int stime = (files.get(i - 1) + files.get(i));
			files.set(i, stime);
			totalTime += stime;
		}
		return totalTime;
	}
}

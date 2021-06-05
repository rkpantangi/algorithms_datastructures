package com.algod.test;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingIntFinderFromHugeList {

	public static void main(String[] args) {
		int[] arr = getSampleData();
		int [] missing = getMissingNums(arr);
	}

	private static int[] getMissingNums(int[] arr) {
		// convert to a bit vector
		int numBits = (int) Math.ceil(Math.log(arr.length)/Math.log(2));
		BitSet bs = new BitSet(numBits);
		Arrays.stream(arr).forEach(x -> bs.set(x));
		return null;
	}

	private static int[] getSampleData() {
		List<Integer> range = IntStream.rangeClosed(0, 1000)
			    .boxed().collect(Collectors.toList());
		Random r = new Random();
		for (int i=1;i<=10; i++) {
			int n = r.nextInt(1000);
			range.remove(n);
		}
		
		return range.stream().mapToInt(Integer::intValue).toArray();
	}
}

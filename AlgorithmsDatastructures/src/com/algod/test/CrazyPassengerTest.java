package com.algod.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CrazyPassengerTest {

	private static int size = 10;
	
	public static void main(String[] args) {
		CrazyPassengerTest cpt = new CrazyPassengerTest();
		
		int successes = 0;
		int noOfExp = 10000000;
		for (int i=1;i<=noOfExp;i++) {
			successes += cpt.runSimulation(size);
		}
		double prob = (double)successes/noOfExp;
		System.out.println(prob);
	}

	public int runSimulation(int size) {
		int [] passToSeat = getShuffledArray(size);
		int lastPassSeatAssignment = -1;
		int lastPass = new Random().nextInt(size);
		List<Integer> rems = getShuffledCollection(size);
		for (int i=0;i<size;i++) {
			int seat = getSeatAssignment(rems);
			if (i == size-1) {
				lastPassSeatAssignment = seat;
			}
		};
		if (passToSeat[lastPass] == lastPassSeatAssignment) {
			return 1;
		} else {
			return 0;
		}
	}
	
	private int getSeatAssignment(List<Integer> rems) {
		int rand = new Random().nextInt(rems.size());
		int seat = rems.remove(rand);
		return seat;
	}
	
	private int [] getShuffledArray(int max) {
		List<Integer> range = IntStream.rangeClosed(0, max-1)
			    .boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		return range.stream().map(i -> i).mapToInt(Integer::intValue).toArray();
	}
	
	private List<Integer> getShuffledCollection(int max) {
		List<Integer> range = IntStream.rangeClosed(0, max-1)
			    .boxed().collect(Collectors.toCollection(() -> new LinkedList<Integer>()));
		return range;
	}

}

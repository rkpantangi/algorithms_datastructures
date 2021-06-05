package com.algod.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CrazyFirstPassengerTest {

	public static void main(String[] args) {
		CrazyFirstPassengerTest cpt = new CrazyFirstPassengerTest();
		
		int successes = 0;
		int noOfExp = 100000;
		for (int i=1;i<=noOfExp;i++) {
			int size = 100;
			successes += cpt.runSimulation(size);
		}
		double prob = (double)successes/noOfExp;
		System.out.println(prob);
	}

	public int runSimulation(int size) {
		int [] passToSeat = getShuffledArray(size);
		int [] newSeatToPass = new int[size];
		for (int i=0;i<size;i++) {
			newSeatToPass[i] = -1;
		}

		int lastPassSeatAssignment = -1;
		List<Integer> rems = getIntList(size);
		for (int i=0;i<size;i++) {
			int seat;
			if (i == 0 || newSeatToPass[passToSeat[i]] > -1) {
				seat = getSeatAssignment(rems);
			} else {
				seat = passToSeat[i];
				// remove from rems
				rems.remove(Integer.valueOf(seat));
			}
			newSeatToPass[seat] = i;
			if (i == size-1) {
				lastPassSeatAssignment = seat;
			}
		}
		if (passToSeat[size-1] == lastPassSeatAssignment) {
			return 1;
		} else {
			return 0;
		}
	}
			
	private int getSeatAssignment(List<Integer> rems) {
		int rand = new Random().nextInt(rems.size());
		return rems.remove(rand);
	}
	
	private int [] getShuffledArray(int max) {
		List<Integer> range = IntStream.rangeClosed(0, max-1)
			    .boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		return range.stream().mapToInt(Integer::intValue).toArray();
	}
	
	private List<Integer> getIntList(int max) {
		return IntStream.rangeClosed(0, max-1)
			    .boxed().collect(Collectors.toCollection(LinkedList::new));
	}

}

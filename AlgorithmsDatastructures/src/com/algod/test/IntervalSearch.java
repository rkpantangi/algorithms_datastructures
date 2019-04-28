package com.algod.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * You are given a list of Intervals. Each Interval is an inclusive Pair with start and end.
 * 
 * Find if a given number is covered by any of those intervals. 
 * 
 * The goal is to minimize the find time, when it is called repeatedly on the same set of intervals.
 */
public class IntervalSearch {

	private static class Interval {
		private int st;
		private int end;
		public Interval(int st, int end) {
			super();
			this.st = st;
			this.end = end;
		}
		@Override
		public String toString() {
			return "[" + st + ", " + end + "]";
		}
	}
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 15));
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(7, 10));
		intervals.add(new Interval(8, 18));
		intervals.add(new Interval(20, 25));

		IntervalSearch is = new IntervalSearch(intervals);

		// search
		System.out.println("6 - " + is.find(6));
		System.out.println("27 - " + is.find(27));
		System.out.println("1 - " + is.find(1));
	}
	
	private List<Interval> merged = new ArrayList<>();
	
	public IntervalSearch(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.st - o2.st;
			}
			
		});
		
		this.merged = new ArrayList<>();
		merged.add(intervals.get(0));
		for (int i=1;i<intervals.size();i++) {
			Interval si = merged.get(merged.size()-1);
			Interval curi = intervals.get(i);
			if (si.end < curi.st) {
				merged.add(curi);
			} else {
				si.end = curi.end;
			}
		}
		
		System.out.println(merged);
	}
	
	public boolean find(int s) {
		int res = bst(s, 0, merged.size()-1);
		return res>=0;
	}
	
	private int bst(int s, int si, int ei) {
		if (si > ei) return -1;
		int midi = (si+ei)/2;
		Interval mide = merged.get(midi);
		if (s >= mide.st && s <= mide.end) {
			return midi;
		} else if (s < mide.st) {
			return bst(s, si, midi-1);
		} else {
			return bst(s, midi+1, ei);
		}
	}
}

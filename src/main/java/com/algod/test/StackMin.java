package com.algod.test;

import java.util.ArrayList;
import java.util.List;

public class StackMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class StackWithMin {
		
		private List<Integer> vals = new ArrayList<>();
		private List<Integer> mins = new ArrayList<>();
		
		public void push(int val) {
			if (val < mins.get(mins.size()-1)) {
				mins.add(val);
			}
			vals.add(val);
		}
		
		public int pop() {
			int val = vals.get(vals.size()-1);
			if (val == mins.get(mins.size()-1)) {
				mins.remove(mins.size()-1);
			}
			return val;
		}
		
		public int min() {
			return mins.get(mins.size()-1);
		}
	}

}

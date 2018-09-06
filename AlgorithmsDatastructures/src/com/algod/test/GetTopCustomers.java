package com.algod.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * (Customer, order, amount) keeps coming in. This program aggregates that data and return Top X number of customers by the total amount at any time.
 */
public class GetTopCustomers {
	
	private final HashMap<String, Double> map = new HashMap<>();
	private final TreeMap<Double, Set<String>> topmap = new TreeMap<>();

	private double min=0;
	private final int topcount;
	
	public GetTopCustomers(int topcount) {
		this.topcount = topcount;
	}
	
	public static void main(String[] args) {
		GetTopCustomers topc = new GetTopCustomers(2);
		
		topc.onOrder("c1", "o1", 15); // c1
		System.out.println(topc.getTopCustomers());
		
		topc.onOrder("c2", "o2", 10); // c1, c2
		System.out.println(topc.getTopCustomers());

		topc.onOrder("c3", "o3", 30); // c1, c3
		System.out.println(topc.getTopCustomers());
		
		topc.onOrder("c4", "o4", 25); // c3, c4
		System.out.println(topc.getTopCustomers());
		
		topc.onOrder("c1", "o5", 30); // c1, c3
		System.out.println(topc.getTopCustomers());

		topc.onOrder("c5", "o6", 5); // c1, c3
		System.out.println(topc.getTopCustomers());
		
		topc.onOrder("c3", "o7", 15); // c1, c3 (updated)
		System.out.println(topc.getTopCustomers());
	}
	
	private int topSize=0;
	
	private void addToTopMap(String cust, double oldval, double newval) {
		Set<String> cids = topmap.get(oldval);
		
		// remove from oldval
		if (cids != null && cids.contains(cust)) {
			cids.remove(cust);
			topSize--;
		}
		
		// add at newval
		cids = topmap.get(newval);
		if (cids == null) {
			cids = new LinkedHashSet<String>();
			topmap.put(newval, cids);
		}
		cids.add(cust);
		topSize++;
	}
	
	private void removeMin() {
		Entry<Double, Set<String>> entry = topmap.firstEntry();
		if (entry != null) {
			Iterator<String> iter = entry.getValue().iterator();
			iter.next();
			iter.remove();
			topSize--;
			if (entry.getValue().size() == 0) {
				topmap.remove(entry.getKey());
			}
			resetMin();
		}
	}
	
	private void resetMin() {
		Entry<Double, Set<String>> entry = topmap.firstEntry();
		if (entry != null) {
			min = entry.getKey();
		}
	}

	private void onOrder(String cid, String oid, double amt) {
		Double val = map.getOrDefault(cid, 0.0);
		double nval = val + amt;
		map.put(cid, nval);

		if (min < nval  || topSize < topcount) {
			addToTopMap(cid, val, nval);
		}
		
		if (topSize > topcount) {
			removeMin();
		}
		resetMin();
	}

	private Map<String, Double> getTopCustomers() {
		Map<String, Double> vals = new LinkedHashMap<>(topcount);
		for (Entry<Double, Set<String>> cids : topmap.entrySet()) {
			for (String cust : cids.getValue()) {
				vals.put(cust, cids.getKey());
			}
		}
		return vals;
	}

}

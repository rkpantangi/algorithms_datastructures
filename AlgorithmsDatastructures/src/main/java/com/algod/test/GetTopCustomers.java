package com.algod.test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * (Customer, order, amount) keeps coming in. This program aggregates that data and return Top X number of customers by the total amount at any time.
 */
public class GetTopCustomers {

	private final HashMap<String, Integer> map = new HashMap<>();
    private final PriorityQueue<String> topSet = new PriorityQueue<>(Comparator.comparingInt(map::get));

	private final int topcount;

	public GetTopCustomers(int topcount) {
		this.topcount = topcount;
	}

	public static void main(String[] args) {
		GetTopCustomers topc = new GetTopCustomers(2);

		topc.onOrder("c1", "o1", 15); // c1
		topc.printTopCustomers();

		topc.onOrder("c2", "o2", 10); // c1, c2
		topc.printTopCustomers();

		topc.onOrder("c3", "o3", 30); // c1, c3
		topc.printTopCustomers();

		topc.onOrder("c4", "o4", 25); // c3, c4
		topc.printTopCustomers();

		topc.onOrder("c1", "o5", 30); // c1, c3
		topc.printTopCustomers();

		topc.onOrder("c5", "o6", 5); // c1, c3
		topc.printTopCustomers();

		topc.onOrder("c3", "o7", 15); // c1, c3 (updated)
		topc.printTopCustomers();
	}

	private void onOrder(String cid, String oid, int amt) {
		int val = map.getOrDefault(cid, 0);
		int nval = val + amt;
		map.put(cid, nval);

		if (topSet.contains(cid)) return;

		if (topSet.size() < topcount || nval > map.get(topSet.peek())) {
		    topSet.add(cid);
        }

		if (topSet.size() > topcount) {
            topSet.poll();
        }
	}

	private void printTopCustomers() {
        System.out.println("----------------- ");
	    for (String s : topSet) {
            System.out.println(s + " - " + map.get(s));
        }
	}

}

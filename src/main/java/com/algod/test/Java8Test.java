package com.algod.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Test {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("1", "2");
		list.forEach(it -> System.out.println(it));
		
		for (String x : list) {
			System.out.println(x);
		}
		
		Map<String, Integer> map = new HashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		
		map.forEach((k, v) -> {
			
		});
		
		int [] arr = new int[10];
		Arrays.setAll(arr, i -> i);
		
		System.out.println(Arrays.toString(arr));
		
		CompletableFuture<List<String>> cf1 = CompletableFuture.supplyAsync(() -> { 
			ArrayList<String> al = new ArrayList<>(10);
			al.add("one");
			al.add("two");
			al.add("three");
			return al;
		});
		
		CompletableFuture<List<Integer>> cf2 = cf1.thenApply(x -> {
			List<Integer> res = x.stream().map(y -> y.length()).collect(Collectors.toList());
			return res;
		});
		
		final int [] sum = new int[1];
		cf2.thenAccept(x -> {
				Optional<Integer> val = x.stream().reduce(Integer::sum);
				sum[0] = val.get();
			}
		);
		
		System.out.println(sum[0]);
		
		int [] x = {1, 1, 4, 5, 6, 6};
        Map<Integer, Long> counted = Arrays.stream(x).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        System.out.println(counted);
        
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int e : x) {
        	map1.compute(e, (k, v) -> v == null ? 1 : v+1);
        }
        System.out.println(map1);
	}

	@FunctionalInterface
	private static interface MyTest {
		int test(int y);
	}
}

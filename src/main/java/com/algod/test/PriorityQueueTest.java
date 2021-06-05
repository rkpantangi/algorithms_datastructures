package com.algod.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(100, (o1, o2) -> o2 - o1);

        q.add(100);
        q.add(20);
        q.add(25);
        q.add(150);
        q.add(1);

        while(!q.isEmpty()) {
            System.out.println(q.poll());
        }

        Comparator<String> comp = (o1, o2) -> {
            if (o1.startsWith("A") && o2.startsWith("A")) return 0;
            if (o1.startsWith("A") && !o2.startsWith("A")) return 1;

            if (o1.startsWith("B") && o2.startsWith("A")) return -1;
            if (o1.startsWith("B") && o2.startsWith("B")) return 0;
            if (o1.startsWith("B")) return 1;

            if (o2.startsWith("A") || o2.startsWith("B")) return -1;

            return 0;
        };
        PriorityQueue<String> q1 = new PriorityQueue<>(100, comp.reversed());

        q1.add("C6");
        q1.add("A1");
        q1.add("B1");
        q1.add("A2");
        q1.add("A3");
        q1.add("C1");
        q1.add("B2");
        q1.add("C2");
        q1.add("A4");
        q1.add("B3");
        q1.add("C3");
        while(!q1.isEmpty()) {
            System.out.println(q1.poll());
        }

        testMethod();
    }

    private static interface Interface1 {
        default void method1() {
            System.out.println("");
        }
    }

    private static interface Interface2 {
        default void method1() {
            System.out.println("");
        }
    }

    private static class Test implements Interface1, Interface2 {
        @Override
        public void method1() {
            Interface2.super.method1();
        }

        private static void smethod1() {
            System.out.println("smethod1 parent");
        }
    }

    private static class SubTest extends Test {
        private static void smethod1() {
            System.out.println("smethod1 child");
        }
    }

    private static void testMethod() {
        Test t = new Test();
        t.smethod1();
        SubTest t1 = new SubTest();
        t1.smethod1();
    }
}

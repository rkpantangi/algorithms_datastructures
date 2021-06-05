package com.algod.test;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println("value - " + romanToInteger("I"));
        System.out.println("value - " + romanToInteger("V"));
        System.out.println("value - " + romanToInteger("IV"));
        System.out.println("value - " + romanToInteger("CD"));
        System.out.println("value - " + romanToInteger("CM"));
        System.out.println("value - " + romanToInteger("LC"));
        System.out.println("value - " + romanToInteger("DM"));
        System.out.println("value - " + romanToInteger("LVIII"));
        System.out.println("value - " + romanToInteger("MCMXCIV"));
        System.out.println("value - " + romanToInteger("MCMXCIVX"));
    }

    private static Map<Character, Integer> symbols = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    private static int romanToInteger(String roman) {
        int value = 0;
        int lastvalue = -1;
        int stoppingvalue = 0;
        for (int i=0;i<roman.length();i++) {
            int curvalue = symbols.get(roman.charAt(i));
            if (lastvalue == 0 && curvalue > stoppingvalue) {
                return value;
            }
            if (lastvalue > 0 && curvalue > lastvalue) {
                value -= lastvalue;
                value += (curvalue - lastvalue);
                lastvalue = 0;
                stoppingvalue = curvalue;
            } else {
                value += curvalue;
                lastvalue = stoppingvalue = curvalue;
            }
        }
        return value;
    }
}

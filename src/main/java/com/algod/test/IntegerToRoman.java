package com.algod.test;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println("value - " + integerToRoman(3));
        System.out.println("value - " + integerToRoman(3674));
    }

    private static String integerToRoman(int num) {
        String roman = "";
        if (num < 1 || num > 3999) return roman;

        roman = handle(roman, num/1000, "M", null);
        num = num%1000;

        roman = handle(roman, num/100, "C", "D");
        num = num%100;

        roman = handle(roman, num/10, "X", "L");
        num = num%10;

        roman = handle(roman, num, "I", "V");
        return roman;
    }

    private static String handle(String roman, int divisor, String lower, String higher) {
        if (divisor < 4 || higher == null) {
            for (int i=1;i<=divisor;i++) {
                roman += lower;
            }
        } else if (divisor == 4) {
            roman += (lower + higher);
        } else {
            roman += higher;
            for (int i=1;i<=(divisor-5);i++) {
                roman += lower;
            }
        }
        return roman;
    }
}

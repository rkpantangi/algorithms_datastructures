package com.algod.test;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("One two three"));
        System.out.println(reverseWords("One"));
        System.out.println(reverseWords("One two"));

        System.out.println(reverseWordsInPlace("One two three".toCharArray()));
        System.out.println(reverseWordsInPlace("One".toCharArray()));
        System.out.println(reverseWordsInPlace("One two".toCharArray()));
    }

    private static String reverseWords(String s) {
        String [] strs = s.split(" ");
        StringBuilder res = new StringBuilder(s.length());
        for (int i=strs.length-1;i>=0;i--) {
            res.append(strs[i]);
            if (i != 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    private static String reverseWordsInPlace(char[] s) {
        for (int i=0,j=s.length-1;i<s.length/2;i++,j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        int st=0;
        for (int i=0;i<s.length;i++) {
            if (s[i] == ' ' || i == (s.length-1)) {
                int end = i;
                if (s[i] == ' ') {
                    end = i-1;
                }
                for (int k=st,j=end;k<(st + (end-st+1)/2);k++,j--) {
                    char temp = s[k];
                    s[k] = s[j];
                    s[j] = temp;
                }
                st=i+1;
            }
        }
        return new String(s);
    }
}

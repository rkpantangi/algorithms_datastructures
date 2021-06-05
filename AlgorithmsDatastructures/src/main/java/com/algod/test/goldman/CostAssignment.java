package com.algod.test.goldman;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class CostAssignment {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }


        int [][] cost = new int [][] {
                {1, 1, 5},
                {4, 1, 7},
                {4, 3, 1}
        };

        int n = cost.length;
        int [] assignments = new int[n];
        for (int i=0;i<n;i++) {
            assignments[i]=-1;
        }

        for (int i=0;i<n;i++) {
            if (assignments[i] < 0) {
                int min = Integer.MAX_VALUE;
                int mini = -1;
                for (int j=0;j<n;j++) {
                    if (cost[i][j] > 0) {
                        if (cost[i][j] < min) {
                            min = cost[i][j];
                            mini = j;
                        }
                    }
                }
                assignments[i]=mini;
                cost[i][mini]=-1;
            }
        }

        // print assignments
        System.out.println(Arrays.toString(assignments));

    }
}


/*
Your previous Plain Text content is preserved below:

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

You can also change the default language your pads are created with
in your account settings: https://app.coderpad.io/settings

Enjoy your interview!


Manager -
N tasks to finish (anyone can do any task)
N people

1 person 1 task per day

cost matrix - NxN matrix given
     T
  [5 1 5
P  1 1 7
   1 3 1]

1. scan 1st column, choose the lowest cost person
2. exclude the above column, row


3 -> 2


P!




minimize the cost of the whole day


 */
package com.algod.test;


import java.util.LinkedList;
import java.util.List;

public class MultiplexMessages {
/*
 * NYDIG question
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.


Implement a system that receives messages from multiple sources and combines them into a single output. For this exercise we will have three producers and a single consumer.

Constraints:
- We have three inputs sources (One, Two, and Three).
- Messages are strings.
- There are three types of messages. If the first character of the message is an "A", the message is considered very urgent, and if the message starts with the character "B" it is considered urgent.
- To process the messages, round-robin the sources, reading one message from each in turn.
- Messages should be available to the consumer in a FIFO fashion, except for urgent messages which should skip ahead of any non-urgent messages, and very urgent messages that should skip ahead of both non-urgent and urgent messages.
- The rate at which messages are consumed is outside of your control.


Notes: For the sake of simplicity we can assume the input sources are pre-populated queues or arrays. In Java it could be as simple as:
    static final String [] sourceOne = {"234", "B34", "234", "435", "345", "A74", "980"};
    static final String [] sourceTwo= {"334", "534", "A75", "435", "345", "435", "980"};
    static final String [] sourceThree = {"444", "534", "234", "B35", "A98", "435", "980"};



 If multiple elements are tied for least value, the head is one of those elements -- ties are broken arbitrarily


 */

    final String [] sourceOne = {"234", "B34", "234", "435", "345", "A74", "980"};
    final String [] sourceTwo= {"334", "534", "A75", "435", "345", "435", "980"};
    final String [] sourceThree = {"444", "534", "234", "B35", "A98", "435", "980"};

    final List<String> aQueue = new LinkedList<>();
    final List<String> bQueue = new LinkedList<>();
    final List<String> allQueue = new LinkedList<>();

    public static void main(String[] args) {
        MultiplexMessages mm = new MultiplexMessages();
        mm.processData();
        mm.consumeData();
    }

    private void processData() {
        int ind=0;
        boolean dataPresent = false;
        while(true) {
            String one=null, two=null, three=null;
            if (ind < sourceOne.length) {
                one = sourceOne[ind];
                dataPresent=true;
            }
            if (ind < sourceTwo.length) {
                two = sourceTwo[ind];
                dataPresent=true;
            }
            if (ind < sourceThree.length) {
                three = sourceThree[ind];
                dataPresent=true;
            }
            if (!dataPresent) break;
            dataPresent = false;
            addToQueue(one);
            addToQueue(two);
            addToQueue(three);
            ind++;
        }
    }

    private void consumeData() {
        System.out.println("-------------");
        for (String s : aQueue) {
            System.out.println(s);
        }
        for (String s : bQueue) {
            System.out.println(s);
        }
        for (String s : allQueue) {
            System.out.println(s);
        }
        System.out.println(aQueue.size());
    }

    private void addToQueue(String s) {
        if (s != null) {
            if (s.startsWith("A")) {
                aQueue.add(s);
            } else if (s.startsWith("B")) {
                bQueue.add(s);
            } else {
                allQueue.add(s);
            }
        }
    }
}

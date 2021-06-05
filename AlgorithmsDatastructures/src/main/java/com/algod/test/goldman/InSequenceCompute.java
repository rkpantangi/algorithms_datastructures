package com.algod.test.goldman;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;

public class InSequenceCompute {
    private final TreeSet<ComputeResult> resultSet = new TreeSet<>(Comparator.comparingInt(ComputeResult::getSeqNo));

    // assuming initial sequence number to be 0, and result to be 0
    private volatile ComputeResult latestValue = new ComputeResult(0, 0);

    private final LinkedBlockingQueue<ComputeResult> waitingQueue = new LinkedBlockingQueue<ComputeResult>();

    private static class ComputeResult {
        private final int seqNo;
        private final int result;

        public ComputeResult(int seqNo, int result) {
            this.seqNo = seqNo;
            this.result = result;
        }

        public int getSeqNo() {
            return seqNo;
        }

        public int getResult() {
            return result;
        }

        @Override
        public String toString() {
            return "ComputeResult{" +
                    "seqNo=" + seqNo +
                    ", result=" + result +
                    '}';
        }
    }

    private void submitToWorker() {

    }

    public static void main(String[] args) {
        InSequenceCompute computeService = new InSequenceCompute();

        // server simulation thread
        new Thread(() -> {
            for (int i=1;i<=20;i++) {

            }
        }).start();

        // client simulation thread
        new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Latest value from the server - " + computeService.latestValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

package com.utils.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class OtpProgram {

    private static final Queue<Integer> otpQueue = new LinkedList<>();
    private static final Random random = new Random();

    private static int generateOTP() {
        return 100000 + random.nextInt(900000);
    }

    static class Producer implements Runnable {
        private static final int MAX_OTPS = 100;

        @Override
        public void run() {
            int produced = 0;

            while (produced < MAX_OTPS) {
                int otp = generateOTP();

                synchronized (otpQueue) {
                    while (otpQueue.size() >= 100) {
                        try {
                            System.out.println("Producer: Queue full (100). Waiting for consumer to reduce to 20...");
                            otpQueue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("Producer interrupted.");
                            return;
                        }
                    }

                    if (produced < MAX_OTPS) {
                        otpQueue.add(otp);
                        produced++;
                        System.out.println("Produced OTP: " + otp 
                            + " | Queue size: " + otpQueue.size() 
                            + " | Total produced: " + produced);
                    }

                    otpQueue.notifyAll();
                }
            }

            System.out.println("=== Producer has created " + MAX_OTPS + " OTPs and is now stopping. ===");
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (otpQueue) {
                    while (otpQueue.isEmpty()) {
                        try {
                            otpQueue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("Consumer interrupted.");
                            return;
                        }
                    }

                    int otp = otpQueue.remove();
                    System.out.println("Consumed OTP: " + otp 
                        + " | Queue size now: " + otpQueue.size());

                    otpQueue.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer(), "OTP-Producer");
        Thread consumerThread = new Thread(new Consumer(), "OTP-Consumer");

        System.out.println("Starting OTP Producer-Consumer...");
        System.out.println("Producer will create exactly 100 OTPs and stop.");
        System.out.println("When queue reaches 100, producer pauses until queue <= 20.");
        System.out.println("Press Ctrl+C to stop the program.\n");

        producerThread.start();
        consumerThread.start();
    }
}
package com.face.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by lifan.
 * Date: 2019/5/10.
 * Time: 13:50.
 */
public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";

    AtomicInteger i = new AtomicInteger(0);

    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (A){
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(B){
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (B){
                    synchronized(A){
                        System.out.println("2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
        i.compareAndSet()
    }

}

package com.face.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Create by lifan.
 * Date: 2019/6/5.
 * Time: 11:11.
 */
public class WaitNotify {

    static volatile boolean flag = true;
    static  Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new  Thread(new Wait(), "WaitThread");
        waitThread.start();

        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(),"NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable{
        public void run() {
            synchronized(lock){
                while(flag){
                    try{
                        System.out.println(Thread.currentThread() + "flag is true. wait @ " +
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();//此时释放锁
                    }catch(InterruptedException e){

                    }

                }
                System.out.println(Thread.currentThread() + "flag is false. running @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread() + "获取到锁 @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized(lock){
                System.out.println(Thread.currentThread() + "再次获取到锁 @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

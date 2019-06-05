package com.face.sort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by lifan.
 * Date: 2019/5/27.
 * Time: 15:03.
 */
public class FuThread extends Thread {

    private AtomicInteger curr;

    public FuThread(AtomicInteger c){
        this.curr = c;
    }

    @Override
    public void run() {
        List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u');
        //处理辅音
        while(true) {
            synchronized(curr) {
                if (!characters.contains((char) curr.intValue()) && curr.get() < 97 + 26) {
                    System.out.println((char) curr.getAndIncrement());
                    try {
                        curr.notifyAll();
                        curr.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    curr.notifyAll();
                }
            }
        }
    }
}

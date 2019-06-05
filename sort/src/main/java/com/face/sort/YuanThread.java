package com.face.sort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by lifan.
 * Date: 2019/5/27.
 * Time: 14:58.
 */
public class YuanThread extends Thread {

    private AtomicInteger curr;

    public YuanThread(AtomicInteger c){
        this.curr = c;
    }

    @Override
    public void run() {
        List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u');
        //处理元音
        while (true) {
            synchronized(curr){
                //唤醒之后
                if(characters.contains((char) curr.get())){
                    System.out.println((char) curr.getAndIncrement());
                    try {
                        curr.notify();
                        curr.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    curr.notify();
                }
            }
        }
    }
}

package com.face.thread;

import java.util.concurrent.TimeUnit;

/**
 * Create by lifan.
 * Date: 2019/6/5.
 * Time: 14:29.
 */
public class Profiler {

    private static ThreadLocal<Long> TIME = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin(){
        TIME.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis() - TIME.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("消耗: "+ Profiler.end() + "秒");

        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("消耗: "+ Profiler.end() + "秒");
    }

}

package com.face.threadpool;

/**
 * Create by lifan.
 * Date: 2019/6/6.
 * Time: 10:05.
 */
public interface MyThreadPool<Job extends Runnable> {

    //执行一个job， 这个job需要实现runnable
    void execute(Job job);
    //关闭线程池
    void shutdown();
    //增加工作者线程
    void addWorkers(int num);
    //减少工作者线程
    void removeWorker(int num);
    //得到正在等待执行的任务数量
    int getJobSize();
}

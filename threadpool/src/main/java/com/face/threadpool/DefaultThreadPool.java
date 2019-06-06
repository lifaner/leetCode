package com.face.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by lifan.
 * Date: 2019/6/6.
 * Time: 10:23.
 */
public class DefaultThreadPool<Job extends Runnable> implements MyThreadPool<Job> {

    private static final int MAX_WORKER_NUM = 10;
    private static final int MIN_WORKER_NUM = 1;
    private static final int DEFAULT_WORKER_NUM = 5;

    //这是一个工作列表
    private final LinkedList<Job> jobs = new LinkedList<>();
    //工作这列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    //工作者线程数量
    private int workerNum = DEFAULT_WORKER_NUM;
    //线程编号生成
    private AtomicInteger threadNum = new AtomicInteger();
    public DefaultThreadPool(){
        initializeWorkers(DEFAULT_WORKER_NUM);
    }

    public DefaultThreadPool(int num){
        workerNum = num > MAX_WORKER_NUM ? MAX_WORKER_NUM : num < MIN_WORKER_NUM ? MIN_WORKER_NUM : num;
        initializeWorkers(workerNum);
    }

    private void initializeWorkers(int num) {
        for(int i=0; i < num; i++){
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.getAndIncrement());
            thread.start();
        }
    }

    @Override
    public void execute(Job job) {
        if(job != null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for(Worker worker : workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs){
            //限制新增的worker数量不能大于最大值
            if(num + this.workerNum > MAX_WORKER_NUM){
                num = MAX_WORKER_NUM - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if(num >= this.workerNum){
                throw new IllegalArgumentException("超过最大worker数量");
            }
            int count = 0;
            while(count < num){
                Worker worker = workers.get(count);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }

            this.workerNum -= num;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    class Worker implements Runnable{

        //是否处于工作
        private volatile boolean running = true;
        @Override
        public void run() {
            while(running){
                Job job = null;
                synchronized(jobs){
                    //如果工作列表为空 就wait
                    if(jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //如果不为空 就拿出来一个
                    job = jobs.removeFirst();
                }
                if(job != null){
                    try {
                        job.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void shutdown(){
            running = false;
        }
    }
}

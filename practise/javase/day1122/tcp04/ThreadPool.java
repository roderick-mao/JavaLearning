package javase.day1122.tcp04;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private ThreadPoolExecutor pool;

    public ThreadPool(int maxPoolSize,int queueSize){
        this.pool = new ThreadPoolExecutor(1, maxPoolSize,
                60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(queueSize),new ThreadPoolExecutor.AbortPolicy());
    }

    public void execute(Runnable runnable){
        pool.submit(runnable);
    }
}

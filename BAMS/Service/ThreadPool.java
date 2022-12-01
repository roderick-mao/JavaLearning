package Service;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private ThreadPoolExecutor poolExecutor;

    public ThreadPool(int maxPoolSize, int queueSize){
        poolExecutor = new ThreadPoolExecutor(1,maxPoolSize,60,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>(queueSize));
    }

    public void execute(Runnable runnable){poolExecutor.submit(runnable);}

    public void stopAll(){
        poolExecutor.shutdownNow();
    }
}

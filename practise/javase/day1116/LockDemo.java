package javase.day1116;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable{
    private  int ticket = 10;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (ticket > 0) {
            if (lock.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 卖了: " + ticket--);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        Thread t1 = new Thread(lockDemo,"窗口1");
        Thread t2 = new Thread(lockDemo,"窗口2");

        t1.start();
        t2.start();
    }
}

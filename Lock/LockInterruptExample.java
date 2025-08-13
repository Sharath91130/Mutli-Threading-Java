package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptExample {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("Thread 1 acquired lock, working...");
                Thread.sleep(5000); // simulate long work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("Thread 1 released lock");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("Thread 2 trying to acquire lock interruptibly...");
                lock.lockInterruptibly(); // can be interrupted while waiting
                System.out.println("Thread 2 acquired lock");
            } catch (InterruptedException e) {
                System.out.println("Thread 2 was interrupted while waiting for lock!");
            } finally {
                if (lock.tryLock()) {
                    System.out.println("processign unlock Thread 2");// only release if actually acquired
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000); // let t2 start waiting
            t2.interrupt(); // interrupt t2 while it is waiting
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

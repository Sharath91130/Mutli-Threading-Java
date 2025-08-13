package Deadlock;

class SleepLockExample {
    private final Object lock = new Object();

    public void method1() {
        synchronized (lock) {
            System.out.println("Thread 1 got lock, sleeping...");
            try {
                Thread.sleep(3000); // keeps lock
            } catch (InterruptedException e) {}
            System.out.println("Thread 1 done sleeping");
        }
    }

    public void method2() {
        synchronized (lock) {

            System.out.println("Thread 2 got lock");
        }
    }

    public static void main(String[] args) {
        SleepLockExample ex = new SleepLockExample();

        new Thread(ex::method1).start();
        new Thread(ex::method2).start();
    }
}

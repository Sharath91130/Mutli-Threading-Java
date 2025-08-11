package RunnableAndThreadExample;

public class MyThread1 extends Thread{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

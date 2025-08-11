package RunnableAndThreadExample;

public class MyThead2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
